package models.vegetable;
import javafx.scene.control.Button;


public abstract class Vegetable {


    public abstract int getX();

    public abstract int getY();

    public abstract void growUp();

    public abstract Button getButton();

    public abstract Long getElapsedTime();

    public abstract int getActualStade();

    public abstract String getType();
}
