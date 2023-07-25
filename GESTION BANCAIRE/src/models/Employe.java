package models;

public class Employe {
        private int id;
        private String nom;
        private boolean retraite;
        private String poste;
        private Service service;
    
        public Employe(int id, String nom, boolean retraite, String poste, Service service) {
            this.id = id;
            this.nom = nom;
            this.retraite = retraite;
            this.poste = poste;
            this.service = service;
        }

        public Employe(int id, String nom, boolean retraite, String poste) {
            this.id = id;
            this.nom = nom;
            this.retraite = retraite;
            this.poste = poste;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public boolean isRetraite() {
            return retraite;
        }

        public void setRetraite(boolean retraite) {
            this.retraite = retraite;
        }

        public String getPoste() {
            return poste;
        }

        public void setPoste(String poste) {
            this.poste = poste;
        }

        public Service getService() {
            return service;
        }

        public void setService(Service service) {
            this.service = service;
        }
    
    
    }
    

