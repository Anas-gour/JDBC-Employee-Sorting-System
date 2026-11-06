package ReadDataFromDatabase;

import java.sql.*;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "JDBC:oracle:thin:@//localhost:1521/orclh";
        String user = "*****";
        String pass = "*****";
        Class.forName("oracle.jdbc.OracleDriver");
        Connection con = DriverManager.getConnection(url,user,pass);
        System.out.println("Connection Successfully");
        
        String sql = "SELECT * FROM EMP WHERE SAL<=?";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter salary where you want to see:  ");
        double sal= sc.nextDouble();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1,sal);
        ResultSet rs = ps.executeQuery();
        LinkedList<employee> list = new LinkedList<>();
        
        while (rs.next()){
            String name = rs.getString("ENAME");
            double salary = rs.getDouble("SAL");
            String job = rs.getString("JOB");
            list.add(new employee(name,job,salary));
        }
//        list.sort(employee.nameBase);
        
        list.sort(employee.salBase);
        Iterator<employee> cursor = list.iterator();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
    }
}
