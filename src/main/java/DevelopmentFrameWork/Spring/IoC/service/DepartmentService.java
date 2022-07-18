package DevelopmentFrameWork.Spring.IoC.service;

import DevelopmentFrameWork.Spring.IoC.dao.ICustomerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Chris Yang
 * created 2022-07-18 10:50
 **/

@Service
public class DepartmentService {

    /**
     * 1. @Resource 设置name 属性，按照name在IoC容器中将bean注入
     * 2. @Resource 未设置name
     * 2.1 以属性名作为bean name 在IoC容器中匹配bean，如有匹配则注入
     * 2.2 按属性名未匹配，则按类型进行匹配，同@Autowired，需加入@Primary解决类型冲突
     * 使用建议：在使用@Resource对象时，推荐设置name或者保证属性名称与bean一致
     */

    @Resource(name = "customerOracleDao")
    private ICustomerDao cDao;

    public void setcDao(ICustomerDao cdao) {
        this.cDao = cdao;
    }

    public ICustomerDao getcDao() {
        return cDao;
    }
}
