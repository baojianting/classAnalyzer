package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: LineNumberTableAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class LineNumberTableAttr extends Attribute {

    public static class LineNumberInfo {
        public int mStartPc;
        public int mLineNumber;
    }

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mLineNumberTableLength;
    public List<LineNumberInfo> mLineNumberTable;

}
