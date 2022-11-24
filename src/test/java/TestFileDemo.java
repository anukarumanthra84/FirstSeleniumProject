import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestFileDemo {
    public static void main(String[] args) throws IOException {
        Properties p=new Properties();
        File f=new File("selenium.properties");
        FileInputStream f1=new FileInputStream(f);
        p.load(f1);
        System.out.println(p.get("driver.path"));
    }
}
