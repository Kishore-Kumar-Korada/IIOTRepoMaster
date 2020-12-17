package com.kishorekumarkorada.test;

public class SomeTest {
	public static void main(String[] args) {
		Animal cat = new Cat("Kyubi","mewwww");
		System.out.println(cat.getName());
		System.out.println(cat.getSuperName());
	}
}

class Animal {
	private String name;
	public void setName(String name) {
		System.out.println("Inside setName of Animal");
		this.name = name;
	}
	public String getName() {
		System.out.println("Inside getName of Animal");
		return this.name;
	}
	public String getSuperName() {
		System.out.println("Inside getSuperName of Animal");
		return this.name;
	}
}

class Cat extends Animal {
	private String sound;
	private String name;
	
	public Cat(String name, String sound) {
		super.setName("Hello Kishore");
		this.name = name;
		this.sound = sound;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	
	public void setName(String name) {
		System.out.println("Inside setName of Cat");
		this.name = name;
	}
	public String getName() {
		System.out.println("Inside getName of Cat");
		return this.name;
	}
	
}