package org.example.unicodejpaopgave.config;

import org.example.unicodejpaopgave.model.Unicode;
import org.example.unicodejpaopgave.repository.UnicodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    UnicodeRepository unicodeRepository;

    @Override
    public void run(String... args) throws Exception {

        Set<Character> unicodeSet = new HashSet<>();

        for (int i = 0; i <= 1000; i++) {
            char c = (char) i;
            unicodeSet.add(c);
        }

        for (char c: unicodeSet) {
//            System.out.println(c + " / " + (int) c);
            Unicode unicode1 = new Unicode();
            unicode1.setUnicode((int) c);
            unicode1.setBogstav(c);
            if ((int) c % 2 > 0) {
                unicode1.setKommentar("Odd number unicode characters are my favourites :)");
            }
            unicodeRepository.save(unicode1);
        }
    }
}
