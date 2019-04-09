package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class BidNowServlet
 */
@WebServlet("/BidNowCheckServlet")
public class BidNowCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BidNowCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");

		Car carDetails = (Car) session.getAttribute("carDetails");
		carDetails.setBidIsGood(false);
		Double bidAmount = Double.parseDouble(request.getParameter("inputBid"));
//		System.out.println("The bid amount is: " + bidAmount);
		carDetails.setTenPercentOfPrice(carDetails.getPrice() * .10);
//		System.out.println("Ten percent of the price amount is: " + carDetails.getTenPercentOfPrice());
		if (bidAmount >= carDetails.getPrice() - carDetails.getTenPercentOfPrice()) {
			User bidder = new User(request.getParameter("bidderFirstName"), request.getParameter("bidderLastName"));
			carDetails.setBidder(bidder);
			carDetails.setBidAmount(Double.parseDouble(request.getParameter("inputBid")));
			carDetails.setBidIsGood(true);
		} else {
			RequestDispatcher rs = request.getRequestDispatcher("/bidnow.jsp");
			rs.forward(request, response);
		}

		User buyer = new User(request.getParameter("bidderFirstName"), request.getParameter("bidderLastName"));
		carDetails.setBuyer(buyer);
		carDetails.setSoldStatus(true);

		// This finds the the vehicle in the inventory list by ID then, removes it and
		// adds
		// the updated version with the purchasers name and changes soldStatus to true
		// so it doesn't show up on home page
		for (int i = 0; i < inventory.size(); i++) {
//					Car[] tempCar = new Car[inventory.size()];
//					tempCar[i] = inventory.get(i);
			if (inventory.get(i).getId().equals(carDetails.getId())) {
				inventory.remove(inventory.get(i));
				inventory.add(carDetails);
			}
		}

		RequestDispatcher rs = request.getRequestDispatcher("/Thankyou2.jsp");
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
