package brimstone.content;

import mindustry.type.Item;
import arc.graphics.Color;

public class BrimstoneItems {
        public static Item pyrite;

        public static void load() {
            pyrite = new Item("pyrite", Color.valueOf("aca566"));
            pyrite.hardness = 0;
            pyrite.cost = 5f;
    }
}