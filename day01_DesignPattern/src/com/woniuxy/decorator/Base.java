package com.woniuxy.decorator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * 装饰器模式
 * 1.需要一个公共的接口
 * 2.要送的礼物（原有的类，功能），要实现接口
 * 3.提供一个公共的装饰器父类，需要实现接口
 * 4.创建装饰器(起到扩展功能作用)
 */
interface Gift{
	public void look();	//
}
//杯子
final class Cup implements Gift{
	@Override
	public void look() {
		System.out.println("正好缺个杯子");//原有的功能
	}
}
//所有装饰器的父类
abstract class Decorator implements Gift{
	//添加一个礼物的属性
	Gift gift;
	public Decorator(Gift gift) {
		super();
		this.gift = gift;
	}
}
//装饰器1
class Box extends Decorator{
	public Box(Gift gift) {
		super(gift);
	}
	@Override
	public void look() {
		//1.先去编写扩展的功能
		System.out.println("哇!好漂亮的盒子");
		//2.调用原来的功能
		gift.look();
	}
}
//装饰器2
class HeartBox extends Decorator{
	public HeartBox(Gift gift) {
		super(gift);
	}
	@Override
	public void look() {
		System.out.println("诶！这人好像对我有意思");
		gift.look();
	}
}
//装饰器3
class GoldBox extends Decorator{
	public GoldBox(Gift gift) {
		super(gift);
	}
	@Override
	public void look() {
		System.out.println("这人真有钱!");
		gift.look();
	}
}

/*
 * 字符流
 * 字节流
 */

public class Base {
	public static void main(String[] args) throws FileNotFoundException {
		Cup cup = new Cup();
		Box box = new Box(cup);
		box.look();
		
		HeartBox heartBox = new HeartBox(cup);
		heartBox.look();
		System.out.println("---------");
		Box box2 = new Box(new HeartBox(new Cup()));
		box2.look();
		System.out.println("---------");
		Box box3 = new Box(new GoldBox(new HeartBox(new Cup())));
		box3.look();
		
		System.out.println("---------");
		//Reader reader = new BufferedReader(new FileReader(new File("a.txt")));
		
		InputStreamReader reader = new InputStreamReader(new FileInputStream("a.txt"));
	}
}
