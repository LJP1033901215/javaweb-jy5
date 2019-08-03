package com.itdr.service;

import com.itdr.common.Const;
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
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
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
    //根据传入的用户ID禁用用户
    public ResponseCode selectOne(String uids) {
        ResponseCode rs = new ResponseCode();//创建一个统一输出的类的对象
//---------------------------判断传进来的uid是不是有问题---------------------------------------------------------------------
        //因为传进来的uid是String类型的值，所以要进行转型
        Integer uid =0;
        try{
            uid = new Integer(uids);}//因为uid很有可能不是数字类型，而是字母，所以可能会出现错误
        catch (Exception e){
            rs.setStatus(Const.USER_DATA_CODE);
            rs.setMag(Const.USER_DATA_MSG);
            return rs;
        }

        if (uids==null||uids.equals("")){//判断uid传入的数据是不是为空
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
 //-------------------------判断获取的用户的信息是不是有问题------------------------------------
        Users u = ud.selctOne(uid);//将传输进来的uid传入到数据层进行查找
        if (u==null){//判断输入的用户是不是存在
            rs.setStatus(Const.USER_NONENTITY_CODE);
            rs.setMag(Const.USER_NONENTITY_MSG);
            return rs;
        }if (u.getUzc()==1){//判断用户是不是已经被禁用
            rs.setStatus(Const.USER_DISABLE_CODE);
            rs.setMag(Const.USER_DISABLE_MSG);
            return rs;
        }
 //---------------------------------进行禁用用户的操作-------------------------------------------------------
        //禁用用户
        Integer row = ud.updateByUid(uid);
        if (row<=0){
            rs.setStatus(Const.USER_BUAT_CODE);
            rs.setMag(Const.USER_BUAT_MSG);
            return rs;
        }
        rs.setStatus(0);
        rs.setData(row);
        return rs;
    }
 //-------------------------------------------------------------------------------------------
}
