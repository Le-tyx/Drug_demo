package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.common.utils.DButils;
import cn.edu.jsu.demo.model.Drug;
import cn.edu.jsu.demo.model.User;

import java.util.List;

public class UserDao {
    //保存注册对象
    public boolean saveUser(User user) {

        String sql = "insert into user(user_name,user_email,user_password)"+
                "values(?,?,?)";

        return DButils.save(sql,user.getUser_name(),user.getUser_email(),user.getUser_password());
    }

    //保存管理员端添加对象
    public boolean saveUserFromManager(User user) {

        String sql = "insert into user(user_name,user_email,user_password,user_department,user_status)"+
                "values(?,?,?,?,?)";

        return DButils.save(sql,user.getUser_name(),user.getUser_email(),user.getUser_password(),user.getUser_department(),user.getUser_status());
    }

    //更新身份信息
    public boolean saveUserSF(User user) {
        String sql ="update user set user_status = ?,user_department=?" +
                "where user_email like ?";

        return DButils.update(sql,user.getUser_status(),user.getUser_department(),user.getUser_email());
    }

    //根据邮箱和密码查询医务人员
    public User getUserByEmailAndPass(String UserEmail,String UserPwd) {
        String sql = "select *from user where user_email = ? and user_password = ?";
        return DButils.getSingleObj(User.class,sql,UserEmail,UserPwd);
    }

    public static Integer selectUserCount(String applicantEmail) {
        String sql = "select count(*) from User a where a.user_email = ?";
        //查询记录数量
        Integer count = DButils.getCount(sql,applicantEmail);
        return count;
    }

    //通过id查询身份是否填写完整 、用户表的
    public boolean isComplete(Integer user_id) {
        String sql = "select user_status from user a where a.user_id =？";
        Integer count = DButils.getCount(sql,user_id);
        return count>0?true:false;
    }

    public List<User> getAllUser() {
        String sql = "select user_id,user_name,user_email,user_department,user_status" +
                " from user";
        return DButils.getList(User.class,sql);
    }

    public List<User> getSearchUser(String type, String flag) {
        String sql = "select *from user " +
                "where " + type+ " like '%"+flag+"%'" ;
        return DButils.getList(User.class,sql);
    }
}
