package brimstone.content;

import mindustry.type.Item;
import arc.graphics.Color;

public class BrimstoneItems {
    public static Item pyrite, ironoxide, quartz, magnetite, cinnabar;

    public static void load() {

        pyrite = new Item("pyrite", Color.valueOf("aca566")) {{
            hardness = 0;
            cost = 5f;
        }};

        ironoxide = new Item("ironoxide", Color.valueOf("8a3b2e")) {{
            hardness = 1;
            cost = 2f;
        }};
        quartz = new Item("quartz", Color.valueOf("D9D9D9")) {{
            hardness = 2;
            cost = 0.5f;
        }};
        magnetite = new Item("magnetite", Color.valueOf("81868A")) {{
            hardness = 1;
            cost = 3f;
        }};
        cinnabar = new Item("cinnabar", Color.valueOf("850000")) {{
            hardness = 1;
        }};
    }
}