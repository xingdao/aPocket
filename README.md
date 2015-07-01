## about
This is aPocket apk
For the purpose to use pocket easier

##function
1: save the URL when another app share text no only url
2: save the Url in Wechat

## use
1: install apk 
you can see 

![start](http://qiaoblog.b0.upaiyun.com/1.jpg)

2: Click "SAVE TEST" Button
you can see 

![SAVE TEST](http://qiaoblog.b0.upaiyun.com/2.jpg)

apk will try save a link to you pocket

3: Click "SAVE ClIP" Button

![SAVE ClIP](http://qiaoblog.b0.upaiyun.com/3.jpg)

apk will try save cilp text to you pocket

4:Click "Handle action bar"

![Handle action bar](http://qiaoblog.b0.upaiyun.com/4.jpg)

5: Click "about"

![about](http://qiaoblog.b0.upaiyun.com/5.jpg)

## note
Cause the source code should be commented and modified, it would be released later.
[dwonload link](http://qiaoblog.b0.upaiyun.com/app-release.apk)

##关于
###起源
这个小应用是自己的一个项目 LinkBox 的一个功能,因为 LinkBox 在进行测试和完善升级.
但有人很喜欢,故先分离出来作为一个单独的apk.

##功能
保存图文分享中的url
非纯链接文字分享中的url
保存微信链接
保存剪切板中的url

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
4. 多链接支持
5. 保存微信链接时,调用浏览器是Android自带的,如果被精简则应用报错闪退.

## 使用
1: 使用请先安装 pocket,后安装本程序

![start](http://qiaoblog.b0.upaiyun.com/1.jpg)

2: 点击 SAVE TEST 按钮 
应用尝试添加默认连接到你的Pocket中

![start](http://qiaoblog.b0.upaiyun.com/2.jpg)
    
3: 点击 SAVE ClIP 按钮 
应用尝试获取你剪切板的文字到你的Pocket中

![start](http://qiaoblog.b0.upaiyun.com/3.jpg)
    
4: 保存微信链接
    在微信打开链接后使用浏览器打开,设置Pocket 为默认,
    如果需要用浏览器打开 那么就点击通知
    
[apk 下载地址](http://qiaoblog.b0.upaiyun.com/app-release.apk)