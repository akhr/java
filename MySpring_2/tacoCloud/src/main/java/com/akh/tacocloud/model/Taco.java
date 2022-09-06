package com.akh.tacocloud.model;

/**
 * @author Akhash Ramamurthy
 * @date 04-22-2022
 */
import java.util.List;
import lombok.Data;

@Data
public class Taco {

    private String name;

    private List<Ingredient> ingredients;

}
