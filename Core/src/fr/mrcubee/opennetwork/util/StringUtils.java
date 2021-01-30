package fr.mrcubee.opennetwork.util;

import io.netty.util.internal.StringUtil;

public class StringUtils {

    public static boolean isNullOrWhiteSpaceOnly(String str) {
        return str == null || StringUtil.indexOfNonWhiteSpace(str, 0) == -1;
    }

    public static boolean isOneNullOrWhiteSpaceOnly(String... strings) {
        if (strings == null || strings.length < 1)
            return true;
        for (String str : strings)
            if (isNullOrWhiteSpaceOnly(str))
                return true;
        return false;
    }

}
