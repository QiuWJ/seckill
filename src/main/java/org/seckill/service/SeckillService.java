package org.seckill.service;

import java.util.List;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

public interface SeckillService {
	
	
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	/**
	 * 查询单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 秒杀开始时输出秒杀接口地址
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 执行秒杀操作
	 * @return
	 */
    SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
    throws SeckillException,RepeatKillException,SeckillCloseException;
	
	
	/**
	 * 存储过程执行秒杀
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 * @return
	 */
    SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5)
    	    throws SeckillException,RepeatKillException,SeckillCloseException;
	
	
}
