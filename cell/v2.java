public abstract class SingleRoleCellProvider {
    protected final SContainmentLink myContainmentLink;
    protected final SNode myOwnerNode;
    protected final EditorContext myEditorContext;
    public SingleRoleCellProvider(final SNode ownerNode, final SContainmentLink containmentLink, EditorContext editorContext) {
      myOwnerNode = ownerNode;
      myContainmentLink = containmentLink;
      myEditorContext = editorContext;
    }
    protected EditorCell createChildCell(EditorContext editorContext, SNode child) {
      EditorCell editorCell = editorContext.getEditorComponent().getUpdater().getCurrentUpdateSession().updateChildNodeCell(child);
      //todo get rid of getDeclarationNode
      editorCell.setAction(CellActionType.DELETE, new CellAction_DeleteSmart(myOwnerNode, myContainmentLink.getDeclarationNode(), child));
      editorCell.setAction(CellActionType.BACKSPACE, new CellAction_DeleteSmart(myOwnerNode, myContainmentLink.getDeclarationNode(), child));
      return editorCell;
     }
  
     public EditorCell createCell() {
       EditorCell_Collection resultCell = jetbrains.mps.nodeEditor.cells.EditorCell_Collection.createIndent2(myEditorContext, myOwnerNode);
       resultCell.setSelectable(false);
       for (SNode child : getNodesToPresent()) {
         resultCell.addEditorCell(createChildCell(myEditorContext, child));
       }
      if (isChildEmpty()) {
        resultCell.addEditorCell(createEmptyCell());
      }
       return resultCell;
     }
  
     private boolean isChildEmpty() {
       return !myOwnerNode.getChildren(myContainmentLink).iterator().hasNext();
     }
    protected EditorCell createEmptyCell() {
      EditorCell_Label result = myContainmentLink.isOptional() ?
           new EditorCell_Constant(myEditorContext, myOwnerNode, "") :
           new EditorCell_Error(myEditorContext, myOwnerNode, getNoTargetText());
       result.setDefaultText(getNoTargetText());
       result.setAction(CellActionType.COMMENT, new CellAction_Comment(myOwnerNode));
       return result;
     }
  
    protected String getNoTargetText() {
      //todo get rid of getRolName
      return "<no " + myContainmentLink.getRoleName() + ">";
    }
    protected Iterable<SNode> getNodesToPresent() {
      return AttributeOperations.getChildNodesAndAttributes(myOwnerNode, myContainmentLink);
    }
  }