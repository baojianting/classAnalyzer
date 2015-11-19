package com.bao.model.constantpool;

/**
 * 名称: DoubleInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class DoubleInfo extends ConstantPoolInfo {

    private double mValue;

    public DoubleInfo(double d) {
        mValue = d;
    }

    public double getmValue() {
        return mValue;
    }

    public void setmValue(double mValue) {
        this.mValue = mValue;
    }
}
