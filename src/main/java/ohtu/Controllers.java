package ohtu;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/")
    public String home(Model model) {
    	ArrayList<BookHint> hints = (ArrayList<BookHint>)bhRep.findAll();
    	
    	model.addAttribute("hints", hints);
    	
        return "home";
    }
    
    @GetMapping("/hint/add")
    public String addBook(Model model){
    	model.addAttribute("bookHintDto", new BookHintDto());
    	
        return "add_hint";
    }
    
    @PostMapping("/hint/add")
    public String saveBook(Model model, @ModelAttribute BookHintDto bookHintDto) {
    	bhService.createBookHint(bookHintDto);
    	
    	return "redirect:/";
    }
}
