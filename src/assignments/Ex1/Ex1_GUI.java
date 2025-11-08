package assignments.Ex1;
//import assignments.Ex1.sol.Ex1_Sol;

/**
 *  * Introduction to Computer Science 2026, Ariel University,
 *  * Ex1: arrays, static functions and JUnit
 *
 * This class is a very simple GUI (Graphic User Interface) main class, which 
 * uses the StdDraw (see: https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html) 
 * in order to draw two polynoms in a defined range.
 * Make sure you follow all the examples below, there is no need to change this class
 * @author boaz.benmoshe
 */
public class Ex1_GUI {
	public static void main(String[] a) {
		double min = -10, max=10;
        int samples = 16;
		StdDraw.setScale(min, max);
		StdDraw.clear();
		double[] po4 = {2,1,-0.7, -0.02,0.02};
        double[] po3 = Ex1.derivative(po4);
        testGUI(po3,po4, min, max, samples);
	}
	
	public static void testGUI(double[] po1, double[] po2, double min, double max, int samples) {
		int n=1000;
        double[] x1 = {-10,-5,0,5};
        double[] x2 = {x1[0]+5,x1[1]+5,x1[2]+5,x1[3]+5};
        double[] xx = new double[x1.length];
        String ps = "";
        for(int i=0;i<xx.length; i=i+1) {
            xx[i] = Ex1.sameValue(po1, po2, x1[i], x2[i], Ex1.EPS);
            String s = ""+xx[i];
            int m = Math.min(7, s.length());
            ps += i+") "+s.substring(0,m)+"  ";
        }

		StdDraw.setPenColor(StdDraw.GRAY);
		drawGrid(min,max);
        StdDraw.setPenRadius(0.005);
		StdDraw.setPenColor(StdDraw.BLACK);
		drawArea(po1,po2, xx[0], 10, samples);
		StdDraw.setPenColor(StdDraw.BLUE);
		drawPoly(po1, min, max,n);
        drawInfo(po2,0,8);
		StdDraw.setPenColor(StdDraw.GREEN);
		drawPoly(po2, min, max,n);
		drawInfo(po1,0,7);

        StdDraw.setPenColor(StdDraw.BLACK);
		double area = Ex1.area(po1, po2, xx[0], 6, samples);
        StdDraw.text(0,-8,"xx: "+ps);
		StdDraw.text(0,-9,"Area:  "+area+",  "+samples+" samples");
	}
	public static void drawPoly(double[] poly, double x1, double x2, int numberOfElements) {
		double x0=x1;
		double y0 = Ex1.f(poly, x0);
		double delta = (x2-x1)/numberOfElements;
		for(double x = x1+delta;x<=x2;x+=delta) {
			double y1 = Ex1.f(poly, x);
			StdDraw.line(x0, y0, x, y1);
			x0=x;
			y0 = y1;
		} 
	} 
	public static void drawArea(double[] p1, double[] p2, double x1, double x2, int numberOfElements) {
		double x0=x1;
		double y01 = Ex1.f(p1, x0);
		double y02 = Ex1.f(p2, x0);
		double delta = (x2-x1)/numberOfElements;
		for(double x = x1+delta;x<=x2;x+=delta) {
			double y11 = Ex1.f(p1, x);
			double y12 = Ex1.f(p2, x);
			double[] xx = {x0,x,x,x0};
			double[] yy = {y01,y11,y12,y02};
			StdDraw.setPenColor(StdDraw.ORANGE);
			StdDraw.filledPolygon(xx, yy);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.polygon(xx, yy);
			x0=x;
			y01 = y11;
			y02=y12;
		} 
	} 
	public static void drawInfo(double[] poly, double x, double y) {
		String s = Ex1.poly(poly);
		StdDraw.text(x,y,s);
	}
	public static void drawGrid(double min, double max) {
		StdDraw.line(0,min,0,max);
		StdDraw.line(min,0,max,0);
	}
}
