/**
 * <p>Class:OOP.java</p>
 * <p>Copyright: Copyright (c) 2019</p>
 * <p>Company: www.woniuxy.com/</p>
 * @author xw
 * @version 1.0
 */
package com.woniuxy.factory;
/*
 * 同一事物在不同情况下针对同一情况作出的不同反应
 */


interface Bark{
	public void bark();
}

//宠物
abstract class Pet implements Bark{
	public String name;

	public Pet(String name) {
		super();
		this.name = name;
	}
}
//
class Cat extends Pet{
	public Cat(String name) {
		super(name);
	}
	@Override
	public void bark() {
		System.out.println("喵");
	}
}
//
class Dog extends Pet{
	public Dog(String name) {
		super(name);
	}
	@Override
	public void bark() {
		System.out.println("汪");
	}
}
//
class Snake extends Pet{
	public Snake(String name) {
		super(name);
	}
	@Override
	public void bark() {
		System.out.println("官人");
	}
	
}
//同一事物在不同情况下针对同一情况作出的不同反应

class Person{
	public Bark pet;
	public Person(Bark pet) {
		super();
		this.pet = pet;
	}
	public void play() {
		pet.bark();
	}
}


public class OOP {
	public static void main(String[] args) {
		Bark pet = new Cat("加菲");
		pet.bark();
		
		pet = new Dog("二哈");
		pet.bark();
		
		pet = new Snake("小白");
		pet.bark();
		
		Person person = new Person(new Cat("Tom"));
		person.play();
		person = new Person(new Dog(""));
		
	}
}
