package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author amine amine
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {
    
    private Object[] zone;
    private int ptr;
    private int taille;

    public Pile(int taille) {
        if (taille < 0) this.taille = TAILLE_PAR_DEFAUT;
        else this.taille = taille;
    
        this.zone = new Object[this.taille]; 
        this.ptr = 0; 
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    @Override
    public void empiler(Object o) throws PilePleineException {
        if (estPleine()) throw new PilePleineException(); 
        this.zone[this.ptr] = o; 
        this.ptr++; 
    }

    @Override
    public Object depiler() throws PileVideException {
        if (estVide()) throw new PileVideException(); 
        this.ptr--; 
        return zone[ptr].toString(); 
    }

    @Override
    public Object sommet() throws PileVideException {
        if(this.estVide()) return null;
        return zone[ptr-1];
    }

    @Override
    public int capacite() {
        if(this.estVide()) return 0;
        return ptr-1;
    }

    @Override
    public int taille() {
        return this.taille;
    }

    @Override
    public boolean estVide() {
        return ptr == 0; 
    }

    @Override
    public boolean estPleine() {
        return ptr == zone.length; 
    }

    @Override
    public boolean equals(Object o) {
        if(this.toString().equals(((Pile)o).toString())) return true;
        return false;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("["); 
        for (int i = ptr - 1; i >= 0; i--) { 
            sb.append(zone[i].toString()); 
            if (i > 0) 
            sb.append(", "); 
        } 
        sb.append("]"); 
        return sb.toString();
    }
}
