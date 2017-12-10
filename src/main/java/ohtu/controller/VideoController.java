package ohtu.controller;

import ohtu.database.dto.CommentDto;
import ohtu.database.dto.VideoHintDto;
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
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

@Controller
public class VideoController {

    @Autowired
    private HintService hintService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;

    @GetMapping("/video/add")
    public String addVideo(Model model) {
        VideoHintDto vhDto = new VideoHintDto();

        model.addAttribute("videoHintDto", vhDto);
        model.addAttribute("allTags", tagService.getAllTags());

        return "add_video";
    }
    
    @GetMapping("/videos/{id}/edit")
    public String editVideo(Model model, @ModelAttribute @Valid VideoHintDto videoHintDto, BindingResult result, @PathVariable long id) {

        model.addAttribute("videoHint", hintService.getHint(id));
        model.addAttribute("allTags", tagService.getAllTags());

        return "edit_video";
    }
    
    @PostMapping("/videos/{id}/edit")
    public String saveVideoEdit(Model model, @ModelAttribute @Valid VideoHintDto videoHintDto, BindingResult result, @PathVariable long id) {
        if (!result.hasErrors()) {
            hintService.editHint(id, videoHintDto);

            return "redirect:/videos/{id}";
        } else {
            
            for (ObjectError error : result.getAllErrors()) {
                FieldError fError = (FieldError) error;
                System.out.println(fError.getField() + " : " + fError.getCode());
            }
            
            model.addAttribute("videoHintDto", videoHintDto);
            model.addAttribute("allTags", tagService.getAllTags());
            return "edit_video";
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
