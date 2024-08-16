package de.tum.cit.ase.maze.gameObjects.dynamicBodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import de.tum.cit.ase.maze.MazeRunnerGame;
import de.tum.cit.ase.maze.gameObjects.staticBodies.Exit;
import de.tum.cit.ase.maze.gameObjects.staticBodies.Wall;

/**
 * The super class DynamicBodies has the two subclasses Character and Enemy
 * It is responsible for dynamic GameObjects who can change their initial position and
 * therefore need to be checked for collisions with walls and exits
 */

public class DynamicBodies {

    // Position Attributes
    private float width, height;
    private float x, y;
    private Rectangle bounds;
    private MazeRunnerGame game;

    // Texture Attributes
    private Texture mobs;
    private Texture characters;
    private final int MOB_SIZE = 16;
    private final int CHARACTER_WIDTH = 17;
    private final int CHARACTER_HEIGHT = 30;
    private final int SPRITE_SIZE = 32;
    private final int puffer = 11;

    // Collision Attributes
    private boolean canMoveRight = true;
    private boolean canMoveLeft = true;
    private boolean canMoveUp = true;
    private boolean canMoveDown = true;


    /**
     * Constructor for the DynamicBodies Class. Initializes the position attributes, the corresponding game and the bounds of the dynamic Objects
     * @param x the x coordinate of the dynamic GameObject
     * @param y the y coordinate of the dynamic GameObject
     * @param width the width of the dynamic GameObject
     * @param height the height of the dynamic GameObject
     * @param game The main game class, used to access global resources and methods.
     */
    public DynamicBodies(float x, float y, float width, float height, MazeRunnerGame game) {

        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.game = game;
        this.bounds = new Rectangle(x * SPRITE_SIZE,y * SPRITE_SIZE, width - puffer, height - puffer);

        // Textures
        characters = new Texture(Gdx.files.internal("character.png"));
        mobs = new Texture(Gdx.files.internal("mobs.png"));
    }


    /** Method to check if the position after movement will collide with one of the walls
     * if there is a collision, it sets the corresponding boolean value to false
     * @param delta the timeFrame of the render Method in the GameScreen Class
     * @param speed the speed of the GameObjects which specifies how fast it can change its position
     */
    public void collisionCheck(float delta, float speed){

        //Reset the collision attributes
        canMoveRight = canMoveLeft = canMoveUp = canMoveDown = true;

        // potential new x or y of the character
        float rightX = getX() + speed * delta;
        float leftX = getX() - speed * delta;
        float upY = getY() + speed * delta;
        float downY = getY() - speed * delta;

        // potential new Bounds of the character
        Rectangle right = new Rectangle(rightX * SPRITE_SIZE, y * SPRITE_SIZE, width - puffer, height - puffer);
        Rectangle left = new Rectangle(leftX * SPRITE_SIZE, y * SPRITE_SIZE, width - puffer, height - puffer);
        Rectangle up = new Rectangle(x * SPRITE_SIZE, upY * SPRITE_SIZE, width - puffer, height - puffer);
        Rectangle down = new Rectangle(x * SPRITE_SIZE, downY * SPRITE_SIZE, width - puffer, height - puffer);

        // Iterating through the Wall Objects of the maze
        for (Wall wall : game.getMaze().getWalls()) {
            if (right.overlaps(wall.getBounds())) {
                canMoveRight = false;
            }
            if (left.overlaps(wall.getBounds())) {
                canMoveLeft = false;
            }
            if (up.overlaps(wall.getBounds())) {
                canMoveUp = false;
            }
            if (down.overlaps(wall.getBounds())) {
                canMoveDown = false;
            }
        }
    }


    /** Method to check if the position after movement will collide with the exits
     * if there is a collision, it sets the corresponding boolean value to false
     * @param delta the timeFrame of the render Method in the GameScreen Class
     * @param speed the speed of the GameObjects which specifies how fast it can change its position
     */
    public void exitCheck(float delta, float speed){

        // potential new x or y of the character
        float rightX = getX() + speed * delta;
        float leftX = getX() - speed * delta;
        float upY = getY() + speed * delta;
        float downY = getY() - speed * delta;

        // potential new Bounds of the character
        Rectangle right = new Rectangle(rightX * SPRITE_SIZE, y * SPRITE_SIZE, width - puffer, height - puffer);
        Rectangle left = new Rectangle(leftX * SPRITE_SIZE, y * SPRITE_SIZE, width - puffer, height - puffer);
        Rectangle up = new Rectangle(x * SPRITE_SIZE, upY * SPRITE_SIZE, width - puffer, height - puffer);
        Rectangle down = new Rectangle(x * SPRITE_SIZE, downY * SPRITE_SIZE, width - puffer, height - puffer);

        // Iterating through the Exit Objects of the maze
        for (Exit exit: getGame().getMaze().getExits()) {
            if (right.overlaps(exit.getBounds())) {
                canMoveRight = false;
            }
            if (left.overlaps(exit.getBounds())) {
                canMoveLeft = false;
            }
            if (up.overlaps(exit.getBounds())) {
                canMoveUp = false;
            }
            if (down.overlaps(exit.getBounds())) {
                canMoveDown = false;
            }
        }
    }


    //<editor-fold desc="Getter">
    // Getter
    public Texture getMobs() {
        return mobs;
    }

    public Texture getCharacters() {
        return characters;
    }

    public int getMOB_SIZE() {
        return MOB_SIZE;
    }

    public int getCHARACTER_WIDTH() {
        return CHARACTER_WIDTH;
    }

    public int getCHARACTER_HEIGHT() {
        return CHARACTER_HEIGHT;
    }

    public int getSPRITE_SIZE() {
        return SPRITE_SIZE;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public MazeRunnerGame getGame() {
        return game;
    }

    public boolean isCanMoveRight() {
        return canMoveRight;
    }

    public boolean isCanMoveLeft() {
        return canMoveLeft;
    }

    public boolean isCanMoveUp() {
        return canMoveUp;
    }

    public boolean isCanMoveDown() {
        return canMoveDown;
    }

    public Rectangle getBounds() {
        return bounds;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    // Setter
    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setBounds(float x, float y) {
        bounds.setPosition(x * SPRITE_SIZE,y * SPRITE_SIZE);
    }
    public void setGame(MazeRunnerGame game) {
        this.game = game;
    }

    //</editor-fold>
}
