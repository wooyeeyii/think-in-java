### 概述
&emsp; 装饰模式又名包装(Wrapper)模式。装饰模式以对客户端透明的方式扩展对象的功能，是**继承关系的一个替代方案**.
&emsp;装饰模式的类图如下：
![image](https://raw.githubusercontent.com/wooyeeyii/UsefulImage/master/youdao/wapper.JPG)
装饰模式中的角色：
- 抽象构建(component)角色:给出抽象接口，并规范准备接受附加责任的对象。
- 具体构建(ConcreteComponent)角色：定义一个将要接受附加责任的类
- 装饰(Decorator)角色：持有一个构件(component)对象的实例，并定义一个与抽象构建接口一致的接口
- 具体装饰(ConcreteDecorator)角色：负责给构件对象附加责任。

***
测试结果
```
mark. I am from ConcreteDecoratorB.
mark. I am from Decorator.
mark. I am from ConcreteDecoratorA.
mark. I am from Decorator.
mark. I am from ConcreteComponent.
```

### 装饰模式的简化
&emsp;无需接口类，只有一个ConcreteComponent类，将Dectorator类当成ConcreteComponent的一个子类。

### 透明性要求


#### 半透明的装饰模式
&emsp;纯粹的装饰模式很难找到。装饰模式的用意是在不改变接口的前提下，增强所考虑的类的性能。在增强性能的时候，往往需要建立新的公开的方法。  
&emsp;这就导致了大多数的装饰模式的实现都是“半透明”的，而不是完全透明的。换言之，允许装饰模式改变接口，增加新的方法。这意味着客户端可以声明ConcreteDecorator类型的变量，从而可以调用ConcreteDecorator类中才有的方法。

### 优缺点
#### 优点
- 装饰模式与继承关系的目的都是要扩展对象的功能，但是装饰模式可以提供比继承更多的灵活性。装饰模式允许系统动态决定“贴上”一个需要的“装饰”，或者除掉一个不需要的“装饰”。继承关系则不同，继承关系是静态的，它在系统运行前就决定了。
- 通过使用不同的具体装饰类以及这些装饰类的排列组合，设计师可以创造出很多不同行为的组合。
#### 缺点
- 由于使用装饰模式，可以比使用继承关系需要较少数目的类。使用较少的类，当然使设计比较易于进行。但是，在另一方面，使用装饰模式会产生比使用继承关系更多的对象。更多的对象会使得查错变得困难，特别是这些对象看上去都很相像。



### 应用实例(JAVA I/O库)

