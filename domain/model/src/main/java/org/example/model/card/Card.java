package org.example.model.card;

public class Card {

    private String id;

    private String name;

    private String url;

    private Long exp;

    private String power;

    private String description;

    private String characteristic;

    public Card(String id, String name, String url, Long exp, String power, String description, String characteristic) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.exp = exp;
        this.power = power;
        this.description = description;
        this.characteristic = characteristic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", exp=" + exp +
                ", power='" + power + '\'' +
                ", description='" + description + '\'' +
                ", characteristic='" + characteristic + '\'' +
                '}';
    }
}

