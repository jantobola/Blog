package cz.jantobola.blog.message;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Jan Tobola
 * 
 */
public class AlertProvider implements AlertSource {
	
	private MessageSourceAccessor messageSourceAccessor;
	
	public AlertProvider() {
		
	}
	
	public AlertProvider(MessageSourceAccessor messageSourceAccessor) {
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
	@Override
	public void error(Model model, String message) {
		model.addAttribute(ERROR_MESSAGE, getMessageInternal(message));
	}
	
	@Override
	public void warning(Model model, String message) {
		model.addAttribute(WARNING_MESSAGE, getMessageInternal(message));
	}
	
	@Override
	public void info(Model model, String message) {
		model.addAttribute(INFO_MESSAGE, getMessageInternal(message));
	}
	
	@Override
	public void success(Model model, String message) {
		model.addAttribute(SUCCESS_MESSAGE, getMessageInternal(message));
	}
	
	@Override
	public void error(RedirectAttributes ra, String message) {
		ra.addFlashAttribute(ERROR_MESSAGE, getMessageInternal(message));
	}
	
	@Override
	public void warning(RedirectAttributes ra, String message) {
		ra.addFlashAttribute(WARNING_MESSAGE, getMessageInternal(message));
	}
	
	@Override
	public void info(RedirectAttributes ra, String message) {
		ra.addFlashAttribute(INFO_MESSAGE, getMessageInternal(message));
	}
	
	@Override
	public void success(RedirectAttributes ra, String message) {
		ra.addFlashAttribute(SUCCESS_MESSAGE, getMessageInternal(message));
	}
	
	private String getMessageInternal(String message) {
		if (messageSourceAccessor != null) {
			return messageSourceAccessor.getMessage(message, message, LocaleContextHolder.getLocale());
		}
		
		return message;
	}
	
	public MessageSourceAccessor getMessageSourceAccessor() {
		return messageSourceAccessor;
	}
	
	public void setMessageSourceAccessor(MessageSourceAccessor messageSourceAccessor) {
		this.messageSourceAccessor = messageSourceAccessor;
	}
	
}
