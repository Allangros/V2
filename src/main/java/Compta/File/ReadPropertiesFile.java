package Compta.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

    public String getPath() {
        String path = "";
        Properties properties = new Properties();
        File file = new File("properties");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            path = properties.getProperty("path");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
