package ohtu.service;

import ohtu.database.dto.VideoHintDto;
import ohtu.model.Hint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ohtu.database.dto.BlogHintDto;
import ohtu.database.dto.BookHintDto;
import ohtu.database.dto.HintDto;
import ohtu.database.repository.HintRepository;

import java.util.List;
import ohtu.model.BlogHint;
import ohtu.model.BookHint;
import ohtu.model.VideoHint;

import javax.transaction.Transactional;

@Service
public class HintService {

    @Autowired
    private HintRepository hintRepository;

    @Autowired
    private BookHintService bookHintService;
    @Autowired
    private BlogHintService blogHintService;
    @Autowired
    private VideoHintService videoHintService;

    public Hint createHint(HintDto hintDto) {
        if (hintDto instanceof BookHintDto) {
            return bookHintService.createBookHint((BookHintDto) hintDto);
        } else if (hintDto instanceof BlogHintDto) {
            return blogHintService.createBlogHint((BlogHintDto) hintDto);
        } else if (hintDto instanceof VideoHintDto) {
            return videoHintService.createBlogHint((VideoHintDto) hintDto);
        }

        return null;
    }

    public List<Hint> getHintsInPage(int pageNumber, int numberOfHints, Boolean isRead) {
        final int pageIndex = pageNumber - 1;
        Pageable pageable = new PageRequest(pageIndex, numberOfHints);
        Page<Hint> pages;
        if (isRead != null) {
            pages = hintRepository.findByIsReadOrderByIdDesc(isRead, pageable);
        } else {
            pages = hintRepository.findAllByOrderByIdDesc(pageable);
        }
        return pages.getContent();
    }

    public int totalNumberOfHints(Boolean isRead) {
        if (isRead != null) {
            return hintRepository.findByIsRead(isRead).size();
        } else {
            return hintRepository.findAll().size();
        }
    }

    public Hint getHint(Long id) {
        return hintRepository.findOne(id);
    }

    public void saveHint(Hint hint) {
        if (hint instanceof BookHint) {
            bookHintService.saveBookHint((BookHint) hint);
        } else if (hint instanceof BlogHint) {
            blogHintService.saveBlogHint((BlogHint) hint);
        } else if (hint instanceof VideoHint) {
            videoHintService.saveVideoHint((VideoHint) hint);
        }
    }
}
