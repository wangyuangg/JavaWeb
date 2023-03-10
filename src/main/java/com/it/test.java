package com.it;

import com.it.mapper.accountMapper;
import com.it.pojo.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) {
        selectAll();
    }
    public static void selectAll(){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //<Account> objects = sqlSession.selectList("test.selectALL");
        //System.out.println(objects);
        accountMapper mapper = sqlSession.getMapper(accountMapper.class);
        List<Account> accounts = mapper.selectALL();
        System.out.println(accounts);
        sqlSession.close();


    }
}
