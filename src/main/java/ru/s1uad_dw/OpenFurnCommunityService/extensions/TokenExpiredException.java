package ru.s1uad_dw.OpenFurnCommunityService.extensions;

public class TokenExpiredException extends RuntimeException{
    public TokenExpiredException(String message) {
        super(message);
    }
}
