package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "emplacement")
public class EmplacementEntity {

    @Id
    @Column(name = "NumEmpl")
    private int numEmpl;

    @Column(name = "CodeTypeE")
    private int codeTypeE;

    @Column(name = "SurfaceEmpl")
    private int surfaceEmpl;

    @Column(name = "NbPersMaxEmpl")
    private int nbPersMaxEmpl;

}
