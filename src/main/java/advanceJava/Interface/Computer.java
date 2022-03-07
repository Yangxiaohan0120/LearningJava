package advanceJava.Interface;

/**
 * @ author: yxh
 * @ created: 2022-02-27 : 8:45 PM
 */
public class Computer {

    public void work(UsbInterface usbInterface){

        // 通过接口调用方法
        usbInterface.start();
        usbInterface.stop();
    }
}