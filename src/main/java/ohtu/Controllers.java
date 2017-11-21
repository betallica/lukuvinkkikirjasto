package ohtu;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ohtu.database.dto.BookHintDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.model.BookHint;
import ohtu.service.BookHintService;

@Controller
public class Controllers {

    @Autowired
    private BookHintService bhService;

    @Autowired
    private BookHintRepository bhRep;

    /**
     * Request is made to home address and all book hints are added to model.
     * @param model
     * @return View of home file is sent.
     */
    @GetMapping("/")
    public String home(Model model) {
    	ArrayList<BookHint> hints = (ArrayList<BookHint>)bhRep.findAll();
    	
    	model.addAttribute("hints", hints);
    	
        return "home";
    }
    
    /**
     * A request is made to the hint/add address and a book hint is added to the model.
     * @param model
     * @return Creates a view of add_hint sends it.
     */
    @GetMapping("/hint/add")
    public String addBook(Model model){
    	model.addAttribute("bookHintDto", new BookHintDto());
    	
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
    		bhService.createBookHint(bookHintDto);
    	
    		return "redirect:/";
    	} else {       		
    		model.addAttribute("bookHintDto", bookHintDto);
        	
            return "add_hint";
    	}
    }
}
