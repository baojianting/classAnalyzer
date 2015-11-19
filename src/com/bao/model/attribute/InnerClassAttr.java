package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: InnerClassAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class InnerClassAttr extends Attribute {

    public static class InnerClass {
        public int mInnerClassInfoIndex;
        public int mOuterClassInfoIndex;
        public int mInnerNameIndex;
        public int mInnerClassAccessFlags;
    }

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mNumberOfClasses;
    public List<InnerClass> mClasses;
}
