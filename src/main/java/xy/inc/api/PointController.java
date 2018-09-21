package xy.inc.api;

import java.util.Collection;
import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xy.inc.models.Point;
import xy.inc.repository.Repository;

@RestController
public class PointController {

    @RequestMapping(
            value = "/mypoints",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Point>> getGreetings() {

        initList();

        Collection<Point> points = Repository.pointsOfInterest;
        return new ResponseEntity<Collection<Point>>(points, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/mypoints/delete/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> deletePoint(@PathVariable("id") Integer id, @RequestBody Point point) {

        Repository.pointsOfInterest.add(point);
        return new ResponseEntity<Point>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(
            value = "/mypoints/update/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Point> updatePoints(@RequestBody Point upDatePoint) {

        Point point = Repository.pointsOfInterest.get(3);///LOGICA UPDATE
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

        Repository.pointsOfInterest.add(newPoint);
        return new ResponseEntity<Point>(newPoint, HttpStatus.CREATED);
    }

    private static void initList(){
        if(Repository.pointsOfInterest.size()==0){
            Repository.loadList();
            Collections.sort(Repository.pointsOfInterest);
        }
    }

    private static void update(Point point){
        if(Repository.pointsOfInterest.equals(point)){
            Repository.pointsOfInterest.add(point);
        }
    }
}
