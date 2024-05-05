package org.example;

import java.util.Objects;

public class Car {
    private String link;
    private String city;
    private String brand;
    private String model;
    private String releaseYear;
    private String category;


    private String color;
    private String engine;
    private String mileage;
    private String transmission;
    private String gear;
    private String new_;
    private String seatCount;
    private String owners;
    private String condition;
    private String market;


    private String price;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getNew_() {
        return new_;
    }

    public void setNew_(String new_) {
        this.new_ = new_;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "link='" + link + '\'' +
                ", city='" + city + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", category='" + category + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", mileage='" + mileage + '\'' +
                ", transmission='" + transmission + '\'' +
                ", gear='" + gear + '\'' +
                ", new_='" + new_ + '\'' +
                ", seatCount='" + seatCount + '\'' +
                ", owners='" + owners + '\'' +
                ", condition='" + condition + '\'' +
                ", market='" + market + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(link, car.link) && Objects.equals(city, car.city) && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(releaseYear, car.releaseYear) && Objects.equals(category, car.category) && Objects.equals(color, car.color) && Objects.equals(engine, car.engine) && Objects.equals(mileage, car.mileage) && Objects.equals(transmission, car.transmission) && Objects.equals(gear, car.gear) && Objects.equals(new_, car.new_) && Objects.equals(seatCount, car.seatCount) && Objects.equals(owners, car.owners) && Objects.equals(condition, car.condition) && Objects.equals(market, car.market) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, city, brand, model, releaseYear, category, color, engine, mileage, transmission, gear, new_, seatCount, owners, condition, market, price);
    }

}
