package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Emplacement implements Serializable {

    private int numEmpl;

    private int codeTypeE;

    private int surfaceEmpl;

    private int nbPersMaxEmpl;

}
