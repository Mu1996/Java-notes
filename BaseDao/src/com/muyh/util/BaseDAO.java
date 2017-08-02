package com.muyh.util;/*
 * Created by muyonghui on 2017/8/2.
 */

import com.muyh.bean.User;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDAO {
    public ArrayList getList(Class cl){
        ArrayList ar = new ArrayList();
        Connection conn = BaseConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from " + cl.getSimpleName();
        Field[] fi = cl.getDeclaredFields();

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Object obj = cl.newInstance();
                for (Field ff : fi){

                    ff.setAccessible(true);
                    System.out.println(ff.getName()+rs.getObject("id"));
                    ff.set(obj, rs.getObject(ff.getName()));
                }
                ar.add(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BaseConnection.closeRes(conn, ps, rs);
        }

        System.out.println(sql);
        return ar;
    }

    public static void main(String[] args) {
        BaseDAO baseDAO = new BaseDAO();
        ArrayList<User> ls = baseDAO.getList(User.class);
        for (User user : ls) {
            System.out.println(user.getId() + " " + user.getName() );
        }
    }
}
