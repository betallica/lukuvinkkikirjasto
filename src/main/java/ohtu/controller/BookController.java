package ohtu.controller;

import ohtu.database.dto.BookHintDto;
import ohtu.database.dto.CommentDto;
import ohtu.model.Hint;
import ohtu.service.CommentService;
import ohtu.service.HintService;
import ohtu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import ohtu.database.dto.BlogHintDto;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private TagService tagService;

    @Autowired
    private HintService hintService;

    @Autowired
    private CommentService commentService;

    /**
     * A request is made to the hint/add address and a book hint is added to the
     * model.
     *
     * @param model
     * @return Creates a view of add_book sends it.
     */
    @GetMapping("/book/add")
    public String addBook(Model model) {
        BookHintDto bhDto = new BookHintDto();

        model.addAttribute("bookHintDto", bhDto);
        model.addAttribute("allTags", tagService.getAllTags());
        return "add_book";
    }
    
    @GetMapping("/books/{id}/edit")
    public String editBook(Model model, @PathVariable long id) throws Exception {
        
        BookHintDto bookHintDto = (BookHintDto) hintService.getHintDto(id);
        
        model.addAttribute("bookHintDto", bookHintDto);
        model.addAttribute("bookHintId", id);
        model.addAttribute("allTags", tagService.getAllTags());
        
        
        return "edit_book";
    }

    /**
     * Checks if that the book hint is added successfully.
     *
     * @param model
     * @param bookHintDto
     * @param result
     * @return Redirects to home or creates view of add_book and sends it.
     */
    @PostMapping("/book/add")
    public String saveBook(Model model, @ModelAttribute @Valid BookHintDto bookHintDto, BindingResult result, RedirectAttributes redirect) {
        if (!result.hasErrors()) {
            hintService.createHint(bookHintDto);
            redirect.addFlashAttribute("notification", "Kirjavinkki lisätty!");
            return "redirect:/";
        } else {
            model.addAttribute("allTags", tagService.getAllTags());
            model.addAttribute("bookHintDto", bookHintDto);
            return "add_book";
        }
    }
    
    @PostMapping("/books/{id}/edit")
    public String saveBookEdit (Model model, @ModelAttribute @Valid BookHintDto bookHintDto, BindingResult result, @PathVariable long id) {
        if (!result.hasErrors()) {
            hintService.editHint(id, bookHintDto);

            return "redirect:/books/{id}";
        } else {
            
            model.addAttribute("bookHint", hintService.getHint(id));
            model.addAttribute("bookHintDto", bookHintDto);
            model.addAttribute("bookHintId", id);
            model.addAttribute("allTags", tagService.getAllTags());
            return "edit_book";
        }
}

    /**
     * A request is made to the books/{id} address and a specific book hint is
     * added to the model.
     *
     * @param model
     * @param id of the book hint
     * @return Creates a view of the info of the book hint sends it.
     */
    @GetMapping("/books/{id}")
    public String getHint(Model model, @PathVariable long id) {
        model.addAttribute("bookHint", hintService.getHint(id));
        model.addAttribute("comments", commentService.getCommentsForHint(id));

        CommentDto commentDto = new CommentDto();
        model.addAttribute("commentDto", commentDto);
        return "book";
    }

    @PostMapping(value = "/books/{id}", params = "text")
    public String addCommentForBook(Model model, @ModelAttribute @Valid CommentDto commentDto, BindingResult result,
                                    @PathVariable long id, RedirectAttributes redirect) {
        if (!result.hasErrors()) {
            commentDto.setHint(hintService.getHint(id));
            commentService.createComment(commentDto);
        } else {
            model.addAttribute("bookHint", hintService.getHint(id));
            model.addAttribute("comments", commentService.getCommentsForHint(id));

            model.addAttribute("commentDto", commentDto);

            return "book";
        }
        redirect.addFlashAttribute("notification", "Kommentti lisätty!");
        return "redirect:/books/" + id;
    }

    @PostMapping(value = "/books/{id}", params = "isRead")
    public String markBookAsRead(Model model, @PathVariable long id) {
        Hint hint = hintService.getHint(id);
        if (hint.getIsRead()) {
            hint.setIsRead(false);
        } else {
            hint.setIsRead(true);
        }
        hintService.saveHint(hint);
        return "redirect:/books/" + id;
    }

}
