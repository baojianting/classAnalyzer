package com.bao.util;

/**
 * 名称: BytesUtil.java<br>
 * 描述: <br>
 * 类型: JAVA<br>
 *
 * @author jianting.bjt
 * @since 2015/10/16
 */


public final class BytesUtil {


    public static int fourBytes2Int(byte[] bytes) {
        int length = bytes.length;
        if (length != 4) {
            System.out.println("byte's length is " + length + ", not 4");
            return -1;
        }
        return (((bytes[0] << 24) & 0xff000000) | ((bytes[1] << 16) & 0xff0000) | ((bytes[2] << 8) & 0xff00) | (bytes[3] & 0xff));
    }

    public static int twoBytes2Int(byte[] bytes) {
        if (bytes.length != 2) {
            System.out.println("byte's length is " + bytes.length + ", not 2");
            return -1;
        }
        return (((bytes[0] << 8) & 0xff00) | (bytes[1] & 0xff));
    }

    public static int oneBytes2Int(byte b) {
        return (int)b;
    }

    public static float fourByte2Float(byte[] bytes) {
        if (bytes.length != 4) {
            System.out.println("byte's length is " + bytes.length + ", not 4");
            return -1;
        }
        return 0;
    }

    public static double eightByte2Double(byte[] bytes) {
        if (bytes.length != 8) {
            System.out.println("byte's length is " + bytes.length + ", not 8");
            return -1;
        }
        return 0;
    }

    public static long eightByte2Long(byte[] bytes) {
        if (bytes.length != 8) {
            System.out.println("byte's length is " + bytes.length + ", not 8");
            return -1;
        }
        return 0;
    }

    public static String byteToString(byte[] bytes) {
        return new String(bytes);
    }
}
