package cz.jantobola.blog.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import cz.jantobola.blog.message.AlertProvider;
import cz.jantobola.blog.message.ValidationAlertSource;
import cz.jantobola.blog.util.PageInfo;

/**
 * @author Jan Tobola
 * 
 */
@Controller
public abstract class AbstractController extends AlertProvider implements MessageSourceAware, ValidationAlertSource {
	
	protected MessageSourceAccessor messages;
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		MessageSourceAccessor msa = new MessageSourceAccessor(messageSource);
		this.messages = msa;
		setMessageSourceAccessor(msa);
	}
	
	public boolean checkError(BindingResult result, Model model, String msg) {
		if (result.hasErrors()) {
			error(model, msg);
			return true;
		}
		
		return false;
	}
	
	protected void initPageInfo(PageInfo pageInfo) {
		pageInfo.setPageNumber(0);
		pageInfo.setPageSize(10);
	}
	
}
