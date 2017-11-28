package ohtu;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import ohtu.database.dto.BlogHintDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import ohtu.database.dto.BookHintDto;
import ohtu.database.dto.CommentDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.model.Hint;
import ohtu.service.BookHintService;
import ohtu.service.CommentService;
import ohtu.service.HintService;

@Controller
public class Controllers {

    @Autowired
    private HintService hintService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private BookHintRepository bhRep;

    final private int HINTS_PER_PAGE = 10;

    /**
     * Request is made to home address and all book hints are added to model.
     *
     * @param model
     * @param request
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

        return "add_book";
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
    public String saveBook(Model model, @ModelAttribute @Valid BookHintDto bookHintDto, BindingResult result) {
        if (!result.hasErrors()) {
            hintService.createHint(bookHintDto);

            return "redirect:/";
        } else {
            model.addAttribute("bookHintDto", bookHintDto);

            return "add_book";
        }
    }

    /**
     * A request is made to the hint/add address and a blog hint is added to the
     * model.
     *
     * @param model
     * @return Creates a view of add_blog sends it.
     */
    @GetMapping("/blog/add")
    public String addBlog(Model model) {
        BlogHintDto bhDto = new BlogHintDto();

        model.addAttribute("blogHintDto", bhDto);

        return "add_blog";
    }

    /**
     * Checks if that the book hint is added successfully.
     *
     * @param model
     * @param blogHintDto
     * @param result
     * @return Redirects to home or creates view of add_blog and sends it.
     */
    @PostMapping("/blog/add")
    public String saveBlog(Model model, @ModelAttribute @Valid BlogHintDto blogHintDto, BindingResult result) {
        if (!result.hasErrors()) {
            hintService.createHint(blogHintDto);

            return "redirect:/";
        } else {
            model.addAttribute("blogHintDto", blogHintDto);

            return "add_blog";
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

    @PostMapping(value="/books/{id}", params="isRead")
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

    @PostMapping(value = "/books/{id}", params = "text")
    public String addCommentForBook(Model model, @ModelAttribute @Valid CommentDto commentDto, @PathVariable long id, BindingResult result) {
        if (!result.hasErrors()) {
            commentDto.setHint(hintService.getHint(id));
            commentService.createComment(commentDto);
        } else {
            model.addAttribute("commentDto", commentDto);

            return "book";
        }

        return "redirect:/books/" + id;
    }

    /**
     * A request is made to the books/{id} address and a specific book hint is
     * added to the model
     *
     * @param model
     * @param id of the blog hint
     * @return Creates a view of the info of the blog hint sends it.
     */
    @GetMapping("/blogs/{id}")
    public String getBlog(Model model, @PathVariable long id) {
        model.addAttribute("blogHint", hintService.getHint(id));
        model.addAttribute("comments", commentService.getCommentsForHint(id));

        CommentDto commentDto = new CommentDto();
        model.addAttribute("commentDto", commentDto);
        return "blog";
    }

    @PostMapping(value="/blogs/{id}", params="isRead")
    public String markBlogAsRead(Model model, @PathVariable long id) {
        Hint hint = hintService.getHint(id);
        if (hint.getIsRead()) {
            hint.setIsRead(false);
        } else {
            hint.setIsRead(true);
        }
        hintService.saveHint(hint);
        
        return "redirect:/blogs/"+id;
    }

    @PostMapping(value = "/blogs/{id}", params = "text")
    public String addCommentForBlog(Model model, @ModelAttribute
            @Valid CommentDto commentDto, @PathVariable long id, BindingResult result) {
        if (!result.hasErrors()) {
            commentDto.setHint(hintService.getHint(id));
            commentService.createComment(commentDto);
        } else {
            model.addAttribute("commentDto", commentDto);

            return "blog";
        }

        return "redirect:/blogs/" + id;
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
