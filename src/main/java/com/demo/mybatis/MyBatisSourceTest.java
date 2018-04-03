package com.demo.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSourceTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		SqlSessionFactory sqlSessionFactory = null;
		String resource = "spring-db.xml";
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
	}

}
