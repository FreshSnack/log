## 概念
`SLF4J`是为各种`logging APIs`提供一个简单统一的接口，从而使得最终用户能够在部署的时候配置自己希望的`logging APIs`实现。 
`SLF4J(Simple logging Facade for Java)`不是一个真正的日志实现，而是一个抽象层`（ abstraction layer）`，它允许你在后台使用任意一个日志类库。

## 依赖
```
implementation group: 'org.slf4j', name: 'slf4j-api', version: '1.7.30'
```
若适配`log4j`则还需依赖
```
testImplementation group: 'org.slf4j', name: 'slf4j-log4j12', version: '1.7.30'
```
`logback`自身实现了`slf4j`接口，即`logback-classic`

## 参考文档
1. [slf4j、jcl、jul、log4j1、log4j2、logback大总结](https://my.oschina.net/pingpangkuangmo/blog/410224)
2. [slf4j用户手册](https://blog.csdn.net/ystyaoshengting/article/details/86596832)

