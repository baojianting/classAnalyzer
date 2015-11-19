package com.bao.model.attribute;

/**
 * 名称: RuntimeVisibleParameterAnnotationAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public class RuntimeVisibleParameterAnnotationAttr extends Attribute {

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mNumParameters;
    public AnnotationsAttr.ParameterAnnotation mParameterAnnotations;
}
