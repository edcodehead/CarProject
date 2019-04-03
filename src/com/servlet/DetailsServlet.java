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

/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentID = request.getParameter("id");
		Car carDetails = new Car();
//		System.out.println("The ID is: " + currentID);
		HttpSession session = request.getSession(true);
		ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");
		
		for (Car car : inventory) {
			if (car.getId().equals(currentID)) {
				carDetails.setMake(car.getMake());
				carDetails.setModel(car.getModel());
				carDetails.setYear(car.getYear());
				carDetails.setMileage(car.getMileage());
				carDetails.setPrice(car.getPrice());
				carDetails.setDescription(car.getDescription());
				carDetails.setId(car.getId());
				carDetails.setImagePath(car.getImagePath());
			}
		}
		session.setAttribute("carDetails", carDetails);
		
		RequestDispatcher rs = request.getRequestDispatcher("Details.jsp");
		rs.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
