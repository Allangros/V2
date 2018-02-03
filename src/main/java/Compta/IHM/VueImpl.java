package Compta.IHM;

import Compta.Class.Compte;
import Compta.File.ReadPropertiesFile;
import Compta.File.StorageImpl;
import Compta.File.WritePropertiesFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Allan on 17/03/2017.
 */
public class VueImpl implements Vue{

    ReadPropertiesFile readPropertiesFile = new ReadPropertiesFile();

    private final String suffix = ".xml";

    StorageImpl storage = new StorageImpl();

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    Compte compte = new Compte();

    Map<Integer, String> mappingCompte = new HashMap<>();

    public String compteExistantQuestion() {
        System.out.print("Avez-vous déjà un compte ? (repondre par y/n)");
        String reponse = "";
        try {
            reponse = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return reponse;
    }

//    public void demanderCreationDeCompte() {
////        System.out.print("Voulez-vous créer un compte ? y/n");
////        String reponse = "";
////
////        try {
////            reponse = bufferedReader.readLine();
////            if (reponse.equals("y")){
////                demanderNomCompte();
////            } else {
////                quitterProgramme();
////            }
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////
////    }

//    public void demanderNumeroDuCompte() {
//        //appelle de la méthode de mapping des comptes
//        mappingCompte=creationMappingCompte();
//        if (mappingCompte.size()==0) {
//            System.out.println("Il n'y a aucun compte enregistré sur la machine, merci d'en créer un dès à présent.");
//            demanderCreationDeCompte();
//        } else {
//
//            System.out.println("Quel est le numero du compte ? ");
//            for (int i = 0; i <= mappingCompte.size()-1; i++) {
//                System.out.println(i + " : " + mappingCompte.get(i));
//            }
//            String reponse;
//            try {
//                reponse = bufferedReader.readLine();
//                int compte = Integer.parseInt(reponse);
//                System.out.println("Ouverture du compte " + reponse + " : " + mappingCompte.get(compte));
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    public Map<Integer, String> creationMappingCompte() {
//        List<String> listCompte=storage.getFileListString(path);
//        for (int i=0; i<=listCompte.size()-1;i++) {
//            mappingCompte.put(i,listCompte.get(i));
//        }
//        return mappingCompte;
//    }

    @Override
    public void demanderLecteur() {
        String path = "";
        String lecteur = "";
        System.out.println("Merci d'entrer la lettre du lecteur ou se situera la sauvegarde : ");
        try {
            lecteur = bufferedReader.readLine();
            path = lecteur +":"+ File.separator +demanderNomRep() + File.separator;

        } catch (IOException e) {
            e.printStackTrace();
        }
        WritePropertiesFile writePropertiesFile = new WritePropertiesFile();
        writePropertiesFile.writePath(path);
    }

    @Override
    public String demanderNomRep() {
        String rep = "";
        System.out.println("Merci d'entrer le nom du repertoire de sauvegarde: ");
        try {
            rep = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rep;
    }

    public void quitterProgramme() {
        try {
            System.out.print("Appuyer sur entrer pour quitter le programme");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void demanderNomCompte() {
//        String reponse = "";
//        System.out.println("Merci de donner un nom a votre compte (de 8 à 12 caracteres alphanumériques :");
//        try {
//            reponse = bufferedReader.readLine();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (compte.isNameCorrect(reponse)){
//            if(!storage.searchForFile(reponse)){
//                succesNomCompte(reponse);
//            } else {
//                compteExistant();
//            }
//        }
//    }

//    public void compteExistant() {
//        String reponse = "";
//        System.out.println("Un compte possède déjà ce nom, merci d'en choisir un nouveau :");
//        try {
//            reponse = bufferedReader.readLine();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (compte.isNameCorrect(reponse)){
//            if (storage.searchForFile(reponse)){
//                compteExistant();
//            } else {
//                succesNomCompte(reponse);
//            }
//        }
//    }

//    private void succesNomCompte(String fileName) {
//        boolean status = false;
//        status = storage.createFile(fileName);
//        statusCreationCompte(status, fileName);
//    }

//    private void statusCreationCompte(boolean status, String fileName) {
//        if (status) {
//            System.out.println("Votre compte a été créer avec succès");
//            System.out.println("Le fichier est enregistré dans :" + path + fileName + suffix);
//            demanderSoldeInitial(fileName);
//        } else {
//            System.out.println("Une erreur est survenue lors de la creation de votre compte, merci de relancer l'application");
//        }
//    }

    private void demanderSoldeInitial(String fileName) {
        String reponse = "";
        System.out.println("Voulez-vous initialiser le compte avec un solde initial? Par défaut le compte sera créer avec un solde nul. y/n");
        try {
            reponse = bufferedReader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }
        if (reponse.equalsIgnoreCase("y")){
            System.out.println("Quel est le montant du solde ? (en Euro)");
            try {
                reponse = bufferedReader.readLine();
                float solde = Float.parseFloat(reponse);
                storage.initialiserSolde(fileName, solde);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            storage.initialiserSolde(fileName);
        }
    }
}
