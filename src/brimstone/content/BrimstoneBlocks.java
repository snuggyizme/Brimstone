package brimstone.content;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.util.Eachable;
import brimstone.content.functions.CoreVoltBlock;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.UnitTypes;
import mindustry.entities.units.BuildPlan;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.DrawDefault;
import mindustry.world.draw.DrawGlowRegion;
import mindustry.world.draw.DrawMulti;
import mindustry.world.meta.BlockGroup;

import static brimstone.content.BrimstoneItems.pyrite;
import static mindustry.type.ItemStack.with;

public class BrimstoneBlocks {
    public static Block
            drill1,
            orepyrite,
            sulfaburna;
    public static CoreVoltBlock
            corevolt;

    public static void load() {
        drill1 = new Drill("drill-mark-1") {{
            tier = 1;
            drillTime = 240f;
            rotateSpeed = 2.5f;
            size = 2;
            category = Category.production;
            requirements(Category.production, with(pyrite, 10));
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
            requirements(Category.crafting, with(pyrite, 25));
            outputItem = new ItemStack(BrimstoneItems.ironoxide, 3);
            outputLiquid = new LiquidStack(BrimstoneGas.sulfurgas, 4f / 60f);
            consumeItems(with(pyrite, 1));
            craftTime = 120f;
            craftEffect = Fx.smeltsmoke;
            drawer = new DrawMulti(
                    new DrawDefault(),
                    new DrawGlowRegion() {{
                        alpha = 1.5f;
                        color = Color.valueOf("FFEFA1");
                        glowIntensity = 0.6f;
                        glowScale = 6f;
                    }}
            );
        }};
        corevolt = new CoreVoltBlock("core-volt") {
            TextureRegion previewRegion;
            @Override
            public void load(){
                super.load();
                previewRegion = Core.atlas.find(name + "-preview");
            }
            @Override
            public TextureRegion[] icons() {
                return new TextureRegion[]{region, previewRegion};
            }
        };
        corevolt.requirements(Category.effect, with(
                pyrite, 500,
                Items.coal, 400
        ));
        corevolt.size = 3;
        corevolt.health = 2000;
        corevolt.alwaysUnlocked = true;
        corevolt.itemCapacity = 2000;
        corevolt.unitCapModifier = 12;
        corevolt.unitType = UnitTypes.corvus;
    }
}
