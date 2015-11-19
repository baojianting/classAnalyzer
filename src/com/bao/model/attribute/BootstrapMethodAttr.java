package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: BootstrapMethodAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public class BootstrapMethodAttr extends Attribute {

    public static class BootstrapMethod {
        public int mBootstrapMethodRef;
        public int mNumBootstrapArguments;
        public int mBootstrapArguments;
    }

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mNumBootstrapMethods;
    public List<BootstrapMethod> mBootstrapMethods;
}
