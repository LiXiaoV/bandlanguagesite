export default {
    activePath: "/",
    // serverUrl: "http://192.168.88.145:8888",
    serverUrl: "http://localhost:8888",
    salt: "wetoband.com",
    defaultUser:{
        userId: 1,
        username: "visitor",
        nickname: "游客",
        head: "",
    },
    setActivePath(path){
        this.activePath = path
    },
}