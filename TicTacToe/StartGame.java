package TicTacToe;

import java.util.Scanner;

public class StartGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] board = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String p1, p2;

		System.out.print("Enter player 1 name: ");
		p1 = sc.nextLine();
		System.out.print("Enter player 2 name: ");
		p2 = sc.nextLine();

//builds board
		int x = 0;
		while (x < 9) {
			System.out.println("   |   |   ");
			System.out.println(" " + board[x] + " | " + board[x + 1] + " | " + board[x + 2]);
			System.out.println("   |   |   ");
			if (x < 6) {
				System.out.println("------------");
			}
			x += 3;
		}

		int x1 = 0;
		System.out.println();
		System.out.println();
		playerpick(board, p1, p2, x1, sc);

	}

	// ------------------------------New
	// Method-----------------------------------------
	public static void playerpick(String[] a, String p1, String p2, int x, Scanner sc) {
		String pick;
		if (x == 0) {
			System.out.print(p1 + ", Enter a # between 1-9: ");
			pick = sc.nextLine();
			if (check(pick, a)) {
				a[Integer.parseInt(pick) - 1] = "X";
				x++;
				drawBoard(a);
				if (p1win(a)) {
					victory(p1, sc, p1, p2, a);
				} else if (p1win(a) == false && p2win(a) == false && boardfull(a) == true) {
					System.out.println("It's Tie");
					System.out.println("Press enter to continue....");
					String s = sc.nextLine();
					playAgain(sc, a, p1, p2);
				}
				playerpick(a, p1, p2, x, sc);
			} else {
				System.out.println("Already taken or Invalid. Pick another number which isn't taken and between 1-9.");
				x = 0;
				playerpick(a, p1, p2, x, sc);
			}
		}
			if (x == 1) {
				System.out.print(p2 + ", Enter a # between 1-9: ");
				pick = sc.nextLine();
				if (check(pick, a)) {
					a[Integer.parseInt(pick) - 1] = "O";
					x--;
					drawBoard(a);
					if (p2win(a)) {
						victory(p2, sc, p1, p2, a);
					} else if (p1win(a) == false && p2win(a) == false && boardfull(a) == true) {
						System.out.println("It's Tie");
						playAgain(sc, a, p1, p2);
					}
					playerpick(a, p1, p2, x, sc);
				} else {
					System.out.println("Already taken or Invalid. Pick another number which isn't taken and between 1-9.");
					x = 1;
					playerpick(a, p1, p2, x, sc);
				}
			}
		
		
	}

	// ------------------------------New
	// Method-----------------------------------------

	public static boolean check(String p, String[] a) {
		boolean run = false;
		int x = Integer.parseInt(p);
		if ((x > 0 && x < 10)) {
			if (!a[x - 1].equals("X") && !a[x - 1].equals("O")) {
				run = true;
			}
		}
		return run;
	}

	// ------------------------------New
	// Method-----------------------------------------
	public static boolean p1win(String[] a) {
		boolean test = false;

		if ((a[0].equals("X") && a[1].equals("X") && a[2].equals("X"))
				|| (a[0].equals("X") && a[3].equals("X") && a[6].equals("X"))
				|| (a[1].equals("X") && a[4].equals("X") && a[7].equals("X"))
				|| (a[2].equals("X") && a[5].equals("X") && a[8].equals("X"))
				|| (a[0].equals("X") && a[4].equals("X") && a[8].equals("X"))
				|| (a[2].equals("X") && a[4].equals("X") && a[6].equals("X"))) {
			test = true;
		}
		return test;
	}

	// ------------------------------New
	// Method-----------------------------------------
	public static boolean p2win(String[] a) {
		boolean test = false;

		if ((a[0].equals("O") && a[1].equals("O") && a[2].equals("O"))
				|| (a[0].equals("O") && a[3].equals("O") && a[6].equals("O"))
				|| (a[1].equals("O") && a[4].equals("O") && a[7].equals("O"))
				|| (a[2].equals("O") && a[5].equals("O") && a[8].equals("O"))
				|| (a[0].equals("O") && a[4].equals("O") && a[8].equals("O"))
				|| (a[2].equals("O") && a[4].equals("O") && a[6].equals("O"))) {
			test = true;
		}
		return test;
	}

	// ------------------------------New
	// Method-----------------------------------------
	public static void victory(String n, Scanner sc, String p1, String p2, String[] a) {
		System.out.println(n + " wins!!!");
		// work on restating the play again. the code just continues after the win.
		playAgain(sc, a, p1, p2);

	}

	// ------------------------------New
	// Method-----------------------------------------
	public static boolean boardfull(String[] n) {
		boolean x = false;

		int count = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i].equals("X") || (n[i].equals("O"))) {
				count++;
			}
		}
		if (count == 9) {
			x = true;
		}
		return x;
	}

	// ------------------------------New
	// Method-----------------------------------------
	public static void playAgain(Scanner sc, String[] a, String p1, String p2) {
		System.out.println("Press Enter to continue....");
		String l = sc.nextLine();

		System.out.print("Do you want to play again? (y/n): ");
		String ask = sc.nextLine();

		ask = ask.toLowerCase();
		while (!ask.equals("y") && !ask.equals("n")) {
			System.out.print("Invalid. Please enter 'y' or 'n': ");
			ask = sc.nextLine();
			ask = ask.toLowerCase();
		}

		if (ask.equals("y")) {
			int x = 0;
			for (int i = 0; i < 30; i++) {
				System.out.println();
			}
			
			System.out.println("--------------------------------------------------------------------------------");
			for(int i=0; i<9; i++) {
				a[i]=Integer.toString(i+1);
			}
			int u = 0;
			while (u < 9) {
				System.out.println("   |   |   ");
				System.out.println(" " + a[u] + " | " + a[u + 1] + " | " + a[u + 2]);
				System.out.println("   |   |   ");
				if (u< 6) {
					System.out.println("------------");
				}
				u += 3;
			}
			playerpick(a, p1, p2, x, sc);
		}
		if (ask.equals("n")) {
			System.out.println("Thanks for playing!");
			System.out.println("Press enter to exit.....");
			String n = sc.nextLine();
			System.exit(0);
		}

	}

	// ------------------------------New
	// Method-----------------------------------------
	static void drawBoard(String[] board) {
		int x = 0;
		while (x < 9) {
			System.out.println("   |   |   ");
			System.out.println(" " + board[x] + " | " + board[x + 1] + " | " + board[x + 2]);
			System.out.println("   |   |   ");
			if (x < 6) {
				System.out.println("------------");
			}
			x += 3;
		}
		System.out.println();
		System.out.println();

	}
}
