package tasks.employer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tasks.employer.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long>{
}
