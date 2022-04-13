package advanceJava.IO.File;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Chris Yang
 * created 2022-04-13 18:59
 **/
public class FileCreate {
    public static void main(String[] args) {
        new FileCreate().create01();
        new FileCreate().create02();
        new FileCreate().create03();
    }

    // 文件创建的方式
    @Test
    public void create01(){
        String path = "./newFile01.txt";
        File file = new File(path);
        System.out.println(file.getAbsolutePath());

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void create02(){
        File path = new File("./");
        String filename = "newFile02.txt";

        File file = new File(path,filename);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void create03(){
        String path = "./";
        String filename = "newFile03.txt";

        File file = new File(path,filename);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // File的属性
    public void getProperties(){
        File file = new File("./newFile01.txt");
        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("是不是一个文件=" + file.isFile());//T
        System.out.println("是不是一个目录=" + file.isDirectory());//F

    }


}
