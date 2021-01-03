package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.common.utils.DButils;
import cn.edu.jsu.demo.model.Drug;
import cn.edu.jsu.demo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PageOperationUser {
        public List<User> getUserPageList(int pageNo, int pageSize){
            List<User> users=new ArrayList<User>();
            int firstIndex=pageSize*(pageNo-1);
            try{
                Connection con=new DButils().getConnection();
                String sql="select * from user";
                PreparedStatement pstmt=con.prepareStatement(sql);
                ResultSet rs=pstmt.executeQuery();
                int i=0,j=0;
                while(rs.next()){
                    if(i>=firstIndex&&j<pageSize){
                        User user=new User();
                        user.setUser_id(rs.getInt("user_id"));
                        user.setUser_name(rs.getString("user_name"));
                        user.setUser_email(rs.getString("user_department"));
                        user.setUser_department(rs.getString("user_department"));
                        user.setUser_status(rs.getString("user_status"));
                        users.add(user);
                        j++;
                    }
                    i++;
                }
                rs.close();
                pstmt.close();
            }catch (Exception e){
                e.printStackTrace();
            }
            return users;
        }
        public int getRecordCount(){
            int recordCount=0;
            try{
                Connection con=new DButils().getConnection();
                String sql="select count(*) from user";
                PreparedStatement pstmt=con.prepareStatement(sql);
                ResultSet rs=pstmt.executeQuery();
                while(rs.next()){
                    recordCount=rs.getInt(1);
                }
            }catch (Exception e){
                e.printStackTrace();
                return 0;
            }
            return recordCount;
        }

}
