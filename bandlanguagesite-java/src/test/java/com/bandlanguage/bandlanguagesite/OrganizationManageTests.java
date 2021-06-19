package com.bandlanguage.bandlanguagesite;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.Script;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser.LanguageLexer;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser.LanguageParser;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser.MyVisitor;
import com.bandlanguage.bandlanguagesite.compilecore.utils.TreeUtils;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author xiaov
 * @since 2021-06-10 20:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganizationManageTests {

    @Test
    public void testCompile() {
        String script = "在 测试开发部 中，创建 ‘运维开发部’ 子部门。";
        CharStream input = CharStreams.fromString(script);
        long startTime = System.currentTimeMillis();

        // 文法-标记
        LanguageLexer lexer = new LanguageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        long endTime = System.currentTimeMillis();
        System.out.println("词法程序运行时间：" + (endTime - startTime) + "ms");
        long startTime1 = System.currentTimeMillis();

        // 满足规则
        LanguageParser parser = new LanguageParser(tokens);
        // 生成树推到语法树
        ParseTree tree = parser.script();
        System.out.println("tree.toStringTree() = " + TreeUtils.printSyntaxTree(parser,tree));
        long endTime1 = System.currentTimeMillis();
        System.out.println("语法程序运行时间：" + (endTime1 - startTime1) + "ms");

        // 关联数据到类，去掉不需要的中间推导
        MyVisitor myVisitor = new MyVisitor();
        Script text = (Script) myVisitor.visit(tree);
        boolean res = text.run("");
        System.out.println("res = " + res);
    }
}
