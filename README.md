# aPocket
This is aPocket , For the purpose to use pocket easier.

## use
1: install apk 
    you can see 1
2: Click "SAVE TEST" Button
    you can see 2
    apk will TEST you install pocket or not 
    
3: Click "SAVE ClIP" Button
    you can see 3
    
4:Click "Handle action bar"
    you can see 4
    
5: Click "about"
    you can see 5    
    
## note
Cause the source code should be commented and modified, it would be released later.


##关于

###起源

  这个小应用是自己的一个项目 LinkBox 的一个功能,因为 LinkBox 在进行测试和完善升级.
  但有人很喜欢,故先分离出来作为一个单独的apk.

###介绍

  这是一个 Pocket 的增强应用,故必须要安装 Pocket 才能运行.
  程序基本思路: 正则表达式 获取 文字或图文分享中的URL,后强行调用Pocket.
  默认运行为 
  intentApp.addCategory(Intent.CATEGORY_HOME);
  intentApp.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

###问题

1. 不知道怎么让他静默的运行后结束.现在直接调用会显示一次黑屏
2. 没有进行屏幕和大小优化(android.support.v7.app.ActionBarActivity 有点大)
3. 没有自动更新的设置,也没有进行机型适配.所以有bug 欢迎在 issue 中提出

## 使用
1: 使用请先安装 pocket,后安装本程序
2: 点击 SAVE TEST 按钮 
    可以看见应用在尝试添加默认连接到你的Pocket中
    
3: 点击 SAVE ClIP 按钮 
    可以看见应用在尝试获取你剪切板的文字到你的Pocket中
    
4: 点击 任务栏
    可以看见关于
    
5: 点击 ABOUT 按钮 
    可以看见关于
    
##其他

  代码需要修正和注释稍后提供下载.
