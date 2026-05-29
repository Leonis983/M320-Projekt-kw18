public class GameLogic {

    public static void playCard(Player current, Player target, Card card) {

        switch(card.getType()) {

            case DRECKSAU:

                if(!target.isDreckig()) {
                    target.setDreckig(true);
                    System.out.println(target.getName() + " ist jetzt dreckig!");
                }
                break;

            case REGENSAU:

                if(target.isDreckig()) {
                    target.setRegen(true);
                    System.out.println(target.getName() + " ist jetzt Regensau!");
                }
                break;

            case STALL:

                target.setStall(true);
                System.out.println(target.getName() + " hat jetzt einen Stall!");
                break;

            case BLITZ:

                if(target.hasStall()) {
                    target.setStall(false);
                    System.out.println("Der Stall wurde zerstört!");
                }
                break;

            case BAUER_SCHRUBB:

                target.setDreckig(false);
                target.setRegen(false);
                System.out.println(target.getName() + " wurde sauber gemacht!");
                break;

            case BAUER_AERGERE:

                target.setStall(false);
                System.out.println(target.getName() + " verliert den Stall!");
                break;
        }

        current.removeCard(card);
    }
}