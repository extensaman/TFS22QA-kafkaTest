package ru.tinkoff.kafkatesting.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;

@Data
public class Car {
    private String model;
    private String price;
    private String color;
}
