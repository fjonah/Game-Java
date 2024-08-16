package de.tum.cit.ase.maze.gameObjects.staticBodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;


/**
 * The class StaticBodies is the superclass for all GameObjects which can not change their position (walls, entryPoints, exits etc.)
 */
public class StaticBodies {

    // Position Attributes
    private float width, height;
    private float x, y;
    private Rectangle bounds;

    // Texture Attributes
    private Texture tiles;
    private Texture objects;
    private Texture things;
    private final int TILE_SIZE = 16;
    private final int SPRITE_SIZE = 32;


    /**
     * Constructor for the StaticBodies Class. Initializes the position attributes and the bounds of the static Objects
     * @param x the x coordinate of the static GameObject
     * @param y the y coordinate of the static GameObject
     * @param width the width of the static GameObject
     * @param height the height of the static GameObject
     */
    public StaticBodies(float x, float y, float width, float height) {

        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.bounds = new Rectangle(x * SPRITE_SIZE,y * SPRITE_SIZE, width, height);

        // Textures
        tiles = new Texture(Gdx.files.internal("basictiles.png"));
        objects = new Texture(Gdx.files.internal("objects.png"));
        things = new Texture(Gdx.files.internal("things.png"));
    }


    //<editor-fold desc="Getter">
    // Getter
    public Texture getTiles() {
        return tiles;
    }

    public Texture getObjects() {
        return objects;
    }

    public Texture getThings() {
        return things;
    }

    public int getTILE_SIZE() {
        return TILE_SIZE;
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

    //</editor-fold>
}
