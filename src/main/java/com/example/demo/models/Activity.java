package com.example.demo.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "activity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activity {

    @Id
    private Long id;

    private String name;
}
