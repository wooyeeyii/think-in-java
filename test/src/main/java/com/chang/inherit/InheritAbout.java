package com.chang.inherit;

class Cat implements IAnimal {

	@Override
	public void bark() {
		System.out.println("miao, miao!");
	}

	@Override
	public void walk() {
		System.out.println("With four feet!");	
	}
	
	public void extraMethod() {
		System.out.println("extraMethod!");
	}
	
}

class Duck implements IAnimal {

	@Override
	public void bark() {
		System.out.println("ga, ga!");
	}

	@Override
	public void walk() {
		System.out.println("With two feet!");
	}
	
	public void extraMethod() {
		System.out.println("extraMethod!");
	}
	
}

class DuckMore extends Duck {
	@Override
	public void bark() {
		System.out.println("gaMore, gaMore!");
	}
}

public class InheritAbout {
	
	public static void main(String[] args) {
		IAnimal animal = new Duck();
		animal.bark();
		
		Duck duck = (Duck)animal;
		duck.extraMethod();

		try {
			Cat cat = (Cat)animal;
			cat.extraMethod();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/* 测试继承 */
		IAnimal duckMore = new DuckMore();
		duckMore.bark();
		duckMore.walk();

	}
	
}










