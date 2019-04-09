package com.servlet;

import java.io.File;
import java.io.IOException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.user.Car;
import com.user.User;

/**
 * Servlet implementation class SellCarServlet
 */
//@WebServlet(name="SellCarServlet", urlPatterns= {"/upload"})
//@WebServlet("/SellCarServlet")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class SellCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "C:\\Java Training\\Workspace\\ServletLab2\\ServletTutorial\\WebContent\\img\\";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		/** The purpose of this post method is to grab the data from the form and store it in 
		 * a text file, and send the same data to a thank you confirmation page.
		 * It is not it's job to save the data unto the session.
		 */

		// -------------------------- TRY DAY 2 -------------------------------------//
		
		HttpSession session = request.getSession(true);
		ArrayList<Car> inventory = (ArrayList<Car>) session.getAttribute("inventory");
		
		// Documentation: https://www.javacodegeeks.com/2013/08/file-upload-example-in-servlet-and-jsp.html
		// And this was also helpful: https://happycoding.io/tutorials/java-server/uploading-files
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				Car tempCar = new Car();

				if (multiparts.get(0).getFieldName().equals("make")) {
					String tempMake = multiparts.get(0).getString();
					tempCar.setMake(tempMake);
				}
				if (multiparts.get(1).getFieldName().equals("model")) {
					String tempModel = multiparts.get(1).getString();
					tempCar.setModel(tempModel);
				}
				if (multiparts.get(2).getFieldName().equals("mileage")) {
					double tempMileage = Double.parseDouble(multiparts.get(2).getString());
					tempCar.setMileage(tempMileage);
				}
				if (multiparts.get(3).getFieldName().equals("year")) {
					int tempYear = Integer.parseInt(multiparts.get(3).getString());
					tempCar.setYear(tempYear);
				}
				if (multiparts.get(4).getFieldName().equals("price")) {
					double tempPrice = Double.parseDouble(multiparts.get(4).getString());
					tempCar.setPrice(tempPrice);
				}
				if (multiparts.get(5).getFieldName().equals("description")) {
					String tempDescription = multiparts.get(5).getString();
					tempCar.setDescription(tempDescription);
				}
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						String name = new File(item.getName()).getName();
						item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
						String picture = String.valueOf(name);
//						String forwardSlashPath = picture.replace("\\", "/");
						tempCar.setImagePath(picture);
					}
				}
				//Here we will add a buyer field and set it to NotSold for now
				User notSold = new User("Not","Sold");
				tempCar.setBuyer(notSold);
				tempCar.setSoldStatus(false);
				tempCar.setId(tempCar.generateID());
				tempCar.setPurchaseDate(LocalDate.now().toString());
				tempCar.saveFile();
				inventory.add(tempCar);
				
				session.setAttribute("tempCar", tempCar);
				session.setAttribute("inventory", inventory);
				// File uploaded successfully
//				request.setAttribute("message", "File Uploaded Successfully");
			
			} catch (Exception ex) {
//				request.setAttribute("message", "File Upload Failed due to " + ex);
			}
		} else
		{
//			request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		}
		
//		request.getRequestDispatcher("/confirmation-page.jsp").forward(request, response);
		RequestDispatcher rs = request.getRequestDispatcher("/confirmation-page.jsp");
		rs.forward(request, response);
	}
}
