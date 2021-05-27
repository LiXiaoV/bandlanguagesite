<template>
  <el-card class="box-card">
    <div v-for="o in 3" :key="o" class="hot-invitation">
      <div class="invitation-item">
        <el-avatar class="invitation-avatar" :size="50" src="https://empty" @error="errorHandler">
          <img :src="default_avatar" alt="我的头像"/>
        </el-avatar>

        <div class="invitation-content">
          <el-row type="flex">
            <el-col><span style="color: #58a8c1">发帖者/场景区{{o}}</span></el-col>
            <el-col :span="6"><span>发帖时间</span></el-col>
          </el-row>
          <el-row type="flex" style="padding-top: 1vh;font-weight: bold;font-size: 1.2rem;">
            <el-col><span>帖子标题</span></el-col>
          </el-row>
          <div style="max-height: 10vh;">
            <p>帖子内容</p>
          </div>
          <el-row type="flex" justify="space-between" class="invitation-operation">
            <el-col class="dianzan">
              <span class="iconfont icondianzan"></span>
              <span>100</span>
            </el-col>
            <el-col class="pinglun">
              <span class="iconfont iconpinglun"></span>
              <span>50</span>
            </el-col>
            <el-col class="fenxiang">
              <span class="iconfont iconfenxiang"></span>
              <span>3</span>
            </el-col>
          </el-row>
        </div>

      </div>
    </div>
  </el-card>
</template>

<script>
import defaultAvatar from '../../assets/images/default-avatar.png';
export default {
  name: "DiscussNewest",
  data(){
    return {
      default_avatar: defaultAvatar,
    }
  },
  methods:{
    errorHandler() {
      return true
    },
  }
}
</script>

<style lang="scss" scoped>

.box-card {
  //width: 65vw;
  //margin-left: 7vw;
  //margin-top: 2vh;
}

.invitation-item{
//text-align: left;
  margin-bottom: 2vh;
//border-bottom: 1px solid #7e7c7c;
  background-color: #f5fdfd;
.invitation-avatar{
  float: left;
  margin: 0;
  padding: 0;
}
.invitation-content{
  margin-left: 5vw;
}
.invitation-operation{
  text-align: center;
}
}
</style>