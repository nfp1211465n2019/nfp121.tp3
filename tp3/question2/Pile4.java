    package question2;
    
    import question1.PilePleineException;
    import question1.PileVideException;
    
    import java.util.Stack;
    
    public class Pile4 implements PileI, Cloneable {
        
        private Maillon stk;
    
        private int capacite;
        private int nombre;
    
        /**
         * Classe interne "statique" contenant chaque élément de la chaine c'est une
         * proposition, vous pouvez l'ignorer !
         */
        private static class Maillon implements Cloneable {
            private Object element;
            private Maillon suivant;
    
            public Maillon(Object element, Maillon suivant) {
                this.element = element;
                this.suivant = suivant;
            }
    
            public Maillon suivant() {
                return this.suivant;
            }
            
            public void setSuivant(Maillon m) {
                this.suivant = m;
            }
    
            public Object element() {
                return this.element;
            }
            
            public String toString() {
                return this.element.toString() + ", " + this.suivant.toString();
            }
    
            public Object clone() throws CloneNotSupportedException {
                Maillon m = (Maillon) super.clone();
                m.element = element;
                return m;
            }
        }
    
        public Pile4(int taille) {
            if (taille <= 0) taille = CAPACITE_PAR_DEFAUT;
            this.stk = null;
            this.capacite = taille;
        }
    
        public Pile4() {
            this(PileI.CAPACITE_PAR_DEFAUT);
        }
    
        public void empiler(Object o) throws PilePleineException {
            if (estPleine()) throw new PilePleineException();
            Maillon tmp = stk;
            while(tmp.suivant() != null) {
                tmp = tmp.suivant();
            }
            tmp.setSuivant(new Maillon(o, null));
            this.nombre++;
        }
    
        public Object depiler() throws PileVideException {
            if (estVide()) throw new PileVideException();
            Maillon tmp = stk;
            Maillon res = null;
            if(tmp.suivant() == null) {
                res = stk;
                stk = null;
            } else {
                while(tmp.suivant().suivant() != null) {
                    tmp = tmp.suivant();
                    res = tmp.suivant();
                }
                tmp.setSuivant(null);
            }
            this.nombre--;
            return res;
        }
    
        public Object sommet() throws PileVideException {
            if (estVide()) throw new PileVideException();
            return this.stk;
        }
    
        public boolean estVide() {
            return this.stk == null;
        }
    
        public boolean estPleine() {
            return this.capacite == this.nombre;
        }
    
        public String toString() {
            String s = "[" + stk.toString() + "]";
            return s;
        }
    
        public boolean equals(Object o) {
            if (o instanceof Pile4) {
                return this.stk.toString().equals(((Pile4) o ).toString());
            }
            return false;
        }
    
        public int capacite() {
            return this.capacite;
        }
    
        public int hashCode() {
            return toString().hashCode();
        }
    
        public int taille() {
            return nombre;
        }
}
