package de.tum.cit.ase.maze.gameObjects.staticBodies;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The class EntryPoint represents the start point of the game within the maze
 * It extends the StaticBodies Class
 */
public class EntryPoint extends StaticBodies {

    // Attributes
    private TextureRegion entryTexture;

    // Constructor
    public EntryPoint(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.entryTexture = new TextureRegion(getTiles(), 2 * getTILE_SIZE(), 6 * getTILE_SIZE(), getTILE_SIZE(), getTILE_SIZE()); // sets the texture for this specific GameObject
    }

    // Getter
    public TextureRegion getEntryTexture() {
        return entryTexture;
    }
}
