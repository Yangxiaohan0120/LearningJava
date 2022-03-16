package advanceJava.Annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chris Yang
 * created 2022-03-14 11:29
 **/
public class SuppressWarnings_ {

    // 当我们不希望看到警告的时候
    // {} 可写入希望抑制的警告
    // all
    // boxing 抑制与封装/拆装作业相关的警告
    // cast 抑制与强制转型作业相关的警告
    // dep-ann 抑制与淘汰注释相关的警告
    // deprecation 抑制与淘汰相关的警告
    // fallthrough 抑制与switch陈述式中遗漏break相关的警告
    // finally 抑制与未传回finally区块相关的警告
    // hiding 抑制与隐藏变数的区域变数相关的警告
    // incomplete-switch 抑制与switch陈述式（cnum case）中遗漏项目相关的警告
    // javadoc 抑制与javadoc相关的警告
    // nls	 to suppress warnings relative to non-nls string literals
    // null	to suppress warnings relative to null analysis
    // rawtypes	to suppress warnings relative to un-specific types when using generics on class params
    // restriction	to suppress warnings relative to usage of discouraged or forbidden references
    // serial	to suppress warnings relative to missing serialVersionUID field for a serializable class
    // static-access	o suppress warnings relative to incorrect static access
    // synthetic-access 	 to suppress warnings relative to unoptimized access from inner classes
    // unchecked	 to suppress warnings relative to unchecked operations
    // unqualified-field-access	to suppress warnings relative to field access unqualified
    // unused	to suppress warnings relative to unused code


    // SuppressWarnings 使用位置：具体的语句，方法，类
    // 源码：@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
    // @Retention(RetentionPolicy.SOURCE)
    // public @interface SuppressWarnings {
    // String[] value();
    // }
    // TARGET : 放置位置
    // 该注解类有一个数组

    @SuppressWarnings({"unchecked","rawtypes","unused"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("jack");
        list.add("mary");
        list.add("rose");
        int i;
        System.out.println(list.get(1));
    }
}
