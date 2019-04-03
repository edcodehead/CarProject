package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
 * Servlet implementation class ReportLogServlet
 */
@WebServlet("/ReportLogServlet")
public class ReportLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private final String myDirectoryPath = "C:\\Java Training\\Workspace\\ServletLab2\\ServletTutorial\\WebContent\\uploaded-files\\";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportLogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * We need to grab all the data like in index. This time we going to output to dashboard.jsp
		 */
		// Grab the session
		HttpSession session = request.getSession(true);
		// Assume there is an inventory in the session and grab it
		ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");
		//Got sorting to work from this site: https://howtodoinjava.com/sort/collections-sort/
		Comparator<Car> compareByPurchaseDate = (Car o1, Car o2) -> o1.getPurchaseDate().compareTo( o2.getPurchaseDate() );
		Collections.sort(inventory, compareByPurchaseDate.reversed());
		
		ArrayList<Car> searchByMakeDataList = (ArrayList<Car>) session.getAttribute("searchByMakeDataList");

		if (searchByMakeDataList != null) {
			session.removeAttribute("searchByMakeDataList");;
		}

		RequestDispatcher rs = request.getRequestDispatcher("dashboard.jsp");
		rs.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
