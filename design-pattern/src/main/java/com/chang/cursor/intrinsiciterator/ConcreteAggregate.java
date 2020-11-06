package com.chang.cursor.intrinsiciterator;

import com.chang.cursor.extrinsiciterator.Aggregate;
import com.chang.cursor.extrinsiciterator.MyIterator;

public class ConcreteAggregate extends Aggregate {

    public Object[] objArray = null;

    //���췽��������ۺ϶���ľ�������
    public ConcreteAggregate(Object[] obj) {
        this.objArray = obj;
    }

    @Override
    public MyIterator createIterator() {
        return new ConcreteIterator();
    }

    //�ڲ���Ա�࣬�����������
    private class ConcreteIterator implements MyIterator {

        //�ڲ���������¼��ǰ������������λ��
        private int index = 0;

        //��¼��ǰ�ۼ�����Ĵ�С
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
            if (index < size) {
                index++;
            }
        }

        @Override
        public boolean isDone() {
            return (index >= size);
        }

        @Override
        public Object currentItem() {
            return objArray[index];
        }

    }

}
