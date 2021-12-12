package vendaGames;

import lombok.Data;

@Data
public class VendaGames {

    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private float na_sales;
    private float eu_sales;
    private float jp_sales;
    private float other_sales;
    private float global_sales;

}