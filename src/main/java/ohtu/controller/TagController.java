package ohtu.controller;

import ohtu.database.dto.TagDto;
import ohtu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TagController {

    @Autowired
    private TagService tagService;

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

}
