package ohtu.controller;

import ohtu.database.dto.BlogHintDto;
import ohtu.database.dto.CommentDto;
import ohtu.model.Hint;
import ohtu.service.CommentService;
import ohtu.service.HintService;
import ohtu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class BlogController {

    @Autowired
    private HintService hintService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @GetMapping("/blog/add")
    public String addBlog(Model model) {
        BlogHintDto bhDto = new BlogHintDto();

        model.addAttribute("blogHintDto", bhDto);
        model.addAttribute("allTags", tagService.getAllTags());

        return "add_blog";
    }

    @PostMapping("/blog/add")
    public String saveBlog(Model model, @ModelAttribute @Valid BlogHintDto blogHintDto, BindingResult result) {
        if (!result.hasErrors()) {
            hintService.createHint(blogHintDto);

            return "redirect:/";
        } else {
            for (ObjectError error : result.getAllErrors()) {
                FieldError fError = (FieldError) error;
                System.out.println(fError.getField() + " : " + fError.getCode());
            }
            model.addAttribute("blogHintDto", blogHintDto);
            model.addAttribute("allTags", tagService.getAllTags());
            return "add_blog";
        }
    }

    @GetMapping("/blogs/{id}")
    public String getBlog(Model model, @PathVariable long id) {
        model.addAttribute("blogHint", hintService.getHint(id));
        model.addAttribute("comments", commentService.getCommentsForHint(id));

        CommentDto commentDto = new CommentDto();
        model.addAttribute("commentDto", commentDto);
        return "blog";
    }
    
    @GetMapping("/blogs/{id}/edit")
    public String editBlog(Model model, @ModelAttribute @Valid BlogHintDto blogHintDto, BindingResult result, @PathVariable long id) {
        
        model.addAttribute("blogHint", hintService.getHint(id));
        model.addAttribute("allTags", tagService.getAllTags());
        
        return "edit_blog";
    }
    
    @PostMapping("/blogs/{id}/edit")
    
    public String saveBlogEdit (Model model, @ModelAttribute @Valid BlogHintDto blogHintDto, BindingResult result, @PathVariable long id) {
        if (!result.hasErrors()) {
            hintService.editHint(id, blogHintDto);

            return "redirect:/blogs/{id}";
        } else {
            for (ObjectError error : result.getAllErrors()) {
                FieldError fError = (FieldError) error;
                System.out.println(fError.getField() + " : " + fError.getCode());
            }
            model.addAttribute("blogHintDto", blogHintDto);
            model.addAttribute("allTags", tagService.getAllTags());
            return "edit_blog";
        }
}

    @PostMapping(value = "/blogs/{id}", params = "text")
    public String addCommentForBlog(Model model, @ModelAttribute @Valid CommentDto commentDto, BindingResult result,
                                    @PathVariable long id) {
        if (!result.hasErrors()) {
            commentDto.setHint(hintService.getHint(id));
            commentService.createComment(commentDto);
        } else {
            model.addAttribute("blogHint", hintService.getHint(id));
            model.addAttribute("comments", commentService.getCommentsForHint(id));

            model.addAttribute("commentDto", commentDto);

            return "blog";
        }

        return "redirect:/blogs/" + id;
    }

    @PostMapping(value = "/blogs/{id}", params = "isRead")
    public String markBlogAsRead(Model model, @PathVariable long id) {
        Hint hint = hintService.getHint(id);
        if (hint.getIsRead()) {
            hint.setIsRead(false);
        } else {
            hint.setIsRead(true);
        }
        hintService.saveHint(hint);

        return "redirect:/blogs/" + id;
    }

}
