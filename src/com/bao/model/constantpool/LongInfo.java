package com.bao.model.constantpool;

/**
 * 名称: LongInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class LongInfo extends ConstantPoolInfo {

    private long mValue;

    public LongInfo(long l) {
        mValue = l;
    }

    public long getmValue() {
        return mValue;
    }

    public void setmValue(long mValue) {
        this.mValue = mValue;
    }
}
