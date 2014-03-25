package cz.jantobola.blog.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Article extends AbstractPage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Section section;
	private boolean deleted = false;
	private boolean concept;
	
	@Transient
	private Long sectionId;
	
	public Section getSection() {
		return section;
	}
	
	public void setSection(Section section) {
		this.section = section;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
	public Long getSectionId() {
		return sectionId;
	}
	
	public void setSectionId(Long sectionId) {
		this.sectionId = sectionId;
	}

	public boolean isConcept() {
		return concept;
	}

	public void setConcept(boolean concept) {
		this.concept = concept;
	}
	
}
