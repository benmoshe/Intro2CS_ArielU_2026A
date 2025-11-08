package assignments.Ex1;

import assignments.Ex1.sol.Ex1_Sol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  * Introduction to Computer Science 2026, Ariel University,
 *  * Ex1: arrays, static functions and JUnit
 *
 * This JUnit class represents a JUnit (unit testing) for Ex1-
 * It contains few testing functions for the polynomial functions as define in Ex1.
 * Note: you should add additional JUnit testing functions to this class.
 *
 * @author boaz.ben-moshe
 */

class Ex1Test {
	static final double[] P1 ={2,0,3, -1,0}, P2 = {0.1,0,1, 0.1,3};
	static double[] po1 = {2,2}, po2 = {-3, 0.61, 0.2};;
	static double[] po3 = {2,1,-0.7, -0.02,0.02};
	static double[] po4 = {-3, 0.61, 0.2};
	
 	@Test
	/**
	 * Tests that f(x) == poly(x).
	 */
	void testF() {
		double fx0 = Ex1_Sol.f(po1, 0);
		double fx1 = Ex1_Sol.f(po1, 1);
		double fx2 = Ex1_Sol.f(po1, 2);
		assertEquals(fx0, 2, Ex1_Sol.EPS);
		assertEquals(fx1, 4, Ex1_Sol.EPS);
		assertEquals(fx2, 6, Ex1_Sol.EPS);
	}
	@Test
	/**
	 * Tests that p1(x) + p2(x) == (p1+p2)(x)
	 */
	void testF2() {
		double x = Math.PI;
		double[] po12 = Ex1_Sol.add(po1, po2);
		double f1x = Ex1_Sol.f(po1, x);
		double f2x = Ex1_Sol.f(po2, x);
		double f12x = Ex1_Sol.f(po12, x);
		assertEquals(f1x + f2x, f12x, Ex1_Sol.EPS);
	}
	@Test
	/**
	 * Tests that p1+p2+ (-1*p2) == p1
	 */
	void testAdd() {
		double[] p12 = Ex1_Sol.add(po1, po2);
		double[] minus1 = {-1};
		double[] pp2 = Ex1_Sol.mul(po2, minus1);
		double[] p1 = Ex1_Sol.add(p12, pp2);
		assertTrue(Ex1_Sol.equals(p1, po1));
	}
	@Test
	/**
	 * Tests that p1+p2 == p2+p1
	 */
	void testAdd2() {
		double[] p12 = Ex1_Sol.add(po1, po2);
		double[] p21 = Ex1_Sol.add(po2, po1);
		assertTrue(Ex1_Sol.equals(p12, p21));
	}
	@Test
	/**
	 * Tests that p1+0 == p1
	 */
	void testAdd3() {
		double[] p1 = Ex1_Sol.add(po1, Ex1_Sol.ZERO);
		assertTrue(Ex1_Sol.equals(p1, po1));
	}
	@Test
	/**
	 * Tests that p1*0 == 0
	 */
	void testMul1() {
		double[] p1 = Ex1_Sol.mul(po1, Ex1_Sol.ZERO);
		assertTrue(Ex1_Sol.equals(p1, Ex1_Sol.ZERO));
	}
	@Test
	/**
	 * Tests that p1*p2 == p2*p1
	 */
	void testMul2() {
		double[] p12 = Ex1_Sol.mul(po1, po2);
		double[] p21 = Ex1_Sol.mul(po2, po1);
		assertTrue(Ex1_Sol.equals(p12, p21));
	}
	@Test
	/**
	 * Tests that p1(x) * p2(x) = (p1*p2)(x),
	 */
	void testMulDoubleArrayDoubleArray() {
		double[] xx = {0,1,2,3,4.1,-15.2222};
		double[] p12 = Ex1_Sol.mul(po1, po2);
		for(int i = 0;i<xx.length;i=i+1) {
			double x = xx[i];
			double f1x = Ex1_Sol.f(po1, x);
			double f2x = Ex1_Sol.f(po2, x);
			double f12x = Ex1_Sol.f(p12, x);
			assertEquals(f12x, f1x*f2x, Ex1_Sol.EPS);
		}
	}
	@Test
	/**
	 * Tests a simple derivative examples - till ZERO.
	 */
	void testDerivativeArrayDoubleArray() {
		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] pt = {2,6}; // 6x+2
		double[] dp1 = Ex1_Sol.derivative(p); // 2x + 6
		double[] dp2 = Ex1_Sol.derivative(dp1); // 2
		double[] dp3 = Ex1_Sol.derivative(dp2); // 0
		double[] dp4 = Ex1_Sol.derivative(dp3); // 0
		assertTrue(Ex1_Sol.equals(dp1, pt));
		assertTrue(Ex1_Sol.equals(Ex1_Sol.ZERO, dp3));
		assertTrue(Ex1_Sol.equals(dp4, dp3));
	}
	@Test
	/** 
	 * Tests the parsing of a polynom in a String like form.
	 */
	public void testFromString() {
		double[] p = {-1.1,2.3,3.1}; // 3.1X^2+ 2.3x -1.1
		String sp2 = "3.1x^2 +2.3x -1.1";
		String sp = Ex1_Sol.poly(p);
		double[] p1 = Ex1_Sol.getPolynomFromString(sp);
		double[] p2 = Ex1_Sol.getPolynomFromString(sp2);
		boolean isSame1 = Ex1_Sol.equals(p1, p);
		boolean isSame2 = Ex1_Sol.equals(p2, p);
		if(!isSame1) {fail();}
		if(!isSame2) {fail();}
		assertEquals(sp, Ex1_Sol.poly(p1));
	}
	@Test
	/**
	 * Tests the equality of pairs of arrays.
	 */
	public void testEquals() {
		double[][] d1 = {{0}, {1}, {1,2,0,0}};
		double[][] d2 = {Ex1_Sol.ZERO, {1+ Ex1_Sol.EPS/2}, {1,2}};
		double[][] xx = {{-2* Ex1_Sol.EPS}, {1+ Ex1_Sol.EPS*1.2}, {1,2, Ex1_Sol.EPS/2}};
		for(int i=0;i<d1.length;i=i+1) {
			assertTrue(Ex1_Sol.equals(d1[i], d2[i]));
		}
		for(int i=0;i<d1.length;i=i+1) {
			assertFalse(Ex1_Sol.equals(d1[i], xx[i]));
		}
	}

	@Test
	/**
	 * Tests is the sameValue function is symmetric.
	 */
	public void testSameValue2() {
		double x1=-4, x2=0;
		double rs1 = Ex1_Sol.sameValue(po1,po2, x1, x2, Ex1_Sol.EPS);
		double rs2 = Ex1_Sol.sameValue(po2,po1, x1, x2, Ex1_Sol.EPS);
		assertEquals(rs1,rs2, Ex1_Sol.EPS);
	}
	@Test
	/**
	 * Test the area function - it should be symmetric.
	 */
	public void testArea() {
		double x1=-4, x2=0;
		double a1 = Ex1_Sol.area(po1, po2, x1, x2, 100);
		double a2 = Ex1_Sol.area(po2, po1, x1, x2, 100);
		assertEquals(a1,a2, Ex1_Sol.EPS);
}
	@Test
	/**
	 * Test the area f1(x)=0, f2(x)=x;
	 */
	public void testArea2() {
		double[] po_a = Ex1_Sol.ZERO;
		double[] po_b = {0,1};
		double x1 = -1;
		double x2 = 2;
		double a1 = Ex1_Sol.area(po_a,po_b, x1, x2, 1);
		double a2 = Ex1_Sol.area(po_a,po_b, x1, x2, 2);
		double a3 = Ex1_Sol.area(po_a,po_b, x1, x2, 3);
		double a100 = Ex1_Sol.area(po_a,po_b, x1, x2, 100);
		double area =2.5;
		assertEquals(a1,area, Ex1_Sol.EPS);
		assertEquals(a2,area, Ex1_Sol.EPS);
		assertEquals(a3,area, Ex1_Sol.EPS);
		assertEquals(a100,area, Ex1_Sol.EPS);
	}
	@Test
	/**
	 * Test the area function.
	 */
	public void testArea3() {
		double[] po_a = {2,1,-0.7, -0.02,0.02};
		double[] po_b = {6, 0.1, -0.2};
		double x1 = Ex1_Sol.sameValue(po_a,po_b, -10,-5, Ex1_Sol.EPS);
		double a1 = Ex1_Sol.area(po_a,po_b, x1, 6, 8);
		double area = 58.5658;
		assertEquals(a1,area, Ex1_Sol.EPS);
	}
}
