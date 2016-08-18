package edu.mobapde.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import edu.mobapde.model.Post;

/**
 * Servlet implementation class SendImage
 */
@WebServlet("/retrieveposts")
public class RetrievePostsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrievePostsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Post> postArrayList = new ArrayList<>();
		postArrayList.add(new Post("This is a post.", "photo1.jpg"));
		postArrayList.add(new Post("This is another post.", "photo2.jpg"));
		postArrayList.add(new Post("This is a third post.", "photo3.jpg"));
		
//		File file = new File(FOLDER, "somefilename.jpg");
		
//		FileInputStream fileInputStream = new FileInputStream(file);
//		byte[] fileBytes = Files.readAllBytes(file.toPath());
//		
//		String fileEncoded = Base64.encode(fileBytes);
		
//		Byte[] fileBytes 
		
//		TempObject tempObject = new TempObject(fileEncoded);
		
		Gson g = new Gson();
		String json = g.toJson(postArrayList);
		response.getWriter().write(json);
	}

}
