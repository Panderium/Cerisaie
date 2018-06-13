package model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Sejour implements Serializable {

    private int numSej;

    private int numCli;

    private int numEmpl;

    private Date dateDebSej;

    private Date dateFinSej;

    private int nbPersonnes;
}
