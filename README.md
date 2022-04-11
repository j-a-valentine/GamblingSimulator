# GamblingSimulator

The main purpose of our project is to create a gambling simulator that will allow the user to play different casino games such as Roulette or Blackjack. Our program keeps track of the player's balance and allows the user to deposit/withdraw money from their accounts to play different games, much like a real casino. We plan on implementing a few games with engaging user interfaces.

**Running the Program**

Either run script.sh or use the following commands
	
	- javac -d bin src/simulator/*.java
		
	- java -cp bin simulator.Main
	

**Iteration 1:**

	- BankAccount object that can manage the users transactions
	
	- Pocket object that stores the bets on each number
	
	- Roulette object where the user places bets
	
	- Unit tests for BankAccount, Pocket, and Roulette
	
	- A setup for the user to watch roullete (NO UI YET)
		- We will be increasing the functionality of our porgram to allow for users to play and interact with the game, but at the current moment, 		     the program is preset.
	
	
	
	
**Iteration 2:**

	- A GamblingSystem object that handles interactions between BankAccounts and Roulette
	
	- Adding a better UI in the GamblingSystem
	
	- Cleaning up the code from Roulette
	
	
**Goals for Iteration 3:**

	- Add a second game

