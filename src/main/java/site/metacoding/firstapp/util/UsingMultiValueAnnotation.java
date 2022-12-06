package site.metacoding.firstapp.util;

public class UsingMultiValueAnnotation {

	@MultiValueAnnotation(roles = {1, 2}) // name = user, roles = {“anonymous’}로 지정된다
	public void testMethod() {
	}

}
//"user”; //미지정시 기본 값으로 user가 지정된다