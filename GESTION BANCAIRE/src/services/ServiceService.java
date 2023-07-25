package services;

import java.util.ArrayList;
import java.util.List;

import models.Service;

public class ServiceService {

    private List<Service> services = new ArrayList<>();

    public ServiceService() {
    }

    public boolean ajouterService(Service service) {
        return false;
    }

    public Service[] listeServices() {
        return null;
    }

    public int generateId() {
        return 0;
    }

    public List<Service> getServices() {
    return services;
}

    public Service getServiceById(int serviceId) {
        return null;
    }

    public Object getServiceByLibelle(String libelle) {
        return null;
    }

    
}
