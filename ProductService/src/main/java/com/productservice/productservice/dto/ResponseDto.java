package com.productservice.productservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto {

  private String message;
  private Integer status;
  private Object Data;

  public ResponseDto(String message, Integer status) {
    this.message = message;
    this.status = status;
  }
}
