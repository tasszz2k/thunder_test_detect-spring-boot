package com.thundertestdetect.converter;

import java.nio.charset.StandardCharsets;

public class Converter {
    public static String decodeUTF8(String strEncode){
        return new String(strEncode.getBytes(StandardCharsets.UTF_8));
    }
}
