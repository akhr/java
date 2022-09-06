package com.akh.restServer.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGameRequest {
    @JsonProperty("competition")
    private String competition;

    @JsonProperty("year")
    private int year;

    @JsonProperty("noOfRounds")
    private String round;

    @JsonProperty("teamA")
    private String team1;

    @JsonProperty("teamB")
    private String team2;

    @JsonProperty("teamAGoals")
    private String team1goals;

    @JsonProperty("teamBGoals")
    private String team2goals;

}
