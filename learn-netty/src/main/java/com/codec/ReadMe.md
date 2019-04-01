#### 编解码技术
- java序列化serializable
- Google的Protobuf
- Facebook的Thrift
- JBoss的Marshalling

#### 示例
&emsp;&emsp; basic包下例子是使用Serializable和直接转换成字节的对比    
&emsp;&emsp; pojo包下发送和回复时使用的两个pojo类    
&emsp;&emsp; serializable.netty包下是netty使用java序列化的示例     
&emsp;&emsp; marashalling包下是使用jboss marshalling编解码的示例(需额外两个依赖)