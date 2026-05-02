package brimstone.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Item;
import mindustry.type.Liquid;

public class BrimstoneGas {
    public static Liquid sulfurgas;

    public static void load() {

        sulfurgas = new Liquid("sulfurgas", Color.valueOf("aca566")) {{
            gas = true;
            flammability = 2f;
        }};

    }
}

