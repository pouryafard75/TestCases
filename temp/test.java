public class test {
    public void displayListFragment(ArrayList<Uri> inputUris) {

        DecryptFilesListFragment frag = DecryptFilesListFragment.newInstance(inputUris);

        FragmentManager fragMan = getSupportFragmentManager();

        FragmentTransaction trans = fragMan.beginTransaction();
        trans.replace(R.id.decrypt_files_fragment_container, frag);

        // if there already is a fragment, allow going back to that. otherwise, we're top level!
        if (fragMan.getFragments() != null && !fragMan.getFragments().isEmpty()) {
            trans.addToBackStack("list");
        }

        trans.commit();

    }
}
