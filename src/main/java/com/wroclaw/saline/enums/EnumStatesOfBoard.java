package com.wroclaw.saline.enums;

public enum EnumStatesOfBoard {
	EMPTY("E"),
	BALL("B"),
	ROUND("R");

	EnumStatesOfBoard(String value) {
		this.state = value;
	}
	
	private String state;
	
	public String getState() {
		return state;
	}
}
