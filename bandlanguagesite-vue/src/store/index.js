import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state:{
        userInfo:JSON.parse(sessionStorage.getItem("userInfo"))
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
        }
    },
    getters:{
        // get
        getUser:state => {
            if(state.userInfo == null){
                let user = {}
                user["userId"] = 1
                user["username"] = "visitor"
                user["nickname"] = "游客"
                user["head"] = ""
                state.userInfo = user
                sessionStorage.setItem("userInfo",JSON.stringify(user))
            }
            return state.userInfo
        }
    },
    actions:{

    },
    modules:{

    }
})