## 概念
`Apache Commons Logging` (原名 `Jakarta Commons Logging`，`JCL`)提供的是一个`Java`的日志接口，同时兼顾轻量级和不依赖于具体的日志实现工具。
它提供给中间件/日志工具开发者一个简单的日志操作抽象，允许程序开发人员使用不同的具体日志实现工具。
用户被假定已熟悉某种日志实现工具的更高级别的细节。`JCL`提供的接口，对其它一些日志工具，包括`Log4J`, `Avalon LogKit`, `JDK 1.4`等，进行了简单的包装，此接口更接近于`Log4J`和`LogKit`的实现。

## 依赖
```
implementation group: 'commons-logging', name: 'commons-logging', version: '1.2'
```

## 组成
`JCL`有两个基本的抽象类，`Log`(基本记录器)和`LogFactory`(负责创建`Log`实例)。
当`commons-logging.jar`被加入到`CLASSPATH`之后，它会合理地猜测你想用的日志工具，然后进行自我设置，用户根本不需要做任何设置。
默认的`LogFactory`是按照下列的步骤去发现并决定那个日志工具将被使用的（按照顺序，寻找过程会在找到第一个工具时中止）:
1. 首先在`classpath`下寻找`commons-logging.properties文件`。如果找到，则使用其中定义的`Log`实现类；如果找不到，则在查找是否已定义系统环境变量`org.apache.commons.logging.Log`，找到则使用其定义的`Log`实现类；
2. 查看`classpath`中是否有`Log4j`的包，如果发现，则自动使用`Log4j`作为日志实现类；
3. 否则，使用`JDK`自身的日志实现类（`JDK1.4`以后才有日志实现类）；
4. 否则，使用`commons-logging`自己提供的一个简单的日志实现类`SimpleLog`；
```
org.apache.commons.logging.impl.Jdk14Logger // 使用 JDK1.4 
org.apache.commons.logging.impl.Log4JLogger // 使用 Log4J 
org.apache.commons.logging.impl.LogKitLogger // 使用 Avalon-Logkit 
org.apache.commons.logging.impl.SimpleLog // common-logging 自带日志实现类
org.apache.commons.logging.impl.NoOpLog // common-logging 自带日志实现类。它实现了 Log 接口。 其输出日志的方法中不进行任何操作。
```