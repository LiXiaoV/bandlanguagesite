package com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.parser;


import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.Node;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.element.*;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.PlaceAdv;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.PreposObj;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.phrase.TimeComp;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.Script;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.script.Stmt;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt.SubAdvPreAttrObjStmt;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt.SubAdvPreComAttrObjStmt;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt.SubPreAttrObjStmt;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.sentence.simpleStmt.SubPreObjStmt;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.Word;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.adjective.Adjective;

import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Identifier;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Num;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.common.Str;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.noun.Noun;
import com.bandlanguage.bandlanguagesite.compilecore.organizationmanage.node.word.verb.Verb;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyVisitor implements LanguageVisitor<Node> {

    public HashMap<String, String> wordMap = new HashMap<>();

    {
        String filePathString = "/Users/xiaov/IdeaProjects/bandlanguagesite/bandlanguagesite-java/src/main/java/com/bandlanguage/bandlanguagesite/compilecore/organizationmanage/parser/Word.cla";
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
        List<Stmt> tempList = new ArrayList<>();
        for (int i = 0; i < ctx.stmt().size(); i++) {
            tempList.add((Stmt) ctx.stmt(i).accept(this));
        }
        script.stmtList = tempList;
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
    public Node visitComplexStmt(LanguageParser.ComplexStmtContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitSubject_predicate_object_stmt(LanguageParser.Subject_predicate_object_stmtContext ctx) {
        SubPreObjStmt subPreObjStmt = new SubPreObjStmt();
        if (ctx.subject() != null){
            subPreObjStmt.subject = (Subject) ctx.subject().accept(this);
        }
        subPreObjStmt.predicate = (Predicate) ctx.predicate().accept(this);
        subPreObjStmt.object = (Obj) ctx.object().accept(this);
        return subPreObjStmt;
    }

    @Override
    public Node visitSubject_predicate_attribute_object_stmt(LanguageParser.Subject_predicate_attribute_object_stmtContext ctx) {
        SubPreAttrObjStmt subPreAttrObjStmt = new SubPreAttrObjStmt();
        if (ctx.subject() != null){
            subPreAttrObjStmt.subject = (Subject) ctx.subject().accept(this);
        }
        subPreAttrObjStmt.predicate = (Predicate) ctx.predicate().accept(this);
        subPreAttrObjStmt.attribute = (Attribute) ctx.attribute().accept(this);
        subPreAttrObjStmt.obj = (Obj) ctx.object().accept(this);
        return subPreAttrObjStmt;
    }

    @Override
    public Node visitSubject_adverbial_predicate_attribute_object_stmt(LanguageParser.Subject_adverbial_predicate_attribute_object_stmtContext ctx) {
        SubAdvPreAttrObjStmt subAdvPreAttrObjStmt = new SubAdvPreAttrObjStmt();
        if (ctx.subject() != null){
            subAdvPreAttrObjStmt.subject = (Subject) ctx.subject().accept(this);
        }
        if (ctx.attribute() != null){
            subAdvPreAttrObjStmt.attribute = (Attribute) ctx.attribute().accept(this);
        }
        subAdvPreAttrObjStmt.adverbial = (Adverbial) ctx.adverbial().accept(this);
        subAdvPreAttrObjStmt.predicate = (Predicate) ctx.predicate().accept(this);
        subAdvPreAttrObjStmt.obj = (Obj) ctx.object().accept(this);
        return subAdvPreAttrObjStmt;
    }

    @Override
    public Node visitSubject_adverbial_predicate_complement_attribute_object_stmt(LanguageParser.Subject_adverbial_predicate_complement_attribute_object_stmtContext ctx) {
        SubAdvPreComAttrObjStmt subAdvPreComAttrObjStmt = new SubAdvPreComAttrObjStmt();
        if (ctx.subject() != null){
            subAdvPreComAttrObjStmt.subject = (Subject) ctx.subject().accept(this);
        }
        if (ctx.adverbial() != null){
            subAdvPreComAttrObjStmt.adverbial = (Adverbial) ctx.adverbial().accept(this);
        }
        if (ctx.attribute() != null){
            subAdvPreComAttrObjStmt.attribute = (Attribute) ctx.attribute().accept(this);
        }
        subAdvPreComAttrObjStmt.predicate = (Predicate) ctx.predicate().accept(this);
        subAdvPreComAttrObjStmt.obj = (Obj) ctx.object().accept(this);
        subAdvPreComAttrObjStmt.complement = (Complement) ctx.complement().accept(this);
        return subAdvPreComAttrObjStmt;
    }

    @Override
    public Node visitIfStmt(LanguageParser.IfStmtContext ctx) {
        return null;
    }

    @Override
    public Node visitConcurrentStmt(LanguageParser.ConcurrentStmtContext ctx) {
        return null;
    }

    @Override
    public Node visitJudgeStmt(LanguageParser.JudgeStmtContext ctx) {
        return null;
    }

    @Override
    public Node visitSubject(LanguageParser.SubjectContext ctx) {
        Subject subject = new Subject();
        if (ctx.Identifier() != null){
            subject.identifier = (Identifier) ctx.Identifier().accept(this);
        }else{
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
        if (ctx.With() != null){
            Obj obj = new Obj();
            for (int i = 0; i < ctx.object().size(); i++) {
                obj.objWithObj.objList.add((Obj) ctx.object(i).accept(this));
            }
            //objConjObj.conjunction = (Conjunction) ctx.conjunction().accept(this);
            return obj;
        }else if (ctx.Of() != null){
            Obj obj = new Obj();
            for (int i = 0; i < ctx.object().size(); i++) {
                obj.objOfObj.objList.add((Obj) ctx.object(i).accept(this));
            }
            return obj;
        }else if (ctx.noun() != null){
            Obj obj = new Obj();
            obj.noun = (Noun) ctx.noun().accept(this);
            return obj;
        }else{
            Obj obj = new Obj();
            if (ctx.Number() != null)
                obj.num = (Num) ctx.Number().accept(this);
            else if (ctx.String() != null)
                obj.str = (Str) ctx.String().accept(this);
            else
                obj.identifier = (Identifier) ctx.Identifier().accept(this);
            return obj;
        }

    }

    @Override
    public Node visitAttribute(LanguageParser.AttributeContext ctx) {
        Attribute attribute = new Attribute();
        if (ctx.adjective() != null){
            attribute.adjective = (Adjective) ctx.adjective().accept(this);
        }else if (ctx.String() != null){
            attribute.str = (Str) ctx.String().accept(this);
        }else if(ctx.Identifier() != null){
            attribute.identifier = (Identifier) ctx.Identifier().accept(this);
        }else if(ctx.noun() != null){
            attribute.noun = (Noun) ctx.noun().accept(this);
        }
        return attribute;
    }

    @Override
    public Node visitAdverbial(LanguageParser.AdverbialContext ctx) {
        Adverbial adverbial = new Adverbial();
        if (ctx.place_adverbial() != null){
            adverbial.placeAdv = (PlaceAdv) ctx.place_adverbial().accept(this);
        }else{
            adverbial.preposObj = (PreposObj) ctx.preposition_object().accept(this);
        }
        return adverbial;
    }

    @Override
    public Node visitComplement(LanguageParser.ComplementContext ctx) {
        Complement complement = new Complement();
        if (ctx.time_complement() != null){
            complement.timeComp = (TimeComp) ctx.time_complement().accept(this);
        }
        return complement;
    }

    @Override
    public Node visitPlace_adverbial(LanguageParser.Place_adverbialContext ctx) {
        PlaceAdv placeAdv = new PlaceAdv();
        placeAdv.obj = (Obj) ctx.object().accept(this);
        return placeAdv;
    }

    @Override
    public Node visitPreposition_object(LanguageParser.Preposition_objectContext ctx) {
        PreposObj preposObj = new PreposObj();
        if (ctx.place_adverbial() != null){
            preposObj.placeAdv = (PlaceAdv) ctx.place_adverbial().accept(this);
        }
        if (ctx.attribute() != null){
            preposObj.attribute = (Attribute) ctx.attribute().accept(this);
        }
        preposObj.obj = (Obj) ctx.object().accept(this);
        return preposObj;
    }

    @Override
    public Node visitIsExist(LanguageParser.IsExistContext ctx) {
        return null;
    }

    @Override
    public Node visitNotExist(LanguageParser.NotExistContext ctx) {
        return null;
    }

    @Override
    public Node visitTime_complement(LanguageParser.Time_complementContext ctx) {
        return null;
    }


    @Override
    public Node visitComparator(LanguageParser.ComparatorContext ctx) {
        return null;
    }

    @Override
    public Node visitLogic_operator(LanguageParser.Logic_operatorContext ctx) {
        return null;
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
    public Node visitAdjective(LanguageParser.AdjectiveContext ctx) {
        return null;
    }

    @Override
    public Node visitPreposition(LanguageParser.PrepositionContext ctx) {
        return null;
    }

    @Override
    public Node visitDirection(LanguageParser.DirectionContext ctx) {
        return null;
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
        if (wordMap.containsKey(text)) {
            Word o = null;
            try{
                Class c = Class.forName(wordMap.get(text));
                Constructor constructor = c.getConstructor(String.class);
                o = (Word) constructor.newInstance(text);
                o.text = text;
            }catch (Exception e){
                System.out.println("实例化词节点出错：" + e.getMessage());
            }
            return o;
        }else if (terminalNode.getText().matches("[0-9]+")) {
            Num num = new Num();
            num.number = Integer.parseInt(text);
            return num;
        } else if (terminalNode.getText().startsWith("‘")) {
            Str str = new Str();
            str.text = text;
            return str;
        } else {
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
