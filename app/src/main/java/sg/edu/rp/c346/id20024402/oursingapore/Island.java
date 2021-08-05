package sg.edu.rp.c346.id20024402.oursingapore;

import java.io.Serializable;

public class Island implements Serializable {
    private int id;
    private String name;
    private String description;
    private int area;
    private int rating;

    public Island(String name, String description, int area, int rating) {
        this.name = name;
        this.description = description;
        this.area = area;
        this.rating = rating;
    }

    public Island(int id, String name, String description, int area, int rating) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.area = area;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getArea() {
        return area;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        String ratingString = "";

        for(int i = 0; i < rating; i++){
            ratingString += "*";
        }
        return name + "\n" + description + " - " + area + "\n" + ratingString;

    }
}

