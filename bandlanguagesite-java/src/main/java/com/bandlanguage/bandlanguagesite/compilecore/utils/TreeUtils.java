package com.bandlanguage.bandlanguagesite.compilecore.utils;

import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//antlr树形结构生成类
public class TreeUtils {
    static private Map<String, String> names = new HashMap<>();
    static{
        names.put("script", "剧本");
        names.put("stmt", "语句");
        names.put("simpleStmt", "简单句");
        names.put("complexStmt", "复杂句");
        names.put("subject_predicate_attribute_object_stmt", "主谓定宾句");
        names.put("subject_predicate_object_stmt", "主谓宾句");
        names.put("subject_adverbial_predicate_attribute_object_stmt", "主状谓定宾句");
        names.put("subject_adverbial_predicate_complement_attribute_object_stmt", "主状谓补定宾句");
        names.put("ifStmt", "如果句");
        names.put("concurrentStmt", "并列句");
        names.put("judgeStmt", "判断句");
        names.put("subject", "主语");
        names.put("predicate", "谓语");
        names.put("attribute", "定语");
        names.put("object", "宾语");
        names.put("adverbial", "状语");
        names.put("complement", "补语");
        names.put("place_adverbial", "地点状语");
        names.put("numberals", "数量词");
        names.put("comparator", "比较词");
        names.put("conjunction", "介词");
        names.put("noun", "名词");
        names.put("verb", "动词");
        names.put("adjective", "形容词");
        names.put("preposition", "介词");
        names.put("direction", "方位词");

    }

    public static String printSyntaxTree(Parser parser, ParseTree root) {
        StringBuilder buf = new StringBuilder();
        recursive(root, buf, 0, Arrays.asList(parser.getRuleNames()));
        return buf.toString();
    }

    private static void recursive(ParseTree aRoot, StringBuilder buf, int offset, List<String> ruleNames) {
        if(offset == 0){
            buf.append("{");
        }
        String s = Trees.getNodeText(aRoot, ruleNames);
        if (names.containsKey(Trees.getNodeText(aRoot, ruleNames))){
            s = names.get(Trees.getNodeText(aRoot, ruleNames));
        }
        buf.append("\"name\":\""+ s).append("\",");
        if (aRoot instanceof ParserRuleContext) {
            ParserRuleContext prc = (ParserRuleContext) aRoot;
            if (prc.children != null) {
                buf.append("\"children\":[");
                for (ParseTree child : prc.children) {
                    buf.append("{");
                    recursive(child, buf, offset + 1, ruleNames);
                    buf.append(",");
                }
            }
            buf.append("]");
        }
        buf.append("}");
    }

}
