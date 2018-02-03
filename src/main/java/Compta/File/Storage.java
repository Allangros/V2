package Compta.File;

import java.io.File;
import java.util.List;

/**
 * Created by Allan on 17/03/2017.
 */
public interface Storage {

    public void writeOnfile(String fileName);

    public List<String> readOnFile(String fileName);

    public Boolean createFile(String fileName);

    public boolean searchForFile(String fileName);

    public List<File> getFileList (String path);

    public List<String> getFileListString (String path);

    public void initialiserSolde(String fileName, float solde);

    public void initialiserSolde(String fileName);

    public void writeOnFile(String filename, String transactionType, float montant);

    public boolean isFirstTime();
}
