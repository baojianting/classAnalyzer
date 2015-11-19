package com.bao.model.attribute;

import com.bao.model.constantpool.ClassInfo;

import java.util.List;

/**
 * 名称: ExceptionAttr.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/15
 */


public class ExceptionAttr extends Attribute {

    public int mAttrNameIndex;
    public int mAttrLength;
    public int mNumberOfExceptions;
    public List<ClassInfo> mExceptionIndexTable;
}
