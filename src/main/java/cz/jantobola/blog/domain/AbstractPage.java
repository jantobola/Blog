package cz.jantobola.blog.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import cz.jantobola.blog.enumeration.C02_PageTheme;

@Entity
//@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractPage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE)
	private User author;

	@ManyToOne(cascade = CascadeType.MERGE)
	private User editor;

	@Enumerated(EnumType.STRING)
	private C02_PageTheme pageTheme;

	@Lob
	@Column(length = 512)
	private String content;
	private Date creationDate;
	private int editCount;
	private String headline;
	private Date lastChange;
	private int popularIndex;
	private int visitIndex;
	private String url;
	private String ribbon;
	private String resource;

	@OneToMany(mappedBy = "page")
	private List<MediaFile> mediaFiles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getEditCount() {
		return editCount;
	}

	public void setEditCount(int editCount) {
		this.editCount = editCount;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public Date getLastChange() {
		return lastChange;
	}

	public void setLastChange(Date lastChange) {
		this.lastChange = lastChange;
	}

	public int getPopularIndex() {
		return popularIndex;
	}

	public void setPopularIndex(int popularIndex) {
		this.popularIndex = popularIndex;
	}

	public int getVisitIndex() {
		return visitIndex;
	}

	public void setVisitIndex(int visitIndex) {
		this.visitIndex = visitIndex;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public C02_PageTheme getPageTheme() {
		return pageTheme;
	}

	public void setPageTheme(C02_PageTheme pageTheme) {
		this.pageTheme = pageTheme;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getEditor() {
		return editor;
	}

	public void setEditor(User editor) {
		this.editor = editor;
	}

	public String getRibbon() {
		return ribbon;
	}

	public void setRibbon(String ribbon) {
		this.ribbon = ribbon;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public List<MediaFile> getMediaFiles() {
		return mediaFiles;
	}

	public void setMediaFiles(List<MediaFile> mediaFiles) {
		this.mediaFiles = mediaFiles;
	}

}
