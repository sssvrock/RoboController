package com.test.robocontroller;

import java.util.Scanner;

public class RoboMover {

	int fieldSizeRow, fieldSizeCol;
	int x = 0, y = 0;
	String roboMoves;
	char currentRoboDirection;

	public static void main(String args[]) {
		RoboMover roboMover = new RoboMover();
		roboMover.readInputData();
	}

	public void readInputData() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Input for field size: (row X Col): ");
		fieldSizeRow = scanner.nextInt();
		fieldSizeCol = scanner.nextInt();

		x = scanner.nextInt();
		y = scanner.nextInt();
		
		currentRoboDirection = scanner.next().charAt(0);

		roboMoves = scanner.next();

		moveRobot(roboMoves);

	}

	public void moveRobot(String roboMove) {

		for (int i = 0; i < roboMove.length(); i++) {
			
			char dir = roboMove.charAt(i);
			
			switch (dir) {
			
			case 'P':
				if (currentRoboDirection == 'N')
					currentRoboDirection = 'W';
				else if (currentRoboDirection == 'W')
					currentRoboDirection = 'S';
				else if (currentRoboDirection == 'S')
					currentRoboDirection = 'E';
				else if (currentRoboDirection == 'E')
					currentRoboDirection = 'N';
				break;
				
			case 'R':
				if (currentRoboDirection == 'N')
					currentRoboDirection = 'E';
				else if (currentRoboDirection == 'E')
					currentRoboDirection = 'S';
				else if (currentRoboDirection == 'S')
					currentRoboDirection = 'W';
				else if (currentRoboDirection == 'W')
					currentRoboDirection = 'N';
				break;

			case 'Q':

				try {

					switch (currentRoboDirection) {
					case 'N':
						y++; // When facing North, increment y position
						break;
					case 'S':
						y--; // When facing south, decrement y position
						break;
					case 'E':
						x++; // When facing East, increment x position
						break;
					case 'W':
						x--; // When facing West, decrement x position
						break;
					}
				} catch (IllegalStateException ise) {
					System.out.println(ise.getLocalizedMessage());
				}

				break;
			default:
				break;
			}
		}

		if (x <= 0 || y <= 0 || x > 5 || y > 5) {
			System.out.println("Robot Can't Move, field area ends here...");
		} else {
			System.out.println(x + " " + y + " " + currentRoboDirection);
		}
	}

}
