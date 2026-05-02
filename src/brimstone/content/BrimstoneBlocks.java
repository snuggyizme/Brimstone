package brimstone.content;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.environment.OreBlock;

import static mindustry.logic.TileLayer.ore;

public class BrimstoneBlocks {
    public static Drill drill1;
    public static OreBlock pyriteore;

    public static void load() {
        drill1 = new Drill("drill-mark-1") {{
            tier = 1;
            drillTime = 240f;
            rotateSpeed = 2.5f;
            size = 2;
            category = Category.production;
            requirements(Category.production, ItemStack.with(BrimstoneItems.pyrite, 10));
            drawMineItem = true;

        }};
        pyriteore = new OreBlock("pyriteore") {{
            itemDrop = BrimstoneItems.pyrite;
            oreScale = 0.6f;
            oreThreshold = 0.5f;
            variants = 3;
            mapColor.set(BrimstoneItems.pyrite.color != null ? BrimstoneItems.pyrite.color : Color.valueOf("aca566"));
        }};
    }
}
