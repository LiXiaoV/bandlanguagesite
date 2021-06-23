package com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.node.sentence.complex;


import com.bandlanguage.bandlanguagesite.compilecore.functionalintegration.environment.staticmessage.BLObjType;

public enum SetValueEnum {
    STRING{
        @Override
        public BLObjType getType(){
            return BLObjType.RESULT_STRING;
        }
    },
    STMT{
        @Override
        public BLObjType getType(){
            return BLObjType.Node;
        }
    },
    OBJ{
        @Override
        public BLObjType getType(){
            return BLObjType.RESULT_STRING;
        }
    },
    NUMBER{
        @Override
        public BLObjType getType(){
            return BLObjType.RESULT_INTEGER;
        }
    };

     public abstract  BLObjType getType();
}
