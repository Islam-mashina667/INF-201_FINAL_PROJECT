package Model;

public class Movie {
    private String name;
    private String description;
    private String genre;
    private String imageSrc;
    private int price;

    public Movie(){}
    public Movie(String name, String description, String genre, String imageSrc, int price){
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.imageSrc = imageSrc;
        this.price = price;
    }

    public void setImageSrc(String imageSrc) { this.imageSrc = imageSrc; }
    public String getImageSrc() {return imageSrc;}
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
