package com.bao.model;

import com.bao.model.attribute.Attribute;

import java.util.List;

/**
 * 名称: FieldInfo.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public class FieldInfo {

    public int mAccessFlags;
    public int mNameIndex;
    public int mDescriptorIndex;
    public int mAttrCount;
    public List<Attribute> mAttributes;
}
