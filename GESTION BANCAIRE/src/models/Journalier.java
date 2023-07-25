package models;

public class Journalier extends Employe {
        public Journalier(int id, String nom, boolean retraite, String poste, Service service) {
        super(id, nom, retraite, poste, service);
    }

        public Journalier(int id, String nom, boolean retraite, String poste) {
        super(id, nom, retraite, poste);
    }

        public Journalier(int id, String nom, boolean retraite) {
            super(id, nom, retraite, "Journalier");
        }
    
}
