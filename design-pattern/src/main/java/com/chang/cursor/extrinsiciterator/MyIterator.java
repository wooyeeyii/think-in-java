package com.chang.cursor.extrinsiciterator;

//抽象迭代子角色类
public interface MyIterator {
	//迭代方法：移动到第一个元素
	public void first();
	
	//迭代方法：移动到下一个元素
	public void next();
	
	//迭代方法：是否为最后一个元素
	public boolean isDone();
	
	//迭代方法：返回当前元素值
	public Object currentItem();

}
