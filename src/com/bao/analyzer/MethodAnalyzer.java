package com.bao.analyzer;

import com.bao.model.ClassFile;
import com.bao.model.MethodInfo;
import com.bao.util.BytesUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 名称: MethodAnalyzer.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/11/18
 */


public class MethodAnalyzer {

    private ClassFile mClassFile;
    private byte[] mbytes;
    private int mPos;

    public MethodAnalyzer(ClassFile classFile, byte[] bytes, int pos) {
        mClassFile = classFile;
        mbytes = bytes;
        mPos = pos;
    }

    public void initMethodCount() {
        int methodCount = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mbytes, mPos, mPos + 2));
        mPos += 2;
        mClassFile.mMethodsCount = methodCount;
    }

    public void initMethods() {
        if (mClassFile.mMethodsCount == 0) {
            return;
        }
        mClassFile.mMethods = new ArrayList<>();
        for (int i = 0; i < mClassFile.mMethodsCount; i++) {
            MethodInfo info = new MethodInfo();
            int accessFlag = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mbytes, mPos, mPos + 2));
            mPos += 2;
            int nameIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mbytes, mPos, mPos + 2));
            mPos += 2;
            int descriptorIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mbytes, mPos, mPos + 2));
            mPos += 2;
            AttributeAnalyzer attributeAnalyzer = AttributeAnalyzer.getInstance();
            attributeAnalyzer.setData(mClassFile, mbytes, mPos);
            mPos = attributeAnalyzer.execute();
            info.mAccessFlags = accessFlag;
            info.mNameIndex = nameIndex;
            info.mDescriptorIndex = descriptorIndex;
            info.mAttrCount = attributeAnalyzer.getAttrCount();
            info.mAttributes = attributeAnalyzer.getAttrs();
            mClassFile.mMethods.add(info);
        }
    }

    public int execute() {
        initMethodCount();
        initMethods();
        return mPos;
    }
}
