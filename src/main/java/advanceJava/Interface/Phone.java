package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 8:44 PM
 */

// phone 需要实现 USBInterface所规定的方法
public class Phone implements UsbInterface{

    @Override
    public void start(){
        System.out.println("Phone starts working ... ");
    }

    @Override
    public void stop(){
        System.out.println("Phone stops");
    }

}