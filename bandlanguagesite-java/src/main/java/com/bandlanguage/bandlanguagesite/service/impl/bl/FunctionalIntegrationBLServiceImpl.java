package com.bandlanguage.bandlanguagesite.service.impl.bl;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.Environment;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.EnvironmentConst;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.script.Script;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.parser.BLLexer;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.parser.BLParser;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.parser.Visitor;
import com.bandlanguage.bandlanguagesite.service.BLService;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.springframework.stereotype.Service;

/**
 * @author xiaov
 * @since 2021-06-15 21:39
 */
@Service
public class FunctionalIntegrationBLServiceImpl implements BLService {
    @Override
    public String getAST(String script) {
        return null;
    }

    @Override
    public Object runScript(String script) {
        Environment environment = new Environment();
        //下面为测试用的部分数据
        environment.add("专家查询工具","专家查询工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("科技论文影响力指数查看工具","科技论文影响力指数查看工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("论文查询工具","论文查询工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("论文参考文献评价分析工具","论文参考文献评价分析工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("摄像头工具","摄像头工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("消息通知工具","消息通知工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("绩效考核工具","绩效考核工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("快递管理工具","快递管理工具", BLObjType.TOOLID, EnvironmentType.BAND);
        environment.add("任务分配工具","任务分配工具", BLObjType.TOOLID, EnvironmentType.BAND);
        EnvironmentConst.environment.set(environment);

//        String script = "显示 专家列表";
        CharStream input = CharStreams.fromString(script);
        BLLexer lexer = new BLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BLParser parser = new BLParser(tokens);
        ParseTree tree = parser.script();
        Visitor visitor = new Visitor();
        Script text = (Script) visitor.visit(tree);

        String res = "执行成功";

        text.run(null);

        if(environment.showForUser.size()>0){
            //将需要显示的内容返回给前端，具体返回一个还是多个，根据需要来确定
            res = environment.showForUser.poll();
        }
        environment.showForUser.clear();
        return res;
    }
}
