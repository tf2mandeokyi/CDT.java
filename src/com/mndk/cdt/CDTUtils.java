package com.mndk.cdt;

import java.util.List;

public class CDTUtils {

	
	
	/**
	 * Advance vertex or neighbor index counter-clockwise
	 * @param i
	 * @return
	 */
	public static int ccw(int i) {
		return (i + 1) % 3;
	}
	
	
	
	/**
	 * Advance vertex or neighbor index clockwise
	 * @param i
	 * @return
	 */
	public static int cw(int i) {
		return (i + 2) % 3;
	}
	
	
	
	/**
	 * Neighbor index from a on-edge location
	 * Note: Call only if located on the edge!
	 * @param location
	 * @return
	 */
	public static int edgeNeighbor(final PtTriLocation location) {
		int result = location.ordinal() - PtTriLocation.ON_EDGE1.ordinal();
		assert result >= 0;
		return result;
	}
	
	
	
	/**
	 * Test if point lies in a circumscribed circle of a triangle.
	 * @param p
	 * @param v1
	 * @param v2
	 * @param v3
	 * @return
	 */
	public static boolean inCircumCircle(
			final V2d p,
			final V2d v1,
			final V2d v2,
			final V2d v3
	);
	
	
	
	/**
	 * Check if location is classified as on any of three edges
	 * @param location
	 * @return
	 */
	public static boolean onEdge(PtTriLocation location) {
		return location.ordinal() > PtTriLocation.OUTSIDE.ordinal();
	}
	
	
	
	/**
	 * Check if point lies to the left of, to the right of, or on a line.
	 * @param p
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static PtLineLocation locatePointLine(V2d p, V2d v1, V2d v2);
	
	
	
	/**
	 * Check if point a lies inside of, outside of, or on an edge of a triangle.
	 * @param p
	 * @param v1
	 * @param v2
	 * @param v3
	 * @return
	 */
	public static PtTriLocation locatePointTriangle(V2d p, V2d v1, V2d v2, V2d v3);
	
	
	
	/**
	 * If triangle has a given neighbor return neighbor-index, throw otherwise.
	 * @param tri
	 * @param iTnbr Index of a triangle neighbor
	 * @return
	 */
	public static int neighborIndex(Triangle tri, int iTnbr) {
		if(iTnbr == tri.neighbors.e1) return 0;
		if(iTnbr == tri.neighbors.e2) return 1;
		if(iTnbr == tri.neighbors.e3) return 2;
		throw new RuntimeException("Could not find neighbor triangle index");
	}
	
	
	
	/**
	 * Opposed neighbor index from vertex index.
	 * @param vertIndex
	 * @return
	 */
	public static int opoNbr(int vertIndex) {
		if(vertIndex >= 0 && vertIndex <= 2) return (vertIndex + 1) % 3;
		throw new RuntimeException("Invalid vertex index");
	}
	
	
	
	/**
	 * Opposed vertex index from neighbor index.
	 * @param neighborIndex
	 * @return
	 */
	public static int opoVrt(int neighborIndex) {
		if(neighborIndex >= 0 && neighborIndex <= 2) return (neighborIndex + 2) % 3;
		throw new RuntimeException("Invalid neighbor index");
	}
	
	
	
	/**
	 * Given triangle and a vertex find opposed triangle.
	 * @param tri
	 * @param iVert Index of a vertex
	 * @return
	 */
	public static int opposedTriangle(Triangle tri, int iVert) {
		int index = opposedTriangleIndex(tri, iVert);
		if(index == 0) return tri.neighbors.e1;
		if(index == 1) return tri.neighbors.e2;
		if(index == 2) return tri.neighbors.e3;
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	
	
	/**
	 * Index of triangle's neighbor opposed to a vertex.
	 * @param tri
	 * @param iVert Index of a vertex
	 * @return
	 */
	public static int opposedTriangleIndex(Triangle tri, int iVert) {
		if(iVert == tri.vertices.e1) return opoNbr(0);
		if(iVert == tri.vertices.e2) return opoNbr(1);
		if(iVert == tri.vertices.e3) return opoNbr(2);
		throw new RuntimeException("Could not find opposed triangle index");
	}
	
	
	
	/**
	 * Index of triangle's neighbor opposed to an edge.
	 * @param tri
	 * @param iVedge1
	 * @param iVedge2
	 * @return
	 */
	public static int opposedTriangleIndex(Triangle tri, int iVedge1, int iVedge2) {
		if(iVedge1 != tri.vertices.e1 && iVedge2 != tri.vertices.e1) return opoNbr(0);
		if(iVedge1 != tri.vertices.e2 && iVedge2 != tri.vertices.e2) return opoNbr(1);
		if(iVedge1 != tri.vertices.e3 && iVedge2 != tri.vertices.e3) return opoNbr(2);
		throw new RuntimeException("Could not find opposed-to-edge triangle index");
	}
	
	
	
	/**
	 * Given two triangles, return vertex of first triangle opposed to the second.
	 * @param tri
	 * @param iTopo Index of opposed triangle
	 * @return
	 */
	public static int opposedVertex(Triangle tri, int iTopo) {
		int index = opposedVertexIndex(tri, iTopo);
		if(index == 0) return tri.vertices.e1;
		if(index == 1) return tri.vertices.e2;
		if(index == 2) return tri.vertices.e3;
		throw new ArrayIndexOutOfBoundsException(index);
	}
	
	
	
	/**
	 * Index of triangle's vertex opposed to a triangle
	 * @param tri
	 * @param iTopo Index of opposed triangle
	 * @return
	 */
	public static int opposedVertexIndex(Triangle tri, int iTopo) {
		if(iTopo == tri.vertices.e1) return opoVrt(0);
		if(iTopo == tri.vertices.e2) return opoVrt(1);
		if(iTopo == tri.vertices.e3) return opoVrt(2);
		throw new RuntimeException("Could not find opposed vertex index");
	}
	
	
	
	/**
	 * If triangle has a given vertex return vertex-index, throw otherwise.
	 * @param tri
	 * @param iV Index of a vertex
	 * @return
	 */
	public static int vertexIndex(Triangle tri, int iV) {
		if(iV == tri.vertices.e1) return 0;
		if(iV == tri.vertices.e2) return 1;
		if(iV == tri.vertices.e3) return 2;
		throw new RuntimeException("Could not find vertex index in triangle");
	}
	
	
	
	/**
	 * Test if two vertices share at least one common triangle.
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean verticesShareEdge(Vertex a, Vertex b) {
		List<Integer> aTris = a.triangles, bTris = b.triangles;
	}
}
