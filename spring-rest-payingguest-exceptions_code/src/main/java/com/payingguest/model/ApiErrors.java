package com.payingguest.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiErrors {
    LocalDateTime timeStamp;
    HttpStatus status;      //http status enum
    int statusCode ;
    String error;           //error message
    List<String > message;


}
