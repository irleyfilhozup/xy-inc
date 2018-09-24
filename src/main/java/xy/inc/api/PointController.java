package xy.inc.api;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xy.inc.logic.Distance;
import xy.inc.models.Point;
import xy.inc.models.PointSearch;
import xy.inc.service.PointService;

@RestController
public class PointController {

    @Autowired
    PointService pointService;

    @RequestMapping(
            value = "/mypoints",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Point>> getPoints() {

        Collection<Point> points = pointService.findAll();

        return new ResponseEntity<Collection<Point>>(points, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/mypoints/delete/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> deletePoint(@PathVariable("id") Integer id, @RequestBody Point point) {

        pointService.delete(id);
        return new ResponseEntity<Point>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/mypoints/update/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> updatePoints(@RequestBody Point upDatePoint) {

        if (upDatePoint.getId()<0){
            return null;
        }
        Point point = pointService.update(upDatePoint);
        if(point == null) {
            return  new ResponseEntity<Point>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Point>(point, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/mypoints/add",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> createPoint(@RequestBody Point newPoint) {

        pointService.create(newPoint);
        return new ResponseEntity<Point>(newPoint, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/mypoints/search",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Point>> getPointsClosest (@RequestBody PointSearch pointSearch) {

        Collection<Point> points = Distance.check(pointSearch, pointService.findAll());

        return new ResponseEntity<Collection<Point>>(points, HttpStatus.OK);
    }
}
