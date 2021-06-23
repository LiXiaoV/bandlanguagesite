package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.parser;

import com.alibaba.fastjson.JSONObject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.Node;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.Adverbial;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.commonadverbial.CommonAdverbial1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.placeadverbial.PlaceAdverbial1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.adverbial.timeadverbial.TimeAdverbial1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.attribute.Attribute;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.attribute.Attribute1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.attribute.Attribute2;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.B_Object;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.Object1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.ObjectSingle;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.ObjectSplit;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.objectsingle.ObjectSingle1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.objectsingle.ObjectSingle2;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.objectsingle.ObjectSingle3;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.object.objectsingle.ObjectSingle4;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate.Predicate;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.predicate.Predicate1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.subject.Subject;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.element.subject.Subject1;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.Script;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.Stmt;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex.*;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.simple.*;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.ObjName;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.Str;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.Word;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.adjective.Adjective;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.adjective.Old;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.compare.*;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.noun.*;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.numerals.Number;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.numerals.Numerals;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.quantifiers.Ge;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.time.Time;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.time.Today;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb.*;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb.sort.SortAscending;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.word.real.verb.sort.SortDescending;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Visitor implements BLVisitor<Node> {

    public Map<String, Word> wordMap = new HashMap<>();
    {
        wordMap.put("显示", new Show());
        wordMap.put("执行", new Execute());
        wordMap.put("得到", new Get());
        wordMap.put("找出", new Find());
        wordMap.put("去掉", new Remove());
        wordMap.put("求", new Qiu());
        wordMap.put("设定", new Set());
        wordMap.put("统计", new Count());
        wordMap.put("进行", new CarryOut());
        wordMap.put("升序排序", new SortAscending());
        wordMap.put("降序排序", new SortDescending());
        wordMap.put("进行分组", new Group());
        wordMap.put("输入部件", new InputPart());
        wordMap.put("输出部件", new OutputPart());
        wordMap.put("元素", new Element());
        wordMap.put("记录", new Element());
        wordMap.put("数量", new Amount());
        wordMap.put("数据", new Data());
        wordMap.put("最大值", new Max());
        wordMap.put("最小值", new Min());
        wordMap.put("平均值", new Average());
        wordMap.put("今天", new Today());
        wordMap.put("个", new Ge());
        wordMap.put("老的", new Old());
        wordMap.put("等于", new Equals());
        wordMap.put("=", new Equals());
        wordMap.put("大于", new MoreThan());
        wordMap.put(">", new MoreThan());
        wordMap.put("小于", new LessThan());
        wordMap.put("<", new LessThan());
        wordMap.put("不等于", new NoEquals());
        wordMap.put("!=", new NoEquals());
        wordMap.put("不大于", new NoMoreThan());
        wordMap.put("<=", new NoMoreThan());
        wordMap.put("不小于", new NoLessThan());
        wordMap.put(">=", new NoLessThan());
        wordMap.put("改成", new Change());
        wordMap.put("新建", new NewObj());
        wordMap.put("重命名为", new Rename());
        wordMap.put("合并成为", new Merge());
    }

    @Override
    public Node visitScript(BLParser.ScriptContext ctx) {
        Script script = new Script();
        List<Stmt> list = new LinkedList<>();
        List<BLParser.StmtContext> stmtContextList = ctx.stmt();
        for (BLParser.StmtContext context : stmtContextList){
            Stmt stmt = (Stmt) context.accept(this);
            list.add(stmt);
        }
        script.lists = list;

        script.text = ctx.getText();
        return script;
    }

    @Override
    public Node visitStmt(BLParser.StmtContext ctx) {
        return ctx.children.get(0).accept(this);
    }

    @Override
    public Node visitSimpleStmt(BLParser.SimpleStmtContext ctx) {
        return ctx.children.get(0).accept(this);
    }

    @Override
    public Node visitPredicate_adverbial_attribute_object_stmt(BLParser.Predicate_adverbial_attribute_object_stmtContext ctx) {
        SimpleStmt1 simpleStmt1 = new SimpleStmt1();

        simpleStmt1.predicate = (Predicate) ctx.predicate().accept(this);
        simpleStmt1.adverbial = (Adverbial) ctx.adverbial().accept(this);
        simpleStmt1.attribute = (Attribute) ctx.attribute().accept(this);
        simpleStmt1.BObject = (B_Object) ctx.object().accept(this);

        simpleStmt1.text = ctx.getText();
        return simpleStmt1;
    }

    @Override
    public Node visitPredicate_adverbial_object_stmt(BLParser.Predicate_adverbial_object_stmtContext ctx) {
        SimpleStmt5 simpleStmt5 = new SimpleStmt5();

        simpleStmt5.predicate = (Predicate) ctx.predicate().accept(this);
        simpleStmt5.adverbial = (Adverbial) ctx.adverbial().accept(this);
        simpleStmt5.BObject = (B_Object) ctx.object().accept(this);

        simpleStmt5.text = ctx.getText();
        return simpleStmt5;
    }

    @Override
    public Node visitPredicate_attribute_object_stmt(BLParser.Predicate_attribute_object_stmtContext ctx) {
        SimpleStmt2 simpleStmt2 = new SimpleStmt2();

        simpleStmt2.predicate = (Predicate) ctx.predicate().accept(this);
        simpleStmt2.attribute = (Attribute) ctx.attribute().accept(this);
        simpleStmt2.BObject = (B_Object) ctx.object().accept(this);

        simpleStmt2.text = ctx.getText();
        return simpleStmt2;
    }

    @Override
    public Node visitSubject_predicate_object_stmt(BLParser.Subject_predicate_object_stmtContext ctx) {
        SimpleStmt3 simpleStmt3 = new SimpleStmt3();

        simpleStmt3.subject = (Subject) ctx.subject().accept(this);
        simpleStmt3.predicate = (Predicate) ctx.predicate().accept(this);
        simpleStmt3.BObject = (B_Object) ctx.object().accept(this);

        simpleStmt3.text = ctx.getText();
        return simpleStmt3;
    }

    @Override
    public Node visitPredicate_object_stmt(BLParser.Predicate_object_stmtContext ctx) {
        SimpleStmt4 simpleStmt4 = new SimpleStmt4();

        simpleStmt4.predicate = (Predicate) ctx.predicate().accept(this);
        simpleStmt4.BObject = (B_Object) ctx.object().accept(this);

        simpleStmt4.text = ctx.getText();
        return simpleStmt4;
    }

    @Override
    public Node visitCompare_stmt(BLParser.Compare_stmtContext ctx) {
        CompareStmt compareStmt = new CompareStmt();
        compareStmt.compare = (Compare) ctx.compare().accept(this);
        compareStmt.text = ctx.getText();
        return compareStmt;
    }

    @Override
    public Node visitComplexStmt(BLParser.ComplexStmtContext ctx) {
        return ctx.children.get(0).accept(this);
    }

    @Override
    public Node visitRunToolStmt(BLParser.RunToolStmtContext ctx) {
        RunToolStmt runToolStmt = new RunToolStmt();

        if(ctx.AsParam() != null){
            //是第二种表示.直接返回第二种节点---规则没写好
            RunToolStmt0 r = new RunToolStmt0();
            r.objName = ctx.ObjName().getText();
            return r;
        }
        List<BLParser.Predicate_object_stmtContext> predicate_object_stmtContexts = ctx.predicate_object_stmt();
        runToolStmt.mainStmt = (SimpleStmt4) predicate_object_stmtContexts.get(0).accept(this);
        if(predicate_object_stmtContexts.size()>1){
            runToolStmt.saveStmt = (SimpleStmt4) predicate_object_stmtContexts.get(1).accept(this);
        }
        List<BLParser.CompareContext> compare_stmtContexts = ctx.compare();
        if(compare_stmtContexts.size()>0){
            runToolStmt.conditionList = new LinkedList<>();
            for (BLParser.CompareContext context: compare_stmtContexts){
                runToolStmt.conditionList.add((Compare)context.accept(this));
            }
        }
        runToolStmt.text = ctx.getText();
        return runToolStmt;
    }

    @Override
    public Node visitSetStmt(BLParser.SetStmtContext ctx) {
        SetStmt setStmt = new SetStmt();
        String text = ctx.Str().get(0).getText();
        setStmt.mainString = text.substring(1,text.length()-1);

        if(null != ctx.stmt()){
            setStmt.value = ctx.stmt().accept(this);
            setStmt.enumType = SetValueEnum.STMT;
        }

        if(null != ctx.Number()){
            setStmt.value = ctx.Number().getText();
            setStmt.enumType = SetValueEnum.NUMBER;
        }

        if(null != ctx.object()){
            setStmt.value = ctx.object().accept(this);
            setStmt.enumType = SetValueEnum.OBJ;
        }

        if(ctx.Str().size()>1){
            String mainString = ctx.Str().get(1).getText();
            setStmt.value = mainString.substring(1,mainString.length()-1);
            setStmt.enumType = SetValueEnum.STRING;
        }
        setStmt.text = ctx.getText();
        return setStmt;
    }

    @Override
    public Node visitSortStmt(BLParser.SortStmtContext ctx) {
        SortStmt sortStmt = new SortStmt();

        String mainString = ctx.ObjName(0).getText();
        sortStmt.para = mainString;

        sortStmt.objName = ctx.ObjName(1).getText();
        sortStmt.type = ctx.sort().SortAscending() == null ? 1 : -1;
        sortStmt.text = ctx.getText();
        return sortStmt;
    }

    @Override
    public Node visitGroupStmt(BLParser.GroupStmtContext ctx) {
        GroupStmt groupStmt = new GroupStmt();

        String mainString = ctx.Str().getText();
        groupStmt.para = mainString.substring(1,mainString.length()-1);

        groupStmt.objName = ctx.ObjName().getText();
        groupStmt.text = ctx.getText();
        return groupStmt;
    }

    @Override
    public Node visitBaStmt(BLParser.BaStmtContext ctx) {
        BaStmt baStmt = new BaStmt();
        baStmt.text = ctx.getText();
        baStmt.object = (B_Object) ctx.object().accept(this);
        baStmt.verb = (Verb) ctx.verb().accept(this);
        baStmt.objectSingle = (ObjectSingle) ctx.object_single().accept(this);
        if(ctx.Str() != null){
            String mainString = ctx.Str().getText();
            baStmt.condition = mainString.substring(1,mainString.length()-1);
        }
        return baStmt;
    }

    @Override
    public Node visitNewObj(BLParser.NewObjContext ctx) {
        NewObjStmt newObjStmt = new NewObjStmt();
        newObjStmt.text = ctx.getText();

        String mainString = ctx.Str().getText();
        newObjStmt.name = mainString.substring(1,mainString.length()-1);

        newObjStmt.verb = new NewObj();

        List<BLParser.CompareContext> compare_stmtContexts = ctx.compare();
        if(compare_stmtContexts.size()>0){
            newObjStmt.conditionList = new LinkedList<>();
            for (BLParser.CompareContext context: compare_stmtContexts){
                newObjStmt.conditionList.add((Compare)context.accept(this));
            }
        }
        return newObjStmt;
    }

    @Override
    public Node visitSubject(BLParser.SubjectContext ctx) {
        Subject1 subject1 = new Subject1();
        subject1.string = ctx.ObjName().getText();
        subject1.text = ctx.getText();
        return subject1;
    }

    @Override
    public Node visitObject(BLParser.ObjectContext ctx) {
        Object1 object1 = new Object1();
        object1.list.add((ObjectSingle) ctx.object_single(0).accept(this));
        int num = ctx.object_single().size();
        for(int i=1; i<num; i++){
            object1.list.add((ObjectSingle) ctx.object_single(i).accept(this));
            object1.splits.add((ObjectSplit) ctx.object_split(i-1).accept(this));
        }

        object1.text = ctx.getText();
        return object1;
    }

    @Override
    public Node visitObject_split(BLParser.Object_splitContext ctx) {
        ObjectSplit objectSplit = new ObjectSplit();
        objectSplit.split = (Word) ctx.Split().accept(this);
        objectSplit.text = ctx.getText();
        return objectSplit;
    }

    @Override
    public Node visitObject_single(BLParser.Object_singleContext ctx) {
        if(ctx.Str() != null){
            ObjectSingle1 res = new ObjectSingle1();
            Str str = new Str();
            str.text = ctx.Str().getText();
            res.str = str;
            res.text = ctx.getText();
            return res;
        }

        if(ctx.time() != null){
            ObjectSingle2 res = new ObjectSingle2();
            Time time = (Time) ctx.time().accept(this);
            res.time = time;
            res.text = ctx.getText();
            return res;
        }

        if(ctx.numerals() != null){
            ObjectSingle3 res = new ObjectSingle3();
            Numerals numerals = (Numerals) ctx.numerals().accept(this);
            res.numerals = numerals;
            res.text = ctx.getText();
            return res;
        }


        ObjectSingle4 res = new ObjectSingle4();
        ParseTree first = ctx.getChild(0);
        if(first instanceof BLParser.NounContext){
            res.first = first.accept(this);
        }else{
            ObjName f = new ObjName();
            f.text = first.getText();
            res.first = f;
        }

        for(int i=2;i<ctx.getChildCount();i=i+2){
            ParseTree second = ctx.getChild(i);
            if(second instanceof BLParser.NounContext){
                res.after.add(second.accept(this));
            }else{
                ObjName f = new ObjName();
                f.text = second.getText();
                res.after.add(f);
            }
        }
        res.text = ctx.getText();
        return res;

    }

    @Override
    public Node visitPredicate(BLParser.PredicateContext ctx) {
        Predicate1 predicate1 = new Predicate1();
        predicate1.verb = (Verb) ctx.verb().accept(this);
        predicate1.text = ctx.getText();
        return predicate1;
    }

    @Override
    public Node visitAttribute(BLParser.AttributeContext ctx) {
        //情况二
        if(ctx.adjective() != null){
            Attribute1 attribute1 = new Attribute1();
            attribute1.text = ctx.getText();
            attribute1.adjective = (Adjective) ctx.adjective().accept(this);
            return attribute1;
        }

        //情况一
        if(ctx.compare() != null){
            Attribute2 attribute2 = new Attribute2();
            attribute2.text = ctx.getText();
            attribute2.compare = (Compare) ctx.compare(0).accept(this);
            return attribute2;
        }

        return null;
    }

    @Override
    public Node visitAdverbial(BLParser.AdverbialContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitPlace_adverbial(BLParser.Place_adverbialContext ctx) {
        PlaceAdverbial1 placeAdverbial1 = new PlaceAdverbial1();
        placeAdverbial1.string = ctx.ObjName().getText();
        placeAdverbial1.text = ctx.getText();
        return placeAdverbial1;
    }

    @Override
    public Node visitTime_adverbial(BLParser.Time_adverbialContext ctx) {
        TimeAdverbial1 timeAdverbial1 = new TimeAdverbial1();
        timeAdverbial1.time = ctx.time().accept(this);
        timeAdverbial1.text = ctx.getText();
        return timeAdverbial1;
    }

    @Override
    public Node visitCommon_adverbial(BLParser.Common_adverbialContext ctx) {
        CommonAdverbial1 commonAdverbial1 = new CommonAdverbial1();
        commonAdverbial1.string = ctx.ObjName().getText();
        commonAdverbial1.text = ctx.getText();
        return commonAdverbial1;
    }

    @Override
    public Node visitNoun(BLParser.NounContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitVerb(BLParser.VerbContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitAdjective(BLParser.AdjectiveContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitNumerals(BLParser.NumeralsContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitQuantifiers(BLParser.QuantifiersContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitTime(BLParser.TimeContext ctx) {
        Today today = new Today();
        today.text = ctx.getText();
        return today;
    }

    @Override
    public Node visitCompareWord(BLParser.CompareWordContext ctx) {
        return ctx.getChild(0).accept(this);
    }

    @Override
    public Node visitCompare(BLParser.CompareContext ctx) {
        Compare compare = new Compare();
        compare.first = (B_Object) ctx.object(0).accept(this);
        compare.second = (B_Object) ctx.object(1).accept(this);
        compare.compare = (CompareWord) ctx.compareWord().accept(this);
        compare.text = ctx.getText();
        return compare;
    }

    @Override
    public Node visitSort(BLParser.SortContext ctx) {
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
        //从map中找到对应的实例
        String text = terminalNode.getText();
        Word word;
        if(wordMap.containsKey(terminalNode.getText())){
            Word word0 = wordMap.get(terminalNode.getText());
            JSONObject jsonObject = (JSONObject) JSONObject.toJSON(word0);
            word = jsonObject.toJavaObject(word0.getClass());
        }else if(terminalNode.getText().matches("[0-9]+")){
            word = new Number();
        } else {
            word = new Str();
        }
        word.text = text;
        return word;
    }

    @Override
    public Node visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
