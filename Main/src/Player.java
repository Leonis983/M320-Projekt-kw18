import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Card> hand;

    private boolean dreckig;
    private boolean stall;
    private boolean regen;
    private boolean superschutz;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public boolean isDreckig() {
        return dreckig;
    }

    public void setDreckig(boolean dreckig) {
        this.dreckig = dreckig;
    }

    public boolean hasSuperschutz() {
        return superschutz;
    }

    public void setSuperschutz(boolean superschutz) {
        this.superschutz = superschutz;
    }

    public boolean hasStall() {
        return stall;
    }

    public void setStall(boolean stall) {
        this.stall = stall;
    }

    public boolean hasRegen() {
        return regen;
    }

    public void setRegen(boolean regen) {
        this.regen = regen;
    }

    public void showStatus() {
        System.out.println("Spieler: " + name);
        System.out.println("Dreckig: " + dreckig);
        System.out.println("Stall: " + stall);
        System.out.println("Regensau: " + regen);
        System.out.println("Superschutz: " + superschutz);
    }
}