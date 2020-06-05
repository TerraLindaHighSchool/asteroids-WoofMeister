import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shaft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shaft extends Cannon
{
    private boolean bulletDB = true;
    private int countdown = 100;
    public Shaft()
    {
        setRotation(-90);
    }

    /**
     * Act - do whatever the Shaft wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        ttM();
        //setRotation(-95);
        //movement();
        shoot();
    }    

    private void ttM()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse == null){}
        else
        {
            turnTowards(mouse.getX(),mouse.getY());
        }
    }

    

    private void shoot()
    {
        Space space = (Space)getWorld();

        if (Greenfoot.isKeyDown("Space") || Greenfoot.mousePressed(null) && bulletDB)
        {
            
            Greenfoot.playSound("EnergyGun.wav");
            Bullet bullet = new Bullet();
            getWorld().addObject(bullet,getX(),getY()); 
            bulletDB = false;
            space.updateScore(1);
        }
        if (!bulletDB)
        {
            bulletDB = true;
        }
    }
}
