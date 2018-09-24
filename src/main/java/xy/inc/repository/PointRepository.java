package xy.inc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import xy.inc.models.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Integer> {
}
