package com.bandlanguage.bandlanguagesite.service.impl.bl;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.script.Script;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.parser.LanguageLexer;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.parser.LanguageParser;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.parser.MyVisitor;
import com.bandlanguage.bandlanguagesite.compilecore.utils.ThrowingErrorListener;
import com.bandlanguage.bandlanguagesite.compilecore.utils.TreeUtils;
import com.bandlanguage.bandlanguagesite.service.BLService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

/**
 * @author xiaov
 * @since 2021-06-15 10:28
 */
@Service
public class PapersAnalysisBLServiceImpl implements BLService {
    @Override
    public String getAST(String script) {
        CommonTokenStream tokens = getCommonTokenStream(script.trim());
        LanguageParser parser = new LanguageParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree parseTree = parser.script();
        return TreeUtils.printSyntaxTree(parser,parseTree);
    }

    @Override
    public Object runScript(String script) {
        CommonTokenStream tokens = getCommonTokenStream(script.trim());

        // 满足规则
        LanguageParser parser = new LanguageParser(tokens);
        // 生成树推到语法树
        ParseTree tree = parser.script();

        // 关联数据到类，去掉不需要的中间推导
        MyVisitor myVisitor = new MyVisitor();
        Script text = (Script) myVisitor.visit(tree);
        return text.run("");
    }

    private CommonTokenStream getCommonTokenStream(String script){
        CharStream input = CharStreams.fromString(script);

        // 文法-标记
        LanguageLexer lexer = new LanguageLexer(input);
        return new CommonTokenStream(lexer);
    }
}
