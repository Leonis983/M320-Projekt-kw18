import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players;
    private Deck deck;
    private Scanner scanner;

    public Game() {
        players = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void start() {

        System.out.println("=== DRECKSAU ===");

        int number;

        do {
            System.out.print("Anzahl Spieler (2-4): ");
            number = scanner.nextInt();
        }
        while(number < 2 || number > 4);

        scanner.nextLine();

        for(int i = 1; i <= number; i++) {

            System.out.print("Name Spieler " + i + ": ");
            String name = scanner.nextLine();

            players.add(new Player(name));
        }

        deck = new Deck();

        for(Player p : players) {

            for(int i = 0; i < 3; i++) {
                p.addCard(deck.drawCard());
            }
        }

        gameLoop();
    }

    private void gameLoop() {

        boolean running = true;

        while(running) {

            for(Player current : players) {

                showBoard();

                System.out.println("\nAm Zug: " + current.getName());

                showHand(current);

                System.out.print("Welche Karte spielen? Index: ");
                int index = scanner.nextInt();

                if(index < 0 || index >= current.getHand().size()) {
                    System.out.println("Ungültige Auswahl!");
                    continue;
                }

                Card selected = current.getHand().get(index);

                System.out.println("Zielspieler wählen:");

                for(int i = 0; i < players.size(); i++) {
                    System.out.println(i + ": " + players.get(i).getName());
                }

                int targetIndex = scanner.nextInt();

                Player target = players.get(targetIndex);

                GameLogic.playCard(current, target, selected);

                if(!deck.isEmpty()) {
                    current.addCard(deck.drawCard());
                }

                if(checkWinner(current)) {
                    System.out.println(current.getName() + " gewinnt das Spiel!");
                    running = false;
                    break;
                }
            }
        }
    }

    private boolean checkWinner(Player player) {
        return player.isDreckig();
    }

    private void showBoard() {

        System.out.println("\n===== SPIELSTAND =====");

        for(Player p : players) {
            p.showStatus();
            System.out.println();
        }
    }

    private void showHand(Player player) {

        System.out.println("Handkarten:");

        for(int i = 0; i < player.getHand().size(); i++) {
            System.out.println(i + ": " + player.getHand().get(i));
        }
    }
}