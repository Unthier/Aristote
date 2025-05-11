package be.ifapme.sab.api.dto;

public class CommandeDTO {
    private String name;

    public CommandeDTO(String name){
        this.name =name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
