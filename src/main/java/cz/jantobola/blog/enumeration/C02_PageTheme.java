package cz.jantobola.blog.enumeration;

public enum C02_PageTheme {
	THEME_BLOG("img_header_blog", "img_footer_blog"), THEME_BUSINESS("img_header_main", "img_footer_main"), THEME_BUSINESS_2("img_header_contact", "img_footer_main");
	
	private String headerStyle;
	private String footerStyle;
	
	private C02_PageTheme(String headerStyle, String footerStyle) {
		this.setHeaderStyle(headerStyle);
		this.setFooterStyle(footerStyle);
	}
	
	public String getHeaderStyle() {
		return headerStyle;
	}
	
	public void setHeaderStyle(String headerStyle) {
		this.headerStyle = headerStyle;
	}
	
	public String getFooterStyle() {
		return footerStyle;
	}
	
	public void setFooterStyle(String footerStyle) {
		this.footerStyle = footerStyle;
	}
	
}
