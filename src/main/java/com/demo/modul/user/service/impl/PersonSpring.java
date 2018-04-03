package com.demo.modul.user.service.impl;

import org.springframework.stereotype.Service;

import com.demo.modul.user.service.Speakable;

@Service
public class PersonSpring implements Speakable {

	@Override
	public void sayHi() {
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println("Hi!!");
	}

	@Override
	public void sayBye() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println("Bye!!");
	}

}
