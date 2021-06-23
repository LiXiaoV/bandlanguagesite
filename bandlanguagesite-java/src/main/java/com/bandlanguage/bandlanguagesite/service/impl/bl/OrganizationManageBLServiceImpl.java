package com.bandlanguage.bandlanguagesite.service.impl.bl;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.Script;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser.LanguageLexer;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser.LanguageParser;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser.MyVisitor;
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
 * @since 2021-06-15 10:22
 */
@Service
public class OrganizationManageBLServiceImpl implements BLService {
    @Override
    public String getAST(String script) {
        CommonTokenStream tokens = getCommonTokenStream(script.trim());
        LanguageParser parser = new LanguageParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree parseTree = parser.script();
        return TreeUtils.printSyntaxTree(parser, parseTree);
    }

    @Override
    public Object runScript(String script) {
        CommonTokenStream tokens = getCommonTokenStream(script.trim());
        LanguageParser parser = new LanguageParser(tokens);
        ParseTree parseTree = parser.script();

        MyVisitor myVisitor = new MyVisitor();
        Script text = (Script) myVisitor.visit(parseTree);
        return text.run("");
    }

    private CommonTokenStream getCommonTokenStream(String script){
        CharStream input = CharStreams.fromString(script);
        LanguageLexer lexer = new LanguageLexer(input);
        return new CommonTokenStream(lexer);
    }
}
