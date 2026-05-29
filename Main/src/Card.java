public class Card {

    private CardType type;

    public Card(CardType type) {
        this.type = type;
    }

    public CardType getType() {
        return type;
    }

    public String toString() {
        return type.toString();
    }
}
