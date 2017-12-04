package ohtu.database.repository;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 2bc3937333619634b48067995cf3d6f2001a6551
import ohtu.model.Hint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


@Component
public interface HintRepository extends JpaRepository<Hint, Long> {
	
	public Page<Hint> findAllByOrderByIdDesc(Pageable pageable);

	public Page<Hint> findByIsReadOrderByIdDesc(Boolean isRead, Pageable pageable);

	public List<Hint> findByIsRead(Boolean isRead);

	
}
