package cz.jantobola.blog.tag;

public class RegexpTag {

	public static boolean regexp(String pattern, String string) {
		return string.matches(pattern);
	}

}
