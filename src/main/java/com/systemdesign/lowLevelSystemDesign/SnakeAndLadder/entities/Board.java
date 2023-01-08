package com.systemdesign.lowLevelSystemDesign.SnakeAndLadder.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Board {

    int boardSize;
    Map<Integer,Item> items;
    List<Dice> dices;
    Queue<Player> players;

    public Board(int boardSize){
        this.boardSize = boardSize;
        this.items = new HashMap<>();
        this.dices = new ArrayList<>();
        this.players = new LinkedList<>();
    }

    public int rollDices(){
        return dices.stream().map(dice -> dice.roll()).reduce(0,(a,b)->a+b);
    }

    public void addItem(ItemType type, int position, int noOfSteps){
        Item item = new Item(type, position, noOfSteps);
        items.put(position,item);
    }

    public void addDice(int diceSize){
        Dice dice = new Dice(diceSize);
        dices.add(dice);
    }

    public void addPlayer(String username){
        Player player = new Player(username,0);
        players.add(player);
    }



    public void start(){
        while(players.size() > 1){
            Player player = players.poll();
            int increment = rollDices();
            int next = player.getPostion()+increment;
            System.out.println(player.getUsername() + " rolled the dices and got "+increment+" and moves from "+player.getPostion()+" to "+ next);
            if(next == boardSize){
                System.out.println(player.getUsername() + " has won the game");
                continue;
            }
            if(next < boardSize){
                player.setPostion(checkForItem(next,player));
            }
            players.add(player);
        }
    }

    private int checkForItem(int next, Player player){
        if(items.containsKey(next)){
            Item item = items.get(next);
            if(item.type == ItemType.Ladder){
                next += item.getNoOfSteps();
                System.out.println(player.getUsername() + " just climbed a ladder to "+next);
            }else{
                next -= item.getNoOfSteps();
                System.out.println(player.getUsername() + " got bitten by a snake, moves to "+next);
            }
        }
        return next;
    }

}
