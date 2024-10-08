package dev.ole.arivon.demo.models;

import dev.ole.arivon.PrimaryKey;
import dev.ole.arivon.demo.models.objects.EnumObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.UUID;

@Accessors(fluent = true)
@Getter
@AllArgsConstructor
@ToString
public final class SimpleModel {

    @PrimaryKey
    private char name;
    private int age;
    private long money;
    private UUID specialId;
    private boolean dead;
    private String address;
    private EnumObject enumObject;

}