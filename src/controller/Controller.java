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

    public void addVereine(Vereine vereine) {
        this.vereine.add(vereine);
    }

    public List<Vereine> getVereine() {
        return vereine;
    }

    public void updateVereine(int vereineID, String newName, String newStadt) {
        for (Vereine vereine : vereine) {
            if (vereine.getVereineID()==vereineID) {
                vereine.setName(newName);
                vereine.setStadt(newStadt);
                System.out.println("Vereine updated: " + vereine);
                return;
            }
        }
        System.out.println("Vereine with ID " + vereineID + " not found.");
    }

    public void deleteVereine(int vereineID) {
        vereine.removeIf(p -> p.getVereineID() == vereineID);
    }

    public void addSpielertoVereine(int spielerID, int vereineID) {
        for (Vereine vereine : vereine) {
            if (vereine.getVereineID()==vereineID) {
                for (Spieler spieler : spielers) {
                    if (spieler.getSpielerID()==spielerID) {
                        vereine.getListSpieler().add(spieler);
                    }
                }
            }
        }
    }


}
