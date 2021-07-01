<template>
  <el-dialog title="编辑句型" :visible="editFormVisible" :show-close="false">
    <el-form :model="existSentence" label-position="top">
      <el-form-item label="句型名称 *" :label-width="formLabelWidth">
        <el-input v-model="existSentence.name" maxlength="20" show-word-limit></el-input>
      </el-form-item>
      <el-form-item label="句型描述 *" :label-width="formLabelWidth">
        <el-input
            v-model="existSentence.description"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="句型的巴科斯范式表示" :label-width="formLabelWidth">
        <el-input
            v-model="existSentence.paradigm"
            type="textarea"
            :autosize="{ minRows: 2 }"
            maxlength="250"
            show-word-limit
        ></el-input>
      </el-form-item>
      <el-form-item label="巴科斯范式的中间范式" :label-width="formLabelWidth">
        <el-card>
          <el-table
              :data="existSentence.paradigms"
              style="width: 100%"
          >
            <el-table-column type="expand">
              <template slot-scope="props">
                <el-form label-position="left" inline class="a-table-expand">
                  <el-form-item label="中间范式表示：">
                    <span>{{ props.row.easyParadigm }}</span>
                  </el-form-item>
                  <el-form-item label="这个范式的举例：">
                    <span>{{ props.row.example }}</span>
                  </el-form-item>
                  <el-form-item label="更新时间：">
                    <span>{{ props.row.updateTime }}</span>
                  </el-form-item>
                </el-form>
              </template>
            </el-table-column>
            <el-table-column prop="easyParadigm" label="中间范式表示" min-width="30" align="center">
            </el-table-column>

            <el-table-column label="操作" min-width="30" align="center">
              <template v-slot:default="scope">
                <el-button size="mini" @click="editDetail(scope.row.paradigmId)"> 编辑 </el-button>
                <el-popconfirm
                    title="确定删除吗？"
                    @confirm="deleteParadigm(scope.row.paradigmId)"
                >
                  <el-button type="danger" size="mini" slot="reference" style="margin-left: 10px;"> 删除 </el-button>
                </el-popconfirm>
              </template>
            </el-table-column>
          </el-table>
          <el-button icon="iconfont iconadd" circle size="mini" @click="registerParadigm" style="margin-top: 1vh;"></el-button>
          <span style="margin-left: 5px;">添加中间范式</span>
        </el-card>
      </el-form-item>
    </el-form>
    <v-paradigm-add :paradigmAddDialogVisible="paradigmAddDialogVisible"
                    :sentenceId="sentenceId"
                    @closeParadigmAddDialog="closeParadigmAddDialog"
                    @updateParadigms="updateParadigms"></v-paradigm-add>
    <v-paradigm-edit :paradigmEditDialogVisible="paradigmEditDialogVisible"
                     :paradigmId="transParadigmId"
                     @closeParadigmEditDialog="closeParadigmEditDialog"
                     @updateParadigms="updateParadigms"></v-paradigm-edit>
    <div slot="footer">
      <el-button @click="cancelEdit">取消</el-button>
      <el-button type="primary" @click="confirmEdit">更新</el-button>
    </div>
  </el-dialog>
</template>

<script>
import ParadigmAdd from "@/components/sentence/ParadigmAdd";
import ParadigmEdit from "@/components/sentence/ParadigmEdit";
export default {
  name: "SentenceEdit",
  data() {
    return {
      existSentence: {
        name: "",
        description: "",
        paradigm: "",
      },

      paradigmAddDialogVisible: false,
      paradigmEditDialogVisible: false,
      transParadigmId: 0,
      formLabelWidth: "120px",
    };
  },
  props:{
    editFormVisible:Boolean,
    sentenceId:Number
  },
  methods: {
    clearInput(){
      this.existSentence = {}
    },
    cancelEdit() {
      this.clearInput()
      this.$emit('closeEditSentenceDialog',false)
    },
    confirmEdit() {
      // 检查输入
      if(this.existSentence.name === '' || this.existSentence.name === undefined || this.existSentence.name === null){
        this.$message({
          showClose: true,
          message: "句型名称不能为空",
          type: 'error'
        });
        return;
      }
      if(this.existSentence.description === '' || this.existSentence.description === undefined || this.existSentence.description === null){
        this.$message({
          showClose: true,
          message: "句型描述不能为空",
          type: 'error'
        });
        return;
      }

      const _this = this
      let updateSentence = _this.existSentence
      updateSentence["userId"] = _this.$store.getters.getUser.userID
      updateSentence["sceneId"] = _this.$route.params.id
      this.$axios({
        method: 'put',
        url: `${this.global.serverUrl}/sentence/`,
        data: updateSentence
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "修改句型成功",
            type: 'success'
          });
          _this.cancelEdit()
        }
        else {
          _this.$message({
            showClose: true,
            message: "修改句型失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "修改句型失败",
          type: 'error'
        });
      })
      // console.log("existSentence:")
      // console.log(this.existSentence)
      this.$emit('closeEditSentenceDialog',false)
    },
    editDetail(id){
      // console.log("编辑中间范式"+id)
      this.transParadigmId = Number(id)
      this.paradigmEditDialogVisible = true
    },
    deleteParadigm(id){
      // console.log("删除中间范式"+id)
      const _this = this
      let deleteParadigm = {}
      deleteParadigm["paradigmId"] = Number(id)
      deleteParadigm["userId"] = _this.$store.getters.getUser.userID
      this.$axios({
        method: 'delete',
        url: `${this.global.serverUrl}/sentence/paradigm/`,
        data: deleteParadigm
      }).then(res => {
        if(res.data.code === 0){
          _this.$message({
            showClose: true,
            message: "删除中间范式成功",
            type: 'success'
          });
          _this.updateParadigms()
        }
        else {
          _this.$message({
            showClose: true,
            message: "删除中间范式失败",
            type: 'error'
          });
        }
      }).catch( () => {
        _this.$message({
          showClose: true,
          message: "删除中间范式失败",
          type: 'error'
        });
      })
    },
    registerParadigm(){
      // console.log("添加中间范式")
      this.paradigmAddDialogVisible = true
    },
    closeParadigmAddDialog(){
      this.paradigmAddDialogVisible = false
    },
    reloadExistSentence(){
      const _this = this
      let sentenceId = this.$props.sentenceId
      this.$axios({
        method: 'get',
        url: `${this.global.serverUrl}/sentence/${sentenceId}`
      }).then(res => {
        let detailSentence = res.data.data

        // 句型状态
        if(detailSentence.isTypeIn === 0){
          detailSentence["isTypeInString"] = "未录入"
        }else if(detailSentence.isTypeIn === 1){
          detailSentence["isTypeInString"] = "已录入"
        }else {
          detailSentence["isTypeInString"] = "其它"
        }
        _this.existSentence = detailSentence
      }).catch( error => {
        console.log(error)
      })
    },
    updateParadigms(){
      this.reloadExistSentence()
    },
    closeParadigmEditDialog(){
      this.paradigmEditDialogVisible = false
    }
  },
  watch: {
    editFormVisible(newVal, oldVal) {
      if (oldVal === false && newVal === true) {
        //请求数据
        this.reloadExistSentence()
      }
    },
  },
  created() {},
  computed: {

  },
  components:{
    "v-paradigm-add": ParadigmAdd,
    "v-paradigm-edit": ParadigmEdit,
  }
}
</script>

<style scoped>
.a-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  margin-top: 0.3rem;
  width: 100%;
  height: fit-content;
}
</style>