package de.tum.cit.ase.maze.gameObjects.staticBodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * The class Key represents the key the player has to collect in order to exit the game
 * It extends the StaticBodies Class
 */
public class Key extends StaticBodies {

    // Attributes
    private Texture keys;
    private TextureRegion keyTexture;

    // Constructor
    public Key(float x, float y, float width, float height) {
        super(x, y, width, height);
        this.keys = new Texture(Gdx.files.internal("keyIcons.png"));
        this.keyTexture = new TextureRegion(keys, 32,0,32,32); // sets the texture for this specific GameObject
    }


    // Getter
    public TextureRegion getKeyTexture() {
        return keyTexture;
    }
}