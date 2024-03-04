package br.com.engineerchallengeapi.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBodyStatus {

    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm:ss a")
    private LocalDateTime timestamp;
    private Integer status;
    private String message;
    private String description;
}
