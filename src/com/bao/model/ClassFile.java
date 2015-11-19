package com.bao.model;

import com.bao.model.attribute.Attribute;
import com.bao.model.constantpool.ConstantPoolInfo;

import java.util.List;

/**
 * 名称: ClassFile.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public class ClassFile {

    public int mMagic;
    public int mMinorVersion;
    public int mMajorVersion;
    public int mConstantPoolCount;
    public List<ConstantPoolInfo> mConstantPools;
    public int mAccessFlags;
    public int mThisClass;
    public int mSuperClass;
    public int mInterfacesCount;
    public List<Integer> mInterfaces;
    public int mFieldsCount;
    public List<FieldInfo> mFields;
    public int mMethodsCount;
    public List<MethodInfo> mMethods;
    public int mAttributesCount;
    public List<Attribute> mAttributes;
}
