package iki.qom.dto;

public class MedicineDto {
    private Long id;
    private String name;
    private String strength;
    private int quantityInStock;
    private int unitPrice;

    public MedicineDto(Long id, String name, String strength, int quantityInStock, int unitPrice) {
        this.id = id;
        this.name = name;
        this.strength = strength;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public MedicineDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
}
