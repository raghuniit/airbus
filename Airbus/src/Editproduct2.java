

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Editproduct2")
public class Editproduct2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int productid=Integer.parseInt(request.getParameter("productid"));
		String productname=request.getParameter("productname");
		String price=request.getParameter("price");
		String description=request.getParameter("description");
		
		
		product e=new product();
		e.setProductId(productid);
		e.setProductname(productname);
		e.setPrice(price);
		e.setDescription(description);
		
		int status=productDao.update(e);
		if(status>0){
			response.sendRedirect("viewproduct");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
