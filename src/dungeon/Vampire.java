
package dungeon;


public class Vampire {

    private int x,y;

    public Vampire(int x, int y) {
     this.x= x;
     this.y= y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    
    
    @Override
  public String toString() {
      return "v " + this.x + " " + this.y;
  
  }  
    
}
