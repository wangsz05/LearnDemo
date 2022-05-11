# LearnDemo
All this Demo is used by my blog : moonsec.top
## 提交方法
fetch("http://127.0.0.1:8088/start-hire-process", {
"headers": {
"content-type": "application/json"
},
"body": '{"name":"cn","email":"aaa@aaa.com","phoneNumber":"13913887631","id":"111"}',
"method": "POST",
"mode": "cors",
"credentials": "include"
}).then(r=>r.log);

![img.png](img.png)

## scriptTask RCE 
通过上述的fetch方式触发 RCE
![img_1.png](img_1.png)

## ServiceTask RCE
通过fetch方式触发RCE
![img_2.png](img_2.png)
