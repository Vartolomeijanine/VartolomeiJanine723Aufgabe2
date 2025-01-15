package controller;

import model.Spieler;
import model.Vereine;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Spieler> spielers = new ArrayList<>();
    private List<Vereine> vereine = new ArrayList<>();

    public void addSpieler(Spieler spieler) {
        spielers.add(spieler);
    }

    public List<Spieler> getProducts() {
        return spielers;
    }

    public void updateSpieler(int spielerID, String newName, int newAge, String newPosition, int newMarkwert) {
        for (Spieler spieler : spielers) {
            if (spieler.getSpielerID()==spielerID) {
                spieler.setName(newName);
                spieler.setAge(newAge);
                spieler.setPosition(newPosition);
                spieler.setMarktwert(newMarkwert);
                System.out.println("Spieler updated: " + spieler);
                return;
            }
        }
        System.out.println("Spieler with ID " + spielerID + " not found.");
    }

    public void deleteSpieler(int spielerId) {
        spielers.removeIf(p -> p.getSpielerID() == spielerId);
    }

    public List<Spieler> getSpielers() {
        return spielers;
    }


}
