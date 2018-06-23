package com.ogcg.threading.second;

public class SuperLongOperation implements Runnable {
	
	Object lock;
	SuperLongOperation(Object lock){
		this.lock = lock;
	}
	
	@Override
	public void run() {
		//WAIT A LOOOOT OF TIME
		synchronized(lock) {
			try {
				System.out.println("Doing extremely long operation");
				Thread.sleep(5000);
				OscThread.state = "world";
				lock.notifyAll();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
