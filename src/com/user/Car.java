package com.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.*;

public class Car {
	private String make;
	private String model;
//	protected String type;
	private int year;
	private boolean soldStatus;
	private double mileage;
	private double price;
	private String description;
	private String purchaseDate;
//	private Period daysInSystem;
	private boolean specialPricing;
	private static final String path = "C:\\Java Training\\Workspace\\ServletLab2\\ServletTutorial\\WebContent\\uploaded-files\\";
	private String id;
	private String imagePath;
	private User buyer;
	private Car[] list;
	ArrayList<Car> inventory = null;

	public Car() {
	};

	public Car(String make, String model, int year, double mileage, double price, String description) {
		this.make = make;
		this.model = model;
//		this.type = type;
		this.year = year;
		this.mileage = mileage;
		this.price = price;
		this.description = description;
		this.id = generateID();
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

//	public String getType() {
//		return type;
//	}
//	
//	public void setType(String type) {
//		this.type = type;
//	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean getSoldStatus() {
		return soldStatus;
	}

	public void setSoldStatus(boolean soldStatus) {
		this.soldStatus = soldStatus;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	

//	public Period getDaysInSystem() {
//		return daysInSystem;
//	}
//
//	public void setDaysInSystem(Period daysInSystem) {
//		this.daysInSystem = daysInSystem;
//	}
	
	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public boolean isSpecialPricing() {
		return specialPricing;
	}

	public void setSpecialPricing(boolean specialPricing) {
		this.specialPricing = specialPricing;
	}

	public ArrayList<Car> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Car> inventory) {
		this.inventory = inventory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Car[] getList() {
		return list;
	}

	public void setList(Car[] list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return make + "," + model + "," + year + "," + mileage + "," + price + "," + description + "," + purchaseDate
				+ "," + buyer + "," + soldStatus + "," + id + "," + imagePath;
	}

	// -------------------- START OF METHODS --------------------//
	public String generateID() {
		Random randomNumber = new Random();
		return id = "VID" + String.valueOf(randomNumber.nextInt(100000));
	}

	public void saveFile() {
		String fileName = path + id + ".txt";
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write(formatData());
			bw.close();
		} catch (IOException e) {
			System.out.println("Error: Save failed");
		}
	}

	public String formatData() {
		return this.make + "," + this.model + ","
//				+ this.type + ","
				+ this.year + "," + this.mileage + "," + this.price + "," + this.description + "," + this.purchaseDate
				 + "," + this.buyer + "," + this.soldStatus + "," + this.id + "," + this.imagePath;
	}

	public boolean checkSpecialPricing(String purchaseDate) {
		// Need to check if the date from today and purchase date is greater than 120
		specialPricing = false;
		// This is todays date
		LocalDate today = LocalDate.now();
		
		// Here I am formatting the purchaseDate we grab from the data
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateConvert = LocalDate.parse(purchaseDate, formatter);
		
		// This is the today's date minus 120
		LocalDate day120 = today.minusDays(120);
//		System.out.println("Day 120: " + day120);
		
		Long timeLapsed = ChronoUnit.DAYS.between(dateConvert, day120);
//		System.out.println("Number of days since added into system: " + timeLapsed);
		
		if(timeLapsed > 120) {
			specialPricing = true;
		}
		return specialPricing;
	}
	
	
	
	
	
	
	
	
	
	
	
	

//	public static Car readFile() { // Got code from: https://stackoverflow.com/questions/4917326/how-to-iterate-over-the-files-of-a-certain-directory-in-java
//		String fileName = path + id + ".txt";
//		Car tempCar = new Car();
//				try {
//					Scanner scanner = new Scanner(new File(String.valueOf(directoryListing[i])));
//					String line = scanner.nextLine();
//					String[] parsedLine = line.split(",");
//					tempCar.setMake(parsedLine[0]);
//					tempCar.setModel(parsedLine[1]);
//					tempCar.setYear(Integer.parseInt(parsedLine[2]));
//					tempCar.setMileage(Double.parseDouble(parsedLine[3]));
//					tempCar.setPrice(Double.parseDouble(parsedLine[4]));
//				} catch (FileNotFoundException f) {
//					System.out.println("File not found");
//				}
//			
//		return tempCar;

}// ------------------ ENDS CLASS ------------------//
