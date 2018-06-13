package model;

import lombok.Data;

import java.io.Serializable;


@Data

public class Client implements Serializable {

    private int numCli;

    private String nomCli;

    private String adrRueCli;

    private int cpCli;

    private String villeCli;

    private String pieceCli;

    private int numPieceCli;
}
