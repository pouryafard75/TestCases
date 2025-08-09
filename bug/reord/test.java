public class test {
    void x(){
        fileContextMenu.getItems().add(actionFactory.createMenuItem(
                StandardActions.OPEN_EXTERNAL_FILE, new OpenExternalFileAction(dialogService, stateManager, preferences, entry, file, taskExecutor)));
    }
    
}
