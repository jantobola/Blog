package cz.jantobola.blog.security;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

/**
 * @author Jan Tobola
 * 
 */
public final class HashEncode {

    private HashEncode() {

    }

    public static String md5(String password, String salt) {
	return new Md5PasswordEncoder().encodePassword(password, salt);
    }

    public static String sha1(String password, String salt) {
	return new ShaPasswordEncoder(1).encodePassword(password, salt);
    }

}
