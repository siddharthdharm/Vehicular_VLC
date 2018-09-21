import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.Math.*;

class Vehicle {
	float x,y,speed;
	Vehicle(float xc, float yc, float s) {
		x = xc;
		y = yc;
		speed = s;
	}

	public static float distance(Vehicle v1, Vehicle v2) {
		return (float) Math.sqrt(Math.pow((v1.x - v2.x),2) + Math.pow((v1.y - v2.y),2));
	}
}

public class Simulator {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		float x,y,speed;

		System.out.println("Enter the x co-ordinate of first vehicle (in SI units)");
		x = Float.valueOf(reader.readLine()).floatValue();
		System.out.println("Enter the y co-ordinate of first vehicle (in SI units)");
		y = Float.valueOf(reader.readLine()).floatValue();
		System.out.println("Enter the speed of first vehicle (in SI units)");
		speed = Float.valueOf(reader.readLine()).floatValue();

		Vehicle v1 = new Vehicle(x,y,speed);

		System.out.println("Enter the x co-ordinate of second vehicle (in SI units)");
		x = Float.valueOf(reader.readLine()).floatValue();
		System.out.println("Enter the y co-ordinate of second vehicle (in SI units)");
		y = Float.valueOf(reader.readLine()).floatValue();
		System.out.println("Enter the speed of second vehicle (in SI units)");
		speed = Float.valueOf(reader.readLine()).floatValue();

		Vehicle v2 = new Vehicle(x,y,speed);

		if(v1.distance(v1,v2) > 101.0 || v1.distance(v1,v2) < 1.5)
			System.out.println("VLC not possible.");
        
        // System.out.println(v1.x);
        // System.out.println(v2.y);

	}
}