package com.chang.cursor.extrinsiciterator;

public class ConcreteIterator implements MyIterator {
	//持有被迭代的具体的聚合对象
	private ConcreteAggregate agg;
	private int index = 0;
	private int size = 0;
	
	public ConcreteIterator(ConcreteAggregate agg) {
		this.agg = agg;
		this.size = agg.size();
		this.index = 0;
	}
	
	@Override
	public void first() {
		index = 0;
	}

	@Override
	public void next() {
		if(index < size) {
			index += 1;
		}
	}

	@Override
	public boolean isDone() {
		return index >= size;
	}

	@Override
	public Object currentItem() {
		return agg.getElement(index);
	}

}
