#### description
example in this package:  
&emsp;&emsp;几种方法解决前面的多线程中错误单例的问题

*** 
方法1：同步方法
```
public static MyObject getInstance() {
    if(null == myObject) {
         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        myObject = new MyObject();
    }
    return myObject;
}
```
将上面的方法变为同步方法：
```
synchronized public static MyObject getInstance() {
    if(null == myObject) {
         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        myObject = new MyObject();
    }
    return myObject;
}
```
**效果**
&emsp;&emsp;可以实现正确的单例模式
**缺点**
&emsp;&emsp;同步方法效率太低了。下一个线程想要获得对象，则必须等上一个线程释放锁后可以执行。
*** 
方法2：同步代码块
```
public static MyObject getInstance() {
    //延迟加载
    if(null == myObject) {
         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        myObject = new MyObject();
    }
    return myObject;
}
```
将上面的方法变为：
```
public static MyObject getInstance() {
    try {
        //这种写法与同步方法的写法类似，效率低下
        synchronized (MyObject.class) {
        if(null == myObject) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            myObject = new MyObject();
        }
        }
    } catch( InterruptedException e) {
        e.printStackTrace;
    }
    return myObject;
}
```
**效果**
&emsp;&emsp;可以实现正确的单例模式
**缺点**
&emsp;&emsp;效率太低。
***
方法3：针对某些重要的代码进行单独的同步
```
public static MyObject getInstance() {
    if(null == myObject) {
         try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        myObject = new MyObject();
    }
    return myObject;
}
```
将上面的方法变为：
```
public static MyObject getInstance() {
    try {
        if(null == myObject) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //虽然部分代码被上锁
            //但还是有多线程安全问题
            synchronized (MyObject.class) {
               myObject = new MyObject();
           }
        }
    } catch( InterruptedException e) {
        e.printStackTrace;
    }
    return myObject;
}
```
**效果**
&emsp;&emsp;方法无效，多线程的情况下还是会产生多个实例。
***
方法4：使用DCL双检查锁机制
```
//修改MyObject类如下：
public class MyObject {
    private volatile static MyObject myObject = null;
    private MyObject() {}
    // 使用双检测机制来解决问题，即保证了不需要同步代码的异步执行
    // 又保证了单例的效果
    public static MyObject getInstance() {
        //延迟加载
        if(null == myObject) {
             try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            synchronized (MyObject.class) {
                if(null == myObject) {
                    myObject = new MyObject();
                }
            }
        }
        return myObject;
    }
    //此版本的代码称为双重检查Double-Check Locking
}
**效果**
&emsp;&emsp;使用双重检查锁功能，成功地解决了"懒汉模式"遇到多线程的问题。DCL也是大多数多线程结合单例模式使用的解决方案。





