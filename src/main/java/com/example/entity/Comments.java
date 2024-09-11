package com.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString(exclude = {"movie"})
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cnum;
    @ManyToOne
    @JoinColumn(name = "mnum")
    private Movie movie;
    private String id;
    private String comments;
}
