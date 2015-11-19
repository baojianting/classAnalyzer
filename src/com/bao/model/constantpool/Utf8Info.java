package com.bao.model.constantpool;

/**
 * 名称: Utf8Info.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class Utf8Info extends ConstantPoolInfo {
    private String mStr;

    public Utf8Info(String str) {
        mStr = str;
    }

    public String getStr() {
        return mStr;
    }

    public void setStr(String str) {
        this.mStr = str;
    }
}
