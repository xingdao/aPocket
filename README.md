## about
This is aPocket apk
For the purpose to use pocket easier

## use
1: install apk 
    you can see [[ http://qiaoblog.b0.upaiyun.com/1.png | height = 100px ]]

2: Click "SAVE TEST" Button
    you can see [[ http://qiaoblog.b0.upaiyun.com/2.png | height = 100px ]]
    apk will TEST you install pocket or not 

3: Click "SAVE ClIP" Button
    you can see [[ http://qiaoblog.b0.upaiyun.com/3.png | height = 100px ]]

4:Click "Handle action bar"
    you can see [[ http://qiaoblog.b0.upaiyun.com/4.png | height = 100px ]]

5: Click "about"
    you can see [[ http://qiaoblog.b0.upaiyun.com/5.png | height = 100px ]]

## note
Cause the source code should be commented and modified, it would be released later.
[dwonload link](http://qiaoblog.b0.upaiyun.com/app-release.apk)

##关于
###起源
这个小应用是自己的一个项目 LinkBox 的一个功能,因为 LinkBox 在进行测试和完善升级.
但有人很喜欢,故先分离出来作为一个单独的apk.

###介绍
这是一个 Pocket 的增强应用,故必须要安装 Pocket 才能运行.
程序基本思路: 正则表达式 获取 文字或图文分享中的URL,后强行调用Pocket.

```java
//默认运行为
intentApp.addCategory(Intent.CATEGORY_HOME);
intentApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
```

###问题

1. 不知道怎么让他静默的运行后结束.现在直接调用会显示一次黑屏
2. 没有进行屏幕和大小优化(android.support.v7.app.ActionBarActivity 有点大)
3. 没有自动更新的设置,也没有进行机型适配.所以有bug 欢迎在 issue 中提出

## 使用
1: 使用请先安装 pocket,后安装本程序
    [[ http://qiaoblog.b0.upaiyun.com/1.png | height = 100px ]]

2: 点击 SAVE TEST 按钮 
    可以看见应用在尝试添加默认连接到你的Pocket中
    [[ http://qiaoblog.b0.upaiyun.com/2.png | height = 100px ]]
    
3: 点击 SAVE ClIP 按钮 
    可以看见应用在尝试获取你剪切板的文字到你的Pocket中
    [[ http://qiaoblog.b0.upaiyun.com/3.png | height = 100px ]]
    
4: 点击 任务栏
    可以看见关于
    [[ http://qiaoblog.b0.upaiyun.com/4.png | height = 100px ]]
    
5: 点击 ABOUT 按钮 
    可以看见关于
    [[ http://qiaoblog.b0.upaiyun.com/5.png | height = 100px ]]
    
[apk 下载地址](http://qiaoblog.b0.upaiyun.com/app-release.apk)