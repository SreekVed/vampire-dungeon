
package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Dungeon {

    
    private int length, height, vampires, moves;
    private final boolean vampiresMove;
    private List<Vampire> vampireList  = new ArrayList<Vampire>();
    private Random random = new Random();
    private Player player = new Player();
    private Scanner input = new Scanner(System.in);
    
     public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length=length;
        this.height=height;
        this.vampires=vampires;
        this.moves=moves;
        this.vampiresMove=vampiresMove;
     }
     
 
     
     private void printVampires() {
        for(Vampire vampire : vampireList) {
                 System.out.println(vampire);
             }
             System.out.println("");
     
     }
     
     private void createVampires() {
         
         for(int i=0;i<this.vampires;i++) {
                
                int x = this.random.nextInt(this.length);
                int y = this.random.nextInt(this.height);
             
                if(this.VampireAt(x, y) || this.player.isAt(x, y)) {
                x = this.random.nextInt(this.length);
                y = this.random.nextInt(this.height);
                this.vampireList.add(new Vampire(x,y));
                }
                
                else this.vampireList.add(new Vampire(x,y));
                
        }

     }
     
     private void printMap() {
         
         for(int y=0;y<this.height;y++) {
         
             for(int x=0;x<this.length;x++) {
                 if(this.player.isAt(x,y)) System.out.print("@");
                 else if(this.VampireAt(x,y)) System.out.print("v");
                 else System.out.print(".");  
             
             }
             System.out.println("");

         }
         System.out.println("");
         
     }
     
     private void randomize() {
         for(Vampire vampire : vampireList) {
             int x = this.random.nextInt(this.length);
             int y = this.random.nextInt(this.height);
             
             if(this.VampireAt(x, y) || this.player.isAt(x, y)) {
                x = this.random.nextInt(this.length);
                y = this.random.nextInt(this.height);
                vampire.setX(x);
                vampire.setY(y);
                }
             
             
             else{
             vampire.setX(x);
             vampire.setY(y);
                     }
         }
     }
     
    
     private boolean VampireAt(int x, int y) {
        for(Vampire vampire : vampireList) {
            if(vampire.getX()==x && vampire.getY()==y) return true;
        }
        return false;
    }
    
     
     private void action(String command) {
     
         ArrayList<Vampire> killed = new ArrayList<Vampire>();
         
         for(int position=0;position<command.length();position++) {
             char letter = command.charAt(position);
             this.player.move(letter);
             if(player.getX()>=this.length) player.setX(this.length-1);
             if(player.getY()>=this.height) player.setY(this.height-1);
             if(player.getX()<0) player.setX(0);
             if(player.getY()<0) player.setY(0);
                        for(Vampire vampire : vampireList) {
                        if(vampire.getX()==this.player.getX() && vampire.getY()==this.player.getY()) {
                killed.add(vampire);
            }
        }
                
             
         }
         
         
         this.vampireList.removeAll(killed);
     
     }
     
     
     public void run() {
     
         this.createVampires();

         while(moves>0) {
             System.out.println(this.moves + "\n");
             System.out.println("@ " + player.getX() + " " + player.getY());
             this.printVampires();
             this.printMap();
         
             String command = input.nextLine();
             this.action(command);
             
             if(this.vampireList.isEmpty()) {
                 System.out.println("YOU WIN");
                 break;
             }
             
             if(vampiresMove) this.randomize();
             moves--;
         }
     
         if(moves==0) System.out.println("YOU LOSE");
         
         
     
     }
 
    
}
