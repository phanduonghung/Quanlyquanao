/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author Admin
 */

     public class SanPhamDAO{
                 public void insert(SanPham model){   
           String sql="INSERT INTO SanPham (masp, tensp, size, dongia, ngaynhapkho) VALUES ( ?, ?, ?, ?, ?)";      
                     JdbcHelper.executeUpdate(sql,             
                   model.getMasp(),               
                   model.getTensp(),               
                   model.getSize(), 
                   model.getDongia(),
                   model.getNgaynhapkho());                             
       }      
       public void update(SanPham model){   
           String sql="UPDATE SanPham SET tensp=?, size=?, dongia=? ngaynhapkho=?  WHERE masp=?";  
           JdbcHelper.executeUpdate(sql,                                       
                   model.getTensp(),               
                   model.getSize(), 
                   model.getDongia(),
                   model.getNgaynhapkho(),
                    model.getMasp());
               }               
        public void delete(String masp){ 
             String sql="DELETE FROM SanPham WHERE masp=?"; 
             JdbcHelper.executeUpdate(sql, masp);   
        }        
             public List<SanPham> select(){      
             String sql="SELECT * FROM SanPham";   
            return select(sql);  
             }   
              
        public SanPham findById(String masp){    
              String sql="SELECT * FROM SanPham WHERE masp=?"; 
              List<SanPham> list = select(sql, masp);    
            return list.size() > 0 ? list.get(0) : null;  
        } 
    private List<SanPham> select(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();

        ResultSet rs ;
        try {
            rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                SanPham model = readFromResultSet(rs);
                list.add(model);
            }

            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
     private SanPham readFromResultSet(ResultSet rs)
        throws SQLException{    
              SanPham model=new SanPham();      
              model.setMasp(rs.getString("masp"));   
              model.setTensp(rs.getString("tensp")); 
             model.setSize(rs.getString("size"));   
              model.setDongia(rs.getString("dongia")); 
              model.setNgaynhapkho(rs.getDate("ngaynhapkho"));
              
        return model;  
} 
}
