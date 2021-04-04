## 概念
`logback`和`log4j`是同一个作者，`logback`可以看作是`log4j`的升级版。
`logback`分为三个模块，`logback-core`，`logback-classic`和`logback-access`，
其中`logback-core`是核心，其他两个模块依赖`core`，
这个`logback-classic`是`log4j`的改善版本，并且原生实现了`SLF4J`门面。
模块`logback-access`可以集成于`Servlet`容器，比如`Tomcat`和`Jetty`。

## 优势
相比`log4j`存在以下优势
1. 比`log4j`更快，重写了内核，在一些关键路径上性能提升10倍，内存占用也更少。
2. 经过大量的测试，和log4j测试不在一个量级。
3. `logback-classic`是`SLF4J`的实现，切换其他日志框架非常方便。
4. 文档丰富并且不断更新，支持`Groovy`风格的配置文件。
5. 配置文件自动重新加载，如果更新了配置文件，`logback-classic`可以自动重新加载。
6. 自动删除日期较老的日志文件，`maxHistory`属性，你可以控制已经产生日志文件的最大数量。如果设置`maxHistory`为`12`，那那些`log`文件超过`12`个月的都会被自动移除。
7. 自动压缩归档的日志文件，压缩文件是异步进行，不影响应用。
8. 配置文件可以处理不同的环境开发，测试，生产），这样一个配置文件就可以适应多个环境。
9. `SiftingAppender`（一个非常多功能的`Appender`）它可以用来分割日志文件根据任何一个给定的运行参数。如，`SiftingAppender`能够区别日志事件跟进用户的`Session`，然后每个用户会有一个日志文件。

## 依赖
```
    implementation group: 'ch.qos.logback', name: 'logback-core', version: '1.2.3'
    testImplementation group: 'ch.qos.logback', name: 'logback-classic', version: '1.2.3'
    implementation group: 'org.slf4j', name: 'slf4j-api', version: '1.7.30'
```

## 加载顺序
1. `logback`首先会试着查找`logback.groovy`文件;
2. 当没有找到时，继续试着查找`logback-test.xml`文件;
3. 当没有找到时，继续试着查找`logback.xml`文件;
4. 如果仍然没有找到，则使用默认配置（打印到控制台）

## 参考文档
1. [logback常用配置](https://blog.csdn.net/qq_36850813/article/details/83092051)
2. [从零开始玩转logback](https://developer.aliyun.com/article/709283)
3. [logback官网](http://logback.qos.ch/)