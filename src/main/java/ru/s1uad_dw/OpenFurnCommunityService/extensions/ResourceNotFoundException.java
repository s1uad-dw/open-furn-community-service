package ru.s1uad_dw.OpenFurnCommunityService.extensions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
