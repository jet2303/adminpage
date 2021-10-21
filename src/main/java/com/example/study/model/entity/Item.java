package com.example.study.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private  String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registerdAt;

    private LocalDateTime unregisterdAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;




//    //1:N
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "item")
//    private List<OrderDetail> orderDetailList;
}
