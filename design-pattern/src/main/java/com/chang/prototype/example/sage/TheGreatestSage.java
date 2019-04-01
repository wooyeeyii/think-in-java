package com.chang.prototype.example.sage;

import java.io.IOException;

/**
 * 浅克隆和深克隆
 * @author junjie.chang
 *
 */
public class TheGreatestSage {
	
	private Monkey monkey = new Monkey();
	
	public void change() {
		//克隆大圣本尊
        Monkey copyMonkey = (Monkey)monkey.clone();
        System.out.println("大圣本尊的生日是：" + monkey.getBirthDate());
        System.out.println("克隆的大圣的生日是：" + copyMonkey.getBirthDate());
        System.out.println("大圣本尊跟克隆的大圣是否为同一个对象 " + (monkey == copyMonkey));
        System.out.println("大圣本尊的生日对象 跟 克隆的大圣的生日对象是否为同一个对象" + (monkey.getBirthDate() == copyMonkey.getBirthDate()));
        System.out.println("大圣本尊持有的金箍棒 跟 克隆的大圣持有的金箍棒是否为同一个对象？ " + (monkey.getStaff() == copyMonkey.getStaff()));
    }
	
	public void deepChange() {
		Monkey copyMonkey = null;
		try {
			copyMonkey = (Monkey)monkey.deepClone();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("大圣本尊的生日是：" + monkey.getBirthDate());
        System.out.println("克隆的大圣的生日是：" + copyMonkey.getBirthDate());
        System.out.println("大圣本尊跟克隆的大圣是否为同一个对象 " + (monkey == copyMonkey));
        System.out.println("大圣本尊的生日对象 跟 克隆的大圣的生日对象是否为同一个对象" + (monkey.getBirthDate() == copyMonkey.getBirthDate()));
        System.out.println("大圣本尊持有的金箍棒 跟 克隆的大圣持有的金箍棒是否为同一个对象？ " + (monkey.getStaff() == copyMonkey.getStaff()));
	}
	
    
    public static void main(String[]args){
        TheGreatestSage sage = new TheGreatestSage();
        System.out.println("-----------------浅克隆-------------------");
        sage.change();
        System.out.println("-----------------深克隆-------------------");
        sage.deepChange();
    }
}
