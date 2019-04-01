package com.chang.cursor.extrinsiciterator;

//抽象聚集角色类
public abstract class Aggregate {
	//工厂方法，创建相应迭代子对象的接口
	public abstract MyIterator createIterator();
}
