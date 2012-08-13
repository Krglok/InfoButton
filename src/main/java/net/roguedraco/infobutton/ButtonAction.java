package net.roguedraco.infobutton;

public class ButtonAction {

	private ActionType type = ActionType.PLAYER_COMMAND;
	private String value = "";
	
	public ButtonAction(ActionType type, String value) {
		this.type = type;
		this.value = value;
	}

	public ActionType getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	public void setType(ActionType type) {
		this.type = type;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
