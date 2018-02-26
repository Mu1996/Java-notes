#分布式通信框架-webservice分析

##什么是webservice
webservice也可以叫xml web service webservice, 轻量级的独立的通讯技术
1.	基于web的服务：服务端提供的服务接口让客户端访问
2.	跨平台、跨语言的整合方案

##为什么要使用webservice
跨语言调用的解决方案

##什么时候要去使用webservice
例如电商平台，订单的物流状态。 
.net实现的webservice服务接口

##webservice中的一些概念
**WSDL(web service definition language  webservice 定义语言)**

**Webservice服务需要通过wsdl文件来说明自己有什么服务可以对外调用。并且有哪些方法、方法里面有哪些参数wsdl基于XML（可扩展标记语言）去定义的**
1.	 对应一个.wsdl的文件类型
2.	 定义了webservice的服务器端和客户端应用进行交互的传递数据和响应数据格式和方式
3.	 一个webservice对应唯一一个wsdl文档

**SOAP（simple object access protocal简单对象访问协议）**

1. http+xml
    webservice通过http协议发送和接收请求时,发送的内容（请求报文）和接收的内容（响应报文）都是采用xml格式进行封装

2. 这些特定的HTTP消息头和XML内容格式就是SOAP协议
    1.	一种简单、基于HTTP和XML的协议
    2.	soap消息：请求和响应消息
    3.	http+xml报文

**SEI（webservice endpoint interface webservice的终端接口）**
* webservice服务端用来处理请求的接口，也就是发布出去的接口。
