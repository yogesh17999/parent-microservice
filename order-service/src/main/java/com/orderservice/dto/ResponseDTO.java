package com.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private int status;
    private String message;
    private Object data;

    public ResponseDTO(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
