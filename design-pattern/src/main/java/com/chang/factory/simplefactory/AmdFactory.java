package com.chang.factory.simplefactory;

import com.chang.factory.abstractfactory.AmdCpu;
import com.chang.factory.abstractfactory.AmdMainboard;
import com.chang.factory.abstractfactory.ICpu;
import com.chang.factory.abstractfactory.IMainboard;

public class AmdFactory implements AbstractFactory {

	@Override
	public ICpu createCpu() {
		return new AmdCpu(938);
	}

	@Override
	public IMainboard createMainboard() {
		return new AmdMainboard(938);
	}

}
