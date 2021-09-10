package com.monteCarlo.integration;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Integration {
	static Scanner sc=new Scanner(System.in);
	static DecimalFormat df=new DecimalFormat("#.000");
	
	static int prevPoints=0;
	public static void main(String[] args) {
		
		float x1,x2;
		float height;		//height of rectangle enclosing curve
		float base;			//base of rectangle
		int powerFact;
		double areaOfRect;
		int n;				//iteration to perform or simulation to perform
		double areaUnderCurve;
		System.out.print("Enter float vlaue, x1 and x2 ");
		x1=sc.nextFloat();
		x2=sc.nextFloat();
		
		base=x2-x1;
		System.out.print("Enter float value height of rectangle:");
		height=sc.nextFloat();
		
		System.out.print("Enter fact b/w a and b:");
		int fact=sc.nextInt();
		
		System.out.print("Iteration to perform (int):n? ");
		n=sc.nextInt();
		
		System.out.print("Enter curve functional power in terms of y=x^a:::(int)");
		System.out.println("a???");
		powerFact=sc.nextInt();
		
		areaOfRect=calAreaOfRect(height,base);		//area of rectangle
		
		int i=1;
		int innerPoints=0;			//points inside curve
		int xrand;
		float x;
		float yrand;
		float y;
		float fx;				//for f(X)=x^3
		
		System.out.println("i\t:"
				+"xrand\t\t:"
				+"x\t\t:"
				+"yrand\t\t:"
				+ "y\t\t:"
				+"fx\t\t:"
				+ "innerPoints");
		while(i<=n)
		{
			xrand=getXRandPoints(x1,x2,fact);
			x=getX(xrand, fact);
			yrand=getYRandPoints();
			y=getY(yrand,height);
			fx=getFuncValue(x,powerFact);
			
			if(y<=fx)
				innerPoints++;
			
			String in=putInPoints(innerPoints);
			
			System.out.println(i+"\t:"
							+xrand+ "\t\t:"
							+x+ "\t\t:"
							+yrand+ "\t\t:"
							+ y+"\t\t:"
							+ fx+"\t\t:"
							+ in);
			
			System.out.println("-----------------------------------------------------------------------------------------------");
			
			i++;
		}
		
		areaUnderCurve=calcAreaOfIrreFig(innerPoints,n,areaOfRect);
		
		System.out.println("Area Of Rect "+areaOfRect);
		System.out.println("Inner Point To Curve "+innerPoints);
		System.out.println("Area Under Curve "+areaUnderCurve);
		
	}
	
	//method
	static double calAreaOfRect(float h,float b)
	{
		return h*b;
	}
	
	static int getXRandPoints(float low,float high,int fact)
	{
		low*=fact;
		high*=fact;
		int xRand;
		xRand=(int)((high-low)*Math.random()+low);
		return xRand;
	}
	static float getX(int xrand,float fact)
	{
		return (float)(xrand/fact);
	}
	
	static float getYRandPoints()		//generate random number b/w 0-1
	{
		float y=(float)Math.random();
		y=Float.parseFloat(df.format(y));
		return y;
	}
	static float getY(float yrand,float h)		
	{
		float yRand;
		yRand=(float)(h*yrand);
		yRand=Float.parseFloat(df.format(yRand));
		return yRand;
	}
	
	static float getFuncValue(float xr,int pf)
	{
		float fx;
		fx=(float)(Math.pow(xr, pf)-1);
		fx=Float.parseFloat(df.format(fx));
		return fx;
	}
	
	static double calcAreaOfIrreFig(int M,int N,double A)
	{
		double I;
		I=(M/(float)N)*A;
		return I;
	}
	
	private static String putInPoints(int inPoints) {
		if(inPoints!=prevPoints)
		{
			String inMess= Integer.toString(inPoints);
			prevPoints=inPoints;
			return inMess;
		}
		else
			return "";
	}
}
