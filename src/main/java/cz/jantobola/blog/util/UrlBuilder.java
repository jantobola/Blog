package cz.jantobola.blog.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class UrlBuilder {
	
	private String delimiter = "-";
	private String accentPattern = "\\p{InCombiningDiacriticalMarks}+";
	private boolean normalized = true;
	private boolean unaccent = true;
	
	public UrlBuilder() {
		
	}
	
	public UrlBuilder(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public UrlBuilder(String delimiter, boolean normalized, boolean unaccent) {
		this.delimiter = delimiter;
		this.normalized = normalized;
		this.unaccent = unaccent;
	}
	
	public String buildUrl(String s) {
		
		if (normalized) {
			s = normalize(s);
		}
		
		if (unaccent) {
			s = unAccent(s);
		}
		
		String url = s.toLowerCase().replace(" ", delimiter).replaceAll(getSpecialCharacters(), " ").replace(" ", "")
				.replaceAll("\\" + delimiter + "+", delimiter);
		
		if (url.startsWith(delimiter)) {
			url = url.substring(1, url.length());
		}
		
		if (url.endsWith(delimiter)) {
			url = url.substring(0, url.length() - 1);
		}
		
		return url;
	}
	
	public static String buildDefaultUrl(String s) {
		UrlBuilder builder = new UrlBuilder();
		return builder.buildUrl(s);
	}
	
	private String normalize(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD);
	}
	
	private String unAccent(String s) {
		Pattern pattern = Pattern.compile(accentPattern);
		return pattern.matcher(s).replaceAll("");
	}
	
	private String getSpecialCharacters() {
		if (!unaccent) {
			return "[^a-zA-Z0-9" + delimiter + "]+" + accentPattern;
		}
		
		return "[^a-zA-Z0-9" + delimiter + "]+";
	}
	
	public String getDelimiter() {
		return delimiter;
	}
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public boolean isNormalized() {
		return normalized;
	}
	
	public void setNormalized(boolean normalized) {
		this.normalized = normalized;
	}
	
	public boolean isUnaccent() {
		return unaccent;
	}
	
	public void setUnaccent(boolean unaccent) {
		this.unaccent = unaccent;
	}
	
}
