package com.example.demo.mysqldemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

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

    public List<bdDao> getData() {
        List<bdDao> db=new ArrayList<>();
        try {
            String query = "select * from c order by id asc";
            rs = st.executeQuery(query);
            System.out.println("Records for Database");

            while(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String price=rs.getString("price");
                db.add(new bdDao(id,name,price));
            }
            System.out.println(db);
            return db;
        }catch(Exception ex) {
            System.out.println(ex);
        }
        return db;
    }
    public void addData() {
        try {
            String setid ="1" ;
            String setname = "A";
            String setprice = "10";
            String query = "insert into c (id , name , price) value (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, setid);
            ps.setString(2, setname);
            ps.setString(3, setprice);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

        public void UpData(){
            try{
                String query = "update c set id=? where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1,"3");
                ps.setString(2,"5");
//                ps.setString(3,"1");
                ps.executeUpdate();
            }
            catch(Exception ex) {
                System.out.println(ex);
            }
    }
    public void delet(){
        try{
            String query = "delete from c where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,"1");
            ps.executeUpdate();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
    }

}


@Data
@AllArgsConstructor
class bdDao{
    private String id;
    private String name;
    private String price;
}