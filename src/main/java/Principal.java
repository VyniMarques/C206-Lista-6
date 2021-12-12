import leituraCSV.CSV;
import vendaGames.VendaGames;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner imp = new Scanner(System.in);

        System.out.println("=============================================");
        System.out.println("Filtar por:");
        int op;
        String p;
        do {
            System.out.println("1 - Plataforma");
            System.out.println("2 - Publishers");
            System.out.println("=============================================");
            op = imp.nextInt();
            imp.nextLine();

            if (op == 1)
                System.out.println("Entre com a Plataforma:");
            else if (op == 2)
                System.out.println("Entre com a Publisher:");
            else
                System.out.println("Opção invalida!");
            p = imp.nextLine();
        } while (!(op == 1 || op == 2));

        CSV leitura = new CSV();
        List<VendaGames> games;

        games = leitura.lerCSV(op,p);

        System.out.println("Jogos filtrados:");
        games.forEach(game -> {
            System.out.println("=============================================");
            System.out.println("Rank: " + game.getRank());
            System.out.println("Name: " + game.getName());
            System.out.println("Plataform: " +game.getPlatform());
            System.out.println("Year: " + game.getYear());
            System.out.println("Genre: " + game.getGenre());
            System.out.println("Publisher: " + game.getPublisher());
            System.out.println("NA Sales: " + game.getNa_sales());
            System.out.println("EU Sales: " + game.getEu_sales());
            System.out.println("JP Sales: " + game.getJp_sales());
            System.out.println("Other Sales: " + game.getOther_sales());
            System.out.println("Global Sales: " + game.getGlobal_sales());
        });
        System.out.println("=============================================");

    }
}