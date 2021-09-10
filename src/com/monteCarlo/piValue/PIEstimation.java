package com.monteCarlo.piValue;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class PIEstimation {
	static Scanner sc=new Scanner(System.in);out
//	static DecimalFormat df=new DecimalFormat("#.000");
	static NumberFormat nf=NumberFormat.getInstance();
	static int prevPoints=0;
	public static void main(String[] args)
	{
		
		float radius;
		int n;				//number of simulation to perform
		System.out.print("Enter radius of circle?r:");
		radius=sc.nextFloat();
		
		System.out.print("Number of Iteration :?(int)  ");
		n=sc.nextInt();
		
		int i=1;
		float rx,ry;
		float R2;
		int inPoints=0;
		
		System.out.println("i\t:"
				+" rx\t\t:"
				+" ry\t\t:"
				+" R2\t\t:"
				+"inPoints");
		while(i<=n)
		{
			rx=getPoint(radius);
			ry=getPoint(radius);
			
			R2=getRootedRadius(radius,rx);
			
			if(ry<=R2)
				inPoints++;
			
			String in=putInPoints(inPoints);
				
			
			System.out.println(i+"\t:"
					+ rx+"\t\t:"
					+ ry+"\t\t:"
					+ R2+"\t\t:"
					+in);
			
			System.out.println("-------------------------------------------------------------------------------");
		
			i++;
		}
		
		System.out.println("Total In points to quadrant :"+inPoints);
		float pi;
		pi=4*(inPoints/(float)n);
		System.out.println("Value of Pi :"+pi);
		
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

	static float getPoint(float r)
	{
		float point;
		point=(float)(r*Math.random());
		
//		point=Float.parseFloat(df.format(point));
		nf.setMaximumFractionDigits(3);
		point=Float.parseFloat(nf.format(point));
		return point;
	}
	
	static float getRootedRadius(float rad,float r1)
	{
		float r2;
		r2=(float)(rad*rad-r1*r1);
		r2=(float)(Math.sqrt(r2));
		
//		r2=Float.parseFloat(df.format(r2));
		nf.setMaximumFractionDigits(3);
		r2=Float.parseFloat(nf.format(r2));
		return r2;
	}
}
