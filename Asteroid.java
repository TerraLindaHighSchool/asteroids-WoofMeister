import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Asteroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends Enemy
{
    private int Speed;

    public Asteroid()
    {
        Speed = Greenfoot.getRandomNumber(3);
        //System.out.println(Speed);
        if (Speed == 0) Speed++;
        size();
    }

    /**
     * Act - do whatever the Asteroids wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        rotate();
        setLocation(getX(), getY() + Speed);
        DIE(); //ALWAYS LAST OR ELSE CRASH IDIOT
    }    

    private void rotate()
    {
        turn(Speed * 2);

    }

    private void size()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + Speed * 10, image.getHeight() + Speed * 10);
        setImage(image);
    }

    private void DIE()
    {
        
        if (isAtEdge() || isTouching(Bullet.class)) 
        {
            if (isAtEdge())
            {
               Space space = (Space)getWorld();
               MyCount counter = space.getMyCount();
                counter.addScore("Health: ", Speed); 
               getWorld().addObject(new Explosion(),getX(),getY());

            }
            getWorld().removeObject(this); 
        }
    }
}
