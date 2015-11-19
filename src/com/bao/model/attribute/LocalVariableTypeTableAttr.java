package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: LocalVariableTypeTableAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class LocalVariableTypeTableAttr extends Attribute {

    public static class LocalVaribleTypeInfo {
        public int mStartPc;
        public int mLength;
        public int mNameIndex;
        public int mSignatureIndex;
        public int mIndex;
    }

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mLocalVariableTypeTableLength;
    public List<LocalVaribleTypeInfo> mLocalVariableTypeTable;
}
