import java.util.*;
import java.sql.*;

public class productDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "raghu");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(product e) {
		int status = 0;
		try {
			Connection con = productDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into product(productid,productname,price,description) values(?,?,?,?)");
			ps.setInt(1, e.getProductId());
			ps.setString(2, e.getProductname());
			ps.setString(3, e.getPrice());
			ps.setString(4, e.getDescription());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int update(product e) {
		int status = 0;
		try {
			Connection con = productDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update product set productname=?,price=?,description=? where productid=?");
			ps.setString(1, e.getProductname());
			ps.setString(2, e.getPrice());
			ps.setString(3, e.getDescription());
			ps.setInt(4, e.getProductId());

			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = productDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from product where productid=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static product getproductById(int productid) {
		product e = new product();

		try {
			Connection con = productDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from product where productid=?");
			ps.setInt(1, productid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setProductId(rs.getInt(1));
				e.setProductname(rs.getString(2));
				e.setPrice(rs.getString(3));
				e.setDescription(rs.getString(4));

			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public static List<product> getAllproduct() {
		List<product> list = new ArrayList<product>();

		try {
			Connection con = productDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				product e = new product();
				e.setProductId(rs.getInt(1));
				e.setProductname(rs.getString(2));
				e.setPrice(rs.getString(3));
				e.setDescription(rs.getString(4));

				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
