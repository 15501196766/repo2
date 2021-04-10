package com.example.demo.controller;

import java.util.concurrent.TimeUnit;

class MyData{
	
	 int num = 20;
	
	public void add() {
		
		this.num = 60;
	}
	
}
public class Test {

	public static void main(String[] args) {
		MyData mydate = new MyData();
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName()+"A 进入");
			try {
				TimeUnit.SECONDS.sleep(3L);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mydate.add();
			System.out.println(Thread.currentThread().getName()+"A线程num的值"+mydate.num);
		},"A").start();
		
//		new Thread(() -> {
//			System.out.println(Thread.currentThread().getName()+"B 进入");
//			try {
//				TimeUnit.SECONDS.sleep(3L);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			mydate.add();
//			System.out.println(Thread.currentThread().getName()+"A线程num的值"+mydate.num);
//		},"A").start();
		
		while(mydate.num == 0) {
			
		}
		System.out.println("================"+"main线程num的值"+mydate.num);
	}
}
