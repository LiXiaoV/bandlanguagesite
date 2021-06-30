package com.bandlanguage.bandlanguagesite.environment;

import com.bandlanguage.bandlanguagesite.cache.IGlobalCache;
import com.bandlanguage.bandlanguagesite.cache.prefix.EnvironmentKey;
import com.bandlanguage.bandlanguagesite.constant.EnvironmentType;
import com.bandlanguage.bandlanguagesite.util.SpringContextUtils;

import java.util.Map;

/**
 *
 **/
public class EnvironmentManagement {

    private static volatile EnvironmentManagement instance;

    private static IGlobalCache cache;

    private EnvironmentManagement(){}

    public static EnvironmentManagement getInstance(){

        if(instance==null){
            synchronized (EnvironmentManagement.class){
                if(instance==null){
                    instance=new EnvironmentManagement();
                    cache= SpringContextUtils.getBean(IGlobalCache.class);
                }
            }
        }

        return instance;
    }

    /**
     * 获取语境的信息
     * 机构和帮语语境使推荐用
     * 获取语境,其中帮区和机构的语境先判断redis中是否有,没有则去创建并保存到语境中
     **/
    public Map<String,Object> getEnvironment(Long id, EnvironmentType environmentType) throws Exception {
        Environment environment=null;
        EnvironmentFactory factory=null;
        Map<String,Object> result;
        switch (environmentType){
            case ORGANIZATION_ENVIRONMENT:{
                factory=OrganizationEnvironmentFactory.getInstance();
                System.out.println("cache is null:");
                System.out.println(cache==null);
                if(/*redis中有记录*/cache.get(EnvironmentKey.instance.getPrefix() +"organization"+id)!=null){
                    return (Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix()+"organization"+id);
                }else{
                    environment=factory.createEnvironment(id);
                    if(environment==null){
                        /*此时肯定是在redis中存有信息*/
                        return (Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix()+"organization"+id);
                    }
                }
                break;
            }
            case BAND_ENVIRONMENT:{
                factory=BandEnvironmentFactory.getInstance();
                if(/*redis中有记录*/cache.get(EnvironmentKey.instance.getPrefix()+"band"+id)!=null){
                    return (Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix()+"band"+id);
                }else{
                    environment=factory.createEnvironment(id);
                    if(environment==null){
                        /*此时肯定是在redis中存有信息*/
                        return (Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix()+"band"+id);
                    }
                }
                break;
            }
            case SCRIPT_ENVIRONMENT:{
                factory=new ScriptEnvironmentFactory();
                environment=factory.createEnvironment(id);
                break;
            }
            default:{
                throw new IllegalArgumentException("没有该类型的语境");
            }
        }

        return environment.getEnvironment();
    }

    public Map<String,Object> updateEnvironment(Long id,EnvironmentType environmentType) throws Exception{
        Environment environment=null;
        Map<String,Object> result=null;

        switch (environmentType){
            case ORGANIZATION_ENVIRONMENT:{
                environment=OrganizationEnvironmentFactory.getInstance().updateEnvironment(id);
                if(environment==null){
                    result= (Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix()+"organization"+id);
                }
                break;
            }
            case BAND_ENVIRONMENT:{
                environment=BandEnvironmentFactory.getInstance().updateEnvironment(id);
                if(environment==null){
                    result= (Map<String, Object>) cache.get(EnvironmentKey.instance.getPrefix()+"band"+id);
                }
                break;
            }
            case SCRIPT_ENVIRONMENT:{
                return null;
            }
        }

        if(environment!=null){
            result=environment.getEnvironment();
        }

        return result;
    }

    /**
     * 获取语境对象
     * 推荐剧本语境使用，需要更新机构和帮区语境时可使用，创建语境
     **/
    private Environment getEnvironmentObject(Long id, EnvironmentType environmentType) throws Exception{
        Environment environment=null;
        EnvironmentFactory factory=null;
        switch (environmentType){
            case ORGANIZATION_ENVIRONMENT:{
                factory=OrganizationEnvironmentFactory.getInstance();
                break;
            }
            case BAND_ENVIRONMENT:{
                factory=BandEnvironmentFactory.getInstance();
                break;
            }
            case SCRIPT_ENVIRONMENT:{
                factory=new ScriptEnvironmentFactory();
                break;
            }
            default:{
                throw new IllegalArgumentException("没有该类型的语境");
            }
        }
        environment=factory.createEnvironment(id);
        return environment;
    }

}
