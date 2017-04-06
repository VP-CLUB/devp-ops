package cn.vpclub.monitor.consumer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  vpclub on 16-6-4.
 * PackageName cn.vpclub.check.consumer
 * ModifyDate  16-6-4
 * Description (服务监控)
 * ProjectName groovydemo
 */
@RestController
@RequestMapping(value = "/check/service")
public class ServiceHealthCheckController {

    private static Logger logger = LoggerFactory.getLogger(ServiceHealthCheckController.class);
    @Scheduled(cron = "${time.service.healthStatCron}")
    public void doCheck()  {
        //如果为true,则开启调度任务

    }
}
