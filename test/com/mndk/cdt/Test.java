package com.mndk.cdt;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		
		try {
			Triangulation cdt = new Triangulation();
			
			List<V2d> points = Arrays.asList(new V2d[] {
					new V2d(0, 0), new V2d(0, 1), new V2d(0, 2), 
					new V2d(1, 0),                new V2d(1, 2), 
					new V2d(2, 0),                new V2d(2, 2), 
					new V2d(3, 0), new V2d(3, 1), new V2d(3, 2)
			});
			
			List<IndexEdge> edges = Arrays.asList(new IndexEdge[] {
					new IndexEdge(2, 7)
			});
			
			cdt.insertVertices(points);
			
			for(IndexTriangle t : cdt.triangles) {
				System.out.println(t);
			}
			
			cdt.insertEdges(edges);
			
			cdt.eraseSuperTriangle();
			V2d[][] triangles = cdt.getTriangles();
			
			for(V2d[] t : triangles) {
				System.out.println("[" + t[0] + ", " + t[1] + ", " + t[2] + "]");
			}
			
			// System.out.println(CDTUtils.locatePointLine(new V2d(15, 28), new V2d(-30, 10), new V2d(29, -15)));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
