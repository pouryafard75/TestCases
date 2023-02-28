package ExVar.4.v2;

public class test {
    public CheckBox (String text, CheckBoxStyle style) {
		super(text, style);
		clearChildren();
		Label label = getLabel();
		imageCell = add(image = new Image(style.checkboxOff));
		add(label);
		label.setAlignment(Align.left);
		setSize(getPrefWidth(), getPrefHeight());
	}

}
