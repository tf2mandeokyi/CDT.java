package com.mndk.cdt;


/**
 * Edge connecting two vertices: vertex with smaller index is always first.<br>
 * Note: hash Edge is specialized at the bottom
 * @author artem-ogre
 */
public class Edge {

	public int v1, v2;
	
	public Edge(int iV1, int iV2) {
		this.v1 = Math.min(iV1, iV2); this.v2 = Math.max(iV1, iV2);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Edge) {
			Edge e = (Edge) obj;
			if(e.v1 == v1 && e.v2 == v2) {
				return true;
			}
		}
		return false;
	}
	
}
