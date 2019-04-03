package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Car;
import com.user.User;

/**
 * Servlet implementation class IndexServlet
 */
//@WebServlet("/IndexServlet")
@WebServlet("/home")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String myDirectoryPath = "C:\\Java Training\\Workspace\\ServletLab2\\ServletTutorial\\WebContent\\uploaded-files\\";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * This doGet method's job is to go to the file directory where data is stored,
		 * go through each file and parse the data for each car, add each one to the
		 * session, so it can be loaded onto the html page.
		 */
		// Grab the session
		HttpSession session = request.getSession(true);
		// Assume there is an inventory in the session and grab it
		ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");

		// If there is no inventory list, create one
		if (inventory == null) {
			inventory = new ArrayList<Car>();

			// Create a temporary car we can load data into
			Car tempCar = new Car();

			// Look in our directory to see if we have car files in there
			File dir = new File(myDirectoryPath);
			// Create an array to load each file we find on to
			File[] directoryListing = dir.listFiles();
			// Loop through the data of each file and store into our tempCar // For each
			// file // Each Data
			for (int i = 0; i < directoryListing.length; i++) {
				tempCar = new Car();
				try {
					Scanner scanner = new Scanner(new File(directoryListing[i].toString()));
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						String[] parsedPart = line.split(",");
						tempCar.setMake(parsedPart[0]);
						tempCar.setModel(parsedPart[1]);
						tempCar.setYear(Integer.parseInt(parsedPart[2]));
						tempCar.setMileage(Double.parseDouble(parsedPart[3]));
						tempCar.setPrice(Double.parseDouble(parsedPart[4]));
						tempCar.setDescription(parsedPart[5]);
						// We are going to grab the dateEntered value, but we are not going to show it
						// onto the html
						tempCar.setPurchaseDate(parsedPart[6]);
						// Check if vehicle qualifies for purchase date special
						tempCar.checkSpecialPricing(parsedPart[6].toString());
						// Grab the buyer name, if not sold, it will be set to "Not" "Sold"
						String[] nameData = parsedPart[7].toString().split(" ");
						User tempUser = new User(nameData[0], nameData[1]);
						tempCar.setBuyer(tempUser);
						tempCar.setSoldStatus(Boolean.parseBoolean(parsedPart[8]));
						tempCar.setId(parsedPart[9]);
						tempCar.setImagePath(parsedPart[10]);
						// Add the tempCar into our Array list called "inventory"
						inventory.add(tempCar);
						session.setAttribute("inventory", inventory);
					}
				} catch (FileNotFoundException e) {
//				System.out.println("File Not Found");
				}

			}
		}
		
		// This allows us to call IndexServlet first, then goes to home page.
		// Documentation: https://stackoverflow.com/questions/10414093/how-to-call-a-servlet-on-jsp-page-load
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		
		
//		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
//		rs.forward(request, response);

//------------- THIS GRABS THE LIST AND GOES THROUGH THE DATA --------------//
//		System.out.println("Number of files in folder: " + directoryListing.length);
//		if (directoryListing != null) {
//			for (int i = 0; i < directoryListing.length; i++) {
//				try {
//					Scanner scanner = new Scanner(new File(String.valueOf(directoryListing[i])));
//					String line = scanner.nextLine();
//					String[] parsedLine = line.split(",");
//					tempCar.setMake(parsedLine[0]);
//					tempCar.setModel(parsedLine[1]);
//					tempCar.setYear(Integer.parseInt(parsedLine[2]));
//					tempCar.setMileage(Double.parseDouble(parsedLine[3]));
//					tempCar.setPrice(Double.parseDouble(parsedLine[4]));
//					tempCar.setId(parsedLine[5]);
//					tempCar.setImagePath(parsedLine[6]);
//					
//					session.setAttribute("directoryListing", directoryListing[i]);
////					System.out.println("File Path: " + directoryListing[i] + "\nData: " + tempCar);
//				} catch (FileNotFoundException f) {
//					System.out.println("File not found");
//				}
//			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
