package brimstone.content;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.environment.OreBlock;
import static brimstone.content.BrimstoneItems.pyrite;

public class BrimstoneBlocks {
    public static Drill drill1;
    public static OreBlock orepyrite;

    public static void load() {
        drill1 = new Drill("drill-mark-1") {{
            tier = 1;
            drillTime = 240f;
            rotateSpeed = 2.5f;
            size = 2;
            category = Category.production;
            requirements(Category.production, ItemStack.with(pyrite, 10));
            drawMineItem = true;

        }};
        orepyrite = new OreBlock(BrimstoneItems.pyrite) {{
            variants = 3;
            mapColor.set(pyrite.color != null ? pyrite.color : Color.valueOf("aca566"));
        }};
    }
}
