package com.systemdesign.lowLevelSystemDesign.SnakeAndLadder;

import com.systemdesign.lowLevelSystemDesign.IApplication;
import com.systemdesign.lowLevelSystemDesign.SnakeAndLadder.entities.Board;
import com.systemdesign.lowLevelSystemDesign.SnakeAndLadder.entities.ItemType;

import java.util.UUID;

public class SnakeAndLadderApplication implements IApplication {

    Board board;

    @Override
    public void execute() {
        init();
        board.start();
    }

    private void init(){
        board = new Board(100);
        board.addDice(6);
        board.addDice(6);
        board.addItem(ItemType.Snake,10,5);
        board.addItem(ItemType.Ladder,12,10);
        board.addItem(ItemType.Ladder,22,5);
        board.addItem(ItemType.Snake,6,5);
        board.addItem(ItemType.Snake,50,23);
        board.addItem(ItemType.Snake,99,23);
        board.addItem(ItemType.Ladder,67,22);
        board.addPlayer(UUID.randomUUID().toString());
        board.addPlayer(UUID.randomUUID().toString());
        board.addPlayer(UUID.randomUUID().toString());
    }
}
