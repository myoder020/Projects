package galaxydefender.models.boss;

/**
 * 
 * aFreq = frequency of attack in seconds
 * rest self explanatory
 */
public abstract class Boss {
	private int beginHealth;
    private int curHealth;
    private int a1Freq;
    private int a2Freq;
    private int a3Freq;
    private int locationx;
    private int locationy;
    
    public void loseHealth(int loss){
    	this.curHealth -= loss;
    	if (this.curHealth < (.60 * beginHealth) );
    		//fairly damaged change color or image to reflect
    	if (this.curHealth < (.15 * beginHealth) );
    		//really damaged change color or image to reflect
    }
    
    public int getHealth(){ return this.curHealth;  }
    
    public void enter(){
    	
    }
    
    public void moveLeft(int howMuch){ this.locationx-=howMuch; }
    public void moveRight(int howMuch){ this.locationx+=howMuch; }
    public void moveUp(int howMuch){ this.locationy-=howMuch; }
    public void moveDown(int howMuch){ this.locationy+=howMuch; }
    
    public void move(){}
    
    public int getLocationX(){ return this.locationx; }
    public int getLocationY(){ return this.locationy; }
    
    public void attack1(){
    	if( ( ( System.currentTimeMillis()*.001 ) % a1Freq) == 0)
    		System.out.println("Attack!"); //attack with weapon
    }
    
    public void attack2(){
    	if( ( ( System.currentTimeMillis()*.001 ) % a2Freq) == 0)
    		System.out.println("Attack!"); //attack with weapon
    }
    
    public void attack3(){
    	if( ( ( System.currentTimeMillis()*.001 ) % a3Freq) == 0)
    		System.out.println("Attack!"); //attack with weapon
    }
    
}