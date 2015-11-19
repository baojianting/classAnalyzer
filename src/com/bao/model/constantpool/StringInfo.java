package com.bao.model.constantpool;

/**
 * 名称: StringInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class StringInfo extends ConstantPoolInfo {

    private int mUtf8Index;

    public StringInfo(int mUtf8Index) {
        this.mUtf8Index = mUtf8Index;
    }

    public int getmUtf8Index() {
        return mUtf8Index;
    }

    public void setmUtf8Index(int mUtf8Index) {
        this.mUtf8Index = mUtf8Index;
    }
}
