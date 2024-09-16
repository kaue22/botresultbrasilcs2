package br.com.botresultbrasilcs2;

import br.com.botresultbrasilcs2.adapters.Draft5Scraping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Botresultbrasilcs2Application {

    public static void main(String[] args) throws IOException {

        ConfigurableApplicationContext bean = SpringApplication.run(Botresultbrasilcs2Application.class, args);
        Draft5Scraping draft5Scraping = bean.getBean(Draft5Scraping.class);
        draft5Scraping.extractNewsTitles();

    }

}
