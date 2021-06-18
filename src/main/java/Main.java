import entites.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {

    public static void main(String[] args) {


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("banque");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();


        Banque banque = new Banque();
        banque.setNom("BNP Paribas");
        Banque banque1 = new Banque();
        banque1.setNom("Credit Agricole");

        em.persist(banque);
        em.persist(banque1);

        //***** Comptes *****

        Compte compte = new Compte();
        compte.setNumero("23564823458");
        compte.setSolde(1520.50);

        Compte compte1 = new Compte();
        compte.setNumero("265689741525");
        compte.setSolde(5850.50);

        em.persist(compte);
        em.persist(compte1);

        // ***** Operations *****

        Operation operation = new Operation();
        operation.setMontant(200);
        operation.setMotif("assurance habitation");

        Operation operation1 = new Operation();
        operation1.setMontant(550.50);
        operation1.setMotif("achat cb FNAC");

        em.persist(operation);
        em.persist(operation1);

        // ***** Clients *****

        Client client = new Client();
        client.setNom("Laurent");
        client.setPrenom("Lefevre");
        client.getComptes().add(compte1);

        Adresse adresse = new Adresse();
        adresse.setNumero(10);
        adresse.setRue("Avenue du  Lodeve");
        adresse.setCodePostal(34070);
        adresse.setVille("Montpellier");

        client.setAdresse(adresse);

        em.persist(client);

        Client client1 = new Client();
        client1.setNom("Hector");
        client1.setPrenom("Berlioz");
        client1.getComptes().add(compte1);

        Adresse adresse1 = new Adresse();
        adresse1.setNumero(15);
        adresse1.setRue("Allee de Paris");
        adresse1.setCodePostal(84030);
        adresse1.setVille("Avignon");

        client1.setAdresse(adresse1);

        em.persist(client1);

        Client client2 = new Client();
        client2.setNom("Arnaud");
        client2.setPrenom("Moisand");
        client2.getComptes().add(compte);

        Adresse adresse2 = new Adresse();
        adresse2.setNumero(100);
        adresse2.setRue("Bd de la Liberte");
        adresse2.setCodePostal(75080);
        adresse2.setVille("Paris");

        client2.setAdresse(adresse2);

        em.persist(client2);

        // ***** Assurance Vie *****

        AssuranceVie assuranceVie = new AssuranceVie();
        assuranceVie.getClients().add(client2);

        em.persist(assuranceVie);

        // ***** Livret A *****

        LivretA livretA = new LivretA();
        livretA.getClients().add(client1);

        em.persist(livretA);

        transaction.commit();

        System.out.println(client.getAdresse());

        System.out.println(client1.getNom());
        System.out.println(client2.getComptes());


        em.close();





        EntityManager em2 = factory.createEntityManager();

        Banque banque2 = em2.find(Banque.class,1);
        Banque banque3 = em2.find(Banque.class,2);
        List<Banque> banques = new ArrayList<>();
        banques.add(banque2);
        banques.add(banque3);

        for(Banque b : banques) {

            System.out.println(b.getNom());

            for(Client c : b.getClients()) {
                System.out.println(c);

                for(Compte c1 : client.getComptes()) {
                    System.out.println(c1);
                }




            }
        }

        em2.close();


        factory.close();

    }
}










































