package brimstone.content.functions;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import mindustry.content.Fx;
import mindustry.entities.Damage;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.gen.Bullet;
import mindustry.gen.Sounds;

public class MortarBullet {

    public static class NormalMortar extends ArtilleryBulletType {

        public static class Data {
            boolean exploded;
        }

        public NormalMortar() {
            super(0.8f, 400f);
            collides = false;
            collidesTiles = false;
            collidesAir = false;
            collidesGround = true;
            keepVelocity = true;

            lifetime = 360f;
            splashDamage = 160f;
            splashDamageRadius = 80f;
            hitEffect = Fx.massiveExplosion;
            smokeEffect = Fx.shootBigSmoke;
            hitSound = Sounds.explosionArtillery;

            trailLength = 20;
            trailWidth = 4f;
            trailColor = Color.valueOf("5A5A60");

            frontColor = Color.valueOf("A0A0A5");
            backColor = Color.valueOf("3A3A3F");
        }

        @Override
        public void init(Bullet b){
            super.init(b);
            b.data = new Data();
        }

        @Override
        public void update(Bullet b){
            super.update(b);

            Data d = (Data)b.data;
            if(d == null || d.exploded) return;
            if(b.fin() >= 0.999f){
                d.exploded = true;

                Fx.massiveExplosion.at(b.x, b.y);
                Fx.shockwaveSmaller.at(b.x, b.y);
                Damage.damage(b.team, b.x, b.y, splashDamageRadius, splashDamage);

                b.remove();
            }
        }

        @Override
        public void despawned(Bullet b){
            super.despawned(b);
            Data d = (Data)b.data;
            if(d == null || d.exploded) return;
            d.exploded = true;

            Fx.massiveExplosion.at(b.x, b.y);
            Fx.shockwaveSmaller.at(b.x, b.y);
            Damage.damage(b.team, b.x, b.y, splashDamageRadius, splashDamage);
        }

        @Override
        public void draw(Bullet b) {
            float progress = b.fin();
            float arc = 4f * progress * (1f - progress);
            float arcHeightPixels = arc * 40f;
            float scale = 1f + arc * 1.5f;

            // Keep your original sprite ordering and colors
            Draw.color(backColor);
            Draw.rect("large-orb-back", b.x, b.y + arcHeightPixels, 12f * scale, 12f * scale, b.rotation());

            Draw.color(frontColor);
            Draw.rect("large-orb", b.x, b.y + arcHeightPixels, 10f * scale, 10f * scale, b.rotation());

            Draw.color();
        }
    }
}
