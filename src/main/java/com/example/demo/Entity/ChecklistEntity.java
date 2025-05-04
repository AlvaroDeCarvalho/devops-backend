package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;
@Table(name = "Checklist")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChecklistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String message;
    private Date atCreate;
    private Date atUpdate;
    private Date atDelete;

}
