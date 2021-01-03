package cn.edu.jsu.demo.model;

import com.alibaba.fastjson.JSON;
import java.util.Date;

/**
 * @author yangguanzan
 * @date 2020-12-25
 * @description
 */
public class UserDemo {

    private Long id;
    private String userName;
    private Date createdDt;
    private Date modifiedDt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public Date getModifiedDt() {
        return modifiedDt;
    }

    public void setModifiedDt(Date modifiedDt) {
        this.modifiedDt = modifiedDt;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
