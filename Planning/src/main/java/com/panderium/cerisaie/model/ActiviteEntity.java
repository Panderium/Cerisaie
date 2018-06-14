package com.panderium.cerisaie.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@IdClass(ActiviteEntityId.class)
@Table(name = "activite")
public class ActiviteEntity {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiviteEntity that = (ActiviteEntity) o;
        return codeSport == that.codeSport &&
                numSej == that.numSej &&
                nbLoc == that.nbLoc &&
                Objects.equals(dateJour, that.dateJour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codeSport, dateJour, numSej, nbLoc);
    }
}
