package ohtu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ohtu.database.dto.BookHintDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.service.BookHintService;

@Controller
public class Controllers {
	
	@Autowired
	private BookHintService bhService;
	
	@Autowired
	private BookHintRepository bhRep;

    @GetMapping("/")
    public String home(Model model) {    	
        return "home";
    }
    
    @GetMapping("/hint/add")
}