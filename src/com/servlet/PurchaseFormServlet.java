package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
 * Servlet implementation class PurchaseFormServlet
 */
@WebServlet("/PurchaseFormServlet")
public class PurchaseFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PurchaseFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String vehicleID = request.getParameter("vehicleID");
//		System.out.println("The vehicle ID is: " + vehicleID);

		HttpSession session = request.getSession(true);
		Car updateCar = (Car) session.getAttribute("carDetails");
		User buyer = new User(request.getParameter("buyerFirstName"), request.getParameter("buyerLastName"));
		updateCar.setBuyer(buyer);
		updateCar.setSoldStatus(true);
		ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");
		
//		for (Iterator<Integer> iterator = integers.iterator(); iterator.hasNext();) {
//		    Integer integer = iterator.next();
//		    if(integer == 2) {
//		        iterator.remove();
//		    }
//		}
		
		// This finds the the vehicle in the inventory list by ID then, removes it and adds
		// the updated version with the purchasers name and changes soldStatus to true so it doesn't show up on home page
		for (int i = 0; i < inventory.size(); i++) {
//			Car[] tempCar = new Car[inventory.size()];
//			tempCar[i] = inventory.get(i);
			if (inventory.get(i).getId().equals(updateCar.getId())) {
				inventory.remove(inventory.get(i));
				inventory.add(updateCar);
			}
		}
		
//		for (Iterator<Car> iterator = inventory.iterator(); iterator.hasNext();) {
//			Car car = iterator.next();
//			System.out.println("The vehicle ID is: " + car.getId());
//			if (car.getId().equals(updateCar.getId())) {
//				inventory.remove(car);
//				inventory.add(updateCar);
//			}
//		}
		

//		for (Car car : inventory) {
//			if (car.getId().equals(updateCar.getId())) {
//				inventory.remove(car);
//				inventory.add(updateCar);
//			}
//		}

//		ArrayList<Car> searchByMakeDataList = (ArrayList<Car>) session.getAttribute("searchByMakeDataList");
//
//		if (searchByMakeDataList == null) {
//			searchByMakeDataList = new ArrayList<Car>();
//		}
//

//
		RequestDispatcher rs = request.getRequestDispatcher("Thankyou.jsp");
		rs.forward(request, response);

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
