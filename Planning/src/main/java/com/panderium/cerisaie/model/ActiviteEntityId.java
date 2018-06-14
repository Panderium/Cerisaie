package com.panderium.cerisaie.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class ActiviteEntityId implements Serializable {

    @Id
    @Column(name = "CodeSport")
    private int codeSport;

    @Id
    @Column(name = "DateJour")
    private Date dateJour;

    @Id
    @Column(name = "NumSej")
    private int numSej;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiviteEntityId that = (ActiviteEntityId) o;
        return codeSport == that.codeSport &&
                numSej == that.numSej &&
                Objects.equals(dateJour, that.dateJour);
    }

    @Override
    public int hashCode() {

        return Objects.hash(codeSport, dateJour, numSej);
    }
}
