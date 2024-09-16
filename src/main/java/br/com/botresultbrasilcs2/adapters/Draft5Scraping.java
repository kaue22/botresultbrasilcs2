package br.com.botresultbrasilcs2.adapters;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class Draft5Scraping {
    public static void extractNewsTitles() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d 'de' MMMM, yyyy", new Locale("pt", "BR"));
        Document doc = Jsoup.connect("https://www.dust2.com.br/resultados").get();
        Elements matchesGroupHeaders = doc.select(".matches-group-header");
        for (Element matchesGroupHeader : matchesGroupHeaders) {
            LocalDate receivedDate = LocalDate.parse(matchesGroupHeader.text(), formatter);
            if (receivedDate.isEqual(LocalDate.now().minusDays(1))) {
                Elements matchesGroupContainers = doc.select(".match-results");
                for (Element matchesGroupContainer : matchesGroupContainers) {
                    Elements links = matchesGroupContainer.select("a[href^=/partidas/]");
                    for (Element link : links) {
                        String href = link.attr("href");
                        System.out.println(href);
                    }
                }
            }
        }
    }
}