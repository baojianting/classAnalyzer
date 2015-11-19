package com.bao.model.constantpool;

/**
 * 名称: MethodHandleInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class MethodHandleInfo extends ConstantPoolInfo {

    private int mReferenceKind;
    private int mReferenceIndex;

    public MethodHandleInfo(int mReferenceIndex, int mReferenceKind) {
        this.mReferenceIndex = mReferenceIndex;
        this.mReferenceKind = mReferenceKind;
    }

    public int getmReferenceIndex() {
        return mReferenceIndex;
    }

    public void setmReferenceIndex(int mReferenceIndex) {
        this.mReferenceIndex = mReferenceIndex;
    }

    public int getmReferenceKind() {
        return mReferenceKind;
    }

    public void setmReferenceKind(int mReferenceKind) {
        this.mReferenceKind = mReferenceKind;
    }
}
