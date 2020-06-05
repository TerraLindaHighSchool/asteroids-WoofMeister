import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class lose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lose extends World
{

    /**
     * Constructor for objects of class lose.
     * 
     */
    public Lose()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1); 
        
        GreenfootImage image = getBackground();
        image.setColor(new Color(0, 0, 0));
        image.setFont(new Font("F", false, false , 40));
        image.drawString("You Killed the Planet", 10, 90);
        image.drawString("All YOUR Fault", 10, 200);
        image.drawString("You have SOLE responsibility", 10, 300);
        image.setColor(new Color(0, 255, 0));
        image.drawString("You Killed the Planet", 15, 95);
        image.drawString("All YOUR Fault", 15, 205);
        image.drawString("You have SOLE responsibility", 15, 305);
    }
}
