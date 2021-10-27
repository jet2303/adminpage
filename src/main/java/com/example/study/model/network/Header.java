package com.example.study.model.network;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("unchecked")      //Header<T> to Header<Object> Warning exclude
public class Header<T> {
    //api 통신시간
    //@JsonProperty("transaction_time")   //해당 이름으로 바꿔줌
    private LocalDateTime transactionTime;

    //api 응답코드
    private String resultCode;

    //api 부가정보
    private String description;

    private T data;

    private Pagenation pagenation;

    //OK
    public static<T> Header<T> OK(){
        return (Header<T>)Header.builder()
                            .transactionTime(LocalDateTime.now())
                            .resultCode("OK")
                            .description("OK")
                            .build();
    }

    //DATA OK
    public static<T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                            .transactionTime(LocalDateTime.now())
                            .resultCode("OK")
                            .description("OK")
                            .data(data)
                            .build();
    }
    public static<T> Header<T> OK(T data, Pagenation pagenation){
        return (Header<T>)Header.builder()
                            .transactionTime(LocalDateTime.now())
                            .resultCode("OK")
                            .description("OK")
                            .pagenation(pagenation)
                            .data(data)
                            .build();
    }
    
    //ERROR
    public static<T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder()
                            .transactionTime(LocalDateTime.now())
                            .resultCode("ERROR")
                            .description(description)
                            .build();
    }

}
