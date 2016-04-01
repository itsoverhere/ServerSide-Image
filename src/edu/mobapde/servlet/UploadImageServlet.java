package edu.mobapde.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


/**
 * Servlet implementation class ReceiveImageServlet
 */
@WebServlet("/uploadimage")
@MultipartConfig
public class UploadImageServlet extends HttpServlet {
	
	// Change this to your own local image repository
	// Check this link : http://stackoverflow.com/questions/18664579/recommended-way-to-save-uploaded-files-in-a-servlet-application/18664715#18664715
	// 		for other ways to link your folder path
	public static File FOLDER = new File("/Users/courtneyngo/Desktop/");
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the file Part, the image we want to receive
		Part part = request.getPart("file");
		
		// Make a fileName for the file to save
		// We can use System.currentTimeMillis() to make the image file name unique, but this will eventually fail if you are expecting high traffic in uploads
		// If expecting many uploads, consider appending the user's ID, or using a universally unique identifier (UUID) generator
		String fileName = System.currentTimeMillis() + "-image.jpg";
		
		// You may also get other parts of the request
		String title = request.getParameter("title");
		System.out.println("title : " + title);
		
		// Create our file name with FOLDER as the parent repository 
	    File file = new File(FOLDER, fileName);
	    
		// Save the file (will replace existing files with similar file name)
	    InputStream fileInputStream = part.getInputStream();
		Files.copy(fileInputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
		fileInputStream.close();
		
		// Here is where you save the file path and the title to your database
		
	    // This is where the file was saved
		System.out.println("Success! File saved in : " + file.getAbsolutePath());
		
		response.getWriter().write("success");
	}

	
}
