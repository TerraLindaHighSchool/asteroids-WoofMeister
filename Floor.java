import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    
    public Floor()
    {
        GreenfootImage image = new GreenfootImage(600, 60);
        image.fillRect(0, 0, 60, 60);
        image.setColor(new Color(187, 189, 174));
        image.fill();
        setImage(image);
    }
    
    /**
     * Act - do whatever the floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }    
}
