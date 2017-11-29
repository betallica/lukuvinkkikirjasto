package ohtu.database.repository;

import ohtu.model.VideoHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface VideoHintRepository extends JpaRepository<VideoHint, Long> {
    
}
