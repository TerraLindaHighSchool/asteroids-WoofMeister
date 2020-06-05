import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instantiates stars and draws them to the world
 * 
 * @author Bruce Gustin
 * @version 3/15/2020 v1
 */
public class Title extends World
{
    private Star[] stars = new Star[210];
    Color color1 = new Color(255,111,111);
    Color color2 = new Color(111,111,255);
    Color color3 = new Color(111,255,111);

    /**
     * Constructor for objects of class Space.
     * 
     */
    public Title()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 500, 1);

        GreenfootImage image = getBackground();
        image.setColor(Color.BLACK);
        image.fill();
        image.setColor(new Color(69, 69, 69));
        image.setFont(new Font("F", false, false , 100));
        image.drawString("Game_Name", 10, 90);

        image.setFont(new Font("F", false, false , 60));
        image.drawString("Space to Start", 10, 190);

        image.setFont(new Font("F", false, false , 20));
        image.drawString("mole.io", 520, 480);

        star();
        prepare();

    }

    private void star()
    {
        for(int i = 0; i < 210; i++){
            Star star;
            int deltaSpeed = Greenfoot.getRandomNumber(2);

            if(i < 70)
            {
                star = new Star(-1 - deltaSpeed, color1, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }

            if(i >= 70 && i < 140)
            {
                star = new Star(-3 - deltaSpeed, color2, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }

            if(i >= 140)
            {
                star = new Star(-5 - deltaSpeed, color3, getWidth(), getHeight());
                addObject(star, star.getX(), star.getY());
                stars[i] = star;
            }
        }
    }

    public void act()
    {
        for(int i = 0; i < 210; i++)
        {
            if(stars[i] != null)
            {
                stars[i].move();
            }
        }

        if (Greenfoot.isKeyDown("Space"))
        {
            Greenfoot.setWorld(new Space());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

    }
}
