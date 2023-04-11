public class VcapApplicationListener {
  public void rename(String newName) {
    int sharp = newName.indexOf("#");
    super.rename(sharp < 0 ? newName : newName.substring(sharp));
    myGeneratorDescriptor.setGeneratorUID(newName);
  }
}