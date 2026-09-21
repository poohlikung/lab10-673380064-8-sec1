package com.example.lab10.model;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String id;
    private String name;
    private String category;
    private String brand;
    private Integer stock;
    private Double price;
    private String discountType;

    //คำนวณราคาหลังส่วนลด
    public Double getDiscountedPrice() {
        if (price == null) return 0.0;
        return switch (discountType == null ? "NONE" : discountType) {
            case "MEMBER"   -> price * 0.90;  // ลด 10%
            case "SEASONAL" -> price * 0.80;  // ลด 20%
            default         -> price;
        };
    }

    @Override
    public String toString() {
        return "Product{id='" + id + "', name='" + name
                + "', price=" + price + ", discounted=" + getDiscountedPrice() + "}";
    }
}
