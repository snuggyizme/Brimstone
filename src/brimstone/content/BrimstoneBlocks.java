package brimstone.content;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;

import static brimstone.content.BrimstoneItems.pyrite;

public class BrimstoneBlocks {
    public static Block
            drill1,
            orepyrite,
            sulfaburna;

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
        orepyrite = new OreBlock(pyrite) {{
            variants = 3;
            mapColor.set(pyrite.color != null ? pyrite.color : Color.valueOf("aca566"));
        }};
                sulfaburna = new GenericCrafter("sulfaburna") {{
            size = 2;
            hasLiquids = true;
            liquidCapacity = 30f;
            category = Category.crafting;
            requirements(Category.crafting, ItemStack.with(pyrite, 25));
            outputItem = new ItemStack(BrimstoneItems.ironoxide, 3);
            outputLiquid = new LiquidStack(BrimstoneGas.sulfurgas, 4f / 60f);
            consumeItems(ItemStack.with(pyrite, 1));
            craftTime = 120f;
            craftEffect = Fx.smeltsmoke;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawGlowRegion() {{
                        alpha = 1.5f;
                        color = Color.valueOf("ffcc44");
                        glowIntensity = 0.6f;
                        glowScale = 6f;
                            }}
                    );
        }};
    }
}
