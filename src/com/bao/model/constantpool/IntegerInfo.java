package com.bao.model.constantpool;

/**
 * 名称: IntegerInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class IntegerInfo extends ConstantPoolInfo {

    private int mValue;

    public IntegerInfo(int mValue) {
        this.mValue = mValue;
    }

    public int getmValue() {
        return mValue;
    }

    public void setmValue(int mValue) {
        this.mValue = mValue;
    }
}
