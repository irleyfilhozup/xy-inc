package xy.inc.service;



import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import xy.inc.models.Point;
import xy.inc.repository.PointRepository;
import xy.inc.util.Validations;

@Service
@Transactional(
        propagation = Propagation.SUPPORTS,
        readOnly = true
)
public class PointServiceBean implements PointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public Collection<Point> findAll() {
        return pointRepository.findAll();
    }

    @Override
    public Point findOne(int id) {

        Optional<Point> optional =  pointRepository.findById(id);

        return optional.get();
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public Point create(Point newPoint) {
        if(Validations.check(newPoint)) {
            Point point = pointRepository.save(newPoint);
            return point;
        }

        return null;
    }


    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public Point update(Point point, Integer id) {
        if (!Validations.check(point)) {
            return null;
        }
        Point pointPersisted = findOne(id);
        if(pointPersisted == null) {
            //Nao existe no bd
            return null;
        }
        point.setId(id);
        Point updatePoint = pointRepository.save(point);
        return updatePoint;
    }

    @Override
    @Transactional(
            propagation = Propagation.REQUIRED,
            readOnly = false
    )
    public void delete(int id) { pointRepository.deleteById(id);}
}
