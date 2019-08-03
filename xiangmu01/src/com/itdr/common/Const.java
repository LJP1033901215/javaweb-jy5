package com.itdr.common;

public class Const {
    //用户相关的错误码

    //传入的参数为空或者是空白时的错误代号
    public static final Integer USER_PARAMETER_CODE =105;
    public static final String USER_PARAMETER_MSG ="参数为空";
    //传入的参数在用户表中不存在时的错误代号
    public static final Integer USER_NONENTITY_CODE =104;
    public static final String USER_NONENTITY_MSG ="传入的用户不存在";
    //传入的用户已经被禁用了
    public static final Integer USER_DISABLE_CODE =106;
    public static final String USER_DISABLE_MSG ="用户已被禁用";
    //输入的数据类型有误
    public static final Integer USER_DATA_CODE =107;
    public static final String USER_DATA_MSG ="输入的数据类型不正确";
   //禁用用户时禁用失败
    public static final Integer USER_BUAT_CODE =108;
    public static final String USER_BUAT_MSG ="用户禁用失败";
    //用户未登录
    public static final Integer USER_NOT_LOG_IN_CODE =103;
    public static final String USER_NOT_LOG_IN_MSG ="当前未登陆";
    //当前用户没有权限
    public static final Integer USER_NOT_JURISDICTION_CODE =110;
    public static final String USER_NOT_JURISDICTION_MSG ="当前用户没有操作权限";
}
