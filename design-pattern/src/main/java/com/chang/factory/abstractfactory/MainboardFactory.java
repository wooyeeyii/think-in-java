package com.chang.factory.abstractfactory;

public class MainboardFactory {
	public static IMainboard createMainboard(int type) {
		if( 1 == type) {
			return new IntelMainboard(755);
		} else if( 2 == type) {
	    	return new AmdMainboard(938);
	    } else {
	    	return null;
	    }
	}
}
