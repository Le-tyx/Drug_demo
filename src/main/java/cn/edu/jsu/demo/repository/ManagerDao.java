package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.common.utils.DButils;
import cn.edu.jsu.demo.model.Manager;

public class ManagerDao {

  //保存注册对象
    public boolean saveManager(Manager manager) {

      String sql = "insert into manager(manager_name,manager_email,manager_password)"+
              "values(?,?,?)";

      return DButils.save(sql,manager.getManager_name(),manager.getManager_email(),manager.getManager_password());
    }

    //根据邮箱和密码查询管理员
  public Manager getManagerByEmailAndPass(String managerEmail,String managerPwd) {
    String sql = "select manager_name,manager_email,manager_password "+
            "from manager where manager_email = ?  and manager_password = ?";
      return DButils.getSingleObj(Manager.class,sql,managerEmail,managerPwd);
  }

  public static Integer selectManagerCount(String applicantEmail) {
      String sql = "select count(*) from manager a where a.manager_email = ?";
      //查询记录数量
      Integer count = DButils.getCount(sql,applicantEmail);
      return count;
  }

}
