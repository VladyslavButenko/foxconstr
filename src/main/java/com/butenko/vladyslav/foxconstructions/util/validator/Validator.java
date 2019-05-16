package com.butenko.vladyslav.foxconstructions.util.validator;

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
}
