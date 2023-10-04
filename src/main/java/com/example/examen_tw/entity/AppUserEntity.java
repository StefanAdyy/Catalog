package com.example.examen_tw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "app_user", schema = "public", catalog = "examen_tw")
public class AppUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private long userId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "q1")
    private String q1;
    @Basic
    @Column(name = "q2")
    private String q2;
    @Basic
    @Column(name = "q3")
    private String q3;
    @Basic
    @Column(name = "q4")
    private String q4;
}
