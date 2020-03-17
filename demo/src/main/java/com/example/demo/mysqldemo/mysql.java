package com.example.demo.mysqldemo;
import java.sql.*;

class Main {

    public static void main(String[] args) {

        DBConnect connection=new DBConnect();
        connection.getData();
    }
}

class DBConnect{
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {
        try {
            //3306|MySQL開放此端口
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","");
            st= con.createStatement();

        }catch(Exception ex){
            System.out.println("Error: "+ex);
        }
    }

    public void getData() {
        try {
            String query = "select * from c";
            rs = st.executeQuery(query);
            System.out.println("Records for Database");
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id= "+id+" name= "+name);
            }
        }catch(Exception ex) {
            System.out.println(ex);
        }
    }

}