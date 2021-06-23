<template>
  <div id="viewer" style="background-color: whitesmoke;height: 80vh;">

  </div>
</template>

<script>
import * as echarts from "echarts";

export default {
  name: "SyntaxTree",
  props:{
    treeJsonString: String,
  },
  methods:{

    // 定义生成树方法
    generateTree(){
      let treeObj = JSON.parse(this.treeJsonString)
      // console.log(treeObj)
      let viewer = document.getElementById('viewer');
      // console.log(viewer)
      // 初始化图表
      let myChart = echarts.init(viewer,'light');
      console.log(myChart)
      myChart.showLoading();
      myChart.hideLoading();
      myChart.setOption( {
        tooltip: { //提示框组件
          trigger: 'item', //触发类型，默认：item（数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用）。可选：'axis'：坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。'none':什么都不触发。
          triggerOn: 'mousemove' //提示框触发的条件，默认mousemove|click（鼠标点击和移动时触发）。可选mousemove：鼠标移动时，click：鼠标点击时，none：
        },
        calculable : false,
        series: [{
          "name":'树图',
          "type":'tree',
          //排列方式，横向、纵向
          "orient": 'vertical',
          "left": '2%',
          "right": '2%',
          "top": '5%',
          "bottom": '10%',
          //连接线长度
          "layerPadding": 5,
          //结点间距
          "nodePadding": 5,
          //图形形状
          "symbol": 'circle',
          //尺寸大小
          "symbolSize": 7,
          initialTreeDepth:-1,  //展开层级为全部展开
          "label":{
            "normal":{
              "show":true,
              "formatter":function(param){
                  return param.name
              },
            },
            "emphasis":{
              "show":false,
            }
          },

          "leaves": {//最底部文字样式
            "label": {
              "normal": {
                "position": 'bottom',
                "verticalAlign": 'middle',
                "align": 'middle',
                "show":true
              },
              "emphasis":{
                "show":false
              }
            }
          },

          "lineStyle":{//正常情况显示
            "color": 'red',
            "width": 1,
          },
          data: [treeObj],
          expandAndCollapse: true,    //子树折叠和展开的交互，默认打开
          animationDuration: 550,     //初始动画的时长，支持回调函数,默认1000
          animationDurationUpdate: 750//数据更新动画的时长，默认300

        }]
      },true);
    }
  },
  mounted() {
    this.generateTree()
  },
  watch:{
    treeJsonString(newValue,oldValue){
      if(newValue !== oldValue){
        this.generateTree()
      }
    }
  }
}
</script>

<style scoped>

</style>