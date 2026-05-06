package brimstone.content;

import arc.graphics.Color;
import arc.math.Mathf;
import arc.util.Log;
import brimstone.content.customSprites.BlueFire;
import brimstone.content.functions.MortarBullet;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.FireBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.Unitc;
import mindustry.gen.Groups;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.defense.turrets.LiquidTurret;

public class BrimstoneTurrets {
    public static ItemTurret siegemortar;
    public static LiquidTurret sulfaspitta;

    public static void load(){
        BlueFire.load();
        siegemortar = new ItemTurret("siegemortar"){{
            requirements(Category.turret, ItemStack.with(
                    BrimstoneItems.ironoxide, 30,
                    BrimstoneItems.pyrite, 12
            ));
            reload = 150f;
            range = 420f;
            size = 2;
            minRange = 70;
            ammo(BrimstoneItems.magnetite, new MortarBullet.NormalMortar());
        }};
        sulfaspitta = new LiquidTurret("sulfurspitter"){{
            requirements(Category.turret, ItemStack.with(BrimstoneItems.pyrite, 30));
            size = 1;
            range = 260f;
            reload = 3f;
            recoil = 0.5f;
            liquidCapacity = 60f;

            ammo(BrimstoneGas.sulfurgas, new FireBulletType(3.5f, 18f){{
                colorFrom = Color.valueOf("7fbfff");
                colorMid  = Color.valueOf("4f9fd6");
                colorTo   = Color.valueOf("2b6fb3");

                radius = 1.0f;

                trailEffect   = BlueFire.blueShootSmallFlameFx != null ? BlueFire.blueShootSmallFlameFx : Fx.none;
                trailEffect2  = BlueFire.blueShootSmallFlameFx != null ? BlueFire.blueShootSmallFlameFx : Fx.none;
                smokeEffect   = BlueFire.blueShootSmallFlameFx != null ? BlueFire.blueShootSmallFlameFx : Fx.none;
                hitEffect     = BlueFire.blueFireHitFx != null ? BlueFire.blueFireHitFx : Fx.none;
                despawnEffect = BlueFire.blueFireSmokeFx != null ? BlueFire.blueFireSmokeFx : Fx.none;

                fireTrailChance = 0f;
                fireEffectChance = 0f;
                makeFire = false;
                incendChance = 0f;
                lifetime = 140f;
                speed = 3.5f;
                velMin = 2.0f;
                velMax = 3.5f;
                collides = true;
                collidesTiles = false;
                collidesGround = true;
                collidesAir = true;
                hittable = true;
                pierce = false;

                // do NOT set to null
                status = StatusEffects.none;
                statusDuration = 60f;
            }});

            shoot = new ShootSpread(){{
                shots = 8;
                spread = 6f;
            }};
        }};
    }
}
