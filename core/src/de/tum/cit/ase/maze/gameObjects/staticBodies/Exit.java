package de.tum.cit.ase.maze.gameObjects.staticBodies;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The class Exit represents the end point of the game within the maze
 * As soon as the player collected the key and reaches this point, the game is won
 * It extends the StaticBodies Class
 */
public class Exit extends StaticBodies {

    // Attributes
    private TextureRegion exitTexture;
    private TextureRegion openExitTexture;

    // Constructor
    public Exit(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.exitTexture = new TextureRegion(getTiles(), 0 * getTILE_SIZE(), 6 * getTILE_SIZE(), getTILE_SIZE(), getTILE_SIZE());  // Texture before the key was collected
        this.openExitTexture = new TextureRegion(getThings(), 2 * getTILE_SIZE(), 2 * getTILE_SIZE(), getTILE_SIZE(), getTILE_SIZE()); // Texture after the key was collected
        super.getBounds().setSize(width - 10, height - 10);
    }

    // Getter
    public TextureRegion getExitTexture() {
        return exitTexture;
    }

    public TextureRegion getOpenExitTexture() {
        return openExitTexture;
    }
}
