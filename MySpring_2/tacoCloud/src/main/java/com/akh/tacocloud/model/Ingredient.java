package com.akh.tacocloud.model;

/**
 * @author Akhash Ramamurthy
 * @date 04-22-2022
 */
import lombok.Data;

@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}