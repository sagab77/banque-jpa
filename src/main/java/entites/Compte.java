package entites;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "solde")
    private double solde;

    @OneToMany
    @JoinColumn(name = "compte")
    private List<Operation> operations = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "id_compte", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"))
    private List<Client> clients = new ArrayList<>();


    public Compte() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", solde=" + solde +
                ", operations=" + operations +
                ", clients=" + clients +
                '}';
    }

    public double virement(Compte compte, Virement virement) {
        if(virement.getMontant() > this.getSolde()) {
            System.out.println("Operation impossible");
        } else {
            return virement.getMontant();
        }
        return 0;
    }
}
