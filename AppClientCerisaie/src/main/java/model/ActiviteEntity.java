package model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "activite")
public class ActiviteEntity implements Serializable {

    @Id
    @Column(name = "CodeSport")
    private int codeSport;

    @Id
    @Column(name = "DateJour")
    private Date dateJour;

    @Id
    @Column(name = "NumSej")
    private int numSej;

    @Column(name = "NbLoc")
    private short nbLoc;
}
