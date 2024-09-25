package dev.ole.arivon.demo.models;

import dev.ole.arivon.PrimaryKey;

import java.util.UUID;

public record RecordModel(@PrimaryKey UUID id, long coins, int age) {
}