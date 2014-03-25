package cz.jantobola.blog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;

/**
 * @author Jan Tobola
 * 
 */
public abstract class AbstractService implements MessageSourceAware {
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	protected MessageSourceAccessor messages;
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		MessageSourceAccessor msa = new MessageSourceAccessor(messageSource);
		this.messages = msa;
	}
	
}
