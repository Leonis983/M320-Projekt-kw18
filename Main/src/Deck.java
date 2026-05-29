import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        createDeck();
        shuffle();
    }

    private void createDeck() {

        for(int i = 0; i < 8; i++) {
            cards.add(new Card(CardType.DRECKSAU));
        }

        for(int i = 0; i < 4; i++) {
            cards.add(new Card(CardType.REGENSAU));
            cards.add(new Card(CardType.STALL));
            cards.add(new Card(CardType.BLITZ));
            cards.add(new Card(CardType.BAUER_SCHRUBB));
            cards.add(new Card(CardType.BAUER_AERGERE));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {

        if(cards.isEmpty()) {
            return null;
        }

        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }
}