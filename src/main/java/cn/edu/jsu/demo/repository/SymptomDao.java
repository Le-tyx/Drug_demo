package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.common.utils.DButils;
import cn.edu.jsu.demo.model.Drug;
import cn.edu.jsu.demo.model.Symptom;

import java.util.List;


public class SymptomDao {
    public static Integer selectSymptomCount(String symptom_type) {
        String sql = "select count(*) from symptom a where a.symptom_type = ?";
        //查询记录数量
        Integer count = DButils.getCount(sql,symptom_type);
        return count;
    }

    //保存症状
    public boolean saveSymptom(Symptom Symptom) {
        String sql = "insert into Symptom(Symptom_type)"+
                "values(?)";
        return DButils.save(sql,Symptom.getSymptom_type());
    }

    public List<Symptom> getAllDrug() {
        String sql = "select * from symptom";
        return DButils.getList(Symptom.class,sql);
    }
}
