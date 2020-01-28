/** 
 * EN.605.201 Introduction to Java Programming
 * PacMan game using numbers as controls to change direction and move.
 * The aim is to eat cookies, represented as O.
 * Number of moves and cookies eaten are printed once the player exits the game.
 * 
 * @version		1.0 December 12, 2019
 * @author		shanzalewis
 */

import java.util.*;

public class PacMan {
    private static Scanner input = new Scanner(System.in);  //user input
    public static int move_count = 0;                       //counts number of moves during play
    public static int cookie_count = 0;                     //counts number of cookies eaten during play
    
    public static void main(String[] args) {
    	int width;                                          //width of game grid
    	int height;                                         //height of game grid
    	int command = 0;
    	
    	do {
    		System.out.print("Enter width of grid. Number should be greater than 3: ");
        	width = input.nextInt();                        //user enters width
    	} while (width < 3);
    	if (width < 3) {
    		System.out.println("Please enter an appropriate number: ");
    		width = input.nextInt(); 
    	}
    		
    	do {
    		System.out.print("Enter height of grid. Number should be greater than 3: ");
        	height = input.nextInt();                       //user enters height
    	} while (height < 3);
    	if (height < 3) {
    		System.out.println("Please enter an appropriate number: ");
    		height = input.nextInt(); 
    	}
    	
    	System.out.println();
    	String[][] grid = displayGrid(width, height);       //method call to display game grid
    	System.out.println();
    	
    	getMenu();                                          //method call for main menu
    	getCommand(grid, command, width, height);           //method call for user to enter game command
    }
    
    /*
     * Accepts user input and displays game grid in console.
     * 8% of the grid is cookies. Cookies are randomly places throughout game grid.
     * @param		width
     * @param		height
     * @return		String[][] grid 
     */
    public static String[][] displayGrid(int width, int height) {
    	int number_cookies = (int)((height * width) * 0.08); //calculates number of cookies at 8% of grid
    	String[][] grid = new String[height][width];         //array to hold cells in game grid
    	
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
    			int cookie_row = (int)(Math.random() * (height - 1) + 1);  //generates random placement of cookies
     
        		if (i == 0 && j == 0) {                      //sets first place in array as PacMan symbol
        			grid[i][j] = "<  ";
        		} else if (i == cookie_row && number_cookies > 0) {
        			grid[i][j] = "O  ";                      //place cookies randomly throughout grid
        			number_cookies--;                        //decrements number of cookies until all are placed
        		} else {
        			grid[i][j] = ".  ";                      //represents not visited cells in grid
        		}
        		
        		System.out.print(grid[i][j]);                //prints cells in game grid
    		}
    		System.out.println();                            //adds line between each row to create grid
    	}
    	return grid;
    }
    
    /*
     * Displays main menu. 
     * USer uses number beside each option to execute a command.
     */
    public static void getMenu() {
		System.out.println();
    	System.out.println ("Play options. Enter number beside option in the main menu to execute play:"
				+"\n1 - Menu"
				+"\n2 - Turn Left"
		        +"\n3 - Turn Right" 
		        +"\n4 - Move" 
		        +"\n5 - Exit");
	}
    
    /*
     * Accepts user's command from the main menu.
     * Calls the method for each command.
     * @param		String[][] grid
     * @param		int command
     * @param		int width
     * @param		int height
     */
    public static void getCommand(String[][] grid, int command, int width, int height) {
    	System.out.println();
    	System.out.print("Enter Command: ");
    	command = input.nextInt();
    	
    	if ((command <= 5) || (command > 0)) {
    		switch (command) {
    	    case 1:
    	    	getMenu();
    	    	getCommand(grid, command, width, height);
    	    	break;
    	    case 2:
    	    	getLeft(grid, command, width, height);
    	    	getCommand(grid, command, width, height);
    	    	break;
    	    case 3:
    	    	getRight(grid, command, width, height);
    	    	getCommand(grid, command, width, height);
    	    	break;
    	    case 4:
    	    	move(grid, command, width, height);
    	    	printGrid(grid, width, height);
    	    	getCommand(grid, command, width, height);
    	    	break;
    	    case 5:
    	    	exit(command);
    	    	break;
    	    default:
    	    	System.out.println("Please enter a valid menu option");
    	    	getMenu();
    	    	getCommand(grid, command, width, height);
    	    	break;
    		}
    	} else {
    		System.out.println("Please enter a valid menu option");
    		getMenu();
    	    getCommand(grid, command, width, height);
    	}
    }
    
    /*
     * Executes command to turn left.
     * Searches grid for current PacMan symbol and replaces it with the next symbol in the left-turn sequence.
     * @param		String[][] grid
     * @param		int command
     * @param		int width
     * @param		int height
     * @return		String[][] grid
     */
    public static String[][] getLeft(String [][] grid, int command, int width, int height) {
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
    			if (grid[i][j] == "<  ") {
    				grid[i][j] = "V  ";
    			} else if (grid[i][j] == "V  ") {
    				grid[i][j] = ">  ";
    			} else if (grid[i][j] == ">  ") {
    				grid[i][j] = "^  ";
    			} else if (grid[i][j] == "^  ") {
    				grid[i][j] = "<  ";
    			}
    			System.out.print(grid[i][j]);
    		}
    		System.out.println();
        }
    	getCommand(grid, command, width, height);
    	return (grid);
    }
    
    /*
     * Executes command to turn right.
     * Searches grid for current PacMan symbol and replaces it with the next symbol in the right-turn sequence.
     * @param		String[][] grid
     * @param		int command
     * @param		int width
     * @param		int height
     * @return		String[][] grid
     */
    public static String[][] getRight(String [][] grid, int command, int width, int height) {
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
    			if (grid[i][j] == "<  ") {
    				grid[i][j] = "^  ";
    			} else if (grid[i][j] == "^  ") {
    				grid[i][j] = ">  ";
    			} else if (grid[i][j] == ">  ") {
    				grid[i][j] = "V  ";
    			} else if (grid[i][j] == "V  ") {
    				grid[i][j] = "<  ";
    			}
    			System.out.print(grid[i][j]);
    		}
    		System.out.println();
    	}
    	getCommand(grid, command, width, height);
    	return (grid);
    }
    
    /*
     * Executes move command.
     * Searches for PacMan symbol in the grid. If the space being moved to is within the height and width of the grid 
     * and it has not been visited before, the PacMan moves to that space. If the space has a cookie, the PacMan eats
     * the cookie, says "Yum!," moves into the next space, and a blank space replaces the previous position.
     * If the space does not have a cookie, the PacMan moves into the space and a blank space replaces the previous position.
     * @param		String[][] grid
     * @param		int command
     * @param		int width
     * @param		int height
     * @return		String[][] grid
     */
    public static String[][] move(String [][] grid,int command, int width, int height) {
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
    			
    			if (grid[i][j] == "<  " ) {
    				if (((j + 1) < width) && (grid[i][j + 1] == ".  ")) { 
						grid[i][j] = "   ";                //checks if cell being moved to has been visited
	    				grid[i][j + 1] = "<  ";            //replaces new position with PacMan symbol
	    				move_count++;                      //increments when a move is made
	    				return grid;
					} else if (((j + 1) < width) && (grid[i][j + 1] == "O  ")) {
						grid[i][j] = "   ";                //checks if cell being moved to has a cookie
	    				grid[i][j + 1] = "<  ";            //replaces new position with PacMan symbol
	    				move_count++;
	    				cookie_count++;                    //increments when a cookie is eaten 
	    				System.out.println("Yum!");
	    				return grid;
	    			} else if (j > width) {                
	    				System.out.print(grid[i][j]);      //prints previous grid if PacMan tries to move beyond the bounds
	    			}                                      //PacMan does not move
    			}
    			
    			else if (grid[i][j] == "^  ") {
    				if (((i + 1) < height) && (grid[i + 1][j] == ".  ")) {
    					grid[i][j] = "   ";
        				grid[i + 1][j] = "^  ";
        				move_count++;
        				return grid;
    				} else if (((i + 1) < height) && (grid[i + 1][j] == "O  ")) {
    				    grid[i][j] = "   ";
        				grid[i + 1][j] = "^  ";
        				move_count++;
        				cookie_count++;;
        				System.out.println("Yum!");
        				return grid;
    				} else if (i > height) {
    					System.out.print(grid[i][j]);
        			}
    			}
    			
    			else if (grid[i][j] == ">  ") {
    				if (((j - 1) >= 0) && (grid[i][j - 1] == ".  ")) {
    					grid[i][j] = "   ";
        				grid[i][j - 1] = ">  ";
        				move_count++;
        				return grid;
        			} else if (((j - 1) >= 0) && (grid[i][j - 1] == "O  ")) {
    			    	grid[i][j] = "   ";
    				    grid[i][j - 1] = ">  ";
    				    move_count++;
        				cookie_count++;
        				System.out.println("Yum!");
        				return grid;
    			    } else if (j < 0) {
    				System.out.print(grid[i][j]);
    			    }
    			}
    			
    			else if (grid[i][j] == "V  ") {
    				if (((i - 1) >= 0) && (grid[i - 1][j] == ".  ")) {
    					grid[i][j] = "   ";
        				grid[i - 1][j] = "V  ";
        				move_count++;
        				return grid;
    			    } else if (((i - 1) >= 0) && (grid[i - 1][j] == "O  ")) {
    			    	grid[i][j] = "   ";
        				grid[i - 1][j] = "V  ";
        				move_count++;
        				cookie_count++;
        				System.out.println("Yum!");
        				return grid;
    			    } else if (i < 0) {
    				System.out.print(grid[i][j]);
    			    }
    			}
    		}
        }
        return grid;
    }
    
    /*
     * Displays grid after each command.
     * @param		String[][] grid
     * @param		int width
     * @param		int height
     */
    public static void printGrid(String [][] grid, int width, int height ) {
    	for (int i = 0; i < height; i++) {
    		for (int j = 0; j < width; j++) {
    			System.out.print(grid[i][j]);
    		}
    		System.out.println();
    	}
    }
    
    /*
     * Executes command to exit game.
     * Prints number of moves made and number of cookies eaten.
     */
    public static void exit(int command) {
    	System.out.println("Thanks for playing!");
    	System.out.println("Number of moves: " + move_count);
    	System.out.println("Number of cookies eaten: " + cookie_count);
    	System.exit(0);
    }	
}
