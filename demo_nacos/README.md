# 工程简介

启动成功访问地址： http://192.168.241.130:8848/nacos/#/login

账号密码：nacos /nacos

nacos官网 https://nacos.io/zh-cn/docs/quick-start.html

安装包地址：https://github.com/alibaba/nacos/releases

nacos可以仅仅用来作为配置中心，不用注册中心也可以用的，当前既然用了nacos，那就一步到位

# NACOS安装和配置参考

```
cd /opt/
wget https://github.com/alibaba/nacos/releases/download/1.4.3/nacos-server-1.4.3.tar.gz
tar -zxvf nacos-server-1.4.3.tar.gz
cd nacos
```

```
cd /opt/nacos/bin

# 启动指令 启动命令(standalone代表着单机模式运行，非集群模式):
sh startup.sh -m standalone
```

## nacos 配置详情

https://nacos.io/zh-cn/docs/system-configurations.html

## 参考

https://blog.csdn.net/qq_42684642/article/details/106454612

## 问题

https://blog.csdn.net/qq_42684642/article/details/106454612
