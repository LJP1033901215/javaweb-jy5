package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

public class UserService {
    //------------------------------------------业务层-------------------------------------------------------------
    private UserDao ud = new UserDao();//创建一个数据层的对象
    //------------------------------------------返回所有的用户数据-------------------------------------------------
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
        rs = ResponseCode.successRS(0,li);
            return rs;
    }
    //-------------------------------------------用户登陆-------------------------------------------------------
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();
        if(username==null ||username.equals("")||password==null||password.equals("")){//进行非空判断
            rs = ResponseCode.defeatdRS(Const.USER_PARAMETER_CODE,"账号或密码错误");
            return rs;
        }
        //出查询是否有相同的名字和密码
        Users u =ud.selctOne(username,password);
        //如果用户不存在
        if (u==null){
            rs = ResponseCode.defeatdRS(1,"账号或密码错误");
            return rs;
        }
        //判断是不是管理员，有没有权限
        if (!u.getUyhlx().equals("1")) {
            rs = ResponseCode.defeatdRS(2, "没有操作权限");
            return rs;
        }
        rs = ResponseCode.successRS(0,u);
        return rs;
    }
//-----------------------------根据传入的用户ID禁用用户------------------------------------------
    public ResponseCode selectOne(Integer uids ,Integer state,String qx) {
        ResponseCode rs = new ResponseCode();//创建一个统一输出的类的对象

 //-------------------------判断获取的用户的信息是不是有问题
        Users u = ud.selctOne(uids);//将传输进来的uid传入到数据层进行查找
        if (u.getUyhlx().equals(qx)){
            rs = ResponseCode.defeatdRS(1,"您的权限不足，不可进行此操作");
            return rs;
        }
//        if (u==null){//判断输入的用户是不是存在
//            rs = ResponseCode.defeatdRS(Const.USER_NONENTITY_CODE,Const.USER_NONENTITY_MSG);
//            return rs;
//        }

 //---------------------------------进行禁用用户的操作
        //禁用用户

        Integer row =ud.updateByUid(uids,state);
        if (row<=0){
            rs = ResponseCode.defeatdRS(Const.USER_BUAT_CODE,Const.USER_BUAT_MSG);
            return rs;
        }
        rs = ResponseCode.successRS(0,row);
        return rs;
    }
//开起用户ID的方法
//    public ResponseCode noselectOne(String uids) {
//        ResponseCode rs = new ResponseCode();//创建一个统一输出的类的对象
//        Integer uid = new Integer(uids);
//        Integer row = ud.noupdateByUid(uid);
//        if (row<=0){
//            rs = ResponseCode.defeatdRS(Const.USER_BUAT_CODE,"用户启用失败");
//            return rs;
//        }
//        rs = ResponseCode.successRS(0,row);
//        return rs;
//    }
    //-------------------------------------------------------------------------------------------
}
