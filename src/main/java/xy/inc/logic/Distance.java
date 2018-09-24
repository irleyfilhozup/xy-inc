package xy.inc.logic;

import java.util.ArrayList;
import java.util.Collection;
import xy.inc.models.Point;
import xy.inc.models.PointSearch;

public class Distance {
	
	public static Collection<Point> check(PointSearch pointSearch, Collection<Point> pointsOfInterest) {
		int pointX;
		int pointY;

		Collection<Point> nearPoints = new ArrayList<Point>();
		for(Point point : pointsOfInterest) {
			pointX = (pointSearch.getCoordinatedX()-point.getCoordinatedX()) * (pointSearch.getCoordinatedX()-point.getCoordinatedX());
			pointY =
					(pointSearch.getCoordinatedY()-point.getCoordinatedY()) * (pointSearch.getCoordinatedY()-point.getCoordinatedY());
			if(sum(pointX,pointY)<=pointSearch.getMaximumDistance()) {
				nearPoints.add(point);
			}
		}
		return nearPoints;
	}

	private static int sum(int pointX, int pointY) {
		
		return (int) Math.sqrt((pointX+pointY));
	}

}
