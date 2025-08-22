import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        System.out.println("🎮WELCOME TO MY GAMING CONSOLE🎮");
        System.out.println("WELCOME TO TIC-TAC-TOE!Human vs AI...🧠 ");
        displayPositionGuide();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        char s = ' ', s1 = ' ';
        int r = 0, c = 0;
        int w=0,wc=0,t=0;
        while(true)
        {
        int[] p = new int[100];// to store position of player's move
        int[] pc = new int[100];//// to store position of computer's move
        while (true) {
            System.out.print("ENTER THE SYMBOL U WANT TO CHOSE: 'X' OR 'O' ? ");
            s = sc.next().charAt(0);
            sc.nextLine();
            s = Character.toUpperCase(s);
            if (s == 'O' || s == 'X')
                break;
            else
                System.out.println("🚫Invalid input. pls enter a 'X' or a 'O': ");
        }
        if (s == 'X')
            s1 = 'O';
        else
            s1 = 'X';
        char[][] box = new char[3][3]; // Creating the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                box[i][j] = ' ';
            }
        }
        for (int i = 1;; i++) {
            while (true) {
                System.out.print("Enter the position u want to chose for round " + i + " :");
                p[i] = sc.nextInt();
                if (p[i] >= 1 && p[i] <= 9)
                    break;
                else
                    System.out.println("🚫Invalid input. Position must be btw 1 and 9. Try again!");
            }
            r = Rows(p[i]);
            c = Columns(p[i]);
            System.out.print("🙂Computer is thinking");
            for (int j = 0; j < 3; j++) {
                try {
                    Thread.sleep(500); // 500 ms = 0.5 sec
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.print(".");
            }
            System.out.println();

            if (box[r][c] == ' ') {
                box[r][c] = s;
                if (i == 1) {
                    if (p[1] == 5) {
                        int randNum = rand.nextInt(4);
                        if (randNum == 0) {
                            box[0][0] = s1;
                            pc[i] = 1;
                        } else if (randNum == 1) {
                            box[0][2] = s1;
                            pc[i] = 3;
                        } else if (randNum == 2) {
                            box[2][0] = s1;
                            pc[i] = 7;
                        } else {
                            box[2][2] = s1;
                            pc[i] = 9;
                        }
                    } else {
                        box[1][1] = s1;
                        pc[i] = 5;
                    }
                } else if (i == 2) {
                    if (p[1] == 5) {
                        if (p[2] == 2) {
                            box[2][1] = s1;
                            pc[i] = 8;
                        }
                        if (p[2] == 8) {
                            box[0][1] = s1;
                            pc[i] = 2;
                        } else if (p[2] == 4) {
                            box[1][2] = s1;
                            pc[i] = 6;
                        } else if (p[2] == 3) {
                            if (box[2][0] == ' ') {
                                box[2][0] = s1;
                                pc[i] = 7;
                            } else {
                                box[2][2] = s1;
                                pc[i] = 9;
                            }
                        }

                        else if (p[2] == 7) {
                            if (box[0][2] == ' ') {
                                box[0][2] = s1;
                                pc[i] = 3;
                            } else {
                                box[0][0] = s1;
                                pc[i] = 1;
                            }
                        }

                        else if (p[2] == 9) {
                            if (box[0][0] == ' ') {
                                box[0][0] = s1;
                                pc[i] = 1;
                            } else {
                                box[0][2] = s1;
                                pc[i] = 3;
                            }
                        }

                        else if (p[2] == 1) {
                            if (box[2][2] == ' ') {
                                box[2][2] = s1;
                                pc[i] = 9;
                            } else {
                                box[2][0] = s1;
                                pc[i] = 7;
                            }
                        }

                        else if (p[2] == 6) {
                            box[1][0] = s1;
                            pc[i] = 4;
                        }
                    }

                    else {
                        if ((p[1] == 1 && p[2] == 7) || (p[1] == 7 && p[2] == 1)) {
                            box[1][0] = s1;
                            pc[i] = 4;
                        } else if ((p[1] == 1 && p[2] == 3) || (p[1] == 3 && p[2] == 1)) {
                            box[0][1] = s1;
                            pc[i] = 2;
                        } else if ((p[1] == 1 && p[2] == 2) || (p[1] == 2 && p[2] == 1)) {
                            box[0][2] = s1;
                            pc[i] = 3;
                        } else if ((p[1] == 1 && p[2] == 4) || (p[1] == 4 && p[2] == 1)) {
                            box[2][0] = s1;
                            pc[i] = 7;
                        } else if ((p[1] == 2 && p[2] == 3) || (p[1] == 3 && p[2] == 2)) {
                            box[0][0] = s1;
                            pc[i] = 1;

                        } else if ((p[1] == 3 && p[2] == 6) || (p[1] == 6 && p[2] == 3)) {
                            box[2][2] = s1;
                            pc[i] = 9;
                        } else if ((p[1] == 3 && p[2] == 9) || (p[1] == 9 && p[2] == 3)) {
                            box[1][2] = s1;
                            pc[i] = 6;
                        } else if ((p[1] == 4 && p[2] == 7) || (p[1] == 7 && p[2] == 4)) {
                            box[0][0] = s1;
                            pc[i] = 1;
                        } else if ((p[1] == 6 && p[2] == 9) || (p[1] == 9 && p[2] == 6)) {
                            box[1][2] = s1;
                            pc[i] = 3;
                        } else if ((p[1] == 7 && p[2] == 8) || (p[1] == 8 && p[2] == 7)) {
                            box[2][2] = s1;
                            pc[i] = 9;
                        } else if ((p[1] == 7 && p[2] == 9) || (p[1] == 9 && p[2] == 7)) {
                            box[2][1] = s1;
                            pc[i] = 8;
                        }

                        // Blocking double threats
                        else if ((p[1] == 1 && p[2] == 6) || (p[1] == 6 && p[2] == 1)) {
                            box[0][2] = s1;
                            pc[i] = 3;
                        } else if ((p[1] == 1 && p[2] == 9) || (p[1] == 9 && p[2] == 1)) {
                            box[0][1] = s1;
                            pc[i] = 2;
                        } else if ((p[1] == 1 && p[2] == 8) || (p[1] == 8 && p[2] == 1)) {
                            box[2][0] = s1;
                            pc[i] = 7;
                        } else if ((p[1] == 3 && p[2] == 7) || (p[1] == 7 && p[2] == 3)) {
                            box[2][1] = s1;
                            pc[i] = 8;
                        } else if ((p[1] == 3 && p[2] == 4) || (p[1] == 4 && p[2] == 3)) {
                            box[0][0] = s1;
                            pc[i] = 1;
                        }

                        else if ((p[1] == 3 && p[2] == 8) || (p[1] == 8 && p[2] == 3)) {
                            box[2][2] = s1;
                            pc[i] = 9;
                        } else if ((p[1] == 7 && p[2] == 6) || (p[1] == 6 && p[2] == 7)) {
                            box[2][2] = s1;
                            pc[i] = 9;
                        } else if ((p[1] == 7 && p[2] == 2) || (p[1] == 2 && p[2] == 7)) {
                            box[0][0] = s1;
                            pc[i] = 1;
                        } else if ((p[1] == 9 && p[2] == 1) || (p[1] == 1 && p[2] == 9)) {
                            box[0][1] = s1;
                            pc[i] = 2;
                        } else if ((p[1] == 9 && p[2] == 2) || (p[1] == 2 && p[2] == 9)) {
                            box[0][2] = s1;
                            pc[i] = 3;
                        } else if ((p[1] == 9 && p[2] == 4) || (p[1] == 4 && p[2] == 9)) {
                            box[2][0] = s1;
                            pc[i] = 7;
                        } else if ((p[1] == 2 && p[2] == 4) || (p[1] == 4 && p[2] == 2)) {
                            box[0][0] = s1;
                            pc[i] = 1;
                        } else if ((p[1] == 2 && p[2] == 6) || (p[1] == 6 && p[2] == 2)) {
                            box[0][2] = s1;
                            pc[i] = 3;
                        } else if ((p[1] == 8 && p[2] == 6) || (p[1] == 6 && p[2] == 8)) {
                            box[2][2] = s1;
                            pc[i] = 9;
                        } else if ((p[1] == 8 && p[2] == 4) || (p[1] == 4 && p[2] == 8)) {
                            box[2][0] = s1;
                            pc[i] = 7;
                        }

                        else {
                            if (box[0][0] == ' ') {
                                box[0][0] = s1;
                                pc[i] = 1;
                            } else if (box[0][2] == ' ') {
                                box[0][2] = s1;
                                pc[i] = 3;
                            } else if (box[2][0] == ' ') {
                                box[2][0] = s1;
                                pc[i] = 7;
                            } else {
                                box[2][2] = s1;
                                pc[i] = 9;
                            }
                        }
                    }
                }

                else if (i >= 3 && i <= 9) {
                    boolean moved = false;
                    int[][] winCombos = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 },
                            { 1, 5, 9 }, { 3, 5, 7 } };

                    // 1�?⃣ First, check if computer can win
                    for (int[] combo : winCombos) {
                        int co = 0, empty = -1;
                        for (int pos : combo) {
                            if (box[Rows(pos)][Columns(pos)] == s1)
                                co++;
                            else if (box[Rows(pos)][Columns(pos)] == ' ')
                                empty = pos;
                        }
                        if (co == 2 && empty != -1) {
                            box[Rows(empty)][Columns(empty)] = s1;
                            pc[i] = empty;
                            moved = true;
                            break;
                        }
                    }

                    // 2�?⃣ If not, block user's winning chance
                    if (!moved) {
                        for (int[] combo : winCombos) {
                            int co = 0, empty = -1;
                            for (int pos : combo) {
                                if (box[Rows(pos)][Columns(pos)] == s)
                                    co++;
                                else if (box[Rows(pos)][Columns(pos)] == ' ')
                                    empty = pos;
                            }
                            if (co == 2 && empty != -1) {
                                box[Rows(empty)][Columns(empty)] = s1;
                                pc[i] = empty;
                                moved = true;
                                break;
                            }
                        }
                    }

                    // 4�?⃣ Try going for forks
                    if (!moved) {
                        // Fork: AI took 1 and 6 → take 3
                        if ((pc[1] == 1 && pc[2] == 6) || (pc[1] == 6 && pc[2] == 1)) {
                            if (box[0][2] == ' ') {
                                box[0][2] = s1;
                                pc[i] = 3;
                            }
                        }

                        // Fork: AI took 1 and 9 → take 3 or 7
                        else if ((pc[1] == 1 && pc[2] == 9) || (pc[1] == 9 && pc[2] == 1)) {
                            if (box[0][2] == ' ') {
                                box[0][2] = s1;
                                pc[i] = 3;
                            } else if (box[2][0] == ' ') {
                                box[2][0] = s1;
                                pc[i] = 7;
                            }
                        }

                        // Fork: AI took 1 and 8 → take 7
                        else if ((pc[1] == 1 && pc[2] == 8) || (pc[1] == 8 && pc[2] == 1)) {
                            if (box[2][0] == ' ') {
                                box[2][0] = s1;
                                pc[i] = 7;
                            }
                        }

                        // Fork: AI took 3 and 7 → take 1
                        else if ((pc[1] == 3 && pc[2] == 7) || (pc[1] == 7 && pc[2] == 3)) {
                            if (box[0][0] == ' ') {
                                box[0][0] = s1;
                                pc[i] = 1;
                            }
                        }

                        // Fork: AI took 3 and 4 → take 1
                        else if ((pc[1] == 3 && pc[2] == 4) || (pc[1] == 4 && pc[2] == 3)) {
                            if (box[0][0] == ' ') {
                                box[0][0] = s1;
                                pc[i] = 1;
                            }
                        }

                        // Fork: AI took 3 and 8 → take 9
                        else if ((pc[1] == 3 && pc[2] == 8) || (pc[1] == 8 && pc[2] == 3)) {
                            if (box[2][2] == ' ') {
                                box[2][2] = s1;
                                pc[i] = 9;
                            }
                        }

                        // Fork: AI took 7 and 6 → take 9
                        else if ((pc[1] == 7 && pc[2] == 6) || (pc[1] == 6 && pc[2] == 7)) {
                            if (box[2][2] == ' ') {
                                box[2][2] = s1;
                                pc[i] = 9;
                            }
                        }

                        // Fork: AI took 7 and 2 → take 1
                        else if ((pc[1] == 7 && pc[2] == 2) || (pc[1] == 2 && pc[2] == 7)) {
                            if (box[0][0] == ' ') {
                                box[0][0] = s1;
                                pc[i] = 1;
                            }
                        }

                        // Fork: AI took 9 and 1 → take 3 or 7
                        else if ((pc[1] == 9 && pc[2] == 1) || (pc[1] == 1 && pc[2] == 9)) {
                            if (box[0][2] == ' ') {
                                box[0][2] = s1;
                                pc[i] = 3;
                            } else if (box[2][0] == ' ') {
                                box[2][0] = s1;
                                pc[i] = 7;
                            }
                        }

                        // Fork: AI took 9 and 2 → take 3
                        else if ((pc[1] == 9 && pc[2] == 2) || (pc[1] == 2 && pc[2] == 9)) {
                            if (box[0][2] == ' ') {
                                box[0][2] = s1;
                                pc[i] = 3;
                            }
                        }

                        // Fork: AI took 9 and 4 → take 7
                        else if ((pc[1] == 9 && pc[2] == 4) || (pc[1] == 4 && pc[2] == 9)) {
                            if (box[2][0] == ' ') {
                                box[2][0] = s1;
                                pc[i] = 7;
                            }
                        }

                    }

                    // 3�?⃣ Else, play a good spot (corners > sides)
                    if (!moved) {
                        int[] priority = { 1, 3, 7, 9, 6, 4, 2, 8 };
                        for (int pos : priority) {
                            if (box[Rows(pos)][Columns(pos)] == ' ') {
                                box[Rows(pos)][Columns(pos)] = s1;
                                pc[i] = pos;
                                moved = true;
                                break;
                            }
                        }
                    }
                }
                System.out.println("Enter chooses the position "+pc[i]);
                printBoard(box);
            }

            // For input in a place which is already filled
            else {
                System.out.println("🚫That spot is already taken. Try again.");
                i--; // repeat turn
                printBoard(box);
            }

            String result = checkGameStatus(box, s, s1);
            if (result.equals("Player")) {
                printBoard(box);
                System.out.println("🎉 CONGRATULATIONS! YOU WON! U R SIMPLYYY AWESOMEEEEEEEEEEEEE!🏆 ");
                w++;
                break;
            } else if (result.equals("Computer")) {
                printBoard(box);
                System.out.println("💻🤖 COMPUTER WINS. Better luck next time!");
                wc++;
                break;
            } else if (result.equals("Tie")) {
                printBoard(box);
                System.out.println("🤝 IT'S A TIE! WELL PLAYED!");
                t++;
                break;
            } else
                continue;
        }
        System.out.println("🧍No. of times player won= "+w);
        System.out.println("🧠No. of times computer won= "+wc);
        System.out.println("🤝No. of ties= "+t);
        System.out.println();

        System.out.println("Do you want to play again? (yes/no): ");
        String ans="";
        while(true)
        {
            ans = sc.next().toLowerCase();
            if(ans.equals("yes")||ans.equals("no"))
            {
                break;
            }
            else
            {
                System.out.println("🚫INVALID INPUT. TRY AGAIN!");
                continue;
            }
        }
        if (ans.equals("yes")) {
            continue;
        } else {
            System.out.println("🙏Thanks for playing!🙏");
            break;
        }
    }
    }

    public static void displayPositionGuide() {
        System.out.println();
        System.out.println("Here's how the board positions are numbered:");
        System.out.println();
        System.out.println(" 1 | 2 | 3 ");
        System.out.println("---+---+---");
        System.out.println(" 4 | 5 | 6 ");
        System.out.println("---+---+---");
        System.out.println(" 7 | 8 | 9 ");
        System.out.println();
    }

    public static void printBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print(" ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == '\0' ? ' ' : board[i][j]); // show blank if empty
                if (j < 2)
                    System.out.print(" | ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("---+---+---");
        }
        System.out.println();
    }

    public static int Rows(int p) {
        if (p <= 3)
            return 0;
        else if (p <= 6)
            return 1;
        else
            return 2;
    }

    public static int Columns(int p) {
        if (p == 1 || p == 4 || p == 7)
            return 0;
        else if (p == 2 || p == 5 || p == 8)
            return 1;
        else
            return 2;
    }

    public static String checkGameStatus(char[][] box, char playerSymbol, char compSymbol) {
        int[][] winCombos = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 }, { 1, 5, 9 },
                { 3, 5, 7 } };

        for (int[] combo : winCombos) {
            char a = box[Rows(combo[0])][Columns(combo[0])];
            char b = box[Rows(combo[1])][Columns(combo[1])];
            char c = box[Rows(combo[2])][Columns(combo[2])];

            if (a == b && b == c && a != ' ') {
                if (a == playerSymbol) {
                    return "Player";
                } else
                    return "Computer";
            }
        }
        boolean full = true;
        for (int i = 1; i <= 9; i++) {
            if (box[Rows(i)][Columns(i)] == ' ') {
                full = false;
                break;
            }
        }
        if (full)
            return "Tie";
        else
            return "None";

    }
}
