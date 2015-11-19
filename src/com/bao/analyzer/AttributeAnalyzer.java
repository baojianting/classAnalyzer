package com.bao.analyzer;

import com.bao.model.ClassFile;
import com.bao.model.attribute.Attribute;
import com.bao.model.attribute.SourceFileAttr;
import com.bao.model.constantpool.ConstantPoolInfo;
import com.bao.model.constantpool.Utf8Info;
import com.bao.util.BytesUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 名称: AttributeAnalyzer.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/11/17
 */


public class AttributeAnalyzer {

    public static final String CONSTANTVALUE = "ConstantValue";
    public static final String CODE = "Code";
    public static final String STACKMAPTABLE = "StackMapTable";
    public static final String EXCEPTIONS = "Exceptions";
    public static final String INNERCLASSES = "InnerClasses";
    public static final String ENCLOSINGMETHOD = "EnclosingMethod";
    public static final String SYNTHETIC = "Synthetic";
    public static final String SIGNATURE = "Signature";
    public static final String SOURCEFILE = "SourceFile";
    public static final String SOURCEDEBUGEXTENSION = "SourceDebugExtension";
    public static final String LINENUMBERTABLE = "LineNumberTable";
    public static final String LOCALVARIABLETABLE = "LocalVariableTable";
    public static final String LOCALVARIABLETYPETABLE = "LocalVariableTypeTable";
    public static final String DEPRECATED = "Deprecated";
    public static final String RUNTIMEVISIBLEANNOTATIONS = "RuntimeVisibleAnnotations";
    public static final String RUNTIMEVISIBLEPARAMETERANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    public static final String RUNTIMEINVISIBLEANNOTATIONS = "RuntimeInvisibleAnnotations";
    public static final String RUNTIMEINVISBLEPARAMETERANNOTATTIONS = "RuntimeInvisibleParameterAnnotations";
    public static final String ANNOTATIONDEFAULT = "AnnotationsDefault";
    public static final String BOOTSTRAPMETHODS = "BootstrapMethods";

    private static AttributeAnalyzer mInstance;
    private ClassFile mClassFile;
    private byte[] mBytes;
    private int mPos;
    private int mAttrCount;
    private List<Attribute> mAttrs;

    private AttributeAnalyzer() {

    }

    public static AttributeAnalyzer getInstance() {
        synchronized (AttributeAnalyzer.class) {
            mInstance = new AttributeAnalyzer();
        }
        return mInstance;
    }

    public void setData(ClassFile classFile, byte[] bytes, int pos) {
        mClassFile = classFile;
        mBytes = bytes;
        mPos = pos;
    }

    public int execute() {
        mAttrCount = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
        mPos += 2;
        if (mAttrCount == 0) {
            return mPos;
        }
        mAttrs = new ArrayList<>();
        for (int i = 0; i < mAttrCount; i++) {
            int attrNameIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
            mPos += 2;
            ConstantPoolInfo constanInfo = mClassFile.mConstantPools.get(attrNameIndex - 1);
            if (constanInfo instanceof Utf8Info) {
                String attrName = ((Utf8Info)constanInfo).getStr();
                if (!attrName.equals(SOURCEFILE)) {
                    //TODO: 完善其他属性 这里只读取attribute_length
                    int attrLength = BytesUtil.fourBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 4));
                    mPos += 4;
                    mPos += attrLength;
                    Attribute attr = new Attribute();
                    mAttrs.add(attr);
                } else {
                    int attrLength = BytesUtil.fourBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 4));
                    mPos += 4;
                    SourceFileAttr attr = new SourceFileAttr();
                    attr.mAttrNameIndex = attrNameIndex;
                    attr.mAttrLength = attrLength;
                    int sourceFileIndex = BytesUtil.twoBytes2Int(Arrays.copyOfRange(mBytes, mPos, mPos + 2));
                    mPos += 2;
                    attr.mSourceFileIndex = sourceFileIndex;
                    mAttrs.add(attr);
                }
            } else {
                throw new RuntimeException("attribute name is not utf8 info" + constanInfo.toString());
            }
        }
        return mPos;
    }

    public int getAttrCount() {
        return mAttrCount;
    }

    public List<Attribute> getAttrs() {
        return mAttrs;
    }

}
