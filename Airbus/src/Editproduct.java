

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Editproduct")
public class Editproduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update product</h1>");
		String sid=request.getParameter("productid");
		int id=Integer.parseInt(sid);
		
		product e=productDao.getproductById(id);
		
		out.print("<form action='Editproduct2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='productid' value="+e.getProductId()+"></td></tr>");
		out.print("<tr><td>product Name:</td><td><input type='text' name='productname' value='"+e.getProductname()+"'/></td></tr>");
		out.print("<tr><td>price:</td><td><input type='text' name='price' value='"+e.getPrice()+"'/></td></tr>");
		out.print("<tr><td>description:</td><td><input type='text' name='description' value='"+e.getDescription()+"'/></td></tr>");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit &amp; Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}
}
