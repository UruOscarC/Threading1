package com.ogcg.threading.second;

public class OscThread implements Runnable{

	private static class Lock {}

	private Thread t;
	private String threadName;
	public static String state = "hello";
	public static Lock lock = new Lock();
	
	OscThread(String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
    }
   
    public void run() {
       System.out.println("Running " +  threadName );
       System.out.println("State is: " + state);
       synchronized(lock) {
    	   Thread newThread = new Thread(new SuperLongOperation(lock), "Super long op");
           newThread.start();
    	   try {
        	   lock.wait();
           } catch (InterruptedException e) {
    		// TODO Auto-generated catch block
        	   e.printStackTrace();
           }
           System.out.println("State is: " + state);
           System.out.println("Thread " +  threadName + " exiting.");
       }
    }
	   
    public void start () {
       System.out.println("Starting " +  threadName );
       if (t == null) {
          t = new Thread(this, threadName);
          t.start();
       }
    }

}
