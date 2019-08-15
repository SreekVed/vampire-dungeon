
package dungeon;


public class Player {

    private int x=0;
    private int y=0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    
    
    
    public void move(char command) {
        
        switch(command) {
        
            case 'w' : this.y-=2;
            case 's' : this.y++; this.x++;
            case 'a' : this.x-=2;
            case 'd' : this.x++;
        
        }
    
    
    }


    boolean isAt(int x, int y) {
        
        return (this.x==x && this.y==y);
    }
    
    
    
}
