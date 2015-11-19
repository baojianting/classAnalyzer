package com.bao.model.attribute;

import java.util.List;

/**
 * 名称: AnnotationsAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public class AnnotationsAttr extends Attribute {

    public static class ElementValuePair {
        public int mElementNameIndex;
        public int value;
    }

    public static class ElementValue {
        public int mTag;
        public Union mValue;
    }

    public static class EnumConstValue {
        public int mTypeNameIndex;
        public int mConstNameIndex;
    }

    public static class ArrayValue {
        public int mNumValues;
        public ElementValue[] values;
    }

    public static class Union {
        public int mConstValueIndex;
        public EnumConstValue mEnumConstValue;
        public int mClassInfoIndex;
        Annotation mAnnotationsVaue;
        ArrayValue mArrayValue;
    }

    public static class Annotation {
        public int mTypeIndex;
        public int mNumElementValuePairs;
        public ElementValuePair[] mElementValuePairs;
    }

    public static class ParameterAnnotation {
        public int mNumAnnotations;
        public List<Annotation> mAnnotations;
    }
}
