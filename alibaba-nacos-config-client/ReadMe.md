Nacos中创建的配置内容是这样的：

    Data ID：alibaba-nacos-config-client.properties
    Group：DEFAULT_GROUP

拆解一下，主要有三个元素，它们与具体应用的配置内容对应关系如下：

    Data ID中的alibaba-nacos-config-client：对应客户端的配置spring.cloud.nacos.config.prefix，默认值为${spring.application.name}，即：服务名
    Data ID中的properties：对应客户端的配置spring.cloud.nacos.config.file-extension，默认值为properties
    Group的值DEFAULT_GROUP：对应客户端的配置spring.cloud.nacos.config.group，默认值为DEFAULT_GROUP

在采用默认值的应用要加载的配置规则就是：Data ID=${spring.application.name}.properties，Group=DEFAULT_GROUP。

下面，我们做一些假设例子，方便大家理解这些配置之间的关系：

例子一：如果我们不想通过服务名来加载，那么可以增加如下配置，就会加载到Data ID=example.properties，Group=DEFAULT_GROUP的配置内容了：

spring.cloud.nacos.config.prefix=example

例子二：如果我们想要加载yaml格式的内容，而不是Properties格式的内容，那么可以通过如下配置，实现加载Data ID=example.yaml，Group=DEFAULT_GROUP的配置内容了：

spring.cloud.nacos.config.prefix=example
spring.cloud.nacos.config.file-extension=yaml

例子三：如果我们对配置做了分组管理，那么可以通过如下配置，实现加载Data ID=example.yaml，Group=DEV_GROUP的配置内容了：

spring.cloud.nacos.config.prefix=example
spring.cloud.nacos.config.file-extension=yaml
spring.cloud.nacos.config.group=DEV_GROUP