package entites;


import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class Virement extends Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "beneficiare")
    private String beneficiare;

    public Virement() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBeneficiare() {
        return beneficiare;
    }

    public void setBeneficiare(String beneficiare) {
        this.beneficiare = beneficiare;
    }



}
