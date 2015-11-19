package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: LocalVariableTableAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class LocalVariableTableAttr extends Attribute {

    public static class LocalVariableInfo {
        public int mStartPc;
        public int mLength;
        public int mNameIndex;
        public int mDescriptorIndex;
        public int mIndex;
    }

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mLocalVariableTableLength;
    public List<LocalVariableInfo> mLocalVariableTable;
}
