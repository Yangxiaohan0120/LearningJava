package DevelopmentFrameWork.Spring.IoC.controller;

import DevelopmentFrameWork.Spring.IoC.service.CustomerService;
import org.springframework.stereotype.Controller;

/**
 * @author Chris Yang
 * created 2022-07-18 10:28
 **/

@Controller
public class CustomerController {
    private CustomerService cService;

    public void setcService(CustomerService cService) {
        this.cService = cService;
    }

    public CustomerService getcService() {
        return cService;
    }
}
