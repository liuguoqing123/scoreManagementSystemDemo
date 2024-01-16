package com.demo.common;

import com.demo.common.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author Lewis
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    private Long startTime;

    @Pointcut("(execution(public * com.demo.service.impl.*.*(..)))")
    public void pointCut() {
        // Do nothing because of Pointcut.
    }

    @Before(value = "pointCut()")
    public void printBeginLog(JoinPoint joinPoint) {

        startTime = System.currentTimeMillis();
        log.info("the method {} is beginning at {}.......",  joinPoint.getSignature().getName(), DateUtil.getCurrentDateWithYYYYMMDDHHMMSS2(new Date()));
    }

    @After(value = "pointCut()")
    public void printEndLog(JoinPoint joinPoint) {
        Long endTime = System.currentTimeMillis();
        log.info("the method {} is end, elapsed time is {}s.......", joinPoint.getSignature().getName(), (double) (endTime - startTime) / 1000);
    }


}
