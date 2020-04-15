package com.chang.factory.simplefactory;

import com.chang.factory.abstractfactory.ICpu;
import com.chang.factory.abstractfactory.IMainboard;

public interface AbstractFactory {

    public ICpu createCpu();

    public IMainboard createMainboard();

}
