package ohtu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ohtu.database.dto.BlogHintDto;
import ohtu.database.dto.VideoHintDto;
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
        bh.setTags(blogHintDto.getTags());
        blogHintRepository.save(bh);

        return bh;
    }
    
    public BlogHint editBlogHint(Long id, BlogHintDto blogHintDto) {
        BlogHint bh = this.getBlogHint(id);
        bh.setName(blogHintDto.getName());
        bh.setAuthor(blogHintDto.getAuthor());
        bh.setUrl(blogHintDto.getUrl());
        bh.setTags(blogHintDto.getTags());
        blogHintRepository.save(bh);
        
        return bh;
}

    public BlogHint getBlogHint(Long id) {
        return blogHintRepository.findOne(id);
    }

    public BlogHint saveBlogHint(BlogHint blogHint) {
        return blogHintRepository.save(blogHint);
    }
    
        public BlogHintDto getBlogHintDto(BlogHint blogHint) {
        BlogHintDto blogHintDto = new BlogHintDto();
        blogHintDto.setAuthor(blogHint.getAuthor());
        blogHintDto.setUrl(blogHint.getUrl());
        blogHintDto.setName(blogHint.getName());
        blogHintDto.setTags(blogHint.getTags());
        return blogHintDto;
    }

    
}
