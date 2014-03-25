package cz.jantobola.blog.message;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Jan Tobola
 * 
 */
public interface AlertSource {

    /**
     * 
     */
    public final static String ERROR_MESSAGE = "errorMsg";

    /**
     * 
     */
    public final static String WARNING_MESSAGE = "warningMsg";

    /**
     * 
     */
    public final static String INFO_MESSAGE = "infoMsg";

    /**
     * 
     */
    public final static String SUCCESS_MESSAGE = "successMsg";

    /**
     * @param model
     * @param message
     */
    public void error(Model model, String message);

    /**
     * @param model
     * @param message
     */
    public void warning(Model model, String message);

    /**
     * @param model
     * @param message
     */
    public void info(Model model, String message);

    /**
     * @param model
     * @param message
     */
    public void success(Model model, String message);

    /**
     * @param ra
     * @param message
     */
    public void error(RedirectAttributes ra, String message);

    /**
     * @param ra
     * @param message
     */
    public void warning(RedirectAttributes ra, String message);

    /**
     * @param ra
     * @param message
     */
    public void info(RedirectAttributes ra, String message);

    /**
     * @param ra
     * @param message
     */
    public void success(RedirectAttributes ra, String message);

}
