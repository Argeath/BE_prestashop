package com.barkomkin.recommendations;

import java.util.concurrent.ThreadLocalRandom;

public class RandomDataGenerator {

    private static String[] maleNames = {
            "Adam", "Adolf", "Adrian", "Albert", "Aleksander", "Aleksy", "Alfred", "Amadeusz", "Andrzej", "Antoni",
            "Arkadiusz", "Arnold", "Artur",
            "Bartlomiej", "Bartosz", "Benedykt", "Beniamin", "Bernard", "Blazej", "Bogdan", "Bogumil", "Boguslaw",
            "Boleslaw", "Borys", "Bronislaw",
            "Cezary", "Cyprian", "Cyryl", "Czeslaw",
            "Damian", "Daniel", "Dariusz", "Dawid", "Dionizy", "Dominik", "Donald",
            "Edward", "Emanuel", "Emil", "Eryk", "Eugeniusz",
            "Fabian", "Feliks", "Ferdynand", "Filip", "Franciszek", "Fryderyk",
            "Gabriel", "Gerard", "Grzegorz", "Gustaw",
            "Henryk", "Herbert", "Hilary", "Hubert",
            "Ignacy", "Igor", "Ireneusz",
            "Jacek", "Jakub", "Jan", "Janusz", "Jaroslaw", "Jerzy", "Joachim", "Jozef", "Julian", "Juliusz",
            "Kacper", "Kajetan", "Kamil", "Karol", "Kazimierz", "Klaudiusz", "Konrad", "Krystian", "Krzysztof",
            "Lech", "Leon", "Leszek", "Lucjan", "Ludwik",
            "Łukasz",
            "Maciej", "Maksymilian", "Marceli", "Marcin", "Marek", "Marian", "Mariusz", "Mateusz", "Michal",
            "Mieczyslaw", "Mikolaj", "Milosz", "Miroslaw",
            "Nikodem", "Norbert",
            "Olaf", "Olgierd", "Oskar",
            "Patryk", "Pawel", "Piotr", "Przemyslaw",
            "Radoslaw", "Rafal", "Remigiusz", "Robert", "Roman", "Rudolf", "Ryszard",
            "Sebastian", "Seweryn", "Slawomir", "Stanislaw", "Stefan", "Sylwester", "Szymon",
            "Tadeusz", "Teodor", "Tomasz",
            "Waclaw", "Waldemar", "Wieslaw", "Wiktor", "Witold", "Wladyslaw", "Wlodzimierz", "Wojciech",
            "Zbigniew", "Zdzislaw", "Zenon", "Zygmunt"
    };

    private static String[] maleSurnames = {
            "nowak", "kowalski", "wisniewski", "wojcik", "kowalczyk", "kaminski", "lewandowski", "dabrowski",
            "zielinski", "szymanski", "wozniak", "kozlowski", "jankowski", "mazur", "baran", "sienkiewicz",
            "cichuniak", "pryk", "pilny", "prokop", "pasterski", "petru", "polanecki", "paracka", "pisala", "pozorski"
    };

    static String randomName() {
        return formatName(maleNames[ThreadLocalRandom.current().nextInt(maleNames.length)]);
    }

    static String randomSurname() {
        return formatName(maleSurnames[ThreadLocalRandom.current().nextInt(maleSurnames.length)]);
    }

    private static String formatName(String str) {
        return Character.toUpperCase(str.charAt(0)) + str.substring(1).toLowerCase();
    }

}
