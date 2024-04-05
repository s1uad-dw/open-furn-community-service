package ru.s1uad_dw.OpenFurnCommunityService.extensions;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException(String message) {
        super(message);
    }
}
