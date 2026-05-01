package brimstone.content;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.Drill;

public class BrimstoneBlocks {
    public static Drill drill1;

    public static void load() {
        drill1 = new Drill("drill1") {{
            tier = 1;
            drillTime = 240f;
            rotateSpeed = 25f;
            size = 1;
            category = Category.production;
            requirements(Category.production, ItemStack.with(BrimstoneItems.pyrite, 10));
        }};
        TextureRegion top = Core.atlas.find("drill-mark-1");
        TextureRegion rot = Core.atlas.find("drill-mark-1-rotator");

        drill1.topRegion = top;
        drill1.rotatorRegion = rot;
    }
}
