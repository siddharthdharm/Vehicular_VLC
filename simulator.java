import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
	
	public static float LambertianOrder(float phi_12) {
		
		return (float) -(Math.log(2)/Math.log(Math.cos(phi_12)));

	}

	public static float ReceiverOpticsGain(float n, float psi_con) {
		
		return (float) (Math.pow(n,2) / Math.sin(Math.pow(psi_con,2)));

	}

	public static float ChannelGain(Vehicle v1, Vehicle v2, float d, float n, float phi_12, float psi_con) {
		
		float incidence_angle = 0, radiance_angle = 0, ml, rog, ts = 1, g = 1;

		ml = LambertianOrder(phi_12);
		rog = ReceiverOpticsGain(n,psi_con);
		return (float) ( ((ml + 1) / (2 * 3.142 * Math.pow(d,2))) * Math.pow(Math.cos(radiance_angle),ml) * ts * g * rog * Math.cos(incidence_angle) );
			
	}

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
		
		float dist = v1.distance(v1,v2);

		if(dist > 101.0 || dist < 1.5)
			System.out.println("VLC not possible.");

		System.out.println(ChannelGain(v1,v2,dist,1,2,3));


        
        // System.out.println(v1.x);
        // System.out.println(v2.y);

	}
}