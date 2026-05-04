package brimstone.content.functions;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Mathf;
import mindustry.content.Fx;
import mindustry.entities.Damage;
import mindustry.entities.bullet.*;
import mindustry.gen.Bullet;

public class MortarBullet {

    public static class NormalMortar extends ArtilleryBulletType {

        public static class Data {
            boolean exploded;
        }

        public NormalMortar() {
            super(0.8f, 500f);
            lifetime = 288f;
            splashDamage = 120f;
            splashDamageRadius = 80f;
            hitEffect = Fx.massiveExplosion;
            frontColor = trailColor = Color.valueOf("81868A");
            backColor = Color.valueOf("2F2F33");
        }

        @Override
        public void init(Bullet b){
            super.init(b);
            b.data = new Data();
        }

        @Override
        public void despawned(Bullet b){
            super.despawned(b);
            Data d = (Data)b.data;
            if(d == null || d.exploded) return;
            d.exploded = true;
            Fx.massiveExplosion.at(b.x, b.y);
            Damage.damage(b.team, b.x, b.y, splashDamageRadius, splashDamage);
        }

        @Override
        public void draw(Bullet b) {
            float progress = b.fin();
            float arc = 4f * progress * (1f - progress);
            float arcHeightPixels = arc * 40f;
            float scale = 1f + arc * 1.5f;

            Draw.color(backColor);
            Draw.rect("large-orb-back", b.x, b.y + arcHeightPixels, 12f * scale, 12f * scale, b.rotation());

            Draw.color(frontColor);
            Draw.rect("large-orb", b.x, b.y + arcHeightPixels, 10f * scale, 10f * scale, b.rotation());

            Draw.color();
        }
    }
}
