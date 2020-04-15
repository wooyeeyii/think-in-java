package com.chang.common;

import java.util.List;

public class ArrayToStringUtil {

    /******************** List ********************/
    public static <T> String oneDimension(List<T> list) {
        if (null == list) {
            return "list is null";
        }
        if (0 == list.size()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T t : list) {
            sb.append(t.toString() + ", ");
        }
        String res = sb.substring(0, sb.length() - 2);
        res += ("]");
        return res;
    }

    public static <T> String twoDimension(List<List<T>> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("\r\n");
        for (List<T> rowList : list) {
            sb.append("\t");
            sb.append(oneDimension(rowList));
            sb.append("\r\n");
        }
        sb.append("]");
        return sb.toString();
    }

}
