package com.example.montyhall;

import java.util.Random;

public class MontyHallGame {

    private final Random random = new Random();

    public GameResult play() {
        int carDoor = random.nextInt(3);  // Дверь с машиной
        int chosenDoor = random.nextInt(3);  // Выбранная игроком дверь

        // Ведущий открывает одну из оставшихся дверей без машины
        int openedDoor;
        do {
            openedDoor = random.nextInt(3);
        } while (openedDoor == carDoor || openedDoor == chosenDoor);

        // Игрок решает, менять ли выбор
        boolean switchDoor = random.nextBoolean();
        int finalChoice = switchDoor ? 3 - chosenDoor - openedDoor : chosenDoor;

        return new GameResult(finalChoice == carDoor, switchDoor);
    }
}
