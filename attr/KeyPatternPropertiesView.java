package org.jabref.gui.libraryproperties.keypattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import org.jabref.gui.Globals;
import org.jabref.gui.actions.ActionFactory;
import org.jabref.gui.actions.StandardActions;
import org.jabref.gui.commonfxcontrols.CitationKeyPatternPanel;
import org.jabref.gui.help.HelpAction;
import org.jabref.gui.libraryproperties.AbstractPropertiesTabView;
import org.jabref.gui.libraryproperties.PropertiesTab;
import org.jabref.logic.help.HelpFile;
import org.jabref.logic.l10n.Localization;
import org.jabref.model.database.BibDatabaseContext;
import org.jabref.model.entry.BibEntryTypesManager;
import org.jabref.preferences.PreferencesService;

import com.airhacks.afterburner.views.ViewLoader;
import jakarta.inject.Inject;

public class KeyPatternPropertiesView extends AbstractPropertiesTabView<KeyPatternPropertiesViewModel> implements PropertiesTab {

    @FXML private Button keyPatternHelp;
    /**
     * The panel for managing citation key patterns in a BibTeX database.
     * 
     * <p>This UI component allows users to view and edit the citation key patterns
     * that are used for generating BibTeX keys automatically. Each pattern can be
     * specified per entry type, enabling customized key generation that adheres to
     * user preferences or specific citation standards.</p>
     *
     * @FXML
     * This annotation marks the {@code bibtexKeyPatternTable} as injectable by JavaFX,
     * meaning that it is automatically populated at runtime with the corresponding
     * component from the FXML file. modified This requires that an FXML element with the fx:id
     * "bibtexKeyPatternTable" exists and is compatible with the {@link CitationKeyPatternsPanel} type.
     */
    @FXML private CitationKeyPatternsPanel bibtexKeyPatternTable;

    @Inject private PreferencesService preferencesService;
    @Inject private BibEntryTypesManager bibEntryTypesManager;

    public KeyPatternPropertiesView(BibDatabaseContext databaseContext) {
        this.databaseContext = databaseContext;

        ViewLoader.view(this)
                  .root(this)
                  .load();
    }

    @Override
    public String getTabName() {
        return Localization.lang("Citation key patterns");
    }

    public void initialize() {
        this.viewModel = new KeyPatternPropertiesViewModel(databaseContext, preferencesService);

        bibtexKeyPatternTable.patternListProperty().bindBidirectional(viewModel.patternListProperty());
        bibtexKeyPatternTable.defaultKeyPatternProperty().bindBidirectional(viewModel.defaultKeyPatternProperty());

        ActionFactory actionFactory = new ActionFactory(Globals.getKeyPrefs());
        actionFactory.configureIconButton(StandardActions.HELP_KEY_PATTERNS, new HelpAction(HelpFile.CITATION_KEY_PATTERN, dialogService, preferencesService.getFilePreferences()), keyPatternHelp);
    }

    @Override
    public void setValues() {
        viewModel.setValues();
        bibtexKeyPatternTable.setValues(
                bibEntryTypesManager.getAllTypes(databaseContext.getMetaData().getMode()
                                                                .orElse(preferencesService.getLibraryPreferences()
                                                                                          .getDefaultBibDatabaseMode())),
                databaseContext.getMetaData().getCiteKeyPattern(preferencesService.getCitationKeyPatternPreferences().getKeyPattern()));
    }

    @FXML
    public void resetAllKeyPatterns() {
        bibtexKeyPatternTable.resetAll();
    }
}