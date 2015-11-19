package com.bao.model.constantpool;

/**
 * 名称: ClassInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class ClassInfo extends ConstantPoolInfo {

    private int mUtf8InfoIndex;

    public ClassInfo(int utf8InfoIndex) {
        this.mUtf8InfoIndex = utf8InfoIndex;
    }

    public int getUtf8InfoIndex() {
        return mUtf8InfoIndex;
    }

    public void setUtf8InfoIndex(int utf8InfoIndex) {
        this.mUtf8InfoIndex = utf8InfoIndex;
    }
}
