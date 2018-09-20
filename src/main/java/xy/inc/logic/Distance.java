package xy.inc.logic;

import xy.inc.models.Point;
import xy.inc.repository.Repository;

public class Distance {
	
	public static void check(int x, int y, int dMax) {
		int pointX;
		int pointY;
		
		Repository.nearPoints.clear();
		
		for(Point point : Repository.pointsOfInterest) {
			pointX = (x-point.getCoordinatedX()) * (x-point.getCoordinatedX());
			pointY = (y-point.getCoordinatedY()) * (y-point.getCoordinatedY());
			if(sum(pointX,pointY)<=dMax) {
				Repository.nearPoints.add(point);
			}
		}		
	}

	private static int sum(int pointX, int pointY) {
		
		return (int) Math.sqrt((pointX+pointY));
	}

}
