package leituraCSV;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import vendaGames.VendaGames;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public List<VendaGames> lerCSV(int op, String p) {
        List<VendaGames> vendas = new ArrayList<>();
        List<VendaGames> vendas2 = new ArrayList<>();

        Path caminho = Paths.get("vendas-games.csv");

        try {
            Reader reader = Files.newBufferedReader(caminho);
            CsvToBean<VendaGames> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(VendaGames.class)
                    .withIgnoreLeadingWhiteSpace(true).build();

            vendas = csvToBean.parse();
            if(op == 1)
                vendas.stream().filter(g -> g.getPlatform().equals(p)).forEach(v -> {
                    vendas2.add(v);
                });
            else
                vendas.stream().filter(g -> g.getPublisher().equals(p)).forEach(v -> {
                    vendas2.add(v);
                });
        }catch (IOException e) {
            e.printStackTrace();
        }
        return vendas2;
    }
}