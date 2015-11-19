package com.bao.analyzer;

import com.bao.model.ClassFile;
import com.bao.model.constantpool.*;
import com.bao.util.BytesUtil;

import java.util.Arrays;

/**
 * 名称: ConstantPoolAnalyzer.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public final class ConstantPoolAnalyzer {

    private int mPos;
    private byte[] mBytes;
    private ClassFile mClassFile;

    public ConstantPoolAnalyzer(byte[] mBytes, ClassFile mClassFile, int mPos) {
        this.mBytes = mBytes;
        this.mClassFile = mClassFile;
        this.mPos = mPos;
    }

    public int initConstantPool() {
        for (int i = 0; i < mClassFile.mConstantPoolCount; i++) {
            int flag = BytesUtil.oneBytes2Int(mBytes[mPos++]);
            switch (flag) {
                case ConstantPoolInfo.CONSTANT_CLASS:
                    initClassInfo();
                    break;
                case ConstantPoolInfo.CONSTANT_FIELDREF:
                    initRefInfo(flag);
                    break;
                case ConstantPoolInfo.CONSTANT_METHODREF:
                    initRefInfo(flag);
                    break;
                case ConstantPoolInfo.CONSTANT_INTERFACEMETHODREF:
                    initRefInfo(flag);
                    break;
                case ConstantPoolInfo.CONSTANT_STRING:
                    initStringInfo();
                    break;
                case ConstantPoolInfo.CONSTANT_INTEGER:
                case ConstantPoolInfo.CONSTANT_FLOAT:
                    initIntegerAndFloat(flag);
                    break;
                case ConstantPoolInfo.CONSTANT_LONG:
                case ConstantPoolInfo.CONSTANT_DOUBLE:
                    initLongAndDouble(flag);
                    //TODO: 坑爹 8位的占两位
                    i++;
                    mClassFile.mConstantPools.add(new ConstantPoolInfo());
                    break;
                case ConstantPoolInfo.CONSTANT_NAMEANDTYPE:
                    initNameAndTypeInfo();
                    break;
                case ConstantPoolInfo.CONSTANT_UTF8:
                    initUtf8Info();
                    break;
                case ConstantPoolInfo.CONSTANT_METHODHANDLE:
                    initMethodHandleInfo();
                    break;
                case ConstantPoolInfo.CONSTANT_METHODTYPE:
                    initMethodTypeInfo();
                    break;
                case ConstantPoolInfo.CONSTANT_INVOKEDYNAMIC:
                    initInvokeDynamicInfo();
                    break;
                default:
                    System.out.println("number:" + flag);
            }
        }
        return mPos;
    }

    public void initClassInfo() {
        int nameIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        ClassInfo classInfo = new ClassInfo(nameIndex);
        mClassFile.mConstantPools.add(classInfo);
    }

    public void initRefInfo(int flag) {
        int classIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        int nameAndTypeIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        switch (flag) {
            case ConstantPoolInfo.CONSTANT_FIELDREF:
                FieldRefInfo fieldRefInfo = new FieldRefInfo(classIndex, nameAndTypeIndex);
                mClassFile.mConstantPools.add(fieldRefInfo);
                break;
            case ConstantPoolInfo.CONSTANT_METHODREF:
                MethodRefInfo methodRefInfo = new MethodRefInfo(classIndex, nameAndTypeIndex);
                mClassFile.mConstantPools.add(methodRefInfo);
                break;
            case ConstantPoolInfo.CONSTANT_INTERFACEMETHODREF:
                InterfaceMethodRefInfo interfaceMethodRefInfo = new InterfaceMethodRefInfo(classIndex, nameAndTypeIndex);
                mClassFile.mConstantPools.add(interfaceMethodRefInfo);
                break;
            default:
                System.out.println("flag is default:" + flag);
        }
    }

    public void initStringInfo() {
        int stringIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        StringInfo stringInfo = new StringInfo(stringIndex);
        mClassFile.mConstantPools.add(stringInfo);
    }

    public void initIntegerAndFloat(int flag) {
        if (flag == ConstantPoolInfo.CONSTANT_INTEGER) {
            int value = BytesUtil.fourBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 4));
            mPos += 4;
            IntegerInfo integerInfo = new IntegerInfo(value);
            mClassFile.mConstantPools.add(integerInfo);
        } else {
            float value = BytesUtil.fourByte2Float(Arrays.copyOfRange(mBytes, mPos, mPos + 4));
            mPos += 4;
            FloatInfo floatInfo = new FloatInfo(value);
            mClassFile.mConstantPools.add(floatInfo);
        }
    }

    public void initLongAndDouble(int flag) {
        if (flag == ConstantPoolInfo.CONSTANT_LONG) {
            long value = BytesUtil.eightByte2Long(Arrays.copyOfRange(mBytes, mPos, mPos + 8));
            mPos += 8;
            LongInfo longInfo= new LongInfo(value);
            mClassFile.mConstantPools.add(longInfo);
        } else {
            double value = BytesUtil.eightByte2Double(Arrays.copyOfRange(mBytes, mPos, mPos + 8));
            mPos += 8;
            DoubleInfo doubleInfo = new DoubleInfo(value);
            mClassFile.mConstantPools.add(doubleInfo);
        }
    }

    public void initNameAndTypeInfo() {
        int nameIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        int descriptorIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        NameAndTypeInfo nameAndTypeInfo = new NameAndTypeInfo(nameIndex, descriptorIndex);
        mClassFile.mConstantPools.add(nameAndTypeInfo);
    }

    public void initUtf8Info() {
        int length = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        String str = BytesUtil.byteToString(Arrays.copyOfRange(mBytes, mPos, mPos + length));
        mPos += length;
        Utf8Info utf8Info = new Utf8Info(str);
        mClassFile.mConstantPools.add(utf8Info);
    }

    public void initMethodHandleInfo() {
        int referenceKind = BytesUtil.oneBytes2Int(mBytes[mPos++]);
        int referenceIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        MethodHandleInfo methodHandleInfo = new MethodHandleInfo(referenceIndex, referenceKind);
        mClassFile.mConstantPools.add(methodHandleInfo);
    }

    public void initMethodTypeInfo() {
        int index = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        MethodTypeInfo methodTypeInfo = new MethodTypeInfo();
        methodTypeInfo.setmDescriptorIndex(index);
        mClassFile.mConstantPools.add(methodTypeInfo);
    }

    public void initInvokeDynamicInfo() {
        int bootstrapMethodAttrIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        int nameAndTypeIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        InvokeDynamicInfo info = new InvokeDynamicInfo(bootstrapMethodAttrIndex, nameAndTypeIndex);
        mClassFile.mConstantPools.add(info);
    }
}
