import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Shaft
{
    private boolean mouseDB = true;
    GreenfootImage bullet = getImage();
    
    public Bullet()
    {

        bullet.scale(50,10 );
        bullet.setTransparency(0);
        setImage(bullet);
    }

    /**
     * Act - do whatever the bu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse == null){}
        else
        {
            if (mouseDB)
            {
                turnTowards(mouse.getX(),mouse.getY());

                mouseDB = false;
            }

        }
        move(10);
        bullet.setTransparency(60);
        if (isAtEdge() || isTouching(Asteroid.class))
        {
            getWorld().removeObject(this);
        }

    }    
}
