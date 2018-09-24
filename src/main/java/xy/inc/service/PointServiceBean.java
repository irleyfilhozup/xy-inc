package xy.inc.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xy.inc.models.Point;
import xy.inc.repository.PointRepository;
import xy.inc.util.Validations;

@Service
public class PointServiceBean implements PointService {

    @Autowired
    private PointRepository pointRepository;

    @Override
    public Collection<Point> findAll() {
        return pointRepository.findAll();
    }

    @Override
    public Point findOne(int id) {
        return pointRepository.findOne(id);
    }

    @Override
    public Point create(Point newPoint) {
        if(Validations.check(newPoint)) {
            return pointRepository.save(newPoint);
        }
        return null;
    }

    @Override
    public Point update(Point point) {
        if (!Validations.check(point)) {
            return null;
        }
        Point pointPersisted = findOne((point.getId()));
        if(pointPersisted == null) {
            //Nao existe no bd
            return null;
        }

        Point updatePoint = pointRepository.save(point);
        return updatePoint;
    }

    @Override
    public void delete(int id) { pointRepository.delete(id);}
}
