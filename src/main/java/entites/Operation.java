package entites;


import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Operation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "montant")
    private double montant;

    @Column(name = "motif")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;


    public Operation() {
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }


}
