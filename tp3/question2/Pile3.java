package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author amine amine
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {
     
    private Vector<Object> v;
    
    private int taille;
    private int capacite;
    
    public Pile3() {
        this.taille = TAILLE_PAR_DEFAUT;
        this.v = new Vector(this.taille); 
    }
    
    public Pile3(int taille) {
        if (taille < 0) this.taille = TAILLE_PAR_DEFAUT;
        else this.taille = taille;
      
        this.v = new Vector(this.taille); 
    }
    
    public void empiler(Object o) throws PilePleineException {
        if (estPleine()) throw new PilePleineException(); 
        v.add(o);
    }
    
    public Object depiler() throws PileVideException {
        if (estVide()) throw new PileVideException();
        return v.removeElement(v.lastElement()); 
    }
    
    public Object sommet() throws PileVideException {
        return this.v.firstElement();
    }
    
    public int taille() {
        return this.v.size();
    }
    
    public int capacite() {
        return this.v.capacity();
    }

    public boolean estVide() {
       return this.v.isEmpty();
    }

    public boolean estPleine() {
        return this.v.size() == this.v.capacity(); 
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("["); 
        int count = 0;
        for(Object tmp : this.v) { 
            if (count > 0) sb.append(", ");
            sb.append(tmp.toString()); 
        } 
        sb.append("]"); 
        return sb.toString();
    }

    public boolean equals(Object o) {
        if(this.toString().equals(((Pile3)o).toString())) return true;
        return false;
    }
    
    public int hashCode() {
        return toString().hashCode();
    }

}
