package ohtu.database.repository;

import ohtu.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TagRepository extends JpaRepository<Tag, Long> {

    public Tag findByName(String name);

}
