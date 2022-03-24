package com.intellij.remoteServer.impl.runtime.ui;

import com.intellij.ide.DataManager;
import com.intellij.ide.actions.ContextHelpAction;
import com.intellij.ide.util.treeView.AbstractTreeNode;
import com.intellij.ide.util.treeView.NodeDescriptor;
import com.intellij.ide.util.treeView.NodeRenderer;
import com.intellij.ide.util.treeView.TreeVisitor;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Splitter;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Disposer;
import com.intellij.remoteServer.configuration.RemoteServer;
import com.intellij.remoteServer.impl.runtime.log.LoggingHandlerImpl;
import com.intellij.remoteServer.impl.runtime.ui.tree.ServersTreeStructure;
import com.intellij.remoteServer.impl.runtime.ui.tree.TreeBuilderBase;
import com.intellij.remoteServer.runtime.ConnectionStatus;
import com.intellij.remoteServer.runtime.ServerConnection;
import com.intellij.remoteServer.runtime.ServerConnectionListener;
import com.intellij.remoteServer.runtime.ServerConnectionManager;
import com.intellij.ui.*;
import com.intellij.ui.components.panels.Wrapper;
import com.intellij.ui.treeStructure.Tree;
import com.intellij.util.Alarm;
import com.intellij.util.ui.UIUtil;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author michael.golubev
 */
public class ServersToolWindowContent extends JPanel implements Disposable {
    public static final DataKey<ServersToolWindowContent> KEY = DataKey.create("serversToolWindowContent");
    @NonNls
    private static final String PLACE_TOOLBAR = "ServersToolWindowContent#Toolbar";
    @NonNls
    private static final String SERVERS_TOOL_WINDOW_TOOLBAR = "RemoteServersViewToolbar";
    @NonNls
    private static final String SERVERS_TOOL_WINDOW_POPUP = "RemoteServersViewPopup";
    @NonNls
    private static final String HELP_ID = "Application_Servers_tool_window";
    private static final String MESSAGE_CARD = "message";
    private static final String EMPTY_SELECTION_MESSAGE = "Select a server or deployment in the tree to view details";
    private static final int POLL_DEPLOYMENTS_DELAY = 2000;
    private final Tree myTree;
    private final CardLayout myPropertiesPanelLayout;
    private final JPanel myPropertiesPanel;
    private final JLabel myMessageLabel;
    private final Map<String, JComponent> myLogComponents = new HashMap<String, JComponent>();
    private final DefaultTreeModel myTreeModel;
    private TreeBuilderBase myBuilder;
    private AbstractTreeNode<?> myLastSelection;
    private final Project myProject;

    public ServersToolWindowContent(@NotNull Project project) {
        super(new BorderLayout());
        myProject = project;
        myTreeModel = new DefaultTreeModel(new DefaultMutableTreeNode());
        myTree = new Tree(myTreeModel);
        myTree.setRootVisible(false);
        myTree.setShowsRootHandles(true);
        myTree.setCellRenderer(new NodeRenderer());
        myTree.setLineStyleAngled();
        getMainPanel().add(createToolbar(), BorderLayout.WEST);
        Splitter splitter = new Splitter(false, 0.3f);
        splitter.setFirstComponent(ScrollPaneFactory.createScrollPane(myTree, SideBorder.LEFT));
        myPropertiesPanelLayout = new CardLayout();
        myPropertiesPanel = new JPanel(myPropertiesPanelLayout);
        myMessageLabel = new JLabel(EMPTY_SELECTION_MESSAGE, SwingConstants.CENTER);
        myPropertiesPanel.add(MESSAGE_CARD, new Wrapper(myMessageLabel));
        splitter.setSecondComponent(myPropertiesPanel);
        getMainPanel().add(splitter, BorderLayout.CENTER);
        setupBuilder(project);
        for (RemoteServersViewContributor contributor : RemoteServersViewContributor.EP_NAME.getExtensions()) {
            contributor.setupTree(myProject, myTree, myBuilder);
        }
        myTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                onSelectionChanged();
            }
        });
        new DoubleClickListener() {
            @Override
            protected boolean onDoubleClick(MouseEvent event) {
                AnAction connectAction = ActionManager.getInstance().getAction("RemoteServers.ConnectServer");
                AnActionEvent actionEvent = AnActionEvent.createFromInputEvent(connectAction, event,
                        ActionPlaces.UNKNOWN);
                connectAction.actionPerformed(actionEvent);
                return true;
            }
        }.installOn(myTree);
        DefaultActionGroup popupActionGroup = new DefaultActionGroup();
        popupActionGroup.add(ActionManager.getInstance().getAction(SERVERS_TOOL_WINDOW_TOOLBAR));
        popupActionGroup.add(ActionManager.getInstance().getAction(SERVERS_TOOL_WINDOW_POPUP));
        PopupHandler.installPopupHandler(myTree, popupActionGroup, ActionPlaces.UNKNOWN, ActionManager.getInstance());
        new TreeSpeedSearch(myTree, TreeSpeedSearch.NODE_DESCRIPTOR_TOSTRING, true);
    }

    private void onSelectionChanged() {
        Set<AbstractTreeNode> nodes = myBuilder.getSelectedElements(AbstractTreeNode.class);
        if (nodes.size() != 1) {
            showMessageLabel(EMPTY_SELECTION_MESSAGE);
            myLastSelection = null;
            return;
        }
        AbstractTreeNode<?> node = nodes.iterator().next();
        if (Comparing.equal(node, myLastSelection)) {
            return;
        }
        myLastSelection = node;
        if (node instanceof ServersTreeStructure.LogProvidingNode) {
            ServersTreeStructure.LogProvidingNode logNode = (ServersTreeStructure.LogProvidingNode) node;
            LoggingHandlerImpl loggingHandler = logNode.getLoggingHandler();
            if (loggingHandler != null) {
                String cardName = logNode.getLogId();
                JComponent oldComponent = myLogComponents.get(cardName);
                JComponent logComponent = loggingHandler.getConsole().getComponent();
                if (!logComponent.equals(oldComponent)) {
                    myLogComponents.put(cardName, logComponent);
                    if (oldComponent != null) {
                        myPropertiesPanel.remove(oldComponent);
                    }
                    myPropertiesPanel.add(cardName, logComponent);
                }
                myPropertiesPanelLayout.show(myPropertiesPanel, cardName);
            } else {
                showMessageLabel("");
            }
        } else if (node instanceof ServersTreeStructure.RemoteServerNode) {
            updateServerDetails((ServersTreeStructure.RemoteServerNode) node);
        } else {
            showMessageLabel("");
        }
    }
}