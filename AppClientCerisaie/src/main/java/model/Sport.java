package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Sport implements Serializable {

    private int codeSport;

    private String libelleSport;

    private String uniteTpsSport;

    private int tarifUnite;
}
