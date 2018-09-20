package xy.inc.repository;

import java.util.ArrayList;
import java.util.List;

import xy.inc.models.Point;

public class Repository {
	
	public static List<Point> pointsOfInterest = new ArrayList<Point>();
	public static List<Point> nearPoints = new ArrayList<Point>();
	
	public static void loadList() {
		
		pointsOfInterest.add(new Point("Lanchonete", 27, 12));
		pointsOfInterest.add(new Point("Posto", 31, 18));
		pointsOfInterest.add(new Point("Joalheria", 15, 12));
		pointsOfInterest.add(new Point("Floricultura", 19, 21));
		pointsOfInterest.add(new Point("Pub", 12, 8));
		pointsOfInterest.add(new Point("Supermercado", 23, 6));
		pointsOfInterest.add(new Point("Churrascaria", 28, 2));		
		
	}

}
