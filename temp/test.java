public class test {
    public void displayListFragment(Uri inputUri) {
        ArrayList<Uri> uris = new ArrayList<>();
        uris.add(inputUri);
        DecryptFilesListFragment frag = DecryptFilesListFragment.newInstance(uris);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.decrypt_files_fragment_container, frag)
                .addToBackStack("list")
                .commit();

    }
}
