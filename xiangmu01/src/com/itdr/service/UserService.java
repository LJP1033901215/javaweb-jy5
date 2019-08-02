package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

public class UserService {
    //业务层
    private UserDao ud = new UserDao();//创建一个数据层的对象
    //返回所有的用户数据
    public ResponseCode<Users> selectAll(String pageSize, String pageNum) {
        if (pageSize==null ||pageSize.equals("")){//进行非空判断
            pageSize = "10" ;
        }
        if (pageNum == null||pageNum.equals("")){//进行非空判断
            pageNum = "1";
        }
           List<Users> li =  ud.selctALL(pageSize,pageNum);//调用数据层的方法输出所有的数据
        //如果几个为空元素呢？
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
            return rs;
    }
    //用户登陆
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();
        if(username==null ||username.equals("")||password==null||password.equals("")){//进行非空判断
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        //出查询是否有相同的名字和密码
        Users u =ud.selctOne(username,password);
        //如果用户不存在
        if (u==null){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        //判断是不是管理员，有没有权限
        if (u.getUyhlx()!=1){
            rs.setStatus(2);
            rs.setMag("没有操作权限");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(u);

        return rs;
    }
}
