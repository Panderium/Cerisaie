package model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "type_emplacement")
public class TypeEmplacementEntity {

    @Id
    @Column(name = "CodeTypeE")
    private int codeTypeE;

    @Column(name = "LIBTYPEPL")
    private String libTypePL;

    @Column(name = "TARIFTYPEPL")
    private int tarifTypePL;
}
