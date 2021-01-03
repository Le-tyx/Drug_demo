package cn.edu.jsu.demo.repository;

import cn.edu.jsu.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class BeanDaoUser {
        public int pageSize=6;
        //每页大小
        public int pageNo=1;
        //当前页码
        public int totalPages;
        //总页数
        public List<User> pageData=new ArrayList<User>();
        //每页数据集合
        public boolean hasNextPage;
        //是否有下一页
        public boolean hasPreviousPage;
        //是否有上一页
        public int getTotalPages(){
            PageOperationUser pageOperationUser =new PageOperationUser();
            int recordCount= pageOperationUser.getRecordCount();
            if(recordCount%pageSize==0)
                return recordCount/pageSize;
            else return recordCount/pageSize+1;
        }
        public List<User> getPageData(){
            PageOperationUser pageOperationUser =new PageOperationUser();
            List<User> users = pageOperationUser.getUserPageList(pageNo,pageSize);
            return users;
        }
        public boolean isHasNextPage(){
            return this.pageNo<this.getTotalPages();
        }
        public boolean isHasPreviousPage() {
            return this.pageNo>1;
        }
        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public void setPageData(List<User> pageData) {
            this.pageData = pageData;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }
}
