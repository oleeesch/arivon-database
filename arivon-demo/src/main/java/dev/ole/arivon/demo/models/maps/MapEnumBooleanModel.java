package dev.ole.arivon.demo.models.maps;

import dev.ole.arivon.PrimaryKey;
import dev.ole.arivon.demo.models.objects.EnumObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Accessors(fluent = true)
@AllArgsConstructor
public final class MapEnumBooleanModel {

    @PrimaryKey
    private final UUID uuid;
    private final Map<EnumObject, Boolean> propertyPlayer = new HashMap<>();

}