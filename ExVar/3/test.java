package exVar.2.v2;

public class test {
    private Drafts getDraftsForCurrentState() {
        Drafts drafts = new Drafts();
        if (!Util.isEmpty(composeText)) {
          drafts.add(new Draft(Draft.TEXT, composeText.getText().toString()));
        }
    
        for (Slide slide : attachmentManager.getSlideDeck().getSlides()) {
          String draftType = null;
          if      (slide.hasAudio()) draftType = Draft.AUDIO;
          else if (slide.hasVideo()) draftType = Draft.VIDEO;
          else if (slide.hasImage()) draftType = slide.isEncrypted() ? Draft.ENCRYPTED_IMAGE : Draft.IMAGE;
    
          if (draftType != null)
            drafts.add(new Draft(draftType, slide.getUri().toString()));
        }
        return drafts;
      }
}
