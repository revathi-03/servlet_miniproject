

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
	    double salary=Double.parseDouble(request.getParameter("salary"));
	    String date=request.getParameter("date");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdemo","root","root");
		PreparedStatement ps=con.prepareStatement("update employee set salary='"+salary+"',hiringDate=STR_TO_DATE('"+date+"','%d/%m/%Y')where empid='"+id+"'");
//	ps.setDouble(1, salary);
//		ps.setString(2, date);
//		ps.setInt(3, id);
//		
		int result=ps.executeUpdate();
		if(result>0) {
			pw.print("update is successed!");
			
		}
		else {
			pw.print("check error!");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
