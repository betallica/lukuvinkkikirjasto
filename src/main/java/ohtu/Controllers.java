package ohtu;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import ohtu.database.dto.BookHintDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.service.BookHintService;
import ohtu.service.HintService;

@Controller
public class Controllers {
	
	@Autowired
	private HintService hintService;


    @Autowired
    private BookHintRepository bhRep;

    final private int HINTS_PER_PAGE = 10;

    /**
     * Request is made to home address and all book hints are added to model.
     * @param model
     * @return View of home file is sent.
     */
    @GetMapping("/")
    public String home(Model model, HttpServletRequest request) {

    	String action = request.getParameter("action");
    	int page;

    	if (action == null) {
    	    page = 0;
        } else {
    	    page = newPageNumber(request.getParameter("page"), action);
        }

    	model.addAttribute("page", page);
        model.addAttribute("totalPages", totalNumberOfPages());
    	model.addAttribute("hints", hintService.getHintsInPage(page, HINTS_PER_PAGE));

        return "home";
    }

    /**
     * A request is made to the hint/add address and a book hint is added to the model.
     * @param model
     * @return Creates a view of add_hint sends it.
     */
    @GetMapping("/hint/add")
    public String addBook(Model model){
    	BookHintDto bhDto = new BookHintDto();
    	
    	model.addAttribute("bookHintDto", bhDto);
    	
        return "add_hint";
    }
    
    /**
     * Checks if that the book hint is added successfully.
     * @param model
     * @param bookHintDto
     * @param result
     * @return Redirects to home or creates view of add_hint and sends it.
     */
    @PostMapping("/hint/add")
    public String saveBook(Model model, @ModelAttribute @Valid BookHintDto bookHintDto, BindingResult result) {   	
     	if(!result.hasErrors()) {
    		hintService.createHint(bookHintDto);
    	
    		return "redirect:/";
    	} else {       		
    		model.addAttribute("bookHintDto", bookHintDto);
        	
            return "add_hint";
    	}
    }

    @GetMapping("/books/{id}")
    public String getHint(Model model, @PathVariable long id) {
        model.addAttribute("bookHint", hintService.getHint(id));
        return "book";
    }

   @GetMapping("/blogs/{id}")
   public String getBlog(Model model, @PathVariable long id) {
        model.addAttribute("blogHint", hintService.getHint(id));
        return "blog";
   }

    private int newPageNumber(String pageParameter, String action) {
        int page = Integer.parseInt(pageParameter);
        if (action.equals("prev")) {
            return Math.max(0, page - 1);
        } else {
            return Math.min(totalNumberOfPages(), page + 1);
        }
    }

    private int totalNumberOfPages() {
        int totalHints = bhRep.findAll().size();
        return (totalHints - 1) / HINTS_PER_PAGE;
    }


}
