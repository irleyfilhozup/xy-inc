package xy.inc.service;

import java.util.Collection;

import xy.inc.models.Point;

public interface PointService {

    Collection<Point> findAll();

    Point findOne(int id);

    Point create(Point point);

    Point update(Point point, Integer id);

    void delete(int id);

}
