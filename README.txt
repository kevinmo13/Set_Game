@author: Kevin Mo

This is where the three asked for methods lie:

1. A method that takes three cards, and determines whether the three cards make a set: GameSet.isSet()
2. A method that given a "board" of cards, will either find a set, or determine if there are no sets on the table: Player.findSet()
3. A method that will play an entire game of Set, from beginning to end, and return a list of each valid sets you removed from the board: Game.playGame()

Unittests have been created for all classes except for Game. The methods GameSet.isSet() and Player.findSet() are both tested
in the unittests. Game is tested using the GameLauncher class where a game can be simulated and the sets removed are printed out
as well as all the remaining cards on the board that cannot be formed into sets.
