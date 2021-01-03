package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.common.utils.DButils;
import cn.edu.jsu.demo.model.Drug;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PageOperationDrug {
    public List<Drug> getDrugPageList(int pageNo, int pageSize){
        List<Drug> drugs=new ArrayList<Drug>();
        int firstIndex=pageSize*(pageNo-1);
        try{
            Connection con=new DButils().getConnection();
            String sql="select * from drug";
            PreparedStatement pstmt=con.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            int i=0,j=0;
            while(rs.next()){
                if(i>=firstIndex&&j<pageSize){
                    Drug drug=new Drug();
                    drug.setDrug_id(rs.getInt("drug_id"));
                    drug.setDrug_name(rs.getString("drug_name"));
                    drug.setDrug_degree(rs.getString("drug_degree"));
                    drug.setSymptom_type(rs.getString("symptom_type"));
                    drugs.add(drug);
                    j++;
                }
                i++;
            }
            rs.close();
            pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return drugs;
    }
    public int getRecordCount(){
        int recordCount=0;
        try{
            Connection con=new DButils().getConnection();
            String sql="select count(*) from drug";
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
