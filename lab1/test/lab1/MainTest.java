package lab1;

import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest {
	/* 
	 * 0 not a triangle
	 * 1 equilateral
	 * 2 isosceles
	 * 3 triangle
	*/
	@Test
	public void test() {
		Main l = new Main();
		
		assertEquals(0,l.tri(-2, 3, 32));
		assertEquals(0,l.tri(2, 3, 32));
		assertEquals(0,l.tri(0, 0, 1));
		assertEquals(0,l.tri(0, 0, 0));
		assertEquals(0,l.tri(-2, -2, -2));
		
		assertEquals(1,l.tri(3, 3, 3));
		
		
		assertEquals(2,l.tri(8, 6, 6));
		assertEquals(2,l.tri(2, 3, 2));
		assertEquals(2,l.tri(2, 1, 2));
		
		assertEquals(3,l.tri(2, 3, 4));
		assertEquals(3,l.tri(2, 5, 6));
		assertEquals(3,l.tri(3, 4, 5));
	}

}
