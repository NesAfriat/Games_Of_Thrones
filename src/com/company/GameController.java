package com.company;

public class GameController {



    public Player choosePlayer(char number)
    {
        Player res=null;
        switch (number){
            case '1': {
                Warrior jon_snow = new Warrior('@', new OurPair(i, j), "Jon Snow", 300, 30, 4, 3);
                res = jon_snow;
                break;
            }
            case '2': {
                Warrior the_hound = new Warrior('@', new OurPair(i, j), "The hound", 400, 20, 6, 5);
                res = the_hound;
                break;
            }
            case '3':
            {
                Mage Melisandre=new Mage('@',OurPair(i,j),"Melisandre",100,5,1,300,30,15,5,6);
                res=Melisandre;
                break;
            }
            case '4':
            {
                Mage thoros_of_myr=new Mage('@',OurPair(i,j),"Thoros of Myr",250,25,4,150,20,20,3,4);
                res=thoros_of_myr;
                break;
            }
            case '5':
            {
                Rogue arya_stark=new Rogue('@',OurPair(i,j),"Arya Stark",150,40,2,20);
                res=arya_stark;
                break;
            }
            case '6':
            {
                Rogue bronn=new Rogue('@',OurPair(i,j),"Bronn",250,35,3,50);
                res=bronn;
                break;
            }
        }
        return res;
    }
}
