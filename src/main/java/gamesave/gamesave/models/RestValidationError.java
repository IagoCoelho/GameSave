package gamesave.gamesave.models;

public record RestValidationError (
    Integer code,
    String field,
    String mesage
){}
