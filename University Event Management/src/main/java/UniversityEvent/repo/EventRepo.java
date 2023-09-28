package UniversityEvent.repo;

import UniversityEvent.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<EventModel,Integer> {
    List<EventModel> findByDate(LocalDate date);
}
