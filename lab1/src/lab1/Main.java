package lab1;

public class Main {
	//whether this three integers can make a triangle 
	public Boolean triangle(int a,int b,int c) {
		if(a <= 0 || b <= 0 || c <= 0 || 
				a+b <= c || a+c <= b || b+c <= a) return false;
		return true;
	}
	public Boolean equilateral(int a,int b,int c) {
		if(triangle(a,b,c) &&  a == b && b == c) return true;
		return false;
	}
	public Boolean isosceles(int a,int b,int c) {
		if(triangle(a,b,c) &&
				(a == b || b == c || a == c) ) return true;
		return false;
	}
	/* 
	 * 0 not a triangle
	 * 1 equilateral
	 * 2 isosceles
	 * 3 triangle
	*/
	public int tri(int a,int b,int c) {
		if(!triangle(a,b,c)) return 0;
		if(equilateral(a,b,c)) return 1;
		if(isosceles(a,b,c)) return 2;
		return 3;
	}
	public static void main(String[] args) {
		
	}
}
