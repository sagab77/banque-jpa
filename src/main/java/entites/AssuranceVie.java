package entites;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class AssuranceVie extends Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "taux")
    private double taux;


    /**
     * Constructeur vide
     */

    public AssuranceVie() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }



    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

}
