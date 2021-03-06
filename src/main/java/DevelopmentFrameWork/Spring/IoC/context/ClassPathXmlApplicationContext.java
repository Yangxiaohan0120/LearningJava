package DevelopmentFrameWork.Spring.IoC.context;

import org.checkerframework.checker.units.qual.t;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Chris Yang
 * created 2022-07-17 21:40
 **/
public class ClassPathXmlApplicationContext implements ApplicationContext {

    private Map iocContainer = new HashMap<>();

    public ClassPathXmlApplicationContext() {
        try {
            String filePath = this.getClass().getResource("/applicationContextIoC.xml").getPath();
            filePath = new URLDecoder().decode(filePath, "UTF-8");
            SAXReader reader = new SAXReader();
            Document document = reader.read(new File(filePath));
            List<Node> beans = document.getRootElement().selectNodes("bean");
            for(Node node : beans){
                Element element = (Element) node;
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                Class c =  Class.forName(className); // 加载指定的类
                Object obj = c.newInstance();

                // 属性添加
                List<Node> properties = element.selectNodes("property");
                for (Node p : properties){
                    Element ele = (Element) p;
                    String propName = ele.attributeValue("name");
                    String propValue = ele.attributeValue("value");

                    String setMethodName = "set" + propName.substring(0,1).toUpperCase() + propName.substring(1);
                    System.out.println("准备执行：" + setMethodName + "方法注入数据");
                    Method setMethod =  c.getMethod(setMethodName,String.class);
                    setMethod.invoke(obj,propValue);
                }
                iocContainer.put(id,obj);
                System.out.println("IoC初始化完毕");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanId) {
        return iocContainer.get(beanId);
    }
}
