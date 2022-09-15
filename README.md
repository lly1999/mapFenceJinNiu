# 金牛区综合执法调度指挥平台  mapFenceJinNiu
## 代码流程
· 现在github默认分支是main，本地git一般是master，所以请注意分支名称的不同，自己本地做好修改
- [ ] Fork一份进自己的github仓库
- [ ] git clone 到自己的本地
- [ ] git new branch dev分支，建议不要在main分支进行改动
- [ ] 改动完毕后，本地merger进main分支
- [ ] git push进自己的远程仓库
- [ ] 在自己的仓库提交pull/request(简称pr),等待owner review




##  后端通用返回接口 CommonResult
```
{
"code": status_code,
"message": String message,
"data": object,如Table,JSONObject,JSONArray,entity等
}
```
### 表格类 Table 
haerderNames,表格头名
dataNames,数据名,前端解析用
格式:
```
 {
"headerNames": [
                "未处理投诉案件",
                "处理中投诉案件",
                "已结案投诉案件",
                "投诉案件结案率"
            ],
 "dataNames": [
                "todo",
                "onProcess",
                "done",
                "rate"
            ],
 "data": [
              {
                 "todo": 0,
                 "onProcess": 1,
                 "done": 12,
                 "rate": "92.30769%"
               }
            ]
        },
```
### 人员类 UserAdmin
```
见代码
```
### 围栏   Fence
```
见代码
```


