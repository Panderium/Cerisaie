package com.panderium.cerisaie.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "sport")
public class SportEntity implements Serializable {

    @Id
    @Column(name = "CodeSport")
    private int codeSport;

    @Column(name = "LibelleSport")
    private String libelleSport;

    @Column(name = "UniteTpsSport")
    private String uniteTpsSport;

    @Column(name = "TarifUnite")
    private int tarifUnite;
}
