package com.chang.factory.simplefactory;

import com.chang.factory.abstractfactory.ICpu;
import com.chang.factory.abstractfactory.IMainboard;
import com.chang.factory.abstractfactory.IntelCpu;
import com.chang.factory.abstractfactory.IntelMainboard;

public class IntelFactory implements AbstractFactory {

	@Override
	public ICpu createCpu() {
		return new IntelCpu(755);
	}

	@Override
	public IMainboard createMainboard() {
		return new IntelMainboard(755);
	}

}
