package ohtu;

import java.util.ArrayList;
import java.util.Date;

import javax.naming.Binding;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import ohtu.database.dto.BlogHintDto;

import ohtu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ohtu.database.dto.TagDto;
import ohtu.database.dto.BookHintDto;
import ohtu.database.dto.CommentDto;
import ohtu.database.dto.VideoHintDto;
import ohtu.database.repository.BookHintRepository;
import ohtu.model.Hint;
import ohtu.model.Tag;
import ohtu.service.CommentService;
import ohtu.service.HintService;

import java.util.List;

@Controller
public class Controllers {

    @Autowired
    private HintService hintService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;


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
        model.addAttribute("allTags", tagService.getAllTags());

        return "add_blog";
    }
    
    @GetMapping("/video/add")
    public String addVideo(Model model) {
        VideoHintDto vhDto = new VideoHintDto();

        model.addAttribute("videoHintDto", vhDto);
        model.addAttribute("allTags", tagService.getAllTags());

        return "add_video";
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
        	for (ObjectError error : result.getAllErrors()) {
				FieldError fError = (FieldError) error;
				System.out.println(fError.getField() + " : " + fError.getCode());
			}
            model.addAttribute("blogHintDto", blogHintDto);
            model.addAttribute("allTags", tagService.getAllTags());
            return "add_blog";
        }
    }
    
    @PostMapping("/video/add")
    public String saveVideo(Model model, @ModelAttribute @Valid VideoHintDto videoHintDto, BindingResult result) {
        if (!result.hasErrors()) {
            hintService.createHint(videoHintDto);

            return "redirect:/";
        } else {
            model.addAttribute("videoHintDto", videoHintDto);
            model.addAttribute("allTags", tagService.getAllTags());
            return "add_video";
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

    @GetMapping("/tags/add")
    public String addTag(@ModelAttribute TagDto tagDto) {
        return "add_tag";
    }

    @PostMapping("/tags/add")
    public String saveTag(Model model, @ModelAttribute @Valid TagDto tagDto, BindingResult result) {
        if (result.hasErrors()) {
            return "add_tag";
        }
        tagService.createTag(tagDto);
        return "redirect:/";
    }

    @GetMapping("/videos/{id}")
    public String getVideo(Model model, @PathVariable long id) {
        model.addAttribute("videoHint", hintService.getHint(id));
        model.addAttribute("comments", commentService.getCommentsForHint(id));

        CommentDto commentDto = new CommentDto();
        model.addAttribute("commentDto", commentDto);
        return "video";
    }

    @PostMapping(value = "/videos/{id}", params = "text")
    public String addCommentForVideo(Model model, @ModelAttribute @Valid CommentDto commentDto, BindingResult result,
            @PathVariable long id) {
        if (!result.hasErrors()) {
            commentDto.setHint(hintService.getHint(id));
            commentService.createComment(commentDto);
        } else {
            model.addAttribute("videoHint", hintService.getHint(id));
            model.addAttribute("comments", commentService.getCommentsForHint(id));

            model.addAttribute("commentDto", commentDto);

            return "video";
        }
        return "redirect:/videos/" + id;
    }

    // Nyt video on "luettu", mikä muoto olisi parempi?
    @PostMapping(value = "/videos/{id}", params = "isRead")
    public String markVideoAsRead(Model model, @PathVariable long id) {
        Hint hint = hintService.getHint(id);
        if (hint.getIsRead()) {
            hint.setIsRead(false);
        } else {
            hint.setIsRead(true);
        }
        hintService.saveHint(hint);

        return "redirect:/videos/" + id;
    }

}
