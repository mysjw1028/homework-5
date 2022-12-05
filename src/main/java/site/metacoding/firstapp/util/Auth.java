package site.metacoding.firstapp.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	int role(); //'일반' = users (디폴트값), '일반 관리자 ' = admin, (디폴트값) '중앙 관리자' = Mainadmin(디폴트값)
	
}
