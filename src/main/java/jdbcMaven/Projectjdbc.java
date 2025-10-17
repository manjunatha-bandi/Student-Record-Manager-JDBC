package jdbcMaven;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
public class Projectjdbc {
	public static void main(String[] args) {
		AllOperation op=new AllOperation();
		op.create();
		op.insert();
		op.read();
		op.update();
		op.delete();
	}		
}
class AllOperation{
	//Creating table
	public void create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_CRUD", "root", "1234");
			Statement st=con.createStatement();
			st.executeUpdate("CREATE TABLE STUDENT_DETAILS(STUDENT_ID INT,ST_NAME VARCHAR(15),ST_COURSE VARCHAR(15),ST_PASSWORD VARCHAR(20))");
			System.out.println("TABLE CREATION COMPLETED !!!!");
			System.out.println("-------------------------------------------------------------------");
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insert() {
		Scanner s=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_CRUD", "root", "1234");
			PreparedStatement pst=con.prepareStatement("INSERT INTO STUDENT_DETAILS VALUES(?,?,?,?)");
			System.out.println("Please Specify Student details to add Database");
			System.out.println("Please Specify How many records to Insert:");
			int a=s.nextInt();
			s.nextLine();
			for(int i=1;i<=a;i++) {
				System.out.println("Enter the STUDENT_ID");
				int b=s.nextInt();
				s.nextLine();
				System.out.println("Enter the STUDENT NAME");
				String c=s.nextLine();
				System.out.println("Enter the ST_COURSE");
				String d=s.nextLine();
				System.out.println("Enter the ST_PASSWORD");
				String e=s.nextLine();
				
				pst.setInt(1, b);
				pst.setString(2, c);
				pst.setString(3, d);
				pst.setString(4, e);
				
				int rows=pst.executeUpdate();
				System.out.println("No.Of Student Details Inserted :"+rows);
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_CRUD", "root", "1234");
			PreparedStatement pst=con.prepareStatement("SELECT*FROM STUDENT_DETAILS");
			ResultSet rst=pst.executeQuery();
			System.out.println("Getting all Student Details !!!!");
			while(rst.next()) {
				System.out.println(rst.getInt(1));
				System.out.println(rst.getString(2));
				System.out.println(rst.getString(3));
				System.out.println(rst.getString(4));
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			rst.close();
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void update() {
		Scanner s=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_CRUD", "root", "1234");
			PreparedStatement pst=con.prepareStatement("UPDATE STUDENT_DETAILS SET ST_PASSWORD=? WHERE STUDENT_ID=?");
			System.out.println("Enter How many Student Details to update.");
			int b=s.nextInt();
				for(int i=1;i<=b;i++) {
					System.out.println("Enter the Student_Id where to update:");
					int a=s.nextInt();
					s.nextLine();
					System.out.println("Enter the password to update:");
					String c=s.nextLine();
					pst.setInt(2, a);
					pst.setString(1, c);
					int rowsEffected=pst.executeUpdate();
					System.out.println("Successfully updated the Student Details :"+rowsEffected);
		}
				System.out.println();
				System.out.println("-------------------------------------------------------------------");
				pst.close();
				con.close();
	}
		  catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void delete() {
		Scanner s=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_CRUD", "root", "1234");
			PreparedStatement pst=con.prepareStatement("DELETE FROM STUDENT_DETAILS WHERE STUDENT_ID=?");
			System.out.println("Enter how many records to Delete :");
			int a=s.nextInt();
			for(int i=1;i<=a;i++) {
				System.out.println("Enter STUDENT_ID to Delete:");
				int b=s.nextInt();
				pst.setInt(1, b);
				int rowsEffected=pst.executeUpdate();
				System.out.println("Successfully deleted no.of students"+rowsEffected);
			}
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
	}