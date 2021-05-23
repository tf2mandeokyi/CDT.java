package com.mndk.cdt;

import java.util.List;


/**
 * Information about removed duplicated vertices.
 * <p>
 * Contains mapping information and removed duplicates indices.
 * <p>
 * Note: vertices <code>{0,1,2,3,4}</code> where 0 and 3 are the same will produce mapping
 *       <code>{0,1,2,0,3}</code> (to new vertices <code>{0,1,2,3}</code>) and duplicates <code>{3}</code>
 * 
 * @author artem-ogre
 */
public class DuplicatesInfo {


	
	/**
	 * Vertex index mapping
	 */
	public List<Integer> mapping;
	
	/**
	 * Duplicates' indices
	 */
	public List<Integer> duplicates;
	
	
	
	
	
	
//	/**
//	 * Find duplicates in given vector array.<br>
//	 * Note: duplicates are points with exactly same X and Y coordinates.
//	 * @param vertices
//	 * @return Information about vertex duplicates
//	 */
//	public static DuplicatesInfo findDuplicates(List<V2d> vertices);
	
	
	
	/**
	 * Remove duplicates in-place from vector of custom points.
	 * @param vertices Vertices to remove duplicates from
	 * @param duplicates Information about duplicates
	 */
	public static void removeDuplicates(List<V2d> vertices, List<Integer> duplicates);
	
	
	
	/**
	 * Remove duplicated points in-place
	 * @param vertices Collection of vertices to remove duplicates from
	 * @return Information about duplicated vertices that were removed.
	 */
	public static DuplicatesInfo removeDuplicates(List<V2d> vertices);
	
	
	
	/**
	 * Remap vertex indices in edges (in-place) using given vertex-index mapping.
	 * <p>
	 * Note: Mapping can be a result of {@link #removeDuplicates(List)}.
	 * @param edges Collection of edges to remap
	 * @param mapping Vertex-index mapping
	 */
	public void remapEdges(List<IndexEdge> edges, List<Integer> mapping);
	
	
	
	/**
	 * Same as a chained call of {@link #removeDuplicates(List)} and {@link #remapEdges(List, List)}.
	 * @param vertices Collection of vertices to remove duplicates from
	 * @param edges Collection of edges to remap
	 * @return Information about vertex duplicates
	 */
	public DuplicatesInfo removeDuplicatesAndRemapEdges(List<V2d> vertices, List<IndexEdge> edges);
	
}
