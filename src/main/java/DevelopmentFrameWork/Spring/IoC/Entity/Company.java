package DevelopmentFrameWork.Spring.IoC.Entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author Chris Yang
 * created 2022-07-17 20:34
 **/
public class Company {
    private List<String> rooms;
    private Map<String,Computer> computers;
    private Properties info;



    public List<String> getRooms() {
        return rooms;
    }

    public Map<String, Computer> getComputers() {
        return computers;
    }

    public Properties getInfo() {
        return info;
    }

    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public void setComputers(Map<String, Computer> computers) {
        this.computers = computers;
    }

    public void setInfo(Properties info) {
        this.info = info;
    }

    @Override
    public String toString(){
        return "Company{" +
                "rooms=" + rooms +
                ", computers=" + computers +
                ", info=" + info +
                "}";
    }
}
