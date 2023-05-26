package com.example.microservicio_materias.models;

import java.util.List;
import java.util.UUID;
import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Persona implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "names")
    private String names;

    @Column(name = "lastnames")
    private String lastnames;

    @Column(name = "institutional_mail")
    private String institutionalMail;

    @Column(name = "code")
    private String code;

    @Column(name = "num_document")
    private String numDocument;

    public Persona() {

    }

    public Persona(UUID id, String names, String lastnames, String institutionalMail, String code, String numDocument) {
        this.id = id;
        this.names = names;
        this.lastnames = lastnames;
        this.institutionalMail = institutionalMail;
        this.code = code;
        this.numDocument = numDocument;

    }

}
