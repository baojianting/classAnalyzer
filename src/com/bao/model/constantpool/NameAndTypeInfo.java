package com.bao.model.constantpool;

/**
 * 名称: NameAndTypeInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class NameAndTypeInfo extends ConstantPoolInfo {

    private int mNameIndex;
    private int mDescriptorIndex;

    public NameAndTypeInfo(int mNameIndex, int mDescriptorIndex) {
        this.mNameIndex = mNameIndex;
        this.mDescriptorIndex = mDescriptorIndex;
    }

    public int getmDescriptorIndex() {
        return mDescriptorIndex;
    }

    public void setmDescriptorIndex(int mDescriptorIndex) {
        this.mDescriptorIndex = mDescriptorIndex;
    }

    public int getmNameIndex() {
        return mNameIndex;
    }

    public void setmNameIndex(int mNameIndex) {
        this.mNameIndex = mNameIndex;
    }
}
