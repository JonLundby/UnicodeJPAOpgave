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
//        unicode1.setBogstav('B');
//        unicode1.setKommentar("this is a B");
//        unicodeRepository.save(unicode1);

        Set<Character> unicodeSet = new HashSet<>();

        for (int i = 0; i <= 100; i++) {
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

        // gemmer i til x unicode/chars i db
//        for (int i = 97; i < 107; i++) {
//            Unicode unicode1 = new Unicode();
//            unicode1.setBogstav((char) i);
//            unicodeRepository.save(unicode1);
//        }
    }
}
