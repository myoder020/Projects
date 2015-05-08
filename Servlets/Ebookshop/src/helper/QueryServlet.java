package helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Set the MIME type for the response message
		response.setContentType("text/html");
		
		//Get a output writer to write the response message into the network socket
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//Step 1: Create a database "Connection" object for mySql
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "m.yoder", "thisISm1ne");
			
			//Step 2: Create a "Statement" object in the "Connection"
			stmt = conn.createStatement();
			
			//Step 3: Execute a SQL Select query
			String sqlStr = "SELECT * FROM BOOKS WHERE AUTHOR IN (";
			
			String[] names = request.getParameterValues("author");
			
			for(int i = 0; i < names.length; i++) {
				sqlStr += "'" + names[i] + "'";
				if(i < names.length-1)
					sqlStr += ", ";
			}
			
				sqlStr += ") AND qty > 0 ORDER BY AUTHOR ASC, TITLE ASC";
			
			//Print an html page as output of query
			out.println("<html><head><title>Query Results</title></head><body>");
			out.println("<h2>Thank you for your query.</h2>");
			out.println("<p>Your query is: " + sqlStr + "</p>"); //Echo for debugging
			ResultSet rset = stmt.executeQuery(sqlStr);
			
			//Step 4: Process the query result
			int count = 0;
			while(rset.next()) {
				//Print a paragraph <p> ... </p> for each query
				out.println("<p>" + rset.getString("author")
						+ ", " + rset.getString("title")
						+ ", $" + rset.getString("price") + "</p>");
				++count;
			}
			out.println("<p>==== " + count + " records found ====</p>");
			out.println("</body></html>");			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
		
			out.close();
			try {
				//Step 5: Close the Statement and Connection
				if(stmt != null)
					stmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
