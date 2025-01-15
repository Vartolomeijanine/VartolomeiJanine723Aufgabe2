package model;

public class Spieler {
    private int spielerID;
    private String name;
    private int age;
    private String position;
    private int marktwert;

    public Spieler(int spielerID, String name, int age, String position, int marktwert) {
        this.spielerID = spielerID;
        this.name = name;
        this.age = age;
        this.position = position;
        this.marktwert = marktwert;
    }

    public int getSpielerID() {
        return spielerID;
    }

    public void setSpielerID(int spielerID) {
        this.spielerID = spielerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getMarktwert() {
        return marktwert;
    }

    public void setMarktwert(int marktwert) {
        this.marktwert = marktwert;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "spielerID=" + spielerID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", marktwert=" + marktwert +
                '}';
    }
}
