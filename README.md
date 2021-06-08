# bandlanguagesite
1. 配置yml文件里面的数据库和redis为自己的连接信息
2. 运行BandlanguagesiteApplication启动后端
3. 修改vue文件夹下src/store/global.js里的serverUrl为后端项目入口地址
4. 进入bandlanguagesite-vue目录，运行yarn
5. 运行 yarn serve运行前端

## 多人协作分支管理策略
1. 克隆项目到本地
2. `git checkout -b dev origin/dev` 拉取dev分支到本地，并切换到dev分支
3. `git switch -c 自己的分支名称` ，创建自己的分支，并切换到自己的分支
4. `git push origin 自己分支的名字` ，将自己的分支提交到远程仓库
5. 自己分支上正常开发、git add、git commit
6. 提交自己的代码到自己的分支，`git push origin 自己分支的名字`
7. 管理员定期合并各个分支到dev分支，冲突都在这里解决
