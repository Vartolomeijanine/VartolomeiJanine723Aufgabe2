package model;

import java.util.ArrayList;
import java.util.List;

public class Vereine {

    private int vereineID;
    private String name;
    private String stadt;
    private List<Spieler> listSpieler;

    public Vereine(int vereineID, String name, String stadt) {
        this.vereineID = vereineID;
        this.name = name;
        this.stadt = stadt;
        this.listSpieler = new ArrayList<>();
    }

    public int getVereineID() {
        return vereineID;
    }

    public void setVereineID(int vereineID) {
        this.vereineID = vereineID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public List<Spieler> getListSpieler() {
        return listSpieler;
    }

    public void setListSpieler(List<Spieler> listSpieler) {
        this.listSpieler = listSpieler;
    }

    @Override
    public String toString() {
        return "Vereine{" +
                "vereineID=" + vereineID +
                ", name='" + name + '\'' +
                ", stadt='" + stadt + '\'' +
                ", listSpieler=" + listSpieler +
                '}';
    }
}
