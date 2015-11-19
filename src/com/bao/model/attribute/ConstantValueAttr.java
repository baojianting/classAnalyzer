package com.bao.model.attribute;

/**
 * 名称: ConstantValueAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class ConstantValueAttr extends Attribute {

    private int mAttrNameIndex;
    private int mConstantValueIndex;

    public ConstantValueAttr(int mAttrNameIndex, int mConstantValueIndex) {
        this.mAttrNameIndex = mAttrNameIndex;
        this.mConstantValueIndex = mConstantValueIndex;
    }

    public int getmAttrNameIndex() {
        return mAttrNameIndex;
    }

    public void setmAttrNameIndex(int mAttrNameIndex) {
        this.mAttrNameIndex = mAttrNameIndex;
    }

    public int getmConstantValueIndex() {
        return mConstantValueIndex;
    }

    public void setmConstantValueIndex(int mConstantValueIndex) {
        this.mConstantValueIndex = mConstantValueIndex;
    }
}
