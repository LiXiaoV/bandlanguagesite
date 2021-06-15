# bandlanguagesite
1. 配置yml文件里面的数据库和redis为自己的连接信息
2. 运行BandlanguagesiteApplication启动后端
3. 修改vue文件夹下src/store/global.js里的serverUrl为后端项目入口地址
4. 进入bandlanguagesite-vue目录，运行yarn
5. 运行 yarn serve运行前端

## 多人协作分支管理策略
1. 克隆项目到本地
2. `git checkout -b dev origin/dev` 拉取dev分支到本地，并切换到dev分支
3. `git branch --set-upstream-to=origin/dev dev` ，将自己的dev分支与远程dev分支关联
4. `git switch -c 自己的分支名称` ，创建自己的分支，并切换到自己的分支
5. `git push origin 自己分支的名字` ，将自己的分支提交到远程仓库
6.  `git branch --set-upstream-to=origin/自己分支的名字 自己分支的名字` ，将自己的分支与远程分支关联
7. 自己分支上正常开发、git add、git commit
8. 提交自己的代码到自己的分支，`git push origin 自己分支的名字`
9. 如果要合并到dev分支，则到github项目里面创建拉取请求，其他人审核代码通过后合并到dev分支
10. 如有修改，建议每天push一次到自己的分支
11. 如果需要更改，建议每次更改之前pull dev分支到自己的分支，如果有冲突自行解决，如：
`git fetch origin dev`，获取远端的origin/dev分支；
    `git log -p dev..origin/dev`，查看本地dev与远端origin/dev的版本差异；
    `git merge origin/dev`，合并远端分支origin/dev到当前分支

