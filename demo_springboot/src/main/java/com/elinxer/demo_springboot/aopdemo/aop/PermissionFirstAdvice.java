package com.elinxer.demo_springboot.aopdemo.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * https://blog.csdn.net/mu_wind/article/details/102758005
 *
 * 有人会问，如果我一个接口想设置多个切面类进行校验怎么办？这些切面的执行顺序如何管理？
 * 很简单，一个自定义的AOP注解可以对应多个切面类，这些切面类执行顺序由@Order注解管理，该注解后的数字越小，所在切面类越先执行。
 *
 * == @Order(0)
 * == @Order(1)
 * == @Order(2)
 *
 * == @Pointcut 注解指定一个切点，定义需要拦截的东西，这里介绍两个常用的表达式：一个是使用 execution()，另一个是使用 annotation()。
 * execution表达式：
 *
 * 以 execution(* com.mutest.controller..*.*(..)) 表达式为例：
 *
 * 第一个 * 号的位置：表示返回值类型，* 表示所有类型。
 * 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，在本例中指 com.mutest.controller包、子包下所有类的方法。
 * 第二个 * 号的位置：表示类名，* 表示所有类。
 * *(..)：这个星号表示方法名，* 表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
 *
 * ============================================
 *
 * annotation() 表达式：
 *
 * annotation() 方式是针对某个注解来定义切点，比如我们对具有 @PostMapping 注解的方法做切面，可以如下定义切面：
 * == @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
 * 然后使用该切面的话，就会切入注解是 @PostMapping 的所有方法。这种方式很适合处理 @GetMapping、@PostMapping、@DeleteMapping不同注解有各种特定处理逻辑的场景。
 * == @Pointcut("@annotation(com.example.demo.PermissionsAnnotation)")
 *
 *
 * @author Elinx<yangdongsheng03>
 */
@Aspect
@Component
//@Order(0)
public class PermissionFirstAdvice {

    // 定义一个切面，括号内写入第1步中自定义注解的路径
    @Pointcut("@annotation(com.zhiteer.demo.aopdemo.annotation.PermissionAnnotation)")
    private void permissionCheck() {
    }

    // 实现上面定义的切面
    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("===================第一个切面===================：" + System.currentTimeMillis());

        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        Long id = ((JSONObject) objects[0]).getLong("id");
        String name = ((JSONObject) objects[0]).getString("name");
        System.out.println("id1->>>>>>>>>>>>>>>>>>>>>>" + id);
        System.out.println("name1->>>>>>>>>>>>>>>>>>>>>>" + name);

        // id小于0则抛出非法id的异常
        if (id < 0) {
            return JSON.parseObject("{\"message\":\"illegal id\",\"code\":403}");
        }

        return joinPoint.proceed();
    }


}
