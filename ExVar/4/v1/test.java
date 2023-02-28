package ExVar.4.v1;

public class test {
    public CheckBox (String text, CheckBoxStyle style) {
		super(text, style);
		clearChildren();
		setCheckBoxRight(false);
		getLabel().setAlignment(Align.left);
		setSize(getPrefWidth(), getPrefHeight());
	}

	public void setCheckBoxRight (boolean right) {
		Label label = getLabel();
		if (right) {
			add(label);
			imageCell = add(image = new Image(style.checkboxOff));
		} else {
			imageCell = add(image = new Image(style.checkboxOff));
			add(label);
		}
	}
    
}
