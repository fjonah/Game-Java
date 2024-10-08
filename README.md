# MAZE RUNNERS

## Introduction

Welcome to Maze Runner, an maze-themed adventure game developed with the help of LibGDX. In Maze Runner, the player navigates through a maze, containing obstacles and enemies, which he has to avoid. With every collision he looses one of his life's. In order to win, the player has to find and collect a key to open the exit doors and then find the exit of the maze before he looses all his lifes.


## Features
Maze Runner has various elements that enhance the gameplay experience. Key features of the game include:

-   **HUD**: Displays information such as the remaining lives of the character and the key collection status.
-   **Character Movement**: Players can navigate the character through the maze's open paths, in four directions: right, left, up, and down.
-   **Enemies (Ghosts)**: Ghosts move randomly within the maze and present a challenge by reducing the player's lives upon collision.
-   **Traps (Fire)**: Stationary fire traps that diminish the player's lives upon contact, adding an element of danger
-   **Collectible Keys**: A key must be collected to exit the maze. Once collected, it disappears from the maze, and the HUD updates to indicate its collection.
-   **Impassable Walls**: Static walls form the maze's structure, creating barriers that neither the character nor enemies can pass through.
-   **Exit Gate**: The exit becomes accessible for the player only after he has found the key. Before that the exit is closed.
-   **EntryPoint**: Marks the starting position of the player, setting the stage for the maze adventure.


## How to play
Maze Runner is an intriguing game that combines strategy, quick thinking, and a bit of luck. Here's how you can dive into the adventure:

1.  **Choosing a level**: Before starting the game, you have to choose a properties files, which will specifiy the level on which you will be playing.

2. **Starting the Game**: Begin at the EntryPoint, where your character is placed at the start of the maze.

4.  **Navigation**: Use your keyboard arrows to move the character. You can move up, down, left, or right along the open paths of the maze.

5.  **Avoiding Obstacles**: Stay alert for Ghosts and Fires. Colliding with either will cost you a life.

6.  **Collecting the Key**: Explore the maze to find a key. Once collected, the key allows you to leave through the exit. The HUD will update to show that the key has been collected.

7.  **Reaching the Exit**: After collecting the key, make your way to the Exit to complete the level and win the game.

8.  **Managing Lives**: Keep an eye on your remaining lives displayed on the HUD. The game ends if you lose all your lives.

9.  **Pause and Resume**: You can pause the game and resume from where you left off with pressing the ESC button, ensuring that you can take breaks without losing your progress.

Navigate through the maze to find the key, outsmart the obstacles, and find your way out of the maze!


## Class Hierarchy Overview

At the core of our game's architecture is the **Maze class**, which acts as a container for various **GameObjects**. These objects are categorized into **StaticBodies** and **DynamicBodies**, each serving distinct roles within the game.

### Maze and GameObjects
-   **Maze:** the Maze class holds lists of all game objects, including walls, traps, exits, entry points, enemies, and keys. This encapsulation allows for organized management of the game's elements.
-   **GameObjects:** These are split into two superclasses:
    -   **StaticBodies:** This category includes elements, which cannot change their positions like walls, traps, exits, entry points, and keys. These objects form the static structure of the mazes.
    -   **DynamicBodies:** Under this category fall the **Character** and **Enemy** classes, representing entities with the ability to move and interactive capabilities like collisions within the game.

### GameScreen

The game leverages different screens to create a structured user experience, managed through the following classes which all extend the screen superclass of libGDX:
-   **GameScreen:** The heart of the gameplay, where the action unfolds. It houses essential attributes like the game instance, maze, character, and other gameplay elements.
-   **MenuScreen:** The main menu interface, offering navigation options to the player.
-   **PauseScreen:** Similar to the MenuScreen, but includes an additional "Continue" button, allowing players to pause and resume their game.
-   **VictoryScreen and LooseScreen:** These screens are displayed based on the game's outcome, celebrating the player's victory or acknowledging their defeat. From there the player also can choose to go back to the menu to exit or start a new game!


*Disclaimer: For the creation of this README file, the language model ChatGPT was used for the purpose of grammar and spell checking, as well as to enhance readability and clarity.*
#   G a m e - J a v a 
 
 
