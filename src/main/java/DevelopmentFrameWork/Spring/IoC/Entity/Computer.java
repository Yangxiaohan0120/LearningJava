package DevelopmentFrameWork.Spring.IoC.Entity;

/**
 * @author Chris Yang
 * created 2022-07-17 20:33
 **/
public class Computer {
    private String brand;
    private String type;
    private String sn;
    private Float price;

    public Computer() {
    }

    public Computer(String brand, String type, String sn, Float price) {
        this.brand = brand;
        this.type = type;
        this.sn = sn;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getSn() {
        return sn;
    }

    public Float getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
