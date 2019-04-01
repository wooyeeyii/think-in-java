package com.chang.once;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class getHostname {
	public static void main(String[] agrs) throws UnknownHostException {
		try {
			System.out.println(InetAddress.getLocalHost().getHostAddress());
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
}
