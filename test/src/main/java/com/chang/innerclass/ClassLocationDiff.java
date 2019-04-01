/*
内部类概述:
    把类定义在其他类的内部，这个类就被称为内部类。
    举例：在类A中定义了一个类B，类B就是内部类。

内部的访问特点：
    A:内部类可以直接访问外部类的成员，包括私有。
    B:外部类要访问内部类的成员，必须创建对象。
*/

package com.chang.innerclass;

public class ClassLocationDiff {

	private int num = 10;

	class Inner {
		String pri = "TTTTTTeeeeessssstttttt";

		public void show() {
			System.out.println(num);
		}
	}

	public static void main(String[] args) {

		ClassLocationDiff outer = new ClassLocationDiff();
		outer.method();

		Inner inner1 = outer.new Inner();
		inner1.show();
		System.out.println( inner1.pri);

		Inner inner2 = outer.new Inner();
		System.out.println( inner1 == inner2 );
	}

	public void method() {
		//找不到符号
		//show();

		Inner i = new Inner();
		i.show();
	}

}
