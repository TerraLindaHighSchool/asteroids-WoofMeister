import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyCount extends Actor
{
    int test = 100;
  
    public MyCount(String text)
    {
        //test = Integer.parseInt(Greenfoot.ask("What Initial Health Value Do you want?"));
        setImage(new GreenfootImage(text + test,40,  Color.BLACK, (new Color(187, 189, 174))));
        //System.out.println(test);
    }

    /**
     * Act - do whatever the MyCount wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(String text) 
    {
        setImage(new GreenfootImage(text + test,40,  Color.BLACK, (new Color(187, 189, 174))));
        if (test < 0)
        {
            Greenfoot.setWorld(new Lose());
        }
    }    
    
    public void addScore(String thing, int Value)
    {
        test = test - Value;
        act(thing);
    }   
    public void subScore(String thing, int Value)
    {
        test = test + Value;
        act(thing);
    }  
}
