package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment;

import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.EnvironmentType;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.BLObj;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.Band;
import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.wetoband.Organization;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 语境
 */
public class Environment {
    public Organization organization; //该剧本的机构环境(帮区环境在里面，但不从这里访问)
    public Band band; //该剧本的帮区环境(在这里访问帮区环境)
    public List<BLObj> scriptEnvironment; //剧本内部环境
    public int place; //分割全局环境和单句环境的标识，其中0-place为全局环境，place之后是单句环境(包括place)

//    存储要显示给用户的内容
    public Queue<String> showForUser = new LinkedList<String>();

//    保存用户选择的句子的执行方法，按照句子顺序进行存储和拿取
    public Queue<String> methodChoosed = new LinkedList<String>();

    public Environment(){
//        String oname = "华南理工大学B8科研实验室";
//        String bname = "办公室";
//        //初始化机构环境
//        List<Organization> olists = WTBConst.organizations;
//
//        for (Organization a :olists){
//            if(a.name.equals(oname)){
//                this.organization = a;
//            }
//        }
//        //初始化帮区环境
//        List<Band> blists = this.organization.bands;
//        for (Band a :blists){
//            if(a.name.equals(bname)){
//                this.band = a;
//            }
//        }

        this.organization = new Organization();
        this.band = new Band();
        this.scriptEnvironment = new LinkedList<BLObj>();
        this.place = 0;
    }

    /**
     * 清空栈
     */
    public void cleanStack(){
        while (this.scriptEnvironment.size()>this.place){
            this.scriptEnvironment.remove(this.place);
        }
    }

    /**
     * 在语境中，查找某一个词所对应的具体内容
     * 查找顺序: 单句环境-全局环境-帮区环境-机构环境
     * @param key 词
     * @return
     */
    public BLObj find(String key){
        BLObj res = findInStack(key);
        if(res != null){
            return res;
        }

        res = findInMemeory(key);
        if(res != null){
            return res;
        }

        res = findInBand(key);
        if(res != null){
            return res;
        }

        res = findInOrganization(key);
        if(res != null){
            return res;
        }

        return null;
    }

    /**
     * 针对单句环境，查找key所对应的数据，如果有，则返回它，并在栈中删除
     * 否则返回null
     * @param key
     * @return
     */
    public BLObj findWithDelete(String key){
        BLObj res = findInStack(key);
        if(res != null){
            deleteInStack(key);
        }
        return res;
    }

    /**
     * 在固定一个环境中查找该词对应的内容
     * @param key 词
     * @param type 选择的环境
     * @return
     */
    public BLObj find(String key, EnvironmentType type){
        switch (type){
            case ORGANIZATION:
                return findInOrganization(key);
            case BAND:
                return findInBand(key);
            case MEMORY:
                return findInMemeory(key);
            case STACK:
                return findInStack(key);
            default: return null;
        }
    }

    /**
     * 在某个环境中，加入一个对象
     * @param key 中文名称
     * @param value 内容
     * @param valueType 值的类型
     * @param type 选择的环境
     */
    public void add(String key, Object value, BLObjType valueType, EnvironmentType type){
        switch (type){
            case ORGANIZATION:
                addInOrganization(key,value,valueType);
                break;
            case BAND:
                addInBand(key,value,valueType);
                break;
            case MEMORY:
                addInMemory(key,value,valueType);
                break;
            case STACK:
                addInStack(key,value,valueType);
                break;
            default: return ;
        }
    }

    /**
     *  删除某个环境中oldKey所对应的记录，并插入新的记录，从而达到更新的目的
     *  注意，因为是删除后增加，所以位置会改变
     * @param oldKey 旧记录key
     * @param newKey 新记录key
     * @param newValue 新记录的值
     * @param newValueType 新记录的类型
     * @param type 环境
     * @return 如果删除失败，返回fales
     */
    public boolean update(String oldKey,String newKey,Object newValue,BLObjType newValueType,EnvironmentType type){
        BLObj old;
        if(type == null){
            //如果没指定环境，则进行查找并替换
            old = find(oldKey);
            if(old == null){
                return false;
            }else {
                old.key = newKey;
                old.value = newValue;
                old.type = newValueType;
                return true;
            }
        }
        switch (type){
            case ORGANIZATION:
                old = find(oldKey,EnvironmentType.ORGANIZATION);
                if(old == null){
                    return false;
                }else {
                    old.key = newKey;
                    old.value = newValue;
                    old.type = newValueType;
                    return true;
                }
            case BAND:
                old = find(oldKey,EnvironmentType.BAND);
                if(old == null){
                    return false;
                }else {
                    old.key = newKey;
                    old.value = newValue;
                    old.type = newValueType;
                    return true;
                }
            case MEMORY:
                old = find(oldKey,EnvironmentType.MEMORY);
                if(old == null){
                    return false;
                }else {
                    old.key = newKey;
                    old.value = newValue;
                    old.type = newValueType;
                    return true;
                }
            case STACK:
                old = find(oldKey,EnvironmentType.STACK);
                if(old == null){
                    return false;
                }else {
                    old.key = newKey;
                    old.value = newValue;
                    old.type = newValueType;
                    return true;
                }
            default: return false;
        }
    }
    /**
     * 在某个环境中，删除一个对象
     * @param key 中文名称
     * @param type 选择的环境
     */
    public boolean delete(String key,EnvironmentType type){
        switch (type){
            case ORGANIZATION:
                return deleteInOrganization(key);
            case BAND:
                return deleteInBand(key);
            case MEMORY:
                return deleteInMemory(key);
            case STACK:
                return deleteInStack(key);
            default: return false;
        }
    }

    /**
     * 在单句环境中查找key所对应的内容
     * @param key
     * @return
     */
    private BLObj findInStack(String key){
        for(int i=this.scriptEnvironment.size()-1;i>=this.place;i--){
            BLObj blObj = this.scriptEnvironment.get(i);
            if(blObj.key.equals(key)){
                return blObj;
            }
        }
        return null;
    }

    /**
     * 在全局环境中查找key所对应的内容
     * @param key
     * @return
     */
    private BLObj findInMemeory(String key){
        for(int i=0;i<this.place;i++){
            BLObj blObj = this.scriptEnvironment.get(i);
            if(blObj.key.equals(key)){
                return blObj;
            }
        }
        return null;
    }

    /**
     * 在帮区环境中查找key所对应的内容
     * @param key
     * @return
     */
    private BLObj findInBand(String key){
        for(BLObj blObj : this.band.things){
            if(blObj.key.equals(key)){
                return blObj;
            }
        }
        return null;
    }

    /**
     * 在帮区环境中查找key所对应的内容
     * @param key
     * @return
     */
    private BLObj findInOrganization(String key){
        for(BLObj blObj : this.organization.things){
            if(blObj.key.equals(key)){
                return blObj;
            }
        }
        return null;
    }

    /**
     * 将对象插入到单句环境中
     * @param key 中文名称
     * @param value 值
     * @param type 值的类型
     * @return
     */
    private void addInStack(String key , Object value, BLObjType type){
        BLObj obj = new BLObj(key,value,type);
        scriptEnvironment.add(obj);
    }

    /**
     * 将对象插入到全局环境中
     * @param key 中文名称
     * @param value 值
     * @param type 值的类型
     * @return
     */
    private void addInMemory(String key ,Object value,BLObjType type){
        BLObj obj = new BLObj(key,value,type);
        scriptEnvironment.add(place,obj);
        place++;
    }

    /**
     * 将对象插入到帮区环境中
     * @param key 中文名称
     * @param value 值
     * @param type 值的类型
     * @return
     */
    private void addInBand(String key ,Object value,BLObjType type){
        BLObj obj = new BLObj(key,value,type);
        this.band.things.add(obj);
    }

    /**
     * 将对象插入到机构环境中
     * @param key 中文名称
     * @param value 值
     * @param type 值的类型
     * @return
     */
    private void addInOrganization(String key ,Object value,BLObjType type){
        BLObj obj = new BLObj(key,value,type);
        this.organization.things.add(obj);
    }




    /**
     * 在单句环境中删除某个对象
     * @param key 中文名称
     * @return true表示成功删除 ，false表示没找到
     */
    private boolean deleteInStack(String key){
        for(int i=this.scriptEnvironment.size()-1;i>=this.place;i--){
            BLObj blObj = this.scriptEnvironment.get(i);
            if(blObj.key.equals(key)){
                this.scriptEnvironment.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * 在全局环境中删除某个对象
     * @param key 中文名称
     * @return true表示成功删除 ，false表示没找到
     */
    private boolean deleteInMemory(String key){
        for(int i=0;i<this.place;i++){
            BLObj blObj = this.scriptEnvironment.get(i);
            if(blObj.key.equals(key)){
                this.scriptEnvironment.remove(i);
                place--;
                return true;
            }
        }
        return false;
    }

    /**
     * 在帮区环境中删除某个对象
     * @param key 中文名称
     * @return true表示成功删除 ，false表示没找到
     */
    private boolean deleteInBand(String key){
        for(BLObj blObj : this.band.things){
            if(blObj.key.equals(key)){
                this.band.things.remove(blObj);
                return true;
            }
        }
        return false;
    }

    /**
     * 在机构环境中删除某个对象
     * @param key 中文名称
     * @return true表示成功删除 ，false表示没找到
     */
    private boolean deleteInOrganization(String key){
        for(BLObj blObj : this.organization.things){
            if(blObj.key.equals(key)){
                this.organization.things.remove(blObj);
                return true;
            }
        }
        return false;
    }

}
