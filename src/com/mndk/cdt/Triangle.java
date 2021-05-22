package com.mndk.cdt;

/**
 * Triangulation triangle (Counter-clockwise winding)
 * 
 * @author artem-ogre
 *
 */
public class Triangle {

	public Array3<Integer> vertices; // Triangle's vertices
	public Array3<Integer> neighbors; // Triangle's three neighbors
	
	public Triangle(Array3<Integer> vertices, Array3<Integer> neighbors) {
		this.vertices = vertices;
		this.neighbors = neighbors;
	}
	
}
