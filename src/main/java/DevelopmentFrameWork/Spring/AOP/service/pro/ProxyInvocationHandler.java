package DevelopmentFrameWork.Spring.AOP.service.pro;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Chris Yang
 * created 2022-07-18 21:12
 **/

/**
 * invocationHandler 是JDK提供的反射类，用于在JDK动态代理中对目标方法进行增强
 * invocationHandler 实现类与切面类的环绕通知类似
 */

// 动态代理的实现
public class ProxyInvocationHandler implements InvocationHandler {

    // 持有委托类对象
    private Object target;

    private ProxyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 在invoke()方法对目标方法进行增强
     *
     * @return 目标方法运行后返回值
     * @throws Throwable 目标方法抛出的异常
     * @param: proxy 代理类对象
     * @param: method 目标方法对象
     * @param: args 目标方法实参
     */

    //
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()) + "-----------");
        Object ret = method.invoke(target, args); // 调用目标方法 == ProceedingJoinPoint.proceed();
        return ret;
    }

    public static void main(String[] args) {
        // 这一部分相当于Application里的内容，将对象传入到代理类
        // 等价于         UserService userService = new UserServiceProxy1(new UserServiceProxy(new UserServiceImpl()));
        UserService userService = new UserServiceImpl();
        ProxyInvocationHandler invocationHandler = new ProxyInvocationHandler(userService);
        // 动态创建代理类
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.createUser();

        // 动态实现代理类，所以可以实现多种接口的代理
        EmployeeService employeeService = new EmployeeServiceImpl();
        ProxyInvocationHandler invocationHandler1 = new ProxyInvocationHandler(employeeService);

        EmployeeService employeeServiceProxy = (EmployeeService) Proxy.newProxyInstance(employeeService.getClass().getClassLoader(),employeeService.getClass().getInterfaces(),invocationHandler1);
        employeeServiceProxy.createEmployee();


    }
}
