package xy.inc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Point {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer coordinatedX;
	private Integer coordinatedY;
	
	public Point(String name, int x, int y) {
		this.name = name;
		this.coordinatedX = x;
		this.coordinatedY = y;
	}
	
	public Point() {		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getCoordinatedX() {
		return coordinatedX;
	}
	
	public void setCoordinatedX(Integer coordinatedX) {
		this.coordinatedX = coordinatedX;
	}
	
	public Integer getCoordinatedY() {
		return coordinatedY;
	}
	
	public void setCoordinatedY(Integer coordinatedY) {
		this.coordinatedY = coordinatedY;
	}
	
	@Override
    public String toString() {
        return "'"+this.name+
        		"' (x="+this.coordinatedX+
        		", y="+this.coordinatedY+")";
	}
}
