package com.bao.model.constantpool;

/**
 * 名称: FloatInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class FloatInfo extends ConstantPoolInfo {

    private float mValue;

    public float getmValue() {
        return mValue;
    }

    public void setmValue(float mValue) {
        this.mValue = mValue;
    }

    public FloatInfo(float f) {
        mValue = f;
    }
}
