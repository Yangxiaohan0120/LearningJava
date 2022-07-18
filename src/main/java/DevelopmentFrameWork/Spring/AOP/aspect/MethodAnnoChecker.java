package DevelopmentFrameWork.Spring.AOP.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-07-18 20:43
 **/

@Component //标记当前类为组件
@Aspect //说明当前类是切面类
public class MethodAnnoChecker {

    // 环绕通知，参数为PointCut切点表达式
    @Around("execution(* DevelopmentFrameWork.Spring.AOP..*AnnoService.*(..))")
//    @Before()
//    @After()
//    @AfterReturning
//    @AfterThrowing
    // ProceedingJoinPoint是JoinPoint的升级版，在原有功能的基础之上，另外添加了控制目标方法是否执行的功能。
    public Object check(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Long startTime = new Date().getTime();
            Object ret = pjp.proceed(); //执行目标方法
            Long endTime = new Date().getTime();
            Long duration = endTime - startTime;
            if (duration >= 1000) {
                String className = pjp.getTarget().getClass().getName(); // 获取目标类的名称
                String methodName = pjp.getSignature().getName(); // 获取目标方法名称

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                String now = sdf.format(new Date());

                System.out.println("============" + now + ":" + className + "." + methodName + "(" + duration + "ms) =================");
            }
            return ret;
        } catch (Throwable e) {
            System.out.println("Exception message:" + e.getMessage());
            throw e;
        }
    }
}
