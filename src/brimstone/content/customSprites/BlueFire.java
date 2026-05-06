package brimstone.content.customSprites;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Mathf;
import arc.util.Log;
import mindustry.entities.Effect;

public class BlueFire {
    public static Effect blueShootSmallFlameFx, blueFireHitFx, blueFireSmokeFx;

    public static void load() {
        final Color INNER = Color.valueOf("aee7ff");
        final Color MID   = Color.valueOf("6fbfff");
        final Color OUTER = Color.valueOf("2b6fb3");

        blueShootSmallFlameFx = new Effect(18f, e -> {
            try {
                if(Float.isNaN(e.x) || Float.isNaN(e.y) || Float.isInfinite(e.x) || Float.isInfinite(e.y)) return;
                Draw.color(INNER, OUTER, e.fin());
                Fill.circle(e.x, e.y, Math.max(0.1f, e.fout() * 3.2f));
                Draw.color(MID, OUTER, e.fin());
                for(int i = 0; i < 3; i++){
                    float ang = Mathf.random(360f);
                    float r = e.fout() * Mathf.random(0.5f, 2.2f);
                    Fill.circle(e.x + Angles.trnsx(ang, r), e.y + Angles.trnsy(ang, r), e.fout() * Mathf.random(0.4f, 1.2f));
                }
                Draw.reset();
            } catch(Throwable ex){
                Log.err("blueShootSmallFlameFx error: " + ex);
            }
        });

        blueFireHitFx = new Effect(14f, e -> {
            try {
                if(Float.isNaN(e.x) || Float.isNaN(e.y)) return;
                Draw.color(INNER, OUTER, e.fin());
                Lines.stroke(e.fout() * 2f, INNER);
                for(int i = 0; i < 6; i++){
                    float ang = Mathf.random(360f);
                    float len = e.fout() * Mathf.random(1.5f, 4f);
                    Lines.lineAngle(e.x, e.y, ang, len);
                }
                Fill.circle(e.x, e.y, e.fout() * 2.6f);
                Draw.reset();
            } catch(Throwable ex){
                Log.err("blueFireHitFx error: " + ex);
            }
        });

        blueFireSmokeFx = new Effect(28f, e -> {
            try {
                if(Float.isNaN(e.x) || Float.isNaN(e.y)) return;
                Draw.color(MID, OUTER, e.fin());
                Fill.circle(e.x, e.y, e.fout() * 4.5f);
                Draw.color(OUTER, Color.clear, e.fin());
                Fill.circle(e.x + Mathf.random(-1f,1f) * e.fout() * 2f, e.y + Mathf.random(-1f,1f) * e.fout() * 2f, e.fout() * 6f);
                Draw.reset();
            } catch(Throwable ex){
                Log.err("blueFireSmokeFx error: " + ex);
            }
        });
        Log.info("BlueFire effects loaded and didnt crash your game");
    }
}
