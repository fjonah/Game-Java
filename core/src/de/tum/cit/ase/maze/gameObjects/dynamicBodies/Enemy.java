package de.tum.cit.ase.maze.gameObjects.dynamicBodies;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import de.tum.cit.ase.maze.MazeRunnerGame;


/**
 * The class Enemy represents the enemies (ghosts) within the MazeRunner Game
 * It extends the DynamicBodies Class
 */
public class Enemy extends DynamicBodies {

    // Texture
    private TextureRegion enemyTexture;

    // Movement Attributes
    private float movementInterval = 1.0f; // Time in seconds after which direction changes
    private float timeSinceLastDirectionChange = 0.0f;
    private Vector2 currentDirection = new Vector2();
    private final float speed = 0.5f; // Enemy movement speed


    /**
     * Constructor for the Enemy class
     * @param x the x coordinate of the Enemy
     * @param y the y coordinate of the Enemy
     * @param width the width of the Enemy
     * @param height the height of the Enemy
     * @param game The main game class, used to access global resources and methods.
     */
    public Enemy(float x, float y, float width, float height, MazeRunnerGame game) {
        super(x, y, width, height, game);
        this.enemyTexture = new TextureRegion(getMobs(), 6 * getMOB_SIZE(), 4 * getMOB_SIZE(), getMOB_SIZE(), getMOB_SIZE());
    }


    // Movement Methods
    // Disclaimer: For the idea and enhancement of the enemies movement methods, the language model ChatGPT was used.

    /**
     * Method which is called every frame to randomly move the enemies within the maze
     * Before moving the enemies it checks for collisions with Walls and exits
     * calls other helper methods
     * @param delta the timeFrame of the render Method in the GameScreen Class
     */
    public void move(float delta) {
        timeSinceLastDirectionChange += delta;

        // Change direction at regular intervals
        if (timeSinceLastDirectionChange >= movementInterval) {
            changeDirection();
            timeSinceLastDirectionChange = 0;
        }

        // Perform collision check
        collisionCheck(delta, speed);
        exitCheck(delta, speed);

        // Calculate potential new position
        float newX = getX() + currentDirection.x * speed * delta;
        float newY = getY() + currentDirection.y * speed * delta;

        // Boundary checks
        if (newX < 0 || newX >= getGame().getMaze().getMaxTileX() * getSPRITE_SIZE() - 1) {
            currentDirection.x = -currentDirection.x; // Reverse direction
        }
        if (newY < 0 || newY >= getGame().getMaze().getMaxTileY() * getSPRITE_SIZE() - 1) {
            currentDirection.y = -currentDirection.y; // Reverse direction
        }

        // Move in the chosen direction if no collision and within boundaries
        if (canMoveInDirection(currentDirection)) {
            setX(newX);
            setY(newY);
            setBounds(getX(), getY()); // Update bounds of the enemy to the new position
        }
    }


    /**
     * Method to make the enemy change direction randomly
     */
    private void changeDirection() {
        // Randomly choose a direction: up, down, left, or right
        int direction = MathUtils.random(0, 3);
        currentDirection.set(0, 0);

        switch (direction) {
            case 0: currentDirection.x = -1; break; // Left
            case 1: currentDirection.x = 1; break;  // Right
            case 2: currentDirection.y = -1; break; // Down
            case 3: currentDirection.y = 1; break;  // Up
        }
    }

    /**
     * Method to check for collisions with the walls and the outside bounds so the enemies stay on the given paths
     * @param direction vector with x and y coordinates that specifies the direction in which the enemies are moving
     * @return returns true, if the enemies can move in the direction given by the vector, false otherwise
     */
    private boolean canMoveInDirection(Vector2 direction) {
        // Use the collision check results to determine if the enemy can move in the chosen direction
        if (direction.x < 0 && !isCanMoveLeft()) return false;
        if (direction.x > 0 && !isCanMoveRight()) return false;
        if (direction.y < 0 && !isCanMoveDown()) return false;
        if (direction.y > 0 && !isCanMoveUp()) return false;
        return true;
    }



    //Getter & Setter
    public TextureRegion getEnemyTexture() {
        return enemyTexture;
    }


}
