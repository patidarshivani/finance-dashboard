package com.finance.dashboard.dto;
import lombok.Getter;
import lombok.AllArgsConstructor;



@Getter
@AllArgsConstructor
public class CategoryWiseDTO {
    private String category;
    private Double total;
}
//public class CategoryWiseDTO {
//
//    private String category;
//    private Double total;
//
//    public CategoryWiseDTO(String category, Double total) {
//        this.category = category;
//        this.total = total;
//    }
//}