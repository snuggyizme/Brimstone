package brimstone.content;

import arc.graphics.Color;
import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.type.ItemStack;
import mindustry.content.Items;
import mindustry.entities.bullet.BulletType;

import brimstone.content.functions.MortarBullet;

public class BrimstoneTurrets {

    public static ItemTurret siegemortar;

    public static void load(){

        BulletType mortarBullet = new BulletType();

        siegemortar = new ItemTurret("siegemortar"){{
            requirements(Category.turret, ItemStack.with(
                    BrimstoneItems.ironoxide, 30,
                    BrimstoneItems.pyrite, 12
            ));
            reload = 150f;
            range = 420f;
            size = 2;
            minRange = 70;
            ammo(
                    BrimstoneItems.magnetite, new MortarBullet.NormalMortar()
            );

                   // BrimstoneItems.quartz, new MortarBullet.FragMortar()
            
        }};
    }
}