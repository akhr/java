package com.akh.restServer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
//    @JsonIgnore
    private long id;

    @JsonProperty("competition")
    @Column(name = "competition")
    private String competition;

    @JsonProperty("year")
    @Column(name = "year")
    private int year;

    @JsonProperty("noOfRounds")
    @Column(name = "round")
    private String round;

    @JsonProperty("teamA")
    @Column(name = "team1")
    private String team1;

    @JsonProperty("teamB")
    @Column(name = "team2")
    private String team2;

    @JsonProperty("teamAGoals")
    @Column(name = "team1goals")
    private String team1goals;

    @JsonProperty("teamBGoals")
    @Column(name = "team2goals")
    private String team2goals;

}
