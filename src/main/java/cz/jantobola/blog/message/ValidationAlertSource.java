package cz.jantobola.blog.message;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

/**
 * @author Jan Tobola
 * 
 */
public interface ValidationAlertSource extends AlertSource {

    /**
     * @param result
     * @param model
     * @param message
     * @return
     */
    public boolean checkError(BindingResult result, Model model, String message);

}
