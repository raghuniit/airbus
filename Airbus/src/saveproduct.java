

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/saveproduct")
public class saveproduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int productid=Integer.parseInt(request.getParameter("productid"));
		String productname=request.getParameter("productname");
		String pr=request.getParameter("price");
		String description=request.getParameter("description");
		
		product e=new product();
		
		e.setProductId(productid);
		e.setProductname(productname);
		e.setPrice(pr);
		e.setDescription(description);
		
		int status=productDao.save(e);
		if(status>0)
		{
			out.print("<p>Record saved successfully!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else{
			out.println("Sorry! unable to save record");
		}
		
		out.close();
	}

}
