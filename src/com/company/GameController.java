package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private Player player;
    List<Enemy> Myenemies;
    MessageHandler m;
    //OurPair playerPosition;
    GameBoard gb;

    public GameController(MessageHandler m){
        this.m=m;
        choosePlayer();

    }
  private void choosePlayer()
    {
        Scanner scanner=new Scanner(System.in);
        m.sendMessage("1.Jon Snow       Health:300/300    Attack:30    Defense:4     Level:1    Experience:0/50    Cooldown:0/3");
        m.sendMessage("2.The hound      Health:400/400    Attack:20    Defense:6     Level:1    Experience:0/50    Cooldown:0/5");
        m.sendMessage("3.Melisandre     Health:100/100    Attack:5     Defense:1     Level:1    Experience:0/50    Mana:75/300     Spell Power:15");
        m.sendMessage("4.Thros of Myr   Health:250/250    Attack:25    Defense:4     Level:1    Experience:0/50    Mana:37/150     Spell Power:20");
        m.sendMessage("5.Arya Stark     Health:150/150    Attack:40    Defense:2     Level:1    Experience:0/50    Energy:100/100");
        m.sendMessage("6.Bronn          Health:250/250    Attack:35    Defense:3     Level:1    Experience:0/50    Energy:100/100");
        m.sendMessage("7.Ygritte        Health:220/220    Attack:30    Defense:2     Level:1    Experience:0/50    Arrows:10        Range:6");

        Player res;
        int number=scanner.nextInt();
        switch (number){
            case 1:
                Warrior jon_snow = new Warrior('@', new OurPair(-1, -1), "Jon Snow", 300, 30, 4, 3);
                res = jon_snow;
                this.player=res;
                break;
            case 2:
                Warrior the_hound = new Warrior('@', new OurPair(-1, -1), "The hound", 400, 20, 6, 5);
                res = the_hound;
                this.player=res;
                break;
            case 3:
                Mage Melisandre=new Mage('@',new OurPair(-1,-1),"Melisandre",100,5,1,300,30,15,5,6);
                res=Melisandre;
                this.player=res;
                break;
            case 4:
                Mage thoros_of_myr=new Mage('@',new OurPair(-1,-1),"Thoros of Myr",250,25,4,150,20,20,3,4);
                res=thoros_of_myr;
                this.player=res;
                break;
            case 5:
                Rogue arya_stark=new Rogue('@',new OurPair(-1,-1),"Arya Stark",150,40,2,20);
                res=arya_stark;
                this.player=res;
                break;
            case 6:
                Rogue bronn=new Rogue('@',new OurPair(-1,-1),"Bronn",250,35,3,50);
                res=bronn;
                this.player=res;
                break;
            case 7:
                Hunter Ygritte= new Hunter('@', new OurPair(-1, -1), "Ygritte", 220, 30, 2, 10,6);
                res = Ygritte;
                this.player=res;
                break;
        }
    }
    public void NewLevel(char[][] currentLevel) {
        GameBoard gb = new GameBoard(currentLevel);
        setBoard(gb);
    }

    private void setBoard(GameBoard gb) {
        this.gb=gb;
        gb.setPlayer(player);
        OurPair playerP=gb.getPlayerLoaction();
        player.setPosition(playerP);
        Myenemies=gb.getMyenemies();
    }

    public void Run(){
        m.sendMessage("You have selected:"+player.name);
        while(player.isAlive()&&!Myenemies.isEmpty())
        {
            m.sendMessage(gb.StringBoard());
            m.sendMessage(player.describe());
            GameTick();
        }
    }

    private void GameTick() {
        VisitorMovement vm = new VisitorMovement(gb);
        Scanner sc = new Scanner(System.in);
        //char move = (char) sc.nextInt();
        char move=sc.next().charAt(0);
        OurPair position = player.getPosition();
        try {


            switch (move) {
                case 'w':  //move up
                    gb.getTile(position.getFirst() - 1, position.getSecond()).accept(vm,player);
                    PlayTheRest(Myenemies);
                    break;
                case 's': //move down
                    gb.getTile(position.getFirst() + 1, position.getSecond()).accept(vm,player);
                    PlayTheRest(Myenemies);
                    break;
                case 'a': //move left
                    gb.getTile(position.getFirst() , position.getSecond()-1).accept(vm,player);
                    PlayTheRest(Myenemies);
                    break;
                case 'd': //move right
                    gb.getTile(position.getFirst(), position.getSecond()+1).accept(vm,player);
                    PlayTheRest(Myenemies);
                    break;
                case 'e': //cast special ability
                    player.abilityCast(Myenemies,gb);
                    PlayTheRest(Myenemies);
                    break;
                case 'q': //do nothing
                    PlayTheRest(Myenemies);
                    break;
            }
        }
        catch (Exception e)
        {
            m.sendMessage("illegal input,try again.");
            GameTick();
        }
    }


    public void PlayTheRest(List<Enemy> Myenemies) {//Enemy's turn to move and act
        player.onGameTick();
        for(Enemy o: Myenemies)
        {
            o.Action(this.gb,player);
        }



    }

    public boolean GameOver() {
        return !player.isAlive();
    }


}

