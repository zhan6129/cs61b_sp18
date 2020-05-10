import java.lang.Math; 

public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
		
	}

	public double calcDistance(Planet p){
		double distance = Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) + (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
		return distance;
	}

	public double calcForceExertedBy(Planet p){
		double Force = G * this.mass * p.mass / (this.calcDistance(p) * this.calcDistance(p));
		return Force;

	}

	public double calcForceExertedByX(Planet p){
		double ForceX = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos)/this.calcDistance(p);
		return ForceX;
	}

	public double calcForceExertedByY(Planet p){
		double ForceY = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos)/this.calcDistance(p);
		return ForceY;
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double netForceX = 0;
		for (Planet i:allPlanets){
			if (!this.equals(i)){
				double ForceX = this.calcForceExertedBy(i)*(i.xxPos -this.xxPos)/this.calcDistance(i);
				netForceX = netForceX + ForceX;
			}		
		}
		return netForceX;
		
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double netForceY = 0;
		for (Planet i:allPlanets){
			if (!this.equals(i)){
			    double ForceY = this.calcForceExertedBy(i)*(i.yyPos -this.yyPos)/this.calcDistance(i);
			    netForceY = netForceY + ForceY;
		    }
		}
		return netForceY;
	}

	public void update(double dt, double fX, double fY){
		double aNetX = fX/this.mass;
		double aNetY = fY/this.mass;
		this.xxVel = this.xxVel + dt * aNetX;
		this.yyVel = this.yyVel + dt * aNetY;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;

	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
	}


}