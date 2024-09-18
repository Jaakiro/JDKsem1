package com.example.montyhall;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import java.util.HashMap;
import java.util.Map;

public class MontyHallSimulation {

    private static final int NUM_SIMULATIONS = 1000;

    public static void main(String[] args) {
        MontyHallGame game = new MontyHallGame();
        Map<Integer, String> results = new HashMap<>();
        int switchWins = 0;
        int stayWins = 0;

        DescriptiveStatistics statistics = new DescriptiveStatistics(); // Для статистики

        for (int i = 1; i <= NUM_SIMULATIONS; i++) {
            GameResult result = game.play();
            results.put(i, result.isSwitched() ? "Switch" : "Stay");

            if (result.isWon()) {
                if (result.isSwitched()) {
                    switchWins++;
                } else {
                    stayWins++;
                }
            }

            statistics.addValue(result.isWon() ? 1 : 0);
        }

        System.out.println("Результаты:");
        results.forEach((step, result) -> System.out.println("Шаг " + step + ": " + result));

        System.out.println("\nСтатистика по победам:");
        System.out.println("Победы при смене выбора: " + switchWins);
        System.out.println("Победы без смены выбора: " + stayWins);
        System.out.println("Процент побед при смене: " + (switchWins * 100.0 / NUM_SIMULATIONS) + "%");
        System.out.println("Процент побед без смены: " + (stayWins * 100.0 / NUM_SIMULATIONS) + "%");

        System.out.println("\nАнализ статистики с использованием Apache Commons Math3:");
        System.out.println("Среднее количество побед: " + statistics.getMean());
        System.out.println("Максимальное количество побед подряд: " + statistics.getMax());
        System.out.println("Минимальное количество побед: " + statistics.getMin());
        System.out.println("Стандартное отклонение: " + statistics.getStandardDeviation());
    }
}
