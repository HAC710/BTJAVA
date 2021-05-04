/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BKT;
import java.sql.*;
import java.io.*;

/**
 *
 * @author Xuan Hoang
 */
public class KT2 {
    public static void main(String[] args) {
        KT2 kt2 = new KT2();
        kt2.go();
    }
    public void go(){
        try {
            File myFile = new File("input.txt");
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            
            String line = null;
            while((line = reader.readLine()) != null){
               
                line = line.replace(" ", "");
                System.out.println(line);
//                String[] result = line.split("")
            }
            reader.close();
            ResultSet rs = excuteQuery("select * from HOCVIEN");
            while(rs.next()) 
            {
                String mhv = rs.getString("MaHocVien");
                String name = rs.getString("TenHocVien");
                Date NgSinh = rs.getDate("NgSinh");
                String Gender = rs.getString("GioiTIinh");
                float Diem = rs.getFloat("DiemThi");
                System.out.println(mhv + " " + name + " " + NgSinh + " " + Gender + " " + Diem);
            }
        } catch (Exception ex) {
            
            ex.printStackTrace();
        }
    }
    public ResultSet excuteQuery(String query){
        try {
            String connectionURL = "jdbc:ucanaccess://Database4.accdb";
            Connection connection = DriverManager.getConnection(connectionURL);
            Statement st = connection.createStatement();
            return st.executeQuery(query);
        } catch (Exception e) {
            System.out.println("BKT.KT2.excuteQuery()");
            return null;
        }
    }
    public void excuteUpdate(String query){
        try {
            String connectionURL = "jdbc:ucanaccess:Database4.accdb";
            Connection connection = DriverManager.getConnection(connectionURL);
            Statement st = connection.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
        }
    }
}
