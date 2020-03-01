# LitterBaby
这是一个对Java程序员友好的《学习强国》自动化测试工具，目的是只使用这一个工具最大化自动完成积分任务。

## 功能
  - 登录(1分) √
  - 阅读文章(6分) √
  - 视听学习(6分) √
  - 文章学习时长(6分) √
  - 视听学习时长(6分) √
  - 每日答题(6分)
  - 每周答题(5分)
  - 专项答题(10分)
  - 挑战答题(6分)
  - 订阅(2分)
  - 收藏(1分) √
  - 分享(1分) √
  - 发表观点(2分) √
  - 本地频道(1分) √
  
目前可以完成 1 + 6 + 6 + 6 + 6 + 1 + 1 + 2 + 1 = 30 分

## 下一步计划
  - 订阅
  - 挑战答题

## 开发
### 准备
  - [JDK8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  - [Android SDK 24.4.1](https://www.androiddevtools.cn)
  - [Appium 1.15.1](http://appium.io/)
  - [夜神模拟器 6.5.0.3](https://www.yeshen.com/)

JDK和Android SDK的安装网上都能找到教程，Appium Desktop启动后要配置JAVA_HOME和ANDROID_HOME
夜神模拟器启动后，要确保命令行运行adb devices能找到设备（可能需要将SDK中的adb覆盖掉夜神模拟器的adb和nox_adb）

### xxqg.properties
修改学习强国的用户名和密码
```
user.phoneNum=
user.password=
```
修改AndroidDriver相关配置
```
# android 版本
cap.version=5.1.1
# 夜神模拟器启动后用 adb devices 查看
cap.deviceName=127.0.0.1:62001
# 这个保证不用每次运行都登录
cap.noReset=true
# 因为要debug所以这个设置得大一点
cap.newCommandTimeout=600
# appium启动的地址
cap.appiumServer=http://localhost:4723/wd/hub
```

## 访问
访问数据库图形界面, 数据库连接信息查看application.properties
> http://localhost:8080/h2 

开始做任务
> http://localhost:8080/start



  
  



