package com.ogcg.threading.first;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OscThread R1 = new OscThread( "Thread-1");
	    R1.start();
	      
	    OscThread R2 = new OscThread( "Thread-2");
	    R2.start();
	}

}
