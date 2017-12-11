package ohtu.service;

import ohtu.database.dto.VideoHintDto;
import ohtu.model.Hint;
import ohtu.model.Tag;

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
import java.util.Set;

import ohtu.model.BlogHint;
import ohtu.model.BookHint;
import ohtu.model.VideoHint;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
            return videoHintService.createVideoHint((VideoHintDto) hintDto);
        }

        return null;
    }
    
    public Hint editHint(Long id, HintDto hintDto) {
        Hint hint= this.getHint(id);
        if (hint instanceof BlogHint) {
            return blogHintService.editBlogHint(id, (BlogHintDto) hintDto);
        } else if (hint instanceof BookHint) {
            return bookHintService.editBookHint(id, (BookHintDto) hintDto);
        } else if (hint instanceof VideoHint) {
            return videoHintService.editVideoHint(id, (VideoHintDto) hintDto);
        }

        return null;
}

    public List<Hint> getHintsInPage(int pageNumber, int numberOfHints, Boolean isRead, Set<Tag> tags, String keyword) {
        final int pageIndex = pageNumber - 1;
        Pageable pageable = new PageRequest(pageIndex, numberOfHints);
        Page<Hint> pages;
        
        pages = hintRepository.findByFilters(isRead, tags, keyword, pageable);
        return pages.getContent();
    }

    public int totalNumberOfHints(Boolean isRead, Set<Tag> tags, String keyword) {
        int totalHints = Math.max(hintRepository.findAll().size(), 1);
        return getHintsInPage(1, totalHints, isRead, tags, keyword).size();
    }

    public Hint getHint(Long id) {
        return hintRepository.findOne(id);
    }

    public HintDto getHintDto(Long id) throws Exception {
        Hint hint = getHint(id);
        if (hint instanceof VideoHint) {
            return videoHintService.getVideoHintDto((VideoHint) hint);
        } else if (hint instanceof BlogHint) {
            return blogHintService.getBlogHintDto((BlogHint) hint);
        } else if (hint instanceof BookHint) {
            return bookHintService.getBookHintDto((BookHint) hint);
        } else {
            throw new NotImplementedException();
        }
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
