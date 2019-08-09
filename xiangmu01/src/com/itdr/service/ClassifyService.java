package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ClassifyDao;
import com.itdr.pojo.Classify;
import com.itdr.pojo.Poiduct;

import java.util.List;

//业务层
public class ClassifyService {
    ClassifyDao cd = new ClassifyDao();
    //------------------------------------查询所有子节点-------------------------------------------------
    public ResponseCode categoryAll(String categoryId) {
        ResponseCode rs = new ResponseCode();
        if (categoryId == null || categoryId.equals("")) {
            rs.setStatus(0);
            rs.setMag("输入的值不能为空");
            return rs;
        }
        List<Poiduct> li = cd.categoryALL(categoryId);
        if (li==null){
            rs.setStatus(1);
            rs.setMag("未找到该品种");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
//----------------------------------------添加数据-------------------------------------------------------
    public ResponseCode categroyaddOne(String parentId, String categoryName) {
        ResponseCode rs = new ResponseCode();
        Classify classify = cd.categoryOneName(categoryName);
        if (classify!=null){
            rs.setStatus(1);
            rs.setMag("数据已经存在");
            return rs;
        }
        if (parentId==null||parentId.equals("")){
            parentId = "0";
        }
        if (categoryName==null||categoryName.equals("")){
            rs.setStatus(0);
            rs.setMag("参数不可以为空");
            return rs;
        }
        Integer li = cd.categoryaddOne(parentId,categoryName);
        if (li!=1){
            rs.setStatus(1);
            rs.setMag("添加失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
//-------------------------------------根据ID修改名字-------------------------------------------
    public ResponseCode categroysetOne(String categoryIds, String categoryName) {
        ResponseCode rs = new ResponseCode();
        Integer categoryId = Integer.parseInt(categoryIds);
        Classify classify = cd.categoryOneName(categoryId);
        if (classify==null){
            rs.setStatus(1);
            rs.setMag("数据不存在");
            return rs;
        }
        Classify classifys1 = cd.categoryOneName(categoryName);
        if (classifys1!=null){
            rs.setStatus(1);
            rs.setMag("名字已经存在");
            return rs;
        }
        if (categoryName==null||categoryName.equals("")||categoryIds==null||categoryIds.equals("")){
            rs.setStatus(0);
            rs.setMag("参数不可以为空");
            return rs;
        }
        Integer li = cd.categorysetOne(categoryId,categoryName);
        if (li!=1){
            rs.setStatus(1);
            rs.setMag("添加失败");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
}
