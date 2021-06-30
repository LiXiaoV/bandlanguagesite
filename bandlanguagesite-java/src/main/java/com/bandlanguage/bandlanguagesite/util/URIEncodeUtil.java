package com.bandlanguage.bandlanguagesite.util;

import java.net.URLEncoder;

public class URIEncodeUtil {

	public static String encodeURI(String param) throws Exception{
		String result = "";
		for (int i = 0; i < param.length(); i++) {
			char charIndex = param.charAt(i);
			if (isChinese(charIndex )) {
				//如果是中文，则对中文转码
				result += URLEncoder.encode(charIndex+"","UTF-8");
			}else if(!ignoredCharacter(charIndex)){
				result += URLEncoder.encode(charIndex+"","UTF-8");
			}
			else if(isEscapeCharacter(charIndex)) {
				result+=URLEncoder.encode(""+charIndex+param.charAt(i+1),"UTF-8");
				//跳过一个字符(已被编码过了)
				i++;
			}
			else {
				result+=charIndex;
			}
		}
		return result;
	}
	
	public static boolean isChinese(char c) {
        return String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }

	private static boolean ignoredCharacter(char c){
		if(c=='+'||c==' '||c=='/'||c=='?'||c=='%'||c=='#'||c=='&'||c=='=') {
			return true;
		}else {
			return false;
		}
	}
	
	private static boolean isEscapeCharacter(char first) {
		if(first=='\\'){
			return true;
		}
				
		return false;
	}

}
