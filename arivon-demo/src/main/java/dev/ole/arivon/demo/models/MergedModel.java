package dev.ole.arivon.demo.models;

import dev.ole.arivon.PrimaryKey;
import dev.ole.arivon.demo.models.objects.TestObject1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
@ToString
public final class MergedModel {

    @PrimaryKey
    private char name;
    private int age;
    private long money;
    private TestObject1 object3;

}