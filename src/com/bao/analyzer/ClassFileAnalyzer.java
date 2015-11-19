package com.bao.analyzer;

import com.bao.model.ClassFile;
import com.bao.util.BytesUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 名称: ClassFileUtil.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public class ClassFileAnalyzer {

    private byte[] mBytes;
    private int mPos;
    private ClassFile mClassFile;

    public ClassFileAnalyzer(byte[] mBytes, ClassFile mClassFile) {
        this.mBytes = mBytes;
        this.mClassFile = mClassFile;
        this.mPos = 0;
    }

    public void initHeader() {
        // 设置magic字段
        mClassFile.mMagic = BytesUtil.fourBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 4));
        mPos += 4;
        mClassFile.mMinorVersion = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        mClassFile.mMajorVersion = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
    }

    public void initConstantPool() {
        mClassFile.mConstantPoolCount = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2)) - 1;
        mPos += 2;
        mClassFile.mConstantPools = new ArrayList<>();
        ConstantPoolAnalyzer analyzer = new ConstantPoolAnalyzer(mBytes, mClassFile, mPos);
        mPos = analyzer.initConstantPool();
    }

    public void initMedium() {
        mClassFile.mAccessFlags = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        mClassFile.mThisClass = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        mClassFile.mSuperClass = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
    }

    public void initInteface() {
        mClassFile.mInterfacesCount = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        mClassFile.mInterfaces = new ArrayList<>();
        for (int i = 0;  i < mClassFile.mInterfacesCount; i++) {
            mClassFile.mInterfaces.add(BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2)));
            mPos += 2;
        }
    }

    public void initField() {
        FieldAnalyzer analyzer = new FieldAnalyzer(mClassFile, mBytes, mPos);
        mPos = analyzer.execute();
    }

    public void initMethod() {
        MethodAnalyzer analyzer = new MethodAnalyzer(mClassFile, mBytes, mPos);
        mPos = analyzer.execute();
    }

    public void initAttrs() {
        AttributeAnalyzer analyzer = AttributeAnalyzer.getInstance();
        analyzer.setData(mClassFile, mBytes, mPos);
        mPos = analyzer.execute();
        mClassFile.mAttributesCount = analyzer.getAttrCount();
        mClassFile.mAttributes = analyzer.getAttrs();
    }

    public ClassFile execute() {
        initHeader();
        initConstantPool();
        initMedium();
        initInteface();
        initField();
        initMethod();
        initAttrs();
        return mClassFile;
    }
}
