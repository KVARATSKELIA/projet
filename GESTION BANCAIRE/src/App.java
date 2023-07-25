import java.util.List;
import java.util.Scanner;
import services.EmployeService;
import services.ServiceService;
import models.Employe;
import models.Journalier;
import models.Service;

public class App {
    
    private ServiceService serviceService;
    private EmployeService employeService;

    public App() {
        serviceService = new ServiceService();
        employeService = new EmployeService();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        cls();

        do {
            System.out.println("\t   Bienvenue dans le système de gestion des employés et des services");
                    System.out.println("\t\t\t\tQue voulez-vous faire ?");
                    System.out.println("\t+------------------------------------------------------------------+");
                    System.out.println("\t|                             MENU                                 |");
                    System.out.println("\t+------------------------------------------------------------------+");
                    System.out.println("\t| 1. Ajouter un service                                            |");
                    System.out.println("\t| 2. Lister les services                                           |");
                    System.out.println("\t| 3. Ajouter un employé                                            |");
                    System.out.println("\t| 4. Lister les journaliers                                        |");
                    System.out.println("\t| 5. Quitter                                                       |");
                    System.out.println("\t+------------------------------------------------------------------+");
                    System.out.print("\tEntrez votre choix : ");
            choix = scanner.nextInt();
            cls();
            switch (choix) {
                case 1:
                    ajouterService(scanner);
                    break;
                case 2:
                    if (serviceService.getServices().isEmpty()) {
                    System.out.println("Il n'y a aucun service enregistré !");
                    } else {
                    listerServices();
                }
                    
                    break;
                case 3:
                    ajouterEmploye(scanner);
                    break;
                case 4:
                    listerJournal();
                    case 5:
                    System.out.println("Merci d'avoir utilisé le système de gestion de Transactions.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
                    attendre(2);                    
                break;
            }
            attendre(2);
            cls();
        } while (choix != 5);

        scanner.close();
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void ajouterService(Scanner scanner) {
            System.out.print("Entrez l'ID : ");
            int id = scanner.nextInt();
            System.out.print("Entrez le libellé du service : ");
            String libelle = scanner.next();
        
            if (libelle.trim().isEmpty()) {
                System.out.println("Le libellé ne peut pas être vide !");
                return;
            }
        
            if (serviceService.getServiceByLibelle(libelle) != null) {
                System.out.println("Le service " + libelle + " existe déjà !");
                return;
            }
        
            Service service = new Service(serviceService.generateId(), libelle);
            serviceService.ajouterService(service);
        
            System.out.println("Le service " + libelle + " a été ajouté avec succès !");

            attendre(3);
            cls();
        }
        
    

        private void listerServices() {
            
                for (Service service : serviceService.getServices()) {
                    System.out.println(service.getLibelle());
                }
            }
        
        

        private void ajouterEmploye(Scanner scanner) {
            System.out.print("Entrez le nom complet de l'employé : ");
            String nom = scanner.next();
            
            // Vérification du format du nom (au moins 2 caractères)
            if (nom.length() < 2) {
                System.out.println("Nom invalide !");
                return;
            }
            
            System.out.print("L'employé est-il retraité ? (true/false) ? ");
            boolean retraite;
            
            // Vérification de la saisie pour le statut de retraité
            try {
                retraite = sc.nextBoolean();
            } catch (Exception e) {
                System.out.println("Statut invalide !");
                return;
            }
            
            System.out.print("Entrez le poste de l'employé (Journalier/Embauche) : ");
            String poste = sc.next();
            
            // Vérification de la saisie pour le poste de l'employé
            if (!poste.equalsIgnoreCase("Journalier") && !poste.equalsIgnoreCase("Embauche")) {
                System.out.println("Poste invalide !");
                return;
            }
            
            Employe employe;
            if (poste.equalsIgnoreCase("Journalier")) {
                employe = new Journalier(employeService.generateId(), nom, retraite);
            } else {
                System.out.print("Entrez l'identifiant du service de l'employé (ou 0 si aucun) : ");
                int serviceId;
                
                // Vérification de la saisie pour l'identifiant du service (entier positif ou 0)
                try {
                    serviceId = scanner.nextInt();
                    if (serviceId < 0) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    System.out.println("Identifiant de service invalide !");
                    return;
                }
                
                Service service = null;
                
                // Si un identifiant de service a été saisi, on recherche le service correspondant
                if (serviceId != 0) {
                    service = serviceService.getServiceById(serviceId);
                    if (service == null) {
                        System.out.println("Service introuvable !");
                        return;
                    }
                }
                
                String metier;
                scanner.nextLine(); // consommer le saut de ligne restant dans le scanner
                
                do {
                    System.out.print("Entrez le métier de l'employé (au moins 2 caractères) : ");
                    metier = scanner.nextLine();
                } while (metier.length() < 2);
                
                employe = new Employe(employeService.generateId(), nom, retraite, metier);
                
                if (service != null) {
                    // On associe l'employé au service
                    service.ajouterEmploye(employe);
                    employe.setService(service);
                }
            }
            
            employeService.ajouterEmploye(employe);
        }
        

        private void listerJournal() {
            List<Journalier> journaliers = employeService.getJournaliers();
            if (journaliers.isEmpty()) {
                System.out.println("Aucun employé journalier enregistré.");
            } else {

                System.out.println("+---------------------------------------------+");
                System.out.println("| LISTE DES EMPLOYES                          |");
                System.out.println("+---------------------------------------------+");
                System.out.println("|  Nom                                        |");
                System.out.println("+---------------------------------------------+");


                // System.out.println("Liste des employés journaliers :");
                for (Employe employe : journaliers) {
                    System.out.println(employe.getNom());
                }
            }
        }

        public static void cls() {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (Exception e) {
                System.out.println(e);
            }
    
            
        }

        public static void attendre(int secondes) {
            try {
                Thread.sleep(secondes * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
}
