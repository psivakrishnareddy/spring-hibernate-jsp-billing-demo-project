package com.billingdemo.util;

public enum constants {
	VALID_USER(1),INVALID_USER(0),VALID_ADMIN(11), NEW_USER(12), ALREADY_LOGGED(3);
	
	private final int value;
	
	
			private constants(int value) {
				this.value = value;
			}
		
		
		    public int getValue() {
				return value;
		     }

}
