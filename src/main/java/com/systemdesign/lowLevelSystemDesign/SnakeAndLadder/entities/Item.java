package com.systemdesign.lowLevelSystemDesign.SnakeAndLadder.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {
    ItemType type;
    int position;
    int noOfSteps;
}
