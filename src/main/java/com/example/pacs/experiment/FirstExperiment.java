package com.example.pacs.experiment;

public class FirstExperiment {

	String aString;
	String bString;
	public FirstExperiment(String a, String b) {
		this.aString=a;
		this.bString=b;
	}

	@Override
	public String toString() {
		return "I am " + aString + " " + bString +"!!";
	}

	public static void main(String[] args) {
		System.out.println("Hello...........");
		
		FirstExperiment obj1= new FirstExperiment("Prince", "Kumar");
		
		System.out.println(obj1);
		
	}

}
