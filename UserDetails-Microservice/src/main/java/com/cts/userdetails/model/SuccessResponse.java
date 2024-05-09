package com.cts.userdetails.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Setter
@Getter
@NoArgsConstructor
public class SuccessResponse {
    private String message;
    private Date timestamp;
}
