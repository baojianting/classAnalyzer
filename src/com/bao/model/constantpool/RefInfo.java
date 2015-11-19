package com.bao.model.constantpool;

/**
 * 名称: RefInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class RefInfo extends ConstantPoolInfo {

    private int mClassIndex;
    private int mNameAndTypeIndex;

    public RefInfo(int mClassIndex, int mNameAndTypeIndex) {
        this.mClassIndex = mClassIndex;
        this.mNameAndTypeIndex = mNameAndTypeIndex;
    }

    public int getmClassIndex() {
        return mClassIndex;
    }

    public void setmClassIndex(int mClassIndex) {
        this.mClassIndex = mClassIndex;
    }

    public int getmNameAndTypeIndex() {
        return mNameAndTypeIndex;
    }

    public void setmNameAndTypeIndex(int mNameAndTypeIndex) {
        this.mNameAndTypeIndex = mNameAndTypeIndex;
    }
}
