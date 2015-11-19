import java.util.ArrayList;
import java.util.Map.Entry;


public class Graph {
	
	public double x_start;
	public double x_end;
	
	public Graph(double x_start, double x_end) {
		this.x_start = x_start;
		this.x_end = x_end;
	}
	
	double getFuzzyValDown(double x) {
		double m = (1/(x_start-x_end));
		double c = -m*x_end;
		double y = m*x + c;
		
		return (y > 1) ? 1 : (y < 0) ? 0 : y;
	}
	
	double getFuzzyValTriangle(double x) {
		double center = x_start+(x_end-x_start)/2.0;
		if (x < center) {
			double x_end = center;
			double m = (-1/(x_start-x_end));
			double c = -m*x_start;
			double y = m*x + c;
			
			return (y > 1) ? 1 : (y < 0) ? 0 : y;
		} else {
			double x_start = center;
			double m = (1/(x_start-x_end));
			double c = -m*x_end;
			double y = m*x + c;
			
			return (y > 1) ? 1 : (y < 0) ? 0 : y;
		}
	}
	
	double getFuzzyValUp(double x) {
		double m = (-1/(x_start-x_end));
		double c = -m*x_start;
		double y = m*x + c;
		
		return (y > 1) ? 1 : (y < 0) ? 0 : y;
	}
}
