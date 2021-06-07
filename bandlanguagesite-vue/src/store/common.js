//去除字符串左右两端的空格
export const trimSpaceLR=function(str){
    return str.replace(/(^\s*)|(\s*$)/g, "");
}

//在“yyyy-MM-dd HH:mm:ss”格式的字符串中获取年月日
export const getYMD=function(str){
    return str.substr(0,10);
}