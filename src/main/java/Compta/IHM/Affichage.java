package Compta.IHM;

import Compta.File.ReadPropertiesFile;
import Compta.File.StorageImpl;

/**
 * Created by Allan on 17/03/2017.
 */
public class Affichage {


    public static void main(String [] args) {

        VueImpl vue = new VueImpl();
        StorageImpl storage = new StorageImpl();
        ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();

        if(storage.isFirstTime()) {
            vue.demanderLecteur();
        } else {
            String path = readPropertiesFile.getPath();
            System.out.println("path :" + path);
        }

        //Recupérer les différents comptes ici via un ReadPropertiesFile
        //Et faire selon qu'il y ai déjà des comptes ou pas ou si on veut en creer un autre.

//        switch (reponse) {
//            case "y":   vue.demanderNumeroDuCompte();
//                        break;
//
//            case "n":   vue.demanderCreationDeCompte();
//                        break;
//
//            default:    vue.quitterProgramme();
//                        break;
//        }

    }
}
