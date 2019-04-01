package com.chang.factory.abstractfactory;

public class CpuFactory {
	public static ICpu createCpu(int type) {
		ICpu cpu = null;
	    if(type == 1) {
	        cpu = new IntelCpu(755);
	    } else if( 2 == type) {
	    	cpu = new AmdCpu(938);
	    }
	    return cpu;
	}
}
