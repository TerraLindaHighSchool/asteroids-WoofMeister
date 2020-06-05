import greenfoot.*;
/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int rgb;
    private int r;
    private int g;
    private int b;
    private int starSize;
    private int level = 1;
    private int enemyCount = 25;
    
    MyCount myCount = new MyCount("Health: ");
    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(new Color(30,30,30));
        background.fill();
        background.setColor(new Color(69, 69, 69));
        background.setFont(new Font("F", false, false , 20));
        background.drawString("mole.io", 520, 20);

        //Rocket rocket = new Rocket();
        //addObject(rocket, getWidth()/2 + 100, getHeight()/2);

        //addAsteroids(startAsteroids);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        //ProtonWave.initializeImages();

        rgb = Greenfoot.getRandomNumber(255);
        //r = Greenfoot.getRandomNumber(255 - 200);
        //g = Greenfoot.getRandomNumber(255 - 200);
        //b = Greenfoot.getRandomNumber(255 - 200);
        // starSize = Greenfoot.getRandomNumber(5);

        paintStars(300);

        prepare();
        addEnemies(enemyCount);
    }

    public MyCount getMyCount()
    {
        return myCount;
    }

    public void act()
    {
        
        if (getObjects(Asteroid.class).isEmpty())
        {
            //System.out.println("STOP IT S-SENPAI");
            Greenfoot.playSound("hooray.wav");
            level++;
            myCount.subScore("Health: ", 100);
            addEnemies(enemyCount * level);
            
        }
        
    }
    
    
    
    public void addEnemies(int count)
    {   

        for (int i = 0; i < count; i++)
        {
            Asteroid roid = new Asteroid();
            addObject(roid,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(100));
        }

    }
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.

    private void addAsteroids(int count) 
    {
    for(int i = 0; i < count; i++) 
    {
    int x = Greenfoot.getRandomNumber(getWidth()/2);
    int y = Greenfoot.getRandomNumber(getHeight()/2);
    addObject(new Asteroid(), x, y);
    }
    }*/

    private void paintStars(int count)
    {
        GreenfootImage background = getBackground();

        for (int i = 0; i < count; i++)
        {
            RGBColors();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

            starSize = Greenfoot.getRandomNumber(5);

            background.fillRect(x, y, starSize, starSize);
            //background.setColor(new Color(r, g, b));
            if (Greenfoot.getRandomNumber(500) < 10)
            {
                background.setColor(new Color(r, g, b));
            }
            else
            {
                background.setColor(new Color(rgb, rgb, rgb));
            }

        }

    }

    public void RGBColors()
    {

        r = Greenfoot.getRandomNumber(255 - 0);
        g = Greenfoot.getRandomNumber(255 - 0);
        b = Greenfoot.getRandomNumber(255 - 0);
        rgb = Greenfoot.getRandomNumber(255 - 0);
    }

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int currentScore = scoreCounter.getValue();
        addObject(new ScoreBoard(currentScore),x ,y);
    }

    public void updateScore(int addToScore)
    {
        scoreCounter.add(addToScore);

    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Floor floor = new Floor();
        addObject(floor,300,475);
        Cannon cannon = new Cannon();
        addObject(cannon,300,450);
        Shaft shaft = new Shaft();
        addObject(shaft,cannon.getX(),cannon.getY());
        //PewPew pew = new PewPew();
        //addObject(pew,300,450);

        addObject(myCount,500,473);
    }

}