import java.util.Scanner;
import java.util.Random;

public class ObsidianOrderGame {
    static Scanner scanner = new Scanner(System.in);
    static int lives = 3;
    static int score = 0;

    public static void main(String[] args) {
        showIntro();
        chooseDifficulty();

        trialOfWisdom();
        if (checkGameOver()) return;

        trialOfFire();
        if (checkGameOver()) return;

        trialOfShadows();
        if (checkGameOver()) return;

        trialOfTime();
        if (checkGameOver()) return;

        trialOfTruth();
        endGame();
    }

    static void showIntro() {
        System.out.println("  _______ _            _            _ _        _   _             ");
        System.out.println(" |__   __| |          (_)          (_) |      | | (_)            ");
        System.out.println("    | |  | |__   ___   _ _ ____   ___| |_ __ _| |_ _  ___  _ __  ");
        System.out.println("    | |  | '_ \\ / _ \\ | | '_ \\ \\ / / | __/ _` | __| |/ _ \\| '_ \\ ");
        System.out.println("    | |  | | | |  __/ | | | | \\ V /| | || (_| | |_| | (_) | | | |");
        System.out.println("    |_|  |_| |_|\\___| |_|_| |_|\\_/ |_|\\__\\__,_|\\__|_|\\___/|_| |_|");
        System.out.println();
        System.out.println("You’ve been chosen. Midnight. The Library. Tell no one. Burn this after reading.");
        System.out.println("You have 3 lives. Each mistake costs one. Survive the five trials.");
    }

    static void chooseDifficulty() {
        System.out.println("Choose difficulty: (1) Easy (2) Normal (3) Hard");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Difficulty set. Good luck.");
    }

    static void trialOfWisdom() {
        System.out.println("\n🧠 Trial of Wisdom");
        System.out.println("You enter a dim study hall filled with ancient scrolls.");
        System.out.println("Solve this riddle to proceed:");
        System.out.println("I speak without a mouth and hear without ears. I have nobody, but I come alive with wind. What am I?");
        String answer = scanner.nextLine().toLowerCase();
        if (answer.contains("echo")) {
            score += 10;
            System.out.println("Correct. You may proceed.");
        } else {
            loseLife("Wrong. The scrolls go silent.");
        }
    }

    static void trialOfFire() {
        System.out.println("\n🔥 Trial of Fire");
        System.out.println("The archive bursts into flames. You have 3 options: (a) Find water, (b) Run, (c) Save the old man.");
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("c")) {
            score += 10;
            System.out.println("You save him. He gives you a fireproof cloak. You live.");
        } else {
            loseLife("You fail. The flames claim something precious.");
        }
    }

    static void trialOfShadows() {
        System.out.println("\n🕶 Trial of Shadows");
        System.out.println("A masked figure offers you a deal. Trust them? (yes/no)");
        String trust = scanner.nextLine().toLowerCase();
        if (trust.equals("yes")) {
            Random rand = new Random();
            if (rand.nextBoolean()) {
                score += 10;
                System.out.println("You gain valuable knowledge.");
            } else {
                loseLife("Betrayed. The figure vanishes.");
            }
        } else {
            System.out.println("You stay cautious. The figure disappears. You move on.");
        }
    }

    static void trialOfTime() {
        System.out.println("\n⏳ Trial of Time");
        System.out.println("You must answer quickly: What is 15 * 3?");
        long start = System.currentTimeMillis();
        int response = scanner.nextInt();
        scanner.nextLine();
        long end = System.currentTimeMillis();
        if (response == 45 && (end - start) < 5000) {
            score += 10;
            System.out.println("Swift and correct. Well done.");
        } else {
            loseLife("Too slow or incorrect. Time is precious.");
        }
    }

    static void trialOfTruth() {
        System.out.println("\n🪞 Trial of Truth");
        System.out.println("You face a mirror. It asks: What do you value more? (a) Power (b) Wisdom (c) Loyalty");
        String choice = scanner.nextLine().toLowerCase();
        switch (choice) {
            case "b":
                score += 10;
                System.out.println("The mirror glows. You’ve chosen well.");
                break;
            case "a":
            case "c":
                System.out.println("The mirror remains still. Your answer is noted.");
                break;
            default:
                loseLife("The mirror rejects indecisiveness.");
        }
    }

    static void endGame() {
        System.out.println("\nYour final score: " + score);
        if (lives <= 0) {
            System.out.println("You failed the trials. The Order fades from your memory.");
        } else if (score >= 40) {
            System.out.println("You are welcomed into the Obsidian Order. The truth is now yours.");
        } else {
            System.out.println("You survived, but barely. You may never know the full truth.");
        }
    }

    static void loseLife(String message) {
        lives--;
        System.out.println(message);
        System.out.println("Lives remaining: " + lives);
    }

    static boolean checkGameOver() {
        if (lives <= 0) {
            System.out.println("You have no more lives. Game Over.");
            return true;
        }
        return false;
    }
}
