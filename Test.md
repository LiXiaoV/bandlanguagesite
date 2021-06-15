使用Postman测试

接口链接：
* 运行剧本（POST请求）：http://localhost:8888/script/runScript
* 获得语法树（GET请求，功能集成暂时没写）：http://localhost:8888/script/showAST

参数：
* sceneId 场景区ID
* script 剧本

如：
机构管理：
* sceneId 1
* script 在 测试开发部 中，创建 ‘运维开发部’ 子部门。

功能集成：
* sceneId 2
* script 显示 专家列表

论文分析：
* sceneId 3
* script 添加 论文


