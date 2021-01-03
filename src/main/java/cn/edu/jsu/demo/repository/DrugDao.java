package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.common.utils.DButils;
import cn.edu.jsu.demo.model.Drug;

import java.util.List;

public class DrugDao {
    public static Integer selectDrugCount(String dname) {
        String sql = "select count(*) from drug a where a.drug_name = ?";
        //查询记录数量
        Integer count = DButils.getCount(sql,dname);
        return count;
    }

    //保存药品
    public boolean saveDrug(Drug drug) {
        String sql = "insert into drug(drug_name,drug_degree,symptom_type)"+
       "values(?,?,?)";
        return DButils.save(sql,drug.getDrug_name(),drug.getDrug_degree(),drug.getSymptom_type());
    }

    //所有药品
    public List<Drug> getAllDrug() {
        String sql = "select * from drug";
        return DButils.getList(Drug.class,sql);
    }


    //查找药品
    public List<Drug> getSearchDrug(String type,String flag) {
        String sql = "select *from drug " +
                "where " + type+ " like '%"+flag+"%'" ;
        return DButils.getList(Drug.class,sql);
    }

    //通过id查找药品
    public Drug getDrugByDrugID(int drug_id) {
        String sql = "select *from drug " +
                "where drug_id = ?" ;
        return DButils.getSingleObj(Drug.class,sql,drug_id);
    }

    //将药品加入无权限表
    public Boolean saveDrug1(Drug drug) {
        String sql = "insert into undruglist(drud_id,drug_name,drug_degree,symptom_type)"+
                "values(?,?,?,?)";
        return DButils.save(sql,drug.getDrug_id(),drug.getDrug_name(),drug.getDrug_degree(),drug.getSymptom_type());
    }

    public boolean saveDrug2(Drug drug) {
        String sql = "insert into druglist(drug_id,drug_name,drug_degree,symptom_type)"+
                "values(?,?,?,?)";
        return DButils.save(sql,drug.getDrug_id(),drug.getDrug_name(),drug.getDrug_degree(),drug.getSymptom_type());
    }
}
