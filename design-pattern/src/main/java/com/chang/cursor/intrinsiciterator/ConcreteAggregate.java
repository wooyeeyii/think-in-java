package com.chang.cursor.intrinsiciterator;

import com.chang.cursor.extrinsiciterator.Aggregate;
import com.chang.cursor.extrinsiciterator.MyIterator;

public class ConcreteAggregate extends Aggregate {
	
	public Object[] objArray = null;
	
	//构造方法，传入聚合对象的具体内容
	public ConcreteAggregate(Object[] obj) {
		this.objArray = obj;
	}

	@Override
	public MyIterator createIterator() {
		// TODO Auto-generated method stub
		return new ConcreteIterator();
	}
	
	//内部成员类，具体迭代子类
	private class ConcreteIterator implements MyIterator {
		
		//内部索引，记录当前迭代到的索引位置
		private int index = 0;
		
		//记录当前聚集对象的大小
		private int size = 0;
		
		public ConcreteIterator() {
			this.size = objArray.length;
			index = 0;
		}
		
		@Override
		public void first() {
			index = 0;
		}

		@Override
		public void next() {
			// TODO Auto-generated method stub
			if(index < size) {
				index++;
			}
		}

		@Override
		public boolean isDone() {
			// TODO Auto-generated method stub
			return (index >= size);
		}

		@Override
		public Object currentItem() {
			// TODO Auto-generated method stub
			return objArray[index];
		}
		
	}

}
