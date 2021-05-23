package com.mndk.cdt;

/**
 * 2D vector
 * @author artem-ogre
 */
public class V2d {

	public double x, y;
	
	public V2d(double x, double y) {
		this.x = x; this.y = y;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof V2d) {
			V2d v = (V2d) obj;
			return x == v.x && y == v.y;
		}
		return false;
	}
	
	/**
	 * @param a
	 * @param b
	 * @return distance between two 2D points
	 */
	public static double distance(V2d a, V2d b) {
		double dx = b.x - a.x, dy = b.y - a.y;
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
}
