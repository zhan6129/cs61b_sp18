public class NBody{
	
	public static double readRadius(String fileName){
		In in = new In(fileName);
		double firstDoubleInFile = in.readDouble();
		double secondDoubleInFile = in.readDouble();

		return secondDoubleInFile;
	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int numPlanets = in.readInt();
		double secondDoubleInFile = in.readDouble();
		Planet[] allPlanets = new Planet[numPlanets];

		for (int i = 0; i < numPlanets; ++i) {
			allPlanets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
		}

		return allPlanets;

	}

	public static void main(String[] args){
		StdDraw.enableDoubleBuffering();

		double T = Double. parseDouble(args[0]);
		double dt = Double. parseDouble(args[1]);

		String filename = args[2];

		double radius = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);

		StdDraw.setScale(-radius, radius);
		StdDraw.clear();

		// create a time variable
		for (double t = 0; t <= T; t = t + dt){
			double[] xForces = new double[allPlanets.length];
			double[] yForces = new double[allPlanets.length];
			for (int i = 0; i < allPlanets.length; i++){
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}
			for (int i = 0; i < allPlanets.length; i++){
				allPlanets[i].update(dt,xForces[i],yForces[i]);
			}

			StdDraw.picture(0, 0, "./images/starfield.jpg");
			for (Planet p : allPlanets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}

		StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < allPlanets.length; i++) {
        	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);   
}

	}


}

