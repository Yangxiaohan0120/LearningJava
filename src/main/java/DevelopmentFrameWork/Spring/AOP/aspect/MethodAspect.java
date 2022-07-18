package DevelopmentFrameWork.Spring.AOP.aspect;

import Multithreading.Join;
import org.aspectj.lang.JoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-07-18 16:47
 **/


//切面类
public class MethodAspect {
    // 切面方法，用于扩展额外功能
    // JoinPoint连接后，可以根据连接点获取目标类/方法的信息
    public void printExecutionTime(JoinPoint joinPoint) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String now = sdf.format(new Date());
        String className = joinPoint.getTarget().getClass().getName(); // 获取目标类的名称
        String methodName = joinPoint.getSignature().getName(); // 获取目标方法名称
        System.out.println("-----> " + now + ":" + className + "." + methodName);

        //获取参数
        Object[] args = joinPoint.getArgs();
        System.out.println("----->参数个数：" + args.length);
        for (Object arg : args) {
            System.out.println("---->参数：" + arg);
        }
    }

    public void doAfterReturning(JoinPoint joinPoint,Object ret){
        System.out.println("<-----返回后通知" + ret);
    }

    public void doAfterThrowing(JoinPoint joinPoint,Throwable throwable){
        System.out.println("<-----异常通知：" + throwable.getMessage());
    }

    public void doAfter(JoinPoint joinPoint){
        System.out.println("<------触发后置通知");
    }
}
