package models;

import java.util.ArrayList;
import java.util.List;

public class Service {
        private int id;
        private String libelle;
        private List<Employe> employes;
    
        public Service(int id, String libelle, List<Employe> employes) {
            this.id = id;
            this.libelle = libelle;
            this.employes = employes;
        }

        public Service(int id, String libelle) {
            this.id = id;
            this.libelle = libelle;
            this.employes = new ArrayList<>();
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLibelle() {
            return libelle;
        }

        public void setLibelle(String libelle) {
            this.libelle = libelle;
        }

        public List<Employe> getEmployes() {
            return employes;
        }

        public void setEmployes(List<Employe> employes) {
            this.employes = employes;
        }

        public void ajouterEmploye(Employe employe) {
        }
    
        
    }



    //     private List<Service> services = new ArrayList<>();

//     public ServiceService() {
//     }

//     public boolean ajouterService(Service service) {
//         return false;
//     }

//     public Service[] listeServices() {
//         return null;
//     }

//     public int generateId() {
//         return 0;
//     }

//     public List<Service> getServices() {
//     return services;
// }

//     public Service getServiceById(int serviceId) {
//         return null;
//     }

//     public Object getServiceByLibelle(String libelle) {
//         return null;
//     }
