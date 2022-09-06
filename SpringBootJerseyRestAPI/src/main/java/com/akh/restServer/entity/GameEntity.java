package com.akh.restServer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "Game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private long id;

    @Column(name = "competition")
    private String competition;

    @Column(name = "year")
    private int year;

    @Column(name = "round")
    private String round;

    @Column(name = "team1")
    private String team1;

    @Column(name = "team2")
    private String team2;

    @Column(name = "team1goals")
    private int team1goals;

    @Column(name = "team2goals")
    private int team2goals;

}
