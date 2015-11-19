package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: RuntimeVisibleAnnotationsAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class RuntimeVisibleAnnotationsAttr extends AnnotationsAttr {

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mNumAnnotations;
    public List<Annotation> mAnnotations;
}
