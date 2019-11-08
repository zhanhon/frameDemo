package com.zhanh.utilslibrary.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断字符串的类型
 */
public class VerdictStringTypeUtil {
    /**
     * 是否为数字
     *
     * @param txt
     * @return
     */
    public static boolean isNumber(String txt) {
        if (txt != null && txt.length() > 0) {
            Pattern p = Pattern.compile("[0-9]*");
            Matcher m = p.matcher(txt);
            return m.matches();

        } else {
            return false;
        }
    }

    /**
     * 是否为字母
     *
     * @param txt
     * @return
     */
    public static boolean isEnglish(String txt) {
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(txt);
        return m.matches();
    }

    /**
     * 是否为汉字
     *
     * @param txt
     * @return
     */
    public static boolean isChinese(String txt) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(txt);
        return m.matches();
    }


}
