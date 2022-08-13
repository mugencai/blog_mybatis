package com.mugencai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class MyBlogMybatisApplicationTests {


    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads() throws SQLException {

        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

}
