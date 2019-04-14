package org.seckill.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//配置Spring和Junit整合，启动时加载SpringIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnit，Spring配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() throws Exception{
		long id=1000L;
		long userPhone=18712241207L;
		int insertCount=successKilledDao.insertSuccessKilled(id, userPhone);
		System.out.println("insertCount"+insertCount);
	}

	@Test
	public void testQueryByIdWithSeckill() throws Exception{
		long id=1000L;
		long userPhone=18712241207L;
		SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(id, userPhone);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
	}

}
