#### example1
&emsp;&emsp; Server和client均采用NIO的形式，流程如下：
1. server开启SocketServerChannel， 注册到selector中监听accept事件;
2. client开启SocketChannel， 若直接连接成功，则注册到selector监听读事件，并首先发送消息，若未直接连接，则监听连接事件；;
3. 若2中是连接成功的，则server触发读事件，打印消息，回复消息，client触发读事件，打印消息，后关闭端口；
4. 若2中是未直接连接，则server创建对应的socketChannel，将其注册到selector中监听读事件，client触发连接事件，添加监听读事件，发送消息给server，重复3的流程。

#### example2
&emsp;&emsp;与1中不同的地方:
