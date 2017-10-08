package org.xebia.mowitnow.infrastructure.validator;

public class StringValidator {

    public static boolean isNullorEmpty(String string){
        return string == null || string.isEmpty();
    }
}
