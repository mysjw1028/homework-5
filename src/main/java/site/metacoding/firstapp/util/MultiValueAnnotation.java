package site.metacoding.firstapp.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MultiValueAnnotation {
    int role();
     int roles();
}
//"user”; //미지정시 기본 값으로 user가 지정된다