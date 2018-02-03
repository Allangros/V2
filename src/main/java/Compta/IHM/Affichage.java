package Compta.IHM;

/**
 * Created by Allan on 17/03/2017.
 */
public class Affichage {


    public static void main(String [] args) {

        VueImpl vue = new VueImpl();
        String reponse = vue.compteExistantQuestion();

        switch (reponse) {
            case "y":   vue.demanderNumeroDuCompte();
                        break;

            case "n":   vue.demanderCreationDeCompte();
                        break;

            default:    vue.quitterProgramme();
                        break;
        }

    }
}
