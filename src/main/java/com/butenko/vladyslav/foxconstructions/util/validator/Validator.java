package com.butenko.vladyslav.foxconstructions.util.validator;

import antlr.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

public class Validator {

    public static boolean isNull(Object object) {
        return (object == null);
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }


    public static boolean isEmpty(Collection collection) {
        return isNull(collection) || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(String string) {
        return string.isEmpty();
    }

    public static boolean isNotEmpty(String string) {
        return !string.isEmpty();
    }

    public static boolean isEmpty(MultipartFile file){
        return isNull(file) || file.isEmpty();
    }

    public static boolean isNotEmpty(MultipartFile file){
        return !isEmpty(file);
    }
}
