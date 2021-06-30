import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        userInfo:JSON.parse(sessionStorage.getItem("userInfo")),
        isLogin: sessionStorage.getItem("isLogin"),
        scriptSelected:{
            isSelected:false,
            text:"tttttttext",
            sceneId:0,
            isSceneSelected:false,
        },
        contextPanelVisible:true,
        currentSceneId:0,
    },
    mutations:{
        // set
        SET_USERINFO:(state,userInfo) => {
            state.userInfo = userInfo
            sessionStorage.setItem("userInfo",JSON.stringify(userInfo))
        },
        REMOVE_INFO:(state) => {
            state.userInfo = {}
            sessionStorage.setItem("userInfo",JSON.stringify(''))
        },
        SET_IS_LOGIN(state,value){
            state.isLogin = value
            sessionStorage.setItem("isLogin",value)
        },
        SET_SCRIPT_SELECTED:(state,selectionInfo)=>{
            state.scriptSelected.isSelected=selectionInfo.isSelected;
            if(selectionInfo.text!=null){
                state.scriptSelected.text=selectionInfo.text;
            }        
            if(selectionInfo.sceneId!=null){
                state.scriptSelected.sceneId=selectionInfo.sceneId;
            }
            if(selectionInfo.isSceneSelected!=null){
                state.scriptSelected.isSceneSelected=selectionInfo.isSceneSelected;
            }  
        },
        SET_CONTEXT_PANEL_VISIBLE:(state,value)=>{
            state.contextPanelVisible=value;
        },
        SET_CURRENT_SCENE_ID:(state,value)=>{
            state.currentSceneId=value;
        },
    },
    getters:{
        // get
        getUser:state => {
            // if(state.userInfo == null){
            //     let user = {}
            //     user["userID"] = 28
            //     user["myBandID"] = 29
            //     user["userStatus"] = "NORMAL"
            //     user["userAccount"] = "wtbpublic"
            //     user["userName"] = "游客"
            //     user["representPositionID"] = 163
            //     state.userInfo = user
            //     sessionStorage.setItem("userInfo",JSON.stringify(user))
            // }
            return state.userInfo
        },
        getIsLogin:state => {
            return state.isLogin
        },
        getScriptSelected:state=>{
            return state.scriptSelected;
        },
        getContextPanelVisible:state=>{
            return state.contextPanelVisible;
        },
        getCurrentSceneId:state=>{
            return state.currentSceneId;
        },
    },
    actions:{

    },
    modules:{

    }
})