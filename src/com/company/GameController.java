package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GameController implements MyObserverable {
    private Player player;
    List<MyObserver> characters;
    //OurPair playerPosition;
    GameBoard gb;

    public GameController(){
        characters= new LinkedList<MyObserver>();
        player=choosePlayer();
    }
  public Player choosePlayer()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("1-Jon snow\n 2-The hound\n 3-Melisandre\n 4-Thoros of Myr\n 5-Arya stark\n6-Bronn");
        int number=scanner.nextInt();
        Player res=null;
        switch (number){
            case '1': {
                Warrior jon_snow = new Warrior('@', new OurPair(-1, -1), "Jon Snow", 300, 30, 4, 3);
                res = jon_snow;
                this.player=res;
                break;
            }
            case '2': {
                Warrior the_hound = new Warrior('@', new OurPair(-1, -1), "The hound", 400, 20, 6, 5);
                res = the_hound;
                this.player=res;
                break;
            }
            case '3':
            {
                Mage Melisandre=new Mage('@',new OurPair(-1,-1),"Melisandre",100,5,1,300,30,15,5,6);
                res=Melisandre;
                this.player=res;
                break;
            }
            case '4':
            {
                Mage thoros_of_myr=new Mage('@',new OurPair(-1,-1),"Thoros of Myr",250,25,4,150,20,20,3,4);
                res=thoros_of_myr;
                this.player=res;
                break;
            }
            case '5':
            {
                Rogue arya_stark=new Rogue('@',new OurPair(-1,-1),"Arya Stark",150,40,2,20);
                res=arya_stark;
                this.player=res;
                break;
            }
            case '6':
            {
                Rogue bronn=new Rogue('@',new OurPair(-1,-1),"Bronn",250,35,3,50);
                res=bronn;
                this.player=res;
                break;
            }
        }
        return res;
    }
   // public Player setPlayer(int i, int j)
    //{
      //  player.setPosition(new OurPair(i,j));
        //return player;
    //}
    public void Run(List<MyObserver> enemiesList){
        this.characters= enemiesList;
        characters.add(player);
        while(player.isAlive()&&!characters.isEmpty())
        {
            GameTick();
        }
    }
    private void GameTick() {
        VisitorMovement vm=new VisitorMovement();
        Scanner sc= new Scanner(System.in);
        char move =(char) sc.nextInt();
        OurPair position=player.getPosition();
        switch (move) {
            case ('w'):  //move up
            {

                //visitor.Move(playerLocation, playlcation(i,j-1)
                vm.visit(player,gb.getTile(position.getFirst()-1,position.getSecond()));
                PlayTheRest();
            }
            break;
            case ('s'): //move down
            {
                //visitor.Move(playerLocation, playlcation(i,j+1)
                vm.visit(player,gb.getTile(position.getFirst()+1,position.getSecond()));
                PlayTheRest();
                break;
            }

            case ('a'): //move left
            {
                //visitor.Move(playerLocation, playlcation(i-1,j)
                vm.visit(player,gb.getTile(position.getFirst(),position.getSecond()-1));
                PlayTheRest();
                break;
            }
            case ('d'): //move right
            {
                //visitor.Move(playerLocation, playlcation(i+1,j)
                vm.visit(player,gb.getTile(position.getFirst(),position.getSecond()+1));
                PlayTheRest();
                break;
            }
            case ('e'): //cast special ability
            {
                player.abilityCast();
                PlayTheRest();
                break;
            }
            case ('q'): //do nothing
            PlayTheRest();
                break;


        }
    }
    @Override
    public void addObserver(MyObserver o) {
        characters.add(o);
    }

    @Override
    public void removeObserver(MyObserver o) {
    characters.remove(o);
    }

    @Override
    public void NotifyObservers() {

    }

    public void setBoard(GameBoard gb) {
        this.gb=gb;
        gb.setPlayer(player);
        OurPair playerP=gb.getPlayerLoaction();
        player.setPosition(playerP);

    }
}

