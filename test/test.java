public class VcapApplicationListener {
  public void rename(String newName) {
    int sharp = newName.indexOf("#");
    String fooName = sharp < 0 ? newName : newName.substring(sharp);
    renameModels(getSourceLanguage().getModuleName(), fooName);
    myGeneratorDescriptor.setGeneratorUID(newName);
  }
}