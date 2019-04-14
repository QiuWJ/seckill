package org.seckill.dao;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 * spring-test,junit
 * @author Administrator
 *
 */
//配置Spring和Junit整合，启动时加载SpringIOC容器
@RunWith(SpringJUnit4ClassRunner.class)

//告诉JUnit，Spring配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})

public class SeckillDaoTest {

	@Resource
	private SeckillDao seckillDao;
	
	
	@Test
	public void testReduceNumber() throws Exception{
		Date killTime=new Date();
		int updateCount=seckillDao.reduceNumber(1000, killTime);
		System.out.println(updateCount);
	}

	@Test
	public void testQueryById() throws Exception{
		long id=1000;
		Seckill seckill=seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
	}

	@Test
	public void testQueryAll() throws Exception{
		List<Seckill> seckills=seckillDao.queryAll(0, 100);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}
		
	}

}
