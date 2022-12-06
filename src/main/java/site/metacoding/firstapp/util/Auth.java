package site.metacoding.firstapp.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	int role(); //'일반' = 0 (디폴트값), '일반 관리자 ' = 1, (디폴트값) '중앙 관리자' = 2(디폴트값)


	
}
