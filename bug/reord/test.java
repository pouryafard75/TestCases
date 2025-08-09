public class test {
    void x(){
        fileContextMenu.getItems().add(actionFactory.createMenuItem(
                StandardActions.OPEN_EXTERNAL_FILE, new OpenSingleExternalFileAction(dialogService, preferences, entry, file, taskExecutor, stateManager)));
    }
    
}
