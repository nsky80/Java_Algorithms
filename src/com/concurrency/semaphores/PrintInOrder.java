/**
 * https://leetcode.com/problems/print-in-order/
 */
package com.concurrency.semaphores;

import java.util.concurrent.Semaphore;

/**
 * @author satis
 *
 */
public class PrintInOrder {
	// Initial number of permits available in zero, it ensures that 
	// release must occur before acquiring a new permit.
	Semaphore mutex2;
	Semaphore mutex3;
	
     public PrintInOrder() {
    	 mutex2 = new Semaphore(0);
    	 mutex3 = new Semaphore(0);
	}

    public void first(Runnable printFirst) throws InterruptedException {
        // first method is allowed to execute freely, after its execution it will permit 2nd method
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        mutex2.release();
    }
    public void second(Runnable printSecond) throws InterruptedException {
    	// before executing try to take permit and after execution release third mutex
    	mutex2.acquire();
    	// printSecond.run() outputs "second". Do not change or remove this line.
    	printSecond.run();
    	mutex3.release();
    }
    
    public void third(Runnable printThird) throws InterruptedException {
    	mutex3.acquire();
    	// printThird.run() outputs "third". Do not change or remove this line.
    	printThird.run();
    }
    
    
    public void one() throws InterruptedException{
    	System.out.println("first");
    	mutex2.release();
    }

    public void two() throws InterruptedException{
    	mutex2.acquire();
    	System.out.println("Second");
    	mutex3.release();
    }
    
    public void three() throws InterruptedException{
    	mutex3.acquire();
    	System.out.println("Three");
    }
	
	
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		PrintInOrder print = new PrintInOrder();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					print.one();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Thread 1");
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					print.two();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Thread 2");
		
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					print.three();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Thread 3");
		
		t3.start();
		t2.start();
		t1.start();
	}
}
