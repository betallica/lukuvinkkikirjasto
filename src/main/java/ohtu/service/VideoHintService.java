package ohtu.service;

import ohtu.database.dto.VideoHintDto;
import ohtu.database.repository.VideoHintRepository;
import ohtu.model.VideoHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoHintService {
    
    @Autowired
    private VideoHintRepository videoHintRepository;
    
    public VideoHint createBlogHint(VideoHintDto videoHintDto) {
        VideoHint vh = new VideoHint();
        vh.setAuthor(videoHintDto.getAuthor());
        vh.setName(videoHintDto.getName());
        vh.setUrl(videoHintDto.getUrl());
        vh.setType("Video");
        vh.setIsRead(false);
        videoHintRepository.save(vh);

        return vh;
    }
    
}
