import java.util.Scanner;
import java.util.Random;

public class ObsidianOrderGame {
    static Scanner scanner = new Scanner(System.in);
    static int lives = 3;
    static int score = 0;
    static int difficulty;

    public static void main(String[] args) {
        showIntro();
        acceptInvitation();
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
    }

    static void acceptInvitation() {
        System.out.println("Choose: Will you Accept the Invitation(1) or Ignore(2)");
        int respons = scanner.nextInt(); // get respons from user
        if(respons == 1) {
            System.out.println("Go to the designated location and pass trials to become member of Obsidian Order");
            System.out.println("You have 3 lives. Each mistake costs one. Survive the five trials.");
        }
        else {
            lives = 0;
            endGame();
        }
    }

    static void chooseDifficulty() {
        System.out.println("Choose difficulty: (1) Easy (2) Normal (3) Hard");
        difficulty = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String setDifficulty;
        switch (difficulty) {
            case 3:
                setDifficulty = "Hard";
                break;
            case 2: 
                setDifficulty = "Normal";
                break;
            default:
                setDifficulty = "Easy";
                break;
        }  
        System.out.println("Difficulty set to " + setDifficulty + ". Good luck.");
    }

    static void trialOfWisdom() {
        System.out.println("\n🧠 Trial of Wisdom");

        System.out.println("          _---~~(~~-_."                 );
        System.out.println("       _{        )   )"                );
        System.out.println("     ,   ) -~~- ( ,-' )_"              );
        System.out.println("    (  `-,_..`., )-- '_,)"             );
        System.out.println("   ( ` _)  (  -~( -_ `,  }"            );
        System.out.println("   (_-  _  ~_-~~~~`,  ,' )"            );
        System.out.println("     `~ -^(    __;-,((()))"            );
        System.out.println("           ~~~~ {_ -_(())"             );
        System.out.println("                  `\\  }"               );
        System.out.println("                    { }"       );


        System.out.println("Solve this riddle to proceed:");
        System.out.println("I speak without a mouth and hear without ears. I have nobody, but I come alive with wind. What am I?");
        if (difficulty == 1) {
            System.out.println("Hint: It's a natural phenomenon often heard in caves.");
            System.out.println("Choose: (a) Shadow (b) Wind (c) Echo");
        }
        if (difficulty == 2) {
            System.out.println("Hint: You might hear it in a canyon when you shout.");
        }
        String answer = scanner.nextLine().toLowerCase();
        if (difficulty == 1 && answer.equals("c")) answer = "echo";
        if (answer.contains("echo")) {
            score += 10;
            System.out.println("Correct. You may proceed.");
        } else {
            loseLife("Wrong. The scrolls go silent.");
        }
    }

    static void trialOfFire() {
        System.out.println("\n🔥 Trial of Fire");

        System.out.println(". . . . . . . . . . . . . . . . . .");
        System.out.println("...............  .###. . . . . . . . . . . . .");
        System.out.println("................. .###@@. . . . . . . . . . .");
        System.out.println("................. .@@@@@@. . . . . . . . . .");
        System.out.println("................. .@@@@@@@#. . . . . . . . .");
        System.out.println("................. #@@@@@@@@@#. #. . . . . . .");
        System.out.println("............... #@@@@@@@@@@@@@@##. . . . . .");
        System.out.println("............. #@@@@@@@@@@@@@@@@@@@#. . . . .");
        System.out.println(".....  ##.. #@@@@@@@#. #@@@@@@@@@@@#. . . .");
        System.out.println(".......###.@@@@@@@@@@. .@@@@@@@@@@@#. . . .");
        System.out.println(".......@@@@@@@@@@@@#. .@@@@@@@@@@@@.  ##...");
        System.out.println(".....##@@@@@@@@@@@#. .#@@@@@@@@@@@#.#@@@#..");
        System.out.println("..##@@@@@@@@@@@@@#.. .@@@@@@@@@@@@#.#@@@@@#");
        System.out.println(".#@@@@@@@@@@@@@@#... #@@@@@@@@@@@#.#@@@@@@@");
        System.out.println(".#@@@@@@@@@@@@@#... .@@.#@@@@@@@@@@@@@@@#@");
        System.out.println("##@@@@@@@@@@@@@#........#@@@@@@@@@@@@@@@#.");
        System.out.println("#@@#@@@@@@@@@@@...........#@@@@@@@@@@@#..");
        System.out.println(".#@@@@@@@@@@@@@.............@@@@@@@@@#.#.");
        System.out.println("..##@@@@@@@@@@@@. . . . . . .@@@@@@@@##@..");
        System.out.println("....##@@@@@@@@@@@#...........@@@@@@@@#...");
        System.out.println("........#@@@@@@@@@##.........#@@@@@##....");
        System.out.println("............#@@@@@@@@#.. . .#@@@@##......");
        System.out.println("................##@@@@@#...##@@##........");
        System.out.println("....................###@@@###............");


        System.out.println("You have 3 options: (a) Find water, (b) Run, (c) Save the old man.");
        if (difficulty == 1) {
            System.out.println("Hint: Compassion may be rewarded.");
        }
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
        if (difficulty == 1) {
            System.out.println("Hint: Risk may bring reward, or pain.");
        }

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
        System.out.println(
            "              O\n" +
            "             (_)\n" +
            "           _ )_( _\n" +
            "         /`_) H (_`\\\n" +
            "       .' (  { }  ) '.\n" +
            "     _/ /` '-'='-' `\\ \\_\n" +
            "    [_.'   _,...,_   '._]\n" +
            "    |   .:\"`````\":.   |\n" +
            "    |__//_________\\\\__|\n" +
            "     | .-----------. |\n" +
            "     | |  .-\"\"\"-.  | |\n" +
            "     | | /    /  \\ | |\n" +
            "     | ||-   <   -|| |\n" +
            "     | | \\    \\  / | |\n" +
            "     | |[`'-...-'`]| |\n" +
            "     | | ;-.___.-; | |\n" +
            "     | | |  |||  | | |\n" +
            "     | | |  |||  | | |\n" +
            "     | | |  |||  | | |\n" +
            "     | | |  |||  | | |\n" +
            "     | | |  |||  | | |\n" +
            "     | | | _|||_ | | |\n" +
            "     | | | >===< | | |\n" +
            "     | | | |___| | | |\n" +
            "     | | |  |||  | | |\n" +
            "     | | |  ;-;  | | |\n" +
            "     | | | (   ) | | |\n" +
            "     | | |  '-'  | | |\n" +
            "     | | '-------' | |\n" +
            "    _| '-----------' |_\n" +
            "   [= === === ==== == =]\n" +
            "   [__--__--___--__--__]\n" +
            "  /__-___-___-___-___-__\\\n" +
            " `\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"`"
        );

        System.out.println("\n⏳ Trial of Time");
        int firstN = (int)(Math.random() * 10) + 1;
        int secondN = (int)(Math.random() * 10) + 1;
        System.out.println("You must answer quickly: What is " + firstN * secondN + "?");
        long start = System.currentTimeMillis();
        int response = scanner.nextInt();
        long end = System.currentTimeMillis();
        int time = 3000;
        if(difficulty == 1) {
            time = 5000;
        }
        if(difficulty == 2) {
            time = 4000;
        }
        if (response == (firstN * secondN) && (end - start) < time) {
            score += 10;
            if (difficulty == 3 && lives < 3) {
                lives++;
                System.out.println("Impressive under pressure. You gain a bonus life!");
            }
            System.out.println("Swift and correct. Well done.");
        } else {
            loseLife("Too slow or incorrect. Time is precious.");
        }
    }

    static void trialOfTruth() {
        System.out.println("\n🪞 Trial of Truth");
        System.out.println("You face a mirror. It asks: What do you value more? (a) Power (b) Wisdom (c) Loyalty");
        if (difficulty == 1) {
            System.out.println("Hint: True strength lies in the mind.");
        }
        String choice = scanner.nextLine().toLowerCase();
        switch (choice) {
            case "b":
                score += 10;
                System.out.println("The mirror glows. You’ve chosen well.");
                break;
            case "a":
                score += 5;
                System.out.println("Power acknowledged. But wisdom is greater.");
                break;
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
        System.out.println("Play again? (yes/no)");
        String again = scanner.nextLine().toLowerCase();
        if (again.equals("yes")) {
            main(null); // restart game
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
            System.out.println("Play again? (yes/no)");
            String again = scanner.nextLine().toLowerCase();
            if (again.equals("yes")) {
                main(null); // restart game
            }
            return true;
        }
        return false;
    }
}
