import com.bao.analyzer.ClassFileAnalyzer;
import com.bao.model.ClassFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\SoftwareProject\\Android\\amap_android_gradle\\amap_module_common\\libs\\agoo-taobao-2.1.7.6\\com\\taobao\\agoo\\TaobaoNotificationBaseIntentService.class";
        FileInputStream in = new FileInputStream(filePath);
        byte[] classBytes = new byte[in.available()];
        in.read(classBytes);
        in.close();
        ClassFile classFile = new ClassFile();
        ClassFileAnalyzer analyzer = new ClassFileAnalyzer(classBytes, classFile);
        analyzer.execute();
    }
}
