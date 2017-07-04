

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/viewproduct")
public class viewproduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='index.html'>Add New product</a>");
		out.println("<h1>product List</h1>");
		
		List<product> list=productDao.getAllproduct();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>productId</th><th>productName</th><th><price</th><th>description</th><th>Edit</th><th>Delete</th></tr>");
		for(product e:list){
			out.print("<tr><td>"+e.getProductId()+"</td><td>"+e.getProductname()+"</td><td>"+e.getPrice()+"</td><td>"+e.getDescription()+"</td><td><a href='Editproduct?productid="+e.getProductId()+"'>edit</a></td><td><a href='Deleteproduct?productid="+e.getProductId()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
