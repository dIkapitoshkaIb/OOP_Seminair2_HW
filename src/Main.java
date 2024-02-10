import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>(Arrays.asList(
                new Human("Jacob", 2.0, 2.0),
                new Human("Lora", 1.5, 4),
                new Cat("Pushok", 3.2, 5.0),
                new Cat("Tiger", 5.0, 8.0),
                new Robot("Anton", 0.0, 1.5)
        ));

        List<Barrier> barrierList = new ArrayList<>(Arrays.asList(
                new Wall("Барьер легкий", 0.8),
                new Wall("Барьер средний", 1.1),
                new Wall("Барьер тяжелый", 1.5),
                new Pathway("Дорожка легая", 0.5),
                new Pathway("Дорожка средняя", 1.0),
                new Pathway("Дорожка тяжелая", 2.0)
        ));


        for(Player player: playerList){
            System.out.println("---Успехи участника " + player.getName() + "---");
            player.run();
            for (Barrier barrier: barrierList){
                if( barrier instanceof Wall){
                    player.jump(((Wall) barrier).getDistance());
                } else if (barrier instanceof Pathway){
                    player.runThrough(((Pathway) barrier).getDistance());
                }
            }
            player.endRace();
        }
    }
}