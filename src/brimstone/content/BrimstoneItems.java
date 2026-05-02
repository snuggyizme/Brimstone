package brimstone.content;

import mindustry.type.Item;
import arc.graphics.Color;

public class BrimstoneItems {
    public static Item pyrite, ironoxide;

    public static void load() {

        pyrite = new Item("pyrite", Color.valueOf("aca566")) {{
            hardness = 0;
            cost = 5f;
        }};

        ironoxide = new Item("ironoxide", Color.valueOf("8a3b2e")) {{
            hardness = 1;
            cost = 2f;
        }};
    }
}