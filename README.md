一个微信公众号每日推送的demo
### 测试账号申请
首先需要申请一下微信的[公众平台测试账号](https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login),申请完成之后就在可以看到自己的appID和appsecret

![20230107220843](https://blog-1253887276.cos.ap-chongqing.myqcloud.com/vscodeblog/20230107220843.png)

模板ID，这个就是等下发送的消息的一个模板，我们向微信的服务器发送消息，它接收到之后就会根据模板ID匹配到相应的模板，然后按照模板配置的参数来组成一个模板信息，模板ID只需要自己新增一个测试模板后就会给你一个ID

![20230107222603](https://blog-1253887276.cos.ap-chongqing.myqcloud.com/vscodeblog/20230107222603.png)

### 天气API

为了实现每日的天气推送就需要使用到接收天气的api，我选择的是[和风天气](https://dev.qweather.com/)的api来实现天气的查询和天气指数的获取，申请一个和风天气的账号，然后在后台创建项目，就可以获取一个key，这个key就是用来发送天气请求必须的参数


![20230107221727](https://blog-1253887276.cos.ap-chongqing.myqcloud.com/vscodeblog/20230107221727.png)

![20230107223224](https://blog-1253887276.cos.ap-chongqing.myqcloud.com/vscodeblog/20230107223224.png)


### 一言API

每日哲学😅，使用[一言](https://developer.hitokoto.cn/)，来实现每日哲学推送


## 消息模板

```text
	今天又是充满七万的一天~ {{smile.DATA}} 
  今天是：{{today.DATA}} 
  农历：{{chineseDate.DATA}} 
  当前城市：{{city.DATA}} 
  今日天气：{{weather.DATA}} 
  风向：{{windDir.DATA}} 
  空气湿度：{{humidity.DATA}} 
  今日温度：{{wendu.DATA}} 
  体感温度：{{tiganwendu.DATA}} 
  运动建议： {{sporttext.DATA}} 
  穿衣建议： {{weartext.DATA}}
  防晒建议： {{skintext.DATA}} 
  一言： {{yiyan.DATA}}

```
