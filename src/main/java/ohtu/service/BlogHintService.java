package ohtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ohtu.database.dto.BlogHintDto;
import ohtu.database.repository.BlogHintRepository;
import ohtu.model.BlogHint;
import ohtu.model.VideoHint;

@Service
public class BlogHintService {

    @Autowired
    private BlogHintRepository blogHintRepository;

    public BlogHint createBlogHint(BlogHintDto blogHintDto) {
        BlogHint bh = new BlogHint();
        bh.setAuthor(blogHintDto.getAuthor());
        bh.setName(blogHintDto.getName());
        bh.setUrl(blogHintDto.getUrl());
        bh.setType("Blog");
        bh.setIsRead(false);
        blogHintRepository.save(bh);

        return bh;
    }

    public BlogHint getBlogHint(Long id) {
        return blogHintRepository.findOne(id);
    }

    public BlogHint saveBlogHint(BlogHint blogHint) {
        return blogHintRepository.save(blogHint);
    }

    
}
