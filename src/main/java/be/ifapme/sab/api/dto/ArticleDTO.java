package be.ifapme.sab.api.dto;

public class ArticleDTO {

    private String name;
    private String description;
    private Double price;
    private Integer number;

    public ArticleDTO(String name, String description, Double price, Integer number) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
}
