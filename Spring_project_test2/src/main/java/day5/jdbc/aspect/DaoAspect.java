package day5.jdbc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class DaoAspect {
private static Logger logger = LoggerFactory.getLogger(DaoAspect.class);
	
	@AfterThrowing(pointcut="execution(* day5..*ServiceImpl.*(..))",throwing="e")
	public void Throwing(JoinPoint jp,Exception e){
		logger.trace("예외 발생 ",e);
	}
}
