package org.seckill.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//配置Spring和Junit整合，启动时加载SpringIOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉JUnit，Spring配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})

public class SeckillServiceTest {
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() throws Exception{
		List<Seckill> seckillList = seckillService.getSeckillList();
		logger.info("seckillList={}",seckillList);
	}

	@Test
	public void testGetById() throws Exception{
		long seckillId=1000L;
		Seckill seckill = seckillService.getById(seckillId);
		logger.info("seckill={}",seckill);
	}

	@Test
	public void testExportSeckillUrl() throws Exception{
		long seckillId=1000L;
		Exposer exposer= seckillService.exportSeckillUrl(seckillId);
		logger.info("exposer={}",exposer);
	}

	@Test
	public void testExecuteSeckill() throws Exception{
		long seckillId=1000L;
		long userPhone=13535999182L;
		String md5="9458cc9b363858dd810460dd1dae54b6";
		SeckillExecution execution = seckillService.executeSeckill(seckillId, userPhone, md5);
		logger.info("execution{}",execution);
	}

	@Test
	public void executeSeckillProcedure(){
		long seckillId=1002;
		long userPhone=19818234592l;
		Exposer exposer=seckillService.exportSeckillUrl(seckillId);
		if (exposer.isExposed()) {
			String md5=exposer.getMd5();
			SeckillExecution execution=seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
			logger.info("execution={}", execution);
		}
	}
	
	
	
	
	
	
	
	
}
