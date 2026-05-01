package brimstone.content;

import mindustry.type.Item;
import arc.graphics.Color;

public class BrimstoneItems {

    public static Item Pyrite;


    public static void load() {
        Pyrite = new Item("pyrite", Color.valueOf("aca566")) {{
            hardness = 0;
            cost = 5f;
        }};

    }
}
