#### TCP粘包/拆包
&emsp;&emsp; TCP是流协议，TCP底层会依据TCP的缓存区的实际情况进行包的划分，一个完整的包可能被TCP拆分为多个包或者多个包被整合为一个包。

#### problem包
&emsp;&emsp;prblem包下的示例就是存在粘包问题代码的展示.

#### modify包
&emsp;&emsp;modify包下是借助Netty提供的LineBaseFrameDecoder类来解决TCP粘包问题.    
&emsp;&emsp;LineBaseFrameDecoder的原理是依次遍历byteBuf中的可读字节，判断看是否有"\r"或者"\r\n", 
若有，就以此位置为结束位置，从可读索引到结束位置区间的字节就组成了一行。它是以换行符为结束标志的解码器， 支持携带结束符或者不携带结束符两种解码方式，
同时支持配置单行的最大长度。如果连续读取到最大长度后仍然没有发现换行符，就会跑出异常，同时忽略掉之前读到的异常码流。    
&emsp;&emsp;StringDecoder就是将接收到的对象转换为字符串，然后继续调用后面的handler。    
&emsp;&emsp;它两的组合就是按行切换的文本解码器，它被涉及用来支持TCP的粘包和拆包.

#### 其他方式的TCP粘包/拆包解码器
&emsp;&emsp;Netty提供除LineBaseFrameDecoder之外的其他类型解码器，看下一章。