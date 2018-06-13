package model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Activite implements Serializable {

    private int codeSport;

    private Date dateJour;

    private int numSej;

    private short nbLoc;
}
