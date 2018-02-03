package Compta.File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WritePropertiesFile {

    public void writePath(String path) {

        Properties properties = new Properties();
        properties.setProperty("path", path);

        File file = new File("properties");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream, "Emplacement de sauvegarde");
            fileOutputStream.close();
            System.out.println("Properties file created succesfully");
        } catch (FileNotFoundException e) {
            System.out.println("Erreur ecriture properties" +e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
