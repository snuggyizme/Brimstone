package brimstone.content;

import arc.graphics.Color;
import brimstone.content.customSprites.BlueFire;
import mindustry.content.Fx;
import mindustry.content.Liquids;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.FireBulletType;
import mindustry.entities.bullet.LiquidBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.type.ItemStack;
import mindustry.content.Items;
import mindustry.entities.bullet.BulletType;

import brimstone.content.functions.MortarBullet;
import mindustry.world.blocks.defense.turrets.LiquidTurret;

public class BrimstoneTurrets {

    public static ItemTurret siegemortar;
    public static LiquidTurret sulfaspitta;

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
        sulfaspitta = new LiquidTurret("sulfurspitter"){{
            requirements(Category.turret, ItemStack.with(
                    BrimstoneItems.pyrite, 30
            ));

            size = 1;
            range = 200f;
            reload = 3f;
            recoil = 0.5f;
            liquidCapacity = 60f;
            ammo(BrimstoneGas.sulfurgas, new FireBulletType(6f, 10f){{
                colorFrom = Color.valueOf("005591");
                colorMid  = Color.valueOf("70CDFF");
                colorTo   = Color.valueOf("550082");
                radius = 4.5f;
                velMin = 7f;
                velMax = 10f;
                lifetime = 100f;
                smokeEffect   = BlueFire.blueShootSmallFlameFx != null ? BlueFire.blueShootSmallFlameFx : Fx.none;
                hitEffect     = BlueFire.blueFireHitFx != null ? BlueFire.blueFireHitFx : Fx.none;
                despawnEffect = BlueFire.blueFireSmokeFx != null ? BlueFire.blueFireSmokeFx : Fx.none;
                pierce = true;
                pierceCap = 3;
                collidesAir = true;
                collidesGround = true;
                fireTrailChance = 0f;
                fireEffectChance = 0f;
            }});
            shoot = new ShootSpread(){{
                shots = 8;
                spread = 2f;
            }};
        }};
    }
}