package Compta.File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

/**
 * Created by Allan on 17/03/2017.
 */
public class StorageImpl implements Storage{

    public WritePropertiesFile writePropertiesFile;

    public ReadPropertiesFile readPropertiesFile;

    private final String suffix = ".xml";

    private String path = "";

    public StorageImpl(){
    }

    public StorageImpl(boolean b){
        readPropertiesFile = new ReadPropertiesFile();
        writePropertiesFile = new WritePropertiesFile();
        path = readPropertiesFile.getPath();
    }

    public void writeOnfile(String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public List<String> readOnFile(String fileName) {
        List<String> compte = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName + suffix));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while ((line = br.readLine()) != null){
                compte.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return compte;
    }

    public Boolean createDirectory(String diskLetter, String directoryName) {
        boolean status = false;
        File theDir = new File(directoryName);
        if(!theDir.exists()){
            System.out.println("dir :" + directoryName +"created");
            theDir.mkdir();
            status = true;
        }
        return status;
    }

    public Boolean createFile(String fileName) {
        boolean status = false;
        String finalPath = path + File.separator + fileName + suffix;
        File f = new File(finalPath);

        f.getParentFile().mkdirs();

        try {
            f.createNewFile();
            status = searchForFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return status;
    }

    public boolean searchForFile(String fileName) {
        boolean success = false;
        List<File> fileList = new ArrayList<File>();
        fileList = getFileList(path);
        for (File file : fileList) {
            if (file.getName().equals(fileName+suffix)) {
                success = true;
            }
        }
        return success;
    }

    public List<File> getFileList (String path) {
        List<File> fileList = new ArrayList<File>();
        File dir = new File(path);
        for (File file : dir.listFiles()) {
            if(file.getName().endsWith(suffix)) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    public List<String> getFileListString (String path) {
        List<String> fileList = new ArrayList<>();
        for (File file : getFileList(path)) {
            fileList.add(file.getName());
        }
        return fileList;
    }

    public void initialiserSolde(String fileName, float solde) {
    }

    public void initialiserSolde(String fileName) {

    }

    @Override
    public void writeOnFile(String fileName, String transactionType, float montant) {
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("erreur writeOnFile(String fileName, String transactionType, float montant)" + e);
        } catch (UnsupportedEncodingException e) {
            System.out.println("erreur writeOnFile(String fileName, String transactionType, float montant)" + e);
        }
    }

    @Override
    public boolean isFirstTime() {
        boolean isFirstTime = true;
        File file = new File("properties");
        if (file.exists()){
            isFirstTime = false;
        }
        return isFirstTime;
    }
}
