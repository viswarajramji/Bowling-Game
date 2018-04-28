import java.util.Arrays;
import java.util.Scanner;

/**@author viswarajramji kumar*/

class StartBowlingGame {

	private int N;
	private int[] rolls;
	protected Scanner scan;
	private final static int TEN = 10;
	
	
	/**Constructor
	 * @param:N - Number of Rolls
	 **/
	StartBowlingGame(int N) {
		this.N = N;
		rolls = new int[(N * 2) + 1];
		scan = new Scanner(System.in);
	}
		
	private int getPinsDown(int pointer, int value) {
		return rolls[pointer] = (rolls[pointer] != -1) ? rolls[pointer]
				: getPinDownCount(value == 10 ? 0 : value);
	}
	
	/**
	 * Calculates the Score + data Validation + Next Attempt
	 **/
	protected int runTimeScoreCal() {
		Arrays.fill(rolls, -1);
		int score = 0;
		int pointer = 0;
		for (int i = 0; i < N; i++) {
			rolls[pointer] = getPinsDown(pointer, 0);
			if (rolls[pointer] == TEN) {
				/** if Strike */
				score += TEN + getPinsDown(pointer + 1, 0)+ getPinsDown(pointer + 2, rolls[pointer + 1]);
				pointer++;
			} else if (rolls[pointer]+ getPinsDown(pointer + 1, rolls[pointer]) == TEN) {
				/** if Spare */
				score += TEN + getPinsDown(pointer + 2, 0);
				pointer += 2;
			} else {
				score += rolls[pointer] + rolls[pointer + 1];
				pointer += 2;
			}
			System.out.println("---------------");
			System.out.println("Result of Round " + (i + 1) + " : " + score);
			System.out.println("---------------");
		}
		return score;
	}

	/**gets the I/P from the console*/
	protected String getScannerInput() {
		return scan.next();
	}
	

	protected int score() {
		int score = 0;
		int pointer = 0;
		for (int i = 0; i < N; i++) {
			if (rolls[pointer] == TEN) {
				/** if Strike */
				score += TEN + rolls[pointer + 1] + rolls[pointer + 2];
				pointer++;
			} else if (rolls[pointer] + rolls[pointer + 1] == TEN) {
				/** if Spare */
				score += TEN + rolls[pointer + 2];
				pointer += 2;
			} else {
				score += rolls[pointer] + rolls[pointer + 1];
				pointer += 2;
			}
		}
		return score;
	}
	
	/** Controls the Game */
	public void startGameController() {
		do {
			System.out
					.println("\n1-> Calculate Score(End of All Rolls) \n2-> Calculate Score(After Each Roll) \n3-> Exit");
			String ch = getScannerInput();
			switch (ch) {
			case "1":
				/** resetting for the next operation */
				getPinsDown();
				System.out.println("Score :" + score());
				break;
			case "2":
				System.out.println("Final Score for all the Rolls :" + runTimeScoreCal());
				break;
			case "3":
				return;
				/** System.exit(0) can also be used */
			default:
				System.out.println("No Option");
			}

		} while (true);
	}
	
    /**auto data validation and loop until proper input is given */
	private int getPinDownCount(int temp) {
		while (true) {
			try {
				System.out.println("Enter Pin Down Values from 0 to "
						+ (10 - temp));
				int value = Integer.parseInt(getScannerInput());
				if (value >= 0 && value <= TEN - temp) {
					if (value == 10 && temp == 0)
						System.out.println("  => RESULT : Wow!! that's a Strike!!");
					else if (value + temp == 10)
						System.out.println("  => RESULT : Great!! that's a Spare!!");
					else
						System.out.println("  => RESULT :Nice Try!!");
					return value;
				}
			} catch (NumberFormatException ex) {
			}
			System.out.println(" => INVALID NUMBER");
		}
	}
	
	/**Handles in getting the inputs*/
	protected void getPinsDown() {
		int j = 0;
		/**Resetting the Values */
		Arrays.fill( rolls, 0);
		/**Get all the rolls Pin Down Values*/
		for (int i = 0; i < N - 1; i++) {
			System.out.println("Roll :" + (i + 1));
			int value = getPinDownCount(0);
			if (value != 10) {
				int temp = value;
				value = getPinDownCount(temp);
				rolls[j++]=temp;
			}
			rolls[j++]=value;
		}

		/**Handling the Last Roll Scenario */
		System.out.println("Roll :" + N);
		boolean isSpare = false;
		rolls[j++] = getPinDownCount(0);
		int temp = (rolls[j - 1] != TEN) ? rolls[j - 1] : 0;
		rolls[j++]=getPinDownCount(temp);
		if (rolls[j - 1] + rolls[j - 2] == TEN) {
			isSpare = true;
		}
		if (rolls[j - 1] == TEN || rolls[j - 2] == TEN || isSpare) {
			temp = isSpare ? 0 : (rolls[j - 1] != TEN) ? rolls[j - 1] : 0;
			rolls[j++]=getPinDownCount(temp);
		}
	}
}
public class BowlingGame {
	public static void main(String args[]) {
		/** @Constructor params : Number of Rolls Allowed **/
		System.out.println("Application Started ");
		StartBowlingGame gamee = new StartBowlingGame(10);
	    gamee.startGameController();
		System.out.println("Application Closed ");
	}
}
