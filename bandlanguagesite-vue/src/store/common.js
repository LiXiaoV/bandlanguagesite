//去除字符串左右两端的空格
export const trimSpaceLR=function(str){
    return str.replace(/(^\s*)|(\s*$)/g, "");
}