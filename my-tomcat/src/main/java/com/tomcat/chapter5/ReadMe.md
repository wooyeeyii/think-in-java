#### servlet容器
##### wrapper容器
&emsp;&emsp; 例子Bootstrap1OfChapter5就是使用wrapper的一个例子，包含了2个阀(valve)和一个基础阀. 

##### context容器
&emsp;&emsp;例子Bootstrap2OfChapter5使用的是context容器，它包含了2个wrapper子容器，分别对应PrimitiveServlet和ModernServlet，对应关系为
url中包含Primitive-->PrimitiveServlet、Modern-->ModernServlet. Context容器中还包含一个映射器，帮助其选择适用哪个wrapper。(示例中看不出来映射器-mapper类有撒用....)