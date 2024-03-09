package org.example;
import java.util.HashMap;
import java.util.Map;

public class Shortener {

    private Map<String, String> originalToShortURL = new HashMap<>();
    private Map<String, String> shortToOriginalURL = new HashMap<>();
    private int id = 0;

    public String urlShortener(String longURL) {
        if (originalToShortURL.containsKey(longURL)) {
            return originalToShortURL.get(longURL);
        } else {
            String shortURL;
            do {
                id++;
                shortURL = "short.ly/" + generateID(id);
            } while (shortToOriginalURL.containsKey(shortURL));

            originalToShortURL.put(longURL, shortURL);
            shortToOriginalURL.put(shortURL, longURL);
            return shortURL;
        }
    }

    public String urlRedirector(String shortURL) {
        return shortToOriginalURL.get(shortURL);
    }

    private String generateID(int id) {
        StringBuilder generatedID = new StringBuilder();
        while (id > 0) {
            generatedID.insert(0, (char) ('a' + (id - 1) % 26));
            id = (id - 1) / 26;
        }
        return generatedID.toString();
    }
}