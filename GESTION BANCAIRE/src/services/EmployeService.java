package services;

import java.util.ArrayList;
import java.util.List;

import models.Employe;
import models.Journalier;

public class EmployeService {
    private List<Employe> employes;
    private List<Journalier> journaliers;

    public EmployeService() {
        this.employes = new ArrayList<>();
        this.journaliers = new ArrayList<>();
    }

    public void ajouterEmploye(Employe employe) {
        employes.add(employe);
        if (employe instanceof Journalier) {
            journaliers.add((Journalier) employe);
        }
    }

    public List<Employe> getEmployes() {
        return employes;
    }

    public List<Journalier> getJournaliers() {
        return journaliers;
    }

    public int generateId() {
        if (employes.size() == 0) {
            return 1;
        }
        return employes.get(employes.size() - 1).getId() + 1;
    }
}






    // private Service[] services;
    // private Employe[] employes;


    // public EmployeService(Service[] services, Employe[] employes) {
    //     this.services = services;
    //     this.employes = employes;
    // }

    // public EmployeService(int nbServices, int nbEmployes) {
    //     services = new Service[nbServices];
    //     employes = new Employe[nbEmployes];
    // }

    // public void ajouterService(Service service) {
    //     if (chercherService(service.getId()) == null) {
    //         for (int i = 0; i < services.length; i++) {
    //             if (services[i] == null) {
    //                 services[i] = service;
    //                 break;
    //             }
    //         }
    //     }
    // }

    // public List<Service> listerServices() {
    //     List<Service> listeServices = new ArrayList<>();
    //     for (Service service : services) {
    //         if (service != null) {
    //             listeServices.add(service);
    //         }
    //     }
    //     return listeServices;
    // }

    // public void ajouterEmploye(Employe employe) {
    //     if (chercherEmploye(employe.getId()) == null) {
    //         for (int i = 0; i < employes.length; i++) {
    //             if (employes[i] == null) {
    //                 employes[i] = employe;
    //                 break;
    //             }
    //         }
    //     }
    // }

    // public List<Employe> listerJournaliers() {
    //     List<Employe> listeJournaliers = new ArrayList<>();
    //     for (Employe employe : employes) {
    //         if (employe != null && employe.getPoste().equals("Journalier")) {
    //             listeJournaliers.add(employe);
    //         }
    //     }
    //     return listeJournaliers;
    // }

    // public Service chercherService(int id) {
    //     for (Service service : services) {
    //         if (service != null && service.getId() == id) {
    //             return service;
    //         }
    //     }
    //     return null;
    // }

    // public Employe chercherEmploye(int id) {
    //     for (Employe employe : employes) {
    //         if (employe != null && employe.getId() == id) {
    //             return employe;
    //         }
    //     }
    //     return null;
    // }

    // public void affecterEmployeService(int employeId, int serviceId) {
    //     Employe employe = chercherEmploye(employeId);
    //     Service service = chercherService(serviceId);

    //     if (employe != null && service != null) {
    //         employe.setService(service);
    //         service.ajouterEmploye(employe);
    //     }
    // }