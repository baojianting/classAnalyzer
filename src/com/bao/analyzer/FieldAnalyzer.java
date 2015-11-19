package com.bao.analyzer;

import com.bao.model.ClassFile;
import com.bao.model.FieldInfo;
import com.bao.util.BytesUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 名称: FieldAnalyzer.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/11/17
 */


public class FieldAnalyzer {

    private ClassFile mClassFile;
    private byte[] mBytes;
    private int mPos;

    public FieldAnalyzer(ClassFile classFile, byte[] bytes, int pos) {
        mClassFile = classFile;
        mBytes = bytes;
        mPos = pos;
    }

    public void initFieldCount() {
        mClassFile.mFieldsCount = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
    }

    public void initFields() {
        mClassFile.mFields = new ArrayList<>();
        for (int i = 0; i < mClassFile.mFieldsCount; i++) {
            FieldInfo fieldInfo = new FieldInfo();
            fieldInfo.mAccessFlags = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
            mPos += 2;
            fieldInfo.mNameIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
            mPos += 2;
            fieldInfo.mDescriptorIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
            mPos += 2;
            AttributeAnalyzer attrAnalyzer = AttributeAnalyzer.getInstance();
            attrAnalyzer.setData(mClassFile, mBytes, mPos);
            mPos = attrAnalyzer.execute();
            fieldInfo.mAttrCount = attrAnalyzer.getAttrCount();
            fieldInfo.mAttributes = attrAnalyzer.getAttrs();
            mClassFile.mFields.add(fieldInfo);
        }
    }

    public int execute() {
        initFieldCount();
        initFields();
        return mPos;
    }
}
