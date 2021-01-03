package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.model.Manager;
import org.junit.Test;

public class ManagerDaoTest {

    @Test
    public void saveManager() {
        ManagerDao dao = new ManagerDao();
        Manager manager = new Manager();
        manager.setManager_email("11235566");
        manager.setManager_name("huh");
        manager.setManager_password("123456");
        dao.saveManager(manager);
    }
}