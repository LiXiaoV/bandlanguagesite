package com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.parser;

import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.Node;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element.Obj;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.element.Subject;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.script.Script;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.script.Stmt;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.sentence.simpleStmt.SubPreObjStmt;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.Word;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.common.Identifier;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.common.Num;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.common.Str;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.noun.Noun;
import com.bandlanguage.bandlanguagesite.compilecore.papersanalysis.node.word.verb.Verb;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xiaov
 * @since 2021-06-11 16:11
 */
public class MyVisitor implements LanguageVisitor<Node>{

    public HashMap<String, String> wordMap = new HashMap<>();

    {
        String filePathString = "/Users/xiaov/IdeaProjects/bandlanguagesite/bandlanguagesite-java/src/main/java/com/bandlanguage/bandlanguagesite/compilecore/papersanalysis/parser/Word.cla";
        try{
            InputStreamReader fReader = new InputStreamReader(new FileInputStream(filePathString),"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(fReader);
            String tempString = null;
            while ((tempString = bufferedReader.readLine()) != null){
                String[] stringList = tempString.split(" ");
                wordMap.put(stringList[0], stringList[1]);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Node visitScript(LanguageParser.ScriptContext ctx) {
        Script script = new Script();
        ArrayList<Stmt> stmtList = new ArrayList<>();
        for (LanguageParser.StmtContext stmtContext : ctx.stmt()) {
            stmtList.add((Stmt) stmtContext.accept(this));
        }
        script.stmtList = stmtList;
        return script;
    }

    @Override
    public Node visitStmt(LanguageParser.StmtContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitSimpleStmt(LanguageParser.SimpleStmtContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitSubject_predicate_object_stmt(LanguageParser.Subject_predicate_object_stmtContext ctx) {
        SubPreObjStmt subPreObjStmt = new SubPreObjStmt();
        if(ctx.subject() != null) {
            subPreObjStmt.subject = (Subject) ctx.subject().accept(this);
        }
        subPreObjStmt.predicate = (Predicate) ctx.predicate().accept(this);
        subPreObjStmt.object = (Obj) ctx.object().accept(this);
        return subPreObjStmt;
    }

    @Override
    public Node visitSubject(LanguageParser.SubjectContext ctx) {
        Subject subject = new Subject();
        if(ctx.Identifier() != null){
            subject.identifier = (Identifier) ctx.Identifier().accept(this);
        }else {
            subject.loginUser = 4032L;
        }
        return subject;
    }

    @Override
    public Node visitPredicate(LanguageParser.PredicateContext ctx) {
        Predicate predicate = new Predicate();
        predicate.verb = (Verb) ctx.getChild(0).accept(this);
        return predicate;
    }

    @Override
    public Node visitObject(LanguageParser.ObjectContext ctx) {
        if(ctx.noun() != null){
            Obj obj = new Obj();
            obj.noun = (Noun) ctx.noun().accept(this);
            return obj;
        }else {
            Obj obj = new Obj();
            if(ctx.Number() != null){
                obj.num = (Num) ctx.Number().accept(this);
            }else if(ctx.String() != null){
                obj.str = (Str) ctx.String().accept(this);
            }else {
                obj.identifier = (Identifier) ctx.Identifier().accept(this);
            }
            return obj;
        }
    }

    @Override
    public Node visitNoun(LanguageParser.NounContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitVerb(LanguageParser.VerbContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visit(ParseTree parseTree) {
        return parseTree.accept(this);
    }

    @Override
    public Node visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Node visitTerminal(TerminalNode terminalNode) {
        String text = terminalNode.getText();
        if(wordMap.containsKey(text)){
            Word word = null;
            try {
                Class c = Class.forName(wordMap.get(text));
                Constructor constructor = c.getConstructor(String.class);
                word = (Word) constructor.newInstance(text);
                word.text = text;
            } catch (Exception e) {
                System.out.println("实例化词节点出错：" + e.getMessage());
            }
            return word;
        }else if(text.matches("[0-9]+")){
            Num num = new Num();
            num.number = Integer.parseInt(text);
            return num;
        }else if(text.startsWith("‘")){
            Str str = new Str();
            str.text = text;
            return str;
        }else {
            Identifier identifier = new Identifier();
            identifier.text = text;
            return identifier;
        }
    }

    @Override
    public Node visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
