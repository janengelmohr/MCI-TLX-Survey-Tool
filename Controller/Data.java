package Controller;

import java.util.HashMap;

public class Data {

    private static Data instance;
    public HashMap<String, Integer> weights = new HashMap<>();
    public HashMap<String, Integer> ratings = new HashMap<>();
    public HashMap<String, Integer> products = new HashMap<>();

    private Data () {}

    public static Data getInstance () {
        if (Data.instance == null) {
            Data.instance = new Data();
        }
        return Data.instance;
    }
}