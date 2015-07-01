## about

    This is aPocket
    For the purpose to use pocket easier

##function
- save the URL when another app share text no only url
- save the Url in Wechat

## use
1: install apk 
you can see 

![start](http://qiaoblog.b0.upaiyun.com/1.jpg)

2: Click "SAVE TEST" Button
you can see 

![SAVE TEST](http://qiaoblog.b0.upaiyun.com/2.jpg)

app will try save a link to you pocket

3: Click "SAVE ClIP" Button

![SAVE ClIP](http://qiaoblog.b0.upaiyun.com/3.jpg)

app will try save cilp text to you pocket

## note
Cause the source code should be commented and modified, it would be released later.

[dwonload link](http://qiaoblog.b0.upaiyun.com/app-release.apk)

##关于
###起源

    这个小应用是自己的一个项目 LinkBox 的一个功能,因为 LinkBox 在进行测试和完善升级.
    但有人很喜欢,故先分离出来作为一个单独的apk.

##功能
- 保存图文分享中的url
- 非纯链接文字分享中的url
- 保存微信链接
- 保存剪切板中的url

###介绍

    这是一个 Pocket 的增强应用,故必须要安装 Pocket 才能运行.
    程序基本思路: 正则表达式 获取 文字或图文分享中的URL,后强行调用 Pocket.

```java
//默认运行为
intentApp.addCategory(Intent.CATEGORY_HOME);
intentApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
```

###问题
- 不知道怎么让他静默的运行后结束.现在直接调用会显示一次黑屏
- 没有进行屏幕和大小优化(android.support.v7.app.ActionBarActivity 有点大)
- 没有自动更新的设置,也没有进行机型适配.所以有 BUG 欢迎在 issue 中提出
- 多URL支持
- 保存微信链接时,调用浏览器是Android自带的,如果被精简则应用报错闪退.

## 使用
1: 使用请先安装 Pocket, 后安装本程序

![start](http://qiaoblog.b0.upaiyun.com/1.jpg)

2: 点击 SAVE TEST 按钮 
应用尝试添加默认链接到你的 Pocket 中

![start](http://qiaoblog.b0.upaiyun.com/2.jpg)
    
3: 点击 SAVE ClIP 按钮 
应用尝试获取你剪切板的文字中链接保存到你的 Pocket 中

![start](http://qiaoblog.b0.upaiyun.com/3.jpg)
    
4: 保存微信链接

    在微信打开链接后使用浏览器打开,设置 aPocket 为默认,
    如果需要用浏览器打开 那么就点击通知
    
[apk 下载地址](http://qiaoblog.b0.upaiyun.com/app-release.apk)