package de.tum.cit.ase.maze.gameObjects.dynamicBodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import de.tum.cit.ase.maze.MazeRunnerGame;
import de.tum.cit.ase.maze.gameObjects.staticBodies.Exit;
import de.tum.cit.ase.maze.gameObjects.staticBodies.Key;
import de.tum.cit.ase.maze.gameObjects.staticBodies.Trap;


/**
 * The class Character represents the player within the MazeRunner Game
 * It extends the DynamicBodies Class
 */
public class Character extends DynamicBodies {

    // Texture Attributes
    private TextureRegion characterTexture;
    private TextureRegion still;
    private TextureRegion down;
    private TextureRegion right;
    private TextureRegion up;
    private TextureRegion left;

    // Other Attributes
    private int lives = 5;
    private float speed = 6;
    private boolean canExit = false;
    private long lastCollision = 0;

    // Sounds
    private Sound lostLife;
    private Sound winSound;
    private Sound keyCollected;


    /**
     * Constructor for the Character class
     * @param x the x coordinate of the character
     * @param y the y coordinate of the character
     * @param width the width of the character
     * @param height the height of the character
     * @param game The main game class, used to access global resources and methods.
     */
    public Character(float x, float y, float width, float height, MazeRunnerGame game) {
        super(x, y, width, height, game);
        this.still = new TextureRegion(getCharacters(), 0,0, getCHARACTER_WIDTH(), getCHARACTER_HEIGHT());
        this.down = new TextureRegion(getCharacters(), 0,0, getCHARACTER_WIDTH(), getCHARACTER_HEIGHT());
        this.right = new TextureRegion(getCharacters(), 0,32, getCHARACTER_WIDTH(), getCHARACTER_HEIGHT());
        this.up = new TextureRegion(getCharacters(), 0,64, getCHARACTER_WIDTH(), getCHARACTER_HEIGHT());
        this.left = new TextureRegion(getCharacters(), 0,96, getCHARACTER_WIDTH(), getCHARACTER_HEIGHT());

        // Sounds
        lostLife= Gdx.audio.newSound(Gdx.files.internal("collision.wav"));
        winSound = Gdx.audio.newSound(Gdx.files.internal("win.mp3"));
        keyCollected = Gdx.audio.newSound(Gdx.files.internal("keyCollected.mp3"));
    }


    /**
     * Method to handle the movement of the character in the game
     * Before moving the character it checks for collisions with walls and if the character can exit
     * @param delta the timeFrame of the render Method in the GameScreen Class
     */
    public void handleCharacterMovement(float delta){

        collisionCheck(delta, speed);
        if (!collectedKey()){
            exitCheck(delta, speed);
        }
        characterTexture = still; // Default to still image (Character standing)

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && isCanMoveLeft()) {
            setX(getX() - speed * delta);
            characterTexture = left;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && isCanMoveRight()) {
            setX(getX() + speed * delta);
            characterTexture = right;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.UP) && isCanMoveUp()) {
            setY(getY() + speed * delta);
            characterTexture = up;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && isCanMoveDown()) {
            setY(getY() - speed * delta);
            characterTexture = down;
        }
        setBounds(getX(), getY()); // updating the bounds of the character
    }


    /**
     * Method that checks if the character collided with an enemy or a trap and lost a life
     * Leaves the character 1 second (1000 ms) time after one collision before loosing another life
     * @return returns true if a collision occurred, false otherwise
     */
    public boolean collided() {
        long currentTime = System.currentTimeMillis();
        boolean collided = false;

        if (currentTime - lastCollision > 1000){ //Checks if more than 1 second ( in ms) has passed since the last collision
            for (Enemy enemy : getGame().getMaze().getEnemies()) {
                if (getBounds().overlaps(enemy.getBounds())) {
                    lives -= 1;
                    lastCollision = currentTime;
                    lostLife.play();
                    collided = true;
                }
            }
            for (Trap trap : getGame().getMaze().getTraps()) {
                if (getBounds().overlaps(trap.getBounds())) {
                    lives -= 1;
                    lastCollision = currentTime;
                    lostLife.play();
                    collided = true;
                    break;
                }
            }
        }
        return collided;
    }


    /**
     * Method that checks if the character collected a key
     * @return returns true if he did, false otherwise
     */
    public boolean collectedKey (){
        for (Key key: getGame().getMaze().getKeys()){
            if (getBounds().overlaps(key.getBounds())){
                keyCollected.play();
                canExit = true;
                break;
            }
        }
        return canExit;
    }


    /**
     * Method that checks if the character has collected the key and reaches the exit
     * @return returns true if he did, false otherwise
     */
    public boolean won(){
        boolean won = false;
        for (Exit exit: getGame().getMaze().getExits()){
            if (getBounds().overlaps(exit.getBounds()) && collectedKey()){
                won = true;
                winSound.play();
                break;
            }
        }
        return won;
    }


    // Getter & Setter
    public TextureRegion getCharacterTexture() {
        return characterTexture;
    }
    public int getLives() {
        return lives;
    }

}
