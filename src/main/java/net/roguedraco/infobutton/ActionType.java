package net.roguedraco.infobutton;

public enum ActionType {

	PLAYER_COMMAND("PLAYER_COMMAND"),
	CONSOLE_COMMAND("CONSOLE_COMMAND"),
	FILE_READ("FILE_READ");
	
	private String type;
	
	private ActionType(String type) {
		this.type = type;
	}
	
	public static ActionType getType(String key) {
		for(ActionType action : values()) {
			if(action.getType().equalsIgnoreCase(key)) {
				return action;
			}
		}
		
		return ActionType.PLAYER_COMMAND;
	}

	public String getType() {
		return type;
	}
}
