package com.demo.modul.user.service.impl;

import com.demo.modul.user.service.Speakable;

public class PersonImpl implements Speakable {

	@Override
	public void sayHi() {
		try {
			Thread.sleep(30);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Hi!!");
	}

	@Override
	public void sayBye() {
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		System.out.println("Bye!!");
	}

}
