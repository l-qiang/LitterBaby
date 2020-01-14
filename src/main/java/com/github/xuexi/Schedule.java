package com.github.xuexi;
//package com.github;
//
//import java.util.Random;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import com.github.service.XuexiService;
//
//@Component
//public class Schedule {
//	
//	private static final Random random = new Random();
//	
//	@Autowired
//	private XuexiService xuexiService;
//	
//	@Scheduled(cron = "0 0 10 * * ?")
//	public void xuexi() {
//		try {
//			Thread.sleep(random.nextInt(10) * 60 * 1000);
//		} catch (InterruptedException e) {
//			
//		}
//		
//		xuexiService.start();
//	}
//}
