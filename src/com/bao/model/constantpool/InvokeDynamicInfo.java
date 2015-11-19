package com.bao.model.constantpool;

/**
 * 名称: InvokeDynamicInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class InvokeDynamicInfo extends ConstantPoolInfo {

    private int mBootstrapMethodAttrIndex;
    private int mNameAndTypeIndex;

    public InvokeDynamicInfo(int mBootstrapMethodAttrIndex, int mNameAndTypeIndex) {
        this.mBootstrapMethodAttrIndex = mBootstrapMethodAttrIndex;
        this.mNameAndTypeIndex = mNameAndTypeIndex;
    }

    public int getmBootstrapMethodAttrIndex() {
        return mBootstrapMethodAttrIndex;
    }

    public void setmBootstrapMethodAttrIndex(int mBootstrapMethodAttrIndex) {
        this.mBootstrapMethodAttrIndex = mBootstrapMethodAttrIndex;
    }

    public int getmNameAndTypeIndex() {
        return mNameAndTypeIndex;
    }

    public void setmNameAndTypeIndex(int mNameAndTypeIndex) {
        this.mNameAndTypeIndex = mNameAndTypeIndex;
    }
}
