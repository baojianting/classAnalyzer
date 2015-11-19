package com.bao.model.constantpool;

/**
 * 名称: MethodTypeInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class MethodTypeInfo extends ConstantPoolInfo {

    private int mDescriptorIndex;

    public int getmDescriptorIndex() {
        return mDescriptorIndex;
    }

    public void setmDescriptorIndex(int mDescriptorIndex) {
        this.mDescriptorIndex = mDescriptorIndex;
    }
}
