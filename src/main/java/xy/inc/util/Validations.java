package xy.inc.util;

import xy.inc.models.Point;

public class Validations {

    public static boolean check(Point point){
        if(pointsPositive(point) && fieldsCompleted(point)){
            return true;
        }
        else{
            return false;
        }

    }

    private static boolean pointsPositive(Point point){

        if(point.getCoordinatedX()>=0 && point.getCoordinatedY()>=0){
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean fieldsCompleted(Point point){

        if(point==null){
            return false;
        }
        else {
            return true;
        }
    }
}
