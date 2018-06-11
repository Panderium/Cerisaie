package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "sejour")
public class SejourEntity {

    @Id
    @Column(name = "NumSej")
    private int numSej;

    @Column(name = "NomCli")
    private String nomCli;

    @Column(name = "NumEmpl")
    private int numEmpl;

    @Column(name = "DatedebSej")
    private Date dateDebSej;

    @Column(name = "DateFinSej")
    private Date dateFinSej;

    @Column(name = "NbPersonnes")
    private int nbPersonnes;
}
