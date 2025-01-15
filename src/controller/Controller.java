package controller;

import model.Spieler;
import model.Vereine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private List<Spieler> spielers = new ArrayList<>();
    private List<Vereine> vereine = new ArrayList<>();

    public void addSpieler(Spieler spieler) {
        spielers.add(spieler);
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
        System.out.println("Spieler added to Vereine successfully!");
    }

    /**
     * Filters vereine by their stadt.
     *
     * @param stadt The stadt to filter by.
     * @return List of customers from the specified place.
     */

    public List<Vereine> filterVereinebyStadt(String stadt) {
        List<Vereine> filteredVereine = new ArrayList<>();
        for (Vereine vereine : vereine) {
            if (vereine.getStadt().equalsIgnoreCase(stadt)) {
                filteredVereine.add(vereine);
            }
        }
        return filteredVereine;
    }


    /**
     * Filters spieler by vereine.
     */
    public List<Spieler> filterSpielerbyVereine(String vereine1) {
        List<Spieler> filteredSpieler = new ArrayList<>();
        for (Vereine vereine : vereine){
            if (vereine.getName().equalsIgnoreCase(vereine1)) {
                for (Spieler spieler : spielers) {
                    filteredSpieler.add(spieler);
                }
            }
        }
        return filteredSpieler;
    }

    /**
     * Sorts spielers owned by a specific vereine.
     *
     * @param vereineName The name of the vereine.
     * @param ascending  Whether to sort in ascending order.
     * @return List of sorted products.
     */

    public List<Spieler> sortSpielersByMarkwert(String vereineName, boolean ascending) {
        List<Spieler> filtered = new ArrayList<>();

        for (Vereine vereine : vereine) {
            if (vereine.getName().equalsIgnoreCase(vereineName)) {
                filtered.addAll(vereine.getListSpieler());
                break;
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("Vereine with ID " + vereineName + " has no products.");
            return filtered;
        }

        if (ascending) {
            filtered.sort(Comparator.comparing(Spieler::getMarktwert));
        } else {
            filtered.sort(Comparator.comparing(Spieler::getMarktwert).reversed());
        }
        return filtered;
    }

}
