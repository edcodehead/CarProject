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

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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
		ArrayList<Car> searchList = (ArrayList<Car>) session.getAttribute("searchList");
		String searchInput = request.getParameter("Search");
//		System.out.println("The search string is: " + searchInput);

//		for (Car car : inventory) {
//			switch (searchInput) {
//			case 
//		}
		
		if (searchList == null || searchList != null) {
			searchList = new ArrayList<Car>();
		}

		for (Car car : inventory) {
			if (car.getMake().equals(searchInput)) {
				searchList.add(car);
//				session.removeAttribute("inventory");
				session.setAttribute("searchList", searchList);
			} else if (car.getModel().equals(searchInput)) {
				searchList.add(car);
				session.setAttribute("searchList", searchList);
			} else if (car.getPurchaseDate().equals(searchInput)) {
				searchList.add(car);
				session.setAttribute("searchList", searchList);
			} else if (car.getId().equals(searchInput)) {
				searchList.add(car);
				session.setAttribute("searchList", searchList);
			} 
		}

	RequestDispatcher rs = request.getRequestDispatcher("dashboard.jsp");rs.forward(request,response);

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
	
//	if (searchByMakeDataList == null || searchByMakeDataList != null) {
//		searchByMakeDataList = new ArrayList<Car>();
//	}
//
//	for (Car car : inventory) {
//		if (car.getMake().equals(searchInput)) {
//			searchByMakeDataList.add(car);
////			session.removeAttribute("inventory");
//			session.setAttribute("searchByMakeDataList", searchByMakeDataList);
//		}
//	}

}
