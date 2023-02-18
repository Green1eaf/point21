package ru.smirnov.point21;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.smirnov.point21.model.Player;
import ru.smirnov.point21.repository.CardRepository;
import ru.smirnov.point21.service.InMemoryCardManager;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Point21Application {

    public static void main(String[] args) throws InterruptedException {
        startGame(new InMemoryCardManager());
    }

    public static void startGame(CardRepository cardRepository) throws InterruptedException {
        Player player = new Player();
        Player comp = new Player();
        Scanner scanner = new Scanner(System.in);
        int answer = 0;

        System.out.println("Игра началась!");
        do {
            player.clearCards();
            comp.clearCards();
            cardRepository.shuffle();
            shuffleCardsAnimation();
            System.out.println();
            do {
                player.addCard(cardRepository.getCard());
                System.out.println("Ваши карты: " + player.getCards());
                if (isLose(player.sum())) {
                    System.out.println("Перебор!");
                    break;
                }
                System.out.println("Ещё?(1 - да, 2 - нет)");
                answer = scanner.nextInt();
            } while (answer != 2);

            if (player.sum() <= 21) {
                System.out.println("Ход компьютера");
            }

            while (player.sum() <= 21) {
                if (comp.sum() <= player.sum()) {
                    compThinking();
                    comp.addCard(cardRepository.getCard());
                    System.out.println("Ваши карты: " + player.getCards());
                    System.out.println("Карты компа:" + comp.getCards());
                } else break;
            }

            if (!isLose(player.sum()) && (isLose(comp.sum()) || player.sum() > comp.sum())) {
                System.out.println("Поздравляем! Вы выиграли!");
            } else if (!isLose(player.sum()) && player.sum() == comp.sum()) {
                System.out.println("Ничья!");
            } else {
                System.out.println("Победил компьютер!");
            }

            System.out.println("Продолжить играть?(1 - да, 2 - нет)");
            int ans = scanner.nextInt();
            if (ans == 2) return;
        } while (true);
    }

    private static boolean isLose(int sum) {
        return sum > 21;
    }

    private static void shuffleCardsAnimation() throws InterruptedException {
        System.out.print("Мешаем карты");
        for (int i = 0; i < 4; i++) {
            System.out.print(".");
            TimeUnit.SECONDS.sleep(1);
        }
    }

    private static void compThinking() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println();
    }
}
