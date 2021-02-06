package mx.edev.crud.domain;

import lombok.Data;

@Data
public class CustomErrorResponse {
    private final String code;
    private final String description;
    public CustomErrorResponse(String code, String description){
        this.code=code;
        this.description=description;
    }
}