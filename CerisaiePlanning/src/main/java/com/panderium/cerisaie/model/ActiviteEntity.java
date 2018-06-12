package com.panderium.cerisaie.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
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
}
