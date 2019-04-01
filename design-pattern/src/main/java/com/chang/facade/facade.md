#### 概述
&emsp;&emsp;门面模式，顾名思义，就是将一个东西封装成一个门面好与人家更容易进行交流。    
&emsp;&emsp;这种设计模式主要用在一个大的系统中有多个子系统组成时，这多个子系统肯定要涉及到相互通信，但是每个子系统又不能将自己的内部数据过多的暴露给其它系统，不然就没有必要划分子系统了。每个子系统都会设计一个门面，把别的系统感兴趣的数据封装起来，通过这个门面来进行访问.     
&emsp;&emsp;这样做的好处有：
1. 访问方便；
2. 安全性高。

#### Tomcat中实例
&emsp;&emsp;在Tomcat中就利用了门面模式的第2个优点，看看源码    
Tomcat4中：    
![iamge](https://github.com/wooyeeyii/UsefulImage/blob/master/youdao/design%20pattern/tomcat4RequestFacade.PNG?raw=true)   
&emsp;&emsp;感觉是假的门面模式，没撒实际用处......
```
/**
 * Facade class that wraps a Catalina-internal <b>HttpRequest</b>
 * object.  All methods are delegated to the wrapped request.
 *
 * @author Remy Maucherat
 * @version $Revision: 1.2 $ $Date: 2001/07/22 20:25:06 $
 */
public final class HttpRequestFacade
    extends RequestFacade
    implements HttpServletRequest {
}
```
Tomcat7中：    
![image](https://github.com/wooyeeyii/UsefulImage/blob/master/youdao/design%20pattern/Tomcat7RequestFacade.png?raw=true)    
从图中可以看出RequestFacade类封装了HttpServletRequest接口能够提供数据，通过调用私有变量Request类访问数据，而Request类中HttpServletRequest封装的接口以外的方法，则不能通过RequestFacade类访问。

#### 参考文档
[《JAVA与模式》之门面模式](https://www.cnblogs.com/java-my-life/archive/2012/05/02/2478101.html)