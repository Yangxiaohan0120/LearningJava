package DevelopmentFrameWork.Spring.IoC.Entity;

/**
 * @author Chris Yang
 * created 2022-07-17 21:28
 **/
public class Order {
    private Float price;
    private Integer quantity;
    private Float total;

    public Order() {
        System.out.println("创建Order对象: " + this);
    }

    public void init(){
        System.out.println("执行init");
        total = price * quantity;
    }

    public void destroy(){
        System.out.println("释放相关的资源");
    }

    public void pay(){
        System.out.println("订单金额为：" + total);
    }

    public void setPrice(Float price) {
        System.out.println("设置Price:" + price);
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        System.out.println("设置Quantity:" + quantity);
        this.quantity = quantity;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Float getTotal() {
        return total;
    }
}
