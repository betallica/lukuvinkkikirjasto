package ohtu.controller;

import ohtu.database.repository.BookHintRepository;
import ohtu.database.repository.HintRepository;
import ohtu.model.Tag;
import ohtu.service.HintService;
import ohtu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    final private int HINTS_PER_PAGE = 10;

    @Autowired
    private BookHintRepository bhRep;

    @Autowired
    private HintService hintService;
    @Autowired
    private HintRepository hintRepository;

    @Autowired
    private TagService tagService;


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
        Boolean isRead = isReadFromString(request.getParameter("isread"));
        String[] tags = request.getParameterValues("tags");
        String keyword = request.getParameter("keyword");

        if(keyword == null)keyword="";

        String filter = request.getParameter("filter");

        int pageNumber = 1;
        int totalHints = hintService.totalNumberOfHints(isRead, tagService.getTagsByNames(tags), keyword);

        if (action != null) {
            pageNumber = newPageNumber(request.getParameter("page"), action, totalHints);
        }

        model.addAttribute("page", pageNumber);
        model.addAttribute("totalPages", totalNumberOfPages(totalHints));
        model.addAttribute("hints", hintService.getHintsInPage(pageNumber, HINTS_PER_PAGE, isRead, tagService.getTagsByNames(tags), keyword));
        model.addAttribute("tags", tagService.getAllTags());
        model.addAttribute("filter", filter);

        return "home";
    }

    private int newPageNumber(String pageParameter, String action, int totalPages) {
        int page = Integer.parseInt(pageParameter);
        if (action.equals("prev")) {
            return Math.max(0, page - 1);
        } else {
            return Math.min(totalPages, page + 1);
        }
    }

    private int totalNumberOfPages(int totalHints) {
        return ((totalHints - 1) / HINTS_PER_PAGE) + 1;
    }

    private Boolean isReadFromString(String paramString) {
        if (paramString == null) {
            return (Boolean) null;
        } else if (paramString.equals("read")) {
            return true;
        } else if (paramString.equals("unread")) {
            return false;
        } else {
            return (Boolean) null;
        }
    }

}
