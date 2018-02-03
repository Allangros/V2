package Compta.Class;

/**
 * Created by Allan on 17/03/2017.
 */
public class Compte {

    private Long solde;
    private String nom;
    private String banque;

    public Compte(){}

    public Compte(Long solde, String nom, String banque) {
        this.solde = solde;
        this.nom = nom;
        this.banque = banque;
    }

    public boolean isNameCorrect(String name) {
        boolean isCorrect = false;
        if (name.matches("^[a-zA-Z0-9]*$")) {
            if (name.length()>=8 && name.length()<=12) {
                isCorrect = true;
            }
        }
        return isCorrect;
    }
}
