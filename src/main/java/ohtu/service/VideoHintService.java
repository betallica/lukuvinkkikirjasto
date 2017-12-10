package ohtu.service;

import ohtu.database.dto.BookHintDto;
import ohtu.database.dto.VideoHintDto;
import ohtu.database.repository.VideoHintRepository;
import ohtu.model.BookHint;
import ohtu.model.VideoHint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoHintService {
    
    @Autowired
    private VideoHintRepository videoHintRepository;
    
    public VideoHint createVideoHint(VideoHintDto videoHintDto) {
        VideoHint vh = new VideoHint();
        vh.setAuthor(videoHintDto.getAuthor());
        vh.setName(videoHintDto.getName());
        vh.setUrl(videoHintDto.getUrl());
        vh.setType("Video");
        vh.setIsRead(false);
        vh.setTags(videoHintDto.getTags());
        videoHintRepository.save(vh);

        return vh;
    }
    
        public VideoHint editVideoHint(Long id, VideoHintDto videoHintDto) {
        VideoHint vh = this.getVideoHint(id);
        vh.setName(videoHintDto.getName());
        vh.setAuthor(videoHintDto.getAuthor());
        vh.setUrl(videoHintDto.getUrl());
        vh.setTags(videoHintDto.getTags());
        videoHintRepository.save(vh);
        
        return vh;
}
        
        public VideoHint getVideoHint(Long id) {
		return videoHintRepository.findOne(id);
	}


    VideoHint saveVideoHint(VideoHint videoHint) {
        return videoHintRepository.save(videoHint); //To change body of generated methods, choose Tools | Templates.
    }
    
}
