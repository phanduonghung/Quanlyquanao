/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.sql.ResultSet;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author Admin
 */
public class TestJdbcHelper {
    public void insertNH(){ 
    try{
    String sql = "{call sp_insert_NguoiHoc(?,?,?,?,?,?,?,?,?)}";
    JdbcHelper.executeUpdate(sql, "01", "hung", "20-10", true, "029173657", "hung@gmail.com", "hihi", "001", "12-2");
     JdbcHelper.executeUpdate(sql, "02", "hieu", "2-10", false, "029173567", "hieu@gmail.com", "hi", "002", "2-8");
      JdbcHelper.executeUpdate(sql, "03", "hoa", "20-1", true, "029173876", "hoa@gmail.com", "hih", "003", "12-7");
       JdbcHelper.executeUpdate(sql, "04", "hue", "6-4", false, "029173254", "hue@gmail.com", "hiha", "004", "2-8");
        JdbcHelper.executeUpdate(sql, "05", "hien", "22-1", true, "029173764", "hien@gmail.com", "hihu", "005", "1-6");           
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("insert: " +e.getMessage());
            }
}
    public void updateNH(){
        try{
            String sql ="{ call sp_update_NguoiHoc(?,?,?,?,?,?,?,?,?)}";
         JdbcHelper.executeUpdate(sql, "012", "thao", "2-10", true, "029173677", "thao@gmail.com", "hihuhu", "011", "1-2");
            System.out.println("sucess");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("erorr"+ e.getMessage());
        }
    }
    public void deleteNH(){
        try {
            String sql="{call sp_delete_NguoiHoc(?)}";
            JdbcHelper.executeUpdate(sql, "01");
                    System.out.println("delete sucess");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erorr" +e.getMessage());
        }    
        }
   public void findByID(String maNH) {
        try {
            String sql = "{call sp_findbyID_NguoiHoc (?)}";

            ResultSet rs = JdbcHelper.executeQuery(sql, "02");
            while (rs.next()) {
                System.out.print(rs.getString("manh") + ",");
                System.out.print(rs.getString("hoten") + ",");
                System.out.print(rs.getString("ngaysinh") + ",");
                System.out.print(rs.getString("gioitinh") + ",");
                System.out.print(rs.getString("dienthoai") + ",");
                System.out.print(rs.getString("email") + ",");
                System.out.print(rs.getString("ghichu") + ",");
                System.out.print(rs.getString("manv") + ",");
                System.out.println(rs.getString("ngaydk"));

            }
            System.out.println("query success!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void findByAll() {
        try {
            String sql = "{call sp_getAll_NguoiHoc}";

            ResultSet rs = JdbcHelper.executeQuery(sql);
            while (rs.next()) {
                System.out.print(rs.getString("manh") + ",");
                System.out.print(rs.getString("hoten") + ",");
                System.out.print(rs.getString("ngaysinh") + ",");
                System.out.print(rs.getString("gioitinh") + ",");
                System.out.print(rs.getString("dienthoai") + ",");
                System.out.print(rs.getString("email") + ",");
                System.out.print(rs.getString("ghichu") + ",");
                System.out.print(rs.getString("manv") + ",");
                System.out.println(rs.getString("ngaydk"));

            }
            System.out.println("query success!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    

    public static void main(String[] args) {
        TestJdbcHelper hp = new TestJdbcHelper();
        hp.insertNH();
        //hp.updateNH();
        //hp.deleteNH();
        // hp.findByAll();
       
    }
}
    
    
