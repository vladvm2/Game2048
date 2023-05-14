import java.util.Scanner;

public class Game2048 {
    public static void main(String[] args) {
        // Crearea unui obiect Scanner pentru a citi intrările utilizatorului
        Scanner sc = new Scanner(System.in);
        // Crearea tablei de joc 2048 cu dimensiunea 4x4
        int[][] board = new int[4][4];
        // Variabila booleana pentru a verifica daca jocul este inca in desfasurare
        boolean gameover = false;

        // Configurarea initiala a tablei de joc
        for (int i = 0; i < 2; i++) {
            int row, col;
            // Genereaza aleatoriu coordonate pentru a plasa un nou numar pe tabla de joc, daca aceste coordonate nu sunt ocupate deja.
            do {
                row = (int) (Math.random() * 4);
                col = (int) (Math.random() * 4);
            } while (board[row][col] != 0);
            // Plasarea valorii 2 pe tabla de joc pe coordonatele alese
            board[row][col] = 2;
        }
        while (!gameover) {
            // Afisarea tablei de joc
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(board[i][j] + "\t");
                }
                System.out.println();
            }
            // Asteptarea si citirea input-ului de la utilizator cu privire la directia in care sa se mute piesele
            System.out.println("Enter direction (up/down/left/right):");
            String direction = sc.nextLine();
            // Mutarea pieselor pe tabla de joc in functie de directia aleasa de utilizator

            switch (direction) {
                case "up":
                    // Implementarea mutarilor pentru directia "up" (spre sus)
                    for (int j = 0; j < 4; j++) {
                        if (board[1][j] != 0) {
                            int k;
                            for (k = 1 - 1; k >= 0 && board[k][j] == 0; k--) ;
                            if (k >= 0 && board[k][j] == board[1][j]) {
                                board[k][j] *= 2;
                                board[1][j] = 0;
                            } else if (k < 1 - 1) {
                                board[k + 1][j] = board[1][j];
                                board[1][j] = 0;
                            }
                        }
                        if (board[2][j] != 0) {
                            int k;
                            for (k = 2 - 1; k >= 0 && board[k][j] == 0; k--) ;
                            if (k >= 0 && board[k][j] == board[2][j]) {
                                board[k][j] *= 2;
                                board[2][j] = 0;
                            } else if (k < 2 - 1) {
                                board[k + 1][j] = board[2][j];
                                board[2][j] = 0;
                            }
                        }
                        if (board[3][j] != 0) {
                            int k;
                            for (k = 3 - 1; k >= 0 && board[k][j] == 0; k--) ;
                            if (k >= 0 && board[k][j] == board[3][j]) {
                                board[k][j] *= 2;
                                board[3][j] = 0;
                            } else if (k < 3 - 1) {
                                board[k + 1][j] = board[3][j];
                                board[3][j] = 0;
                            }
                        }
                    }
                    break;
                case "down":
                    // Implementarea mutarilor pentru directia "down" (spre jos)
                    for (int j = 0; j < 4; j++) {
                        if (board[2][j] != 0) {
                            int k;
                            for (k = 2 + 1; k < 4 && board[k][j] == 0; k++) ;
                            if (k < 4 && board[k][j] == board[2][j]) {
                                board[k][j] *= 2;
                                board[2][j] = 0;
                            } else if (k > 2 + 1) {
                                board[k - 1][j] = board[2][j];
                                board[2][j] = 0;
                            }
                        }
                        if (board[1][j] != 0) {
                            int k;
                            for (k = 1 + 1; k < 4 && board[k][j] == 0; k++) ;
                            if (k < 4 && board[k][j] == board[1][j]) {
                                board[k][j] *= 2;
                                board[1][j] = 0;
                            } else if (k > 1 + 1) {
                                board[k - 1][j] = board[1][j];
                                board[1][j] = 0;
                            }
                        }
                        if (board[0][j] != 0) {
                            int k;
                            for (k = 0 + 1; k < 4 && board[k][j] == 0; k++) ;
                            if (k < 4 && board[k][j] == board[0][j]) {
                                board[k][j] *= 2;
                                board[0][j] = 0;
                            } else if (k > 0 + 1) {
                                board[k - 1][j] = board[0][j];
                                board[0][j] = 0;
                            }
                        }
                    }
                    break;


                case "left":
                    // Implementarea mutarilor pentru directia "left" (spre stanga)
                    for (int i = 0; i < 4; i++) {
                        if (board[i][1] != 0) {
                            int k;
                            for (k = 1 - 1; k >= 0 && board[i][k] == 0; k--) ;
                            if (k >= 0 && board[i][k] == board[i][1]) {
                                board[i][k] *= 2;
                                board[i][1] = 0;
                            } else if (k < 1 - 1) {
                                board[i][k + 1] = board[i][1];
                                board[i][1] = 0;
                            }
                        }
                        if (board[i][2] != 0) {
                            int k;
                            for (k = 2 - 1; k >= 0 && board[i][k] == 0; k--) ;
                            if (k >= 0 && board[i][k] == board[i][2]) {
                                board[i][k] *= 2;
                                board[i][2] = 0;
                            } else if (k < 2 - 1) {
                                board[i][k + 1] = board[i][2];
                                board[i][2] = 0;
                            }
                        }
                        if (board[i][3] != 0) {
                            int k;
                            for (k = 3 - 1; k >= 0 && board[i][k] == 0; k--) ;
                            if (k >= 0 && board[i][k] == board[i][3]) {
                                board[i][k] *= 2;
                                board[i][3] = 0;
                            } else if (k < 3 - 1) {
                                board[i][k + 1] = board[i][3];
                                board[i][3] = 0;
                            }
                        }
                    }
                    break;


                case "right":
                    // Implementarea mutarilor pentru directia "right" (spre dreapta)
                    for (int i = 0; i < 4; i++) {
                        if (board[i][2] != 0) {
                            int k;
                            for (k = 2 + 1; k < 4 && board[i][k] == 0; k++) ;
                            if (k < 4 && board[i][k] == board[i][2]) {
                                board[i][k] *= 2;
                                board[i][2] = 0;
                            } else if (k > 2 + 1) {
                                board[i][k - 1] = board[i][2];
                                board[i][2] = 0;
                            }
                        }
                        if (board[i][1] != 0) {
                            int k;
                            for (k = 1 + 1; k < 4 && board[i][k] == 0; k++) ;
                            if (k < 4 && board[i][k] == board[i][1]) {
                                board[i][k] *= 2;
                                board[i][1] = 0;
                            } else if (k > 1 + 1) {
                                board[i][k - 1] = board[i][1];
                                board[i][1] = 0;
                            }
                        }
                        if (board[i][0] != 0) {
                            int k;
                            for (k = 0 + 1; k < 4 && board[i][k] == 0; k++) ;
                            if (k < 4 && board[i][k] == board[i][0]) {
                                board[i][k] *= 2;
                                board[i][0] = 0;
                            } else if (k > 0 + 1) {
                                board[i][k - 1] = board[i][0];
                                board[i][0] = 0;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid direction! Please enter a valid direction.");
            }
        }
    }
}
