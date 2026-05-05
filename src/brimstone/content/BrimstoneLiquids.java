package brimstone.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class BrimstoneLiquids {

    public static Liquid quicksilver;

    public static void load() {

        quicksilver = new Liquid("quicksilver", Color.valueOf("c2c2c2")) {{
            flammability = 2.5f;
            explosiveness = 1.8f;
            heatCapacity = 0.3f;
            viscosity = 0.5f;
        }};
    }
}
