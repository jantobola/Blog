package cz.jantobola.blog.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.jantobola.blog.domain.Section;
import cz.jantobola.blog.domain.User;
import cz.jantobola.blog.repository.SectionRepository;
import cz.jantobola.blog.service.AbstractService;
import cz.jantobola.blog.service.SectionService;

@Service
public class SectionServiceImpl extends AbstractService implements SectionService {

	@Autowired
	private SectionRepository sectionRepository;
	
	@Override
	@Transactional
	public void saveSection(Section section, Long id) {
		if (id != null) {
			Section edited = sectionRepository.findOne(id);
			
			edited.setDescription(section.getDescription());
			edited.setName(section.getName());
			
			log.info("EDITED SECTION with id: " + id);
		} else {
			
			section.setAuthor(User.getCurrentUser());
			section.setCreationDate(new Date());
			
			sectionRepository.save(section);
			log.info("SAVED NEW SECTION");
		}
	}

}
