package com.panderium.cerisaie.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "client")
public class ClientEntity {

    @Id
    @Column(name = "Numcli")
    private int numCli;

    @Column(name = "NomCli")
    private String nomCli;

    @Column(name = "AdrRueCli")
    private String adrRueCli;

    @Column(name = "Cpcli")
    private int cpCli;

    @Column(name = "VilleCli")
    private String villeCli;

    @Column(name = "PieceCli")
    private String pieceCli;

    @Column(name = "NumPieceCli")
    private int numPieceCli;
}
