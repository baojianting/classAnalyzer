package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: CodeAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class CodeAttr extends Attribute {

    public static class ExceptionTableInfo {
        public int mStartPc;
        public int mEndPc;
        public int mHandlerPc;
        public int mCatchType;
    }

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mMaxStack;
    public int mMaxLocals;
    public int mCodeLength;
    public List<Byte> mCode;
    public int mExceptionTableLength;
    public List<ExceptionTableInfo> mExceptionTables;
    public int mAttrCount;
    public List<Attribute> mAttrs;

}
