package com.mndk.cdt;

import java.util.List;


/**
 * 2D bounding box.
 * @author artem-ogre
 */
public class Box2d {
	
	public V2d min, max;
	
	public Box2d(V2d min, V2d max) {
		this.min = min; this.max = max;
	}
	
	/**
	 * Bounding box of a collection of 2D points.
	 * @param vertices
	 * @return
	 */
	public static Box2d envelope(List<V2d> vertices) {
		double max = Double.MAX_VALUE;
		Box2d box = new Box2d(new V2d(max, max), new V2d(-max, -max));
		for(V2d vertex : vertices) {
			box.min.x = Math.min(vertex.x, box.min.x);
			box.max.x = Math.max(vertex.x, box.max.x);
			box.min.y = Math.min(vertex.y, box.min.y);
			box.max.y = Math.max(vertex.y, box.max.y);
		}
		return box;
	}
	
}
