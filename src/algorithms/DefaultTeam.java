package algorithms;

import java.awt.Point;
import java.util.ArrayList;

/***************************************************************
 * TME 1: calcul de diamètre et de cercle couvrant minimum.    *
 *   - Trouver deux points les plus éloignés d'un ensemble de  *
 *     points donné en entrée.                                 *
 *   - Couvrir l'ensemble de poitns donné en entrée par un     *
 *     cercle de rayon minimum.                                *
 *                                                             *
 * class Circle:                                               *
 *   - Circle(Point c, int r) constructs a new circle          *
 *     centered at c with radius r.                            *
 *   - Point getCenter() returns the center point.             *
 *   - int getRadius() returns the circle radius.              *
 *                                                             *
 * class Line:                                                 *
 *   - Line(Point p, Point q) constructs a new line            *
 *     starting at p ending at q.                              *
 *   - Point getP() returns one of the two end points.         *
 *   - Point getQ() returns the other end point.               *
 ***************************************************************/
import supportGUI.Circle;
import supportGUI.Line;

public class DefaultTeam {

  // calculDiametre: ArrayList<Point> --> Line
  //   renvoie une paire de points de la liste, de distance maximum.
  public Line calculDiametre(ArrayList<Point> points) {
    if (points.size()<3) {
      return null;
    }

    Point pf=points.get(0);
    Point qf=points.get(1);

   
    Double distance_max = null ;
    
    
    for (Point p : points) {
    	for (Point q : points) {
    		if (distance_max == null) {
    			distance_max = distance(p,q);
    		
    		} else {
    			double d  = distance (p,q);
    			if (d < distance_max) {
    				
    			}
    		}
		}
		
	}
    return null;
    //return new Line(p,q);
  }

  // calculCercleMin: ArrayList<Point> --> Circle
  //   renvoie un cercle couvrant tout point de la liste, de rayon minimum.
  public Circle calculCercleMin(ArrayList<Point> points) {
    if (points.isEmpty()) {
      return null;
    }
    

    Point center=points.get(0);
    int radius=100;

    /*******************
     * PARTIE A ECRIRE *
     *******************/
    for (Point p : points) {
		for (Point q : points) {
			center.setLocation((p.x+q.x)/2, (p.y + q.y)/2 );
			radius = (int) distance(p, q);
			Circle circle = new Circle(center, radius);
			if (cerclecontainsAll(circle, points)  ) {
				return circle;
			}
			
		}
	}
    return new Circle(center, radius);
  }
  private Circle AlgoRitter (ArrayList<Point> points) {
	  if (points.isEmpty()) {
	  return null;
	}
	  Point dummy = points.get(0);
	  Point pPL;
	  for (Point p : points) {
		
	}
	  return null;
  }
  
  
  
  
  private double distance (Point p, Point q) {
	  double dx = p.getX() - q.getX();
	  double dy = p.getY() - q.getY();
	  return Math.sqrt(dx*dx + dy*dy);	  
  }
  
  
  private boolean cerclecontainsAll(Circle circle, ArrayList<Point> points) {
	  for (Point p : points) {
		
		 if (distance(p , circle.getCenter()) > circle.getRadius()) {
			 return false;
		 }
	  }
	  return true;
  }
}
