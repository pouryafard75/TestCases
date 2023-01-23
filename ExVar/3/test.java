package exVar.2.v1;

public class test {
    private Drafts getDraftsForCurrentState() {
        Drafts drafts = new Drafts();
    
        if (!Util.isEmpty(composeText)) {
          drafts.add(new Draft(Draft.TEXT, composeText.getText().toString()));
        }
    
        for (Slide slide : attachmentManager.getSlideDeck().getSlides()) {
          if      (slide.hasAudio()) drafts.add(new Draft(Draft.AUDIO, slide.getUri().toString()));
          else if (slide.hasVideo()) drafts.add(new Draft(Draft.VIDEO, slide.getUri().toString()));
          else if (slide.hasImage()) drafts.add(new Draft(Draft.IMAGE, slide.getUri().toString()));
        }
    
        return drafts;
      }
    
}
