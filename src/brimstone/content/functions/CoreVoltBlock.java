package brimstone.content.functions;

import arc.Core;
import arc.audio.Sound;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import mindustry.graphics.Pal;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.gen.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import arc.graphics.g2d.TextureRegion;
import arc.graphics.*;
import arc.math.*;
import arc.util.*;

import static mindustry.Vars.state;
import static mindustry.Vars.tilesize;

public class CoreVoltBlock extends CoreBlock {

    public float lightningChance = 0.2f;
    public float lightningDamage = 50f;
    public int lightningLength = 25;
    public Color lightningColor = Pal.surge;
    public Sound lightningSound = Sounds.shootArc;

    public CoreVoltBlock(String name){
        super(name);
        buildType = CoreVoltBuild::new;
    }
    TextureRegion previewRegion;

    @Override
    public void load(){
        super.load();
        previewRegion = Core.atlas.find(name + "-preview");
    }

    @Override
    public TextureRegion[] icons(){
        return new TextureRegion[]{ region, previewRegion };
    }

    public class CoreVoltBuild extends CoreBuild {

        public float hit;

        @Override
        public void draw(){
            super.draw();
            if(hit > 0.0001f){
                Draw.color(Color.purple);
                Draw.alpha(hit * 0.5f);
                Draw.blend(Blending.additive);
                Fill.rect(x, y, tilesize * block.size, tilesize * block.size);
                Draw.blend();
                Draw.reset();

                if(!state.isPaused()){
                    hit = Mathf.clamp(hit - Time.delta / 10f);
                }
            }
        }
        @Override
        public void damage(float amount){
            super.damage(amount);

            hit = 1f;

            CoreVoltBlock b = (CoreVoltBlock)block;

            if(b.lightningChance > 0f && Mathf.chance(b.lightningChance)){
                for(int i = 0; i < 5; i++){
                    Lightning.create(
                            team,
                            b.lightningColor,
                            b.lightningDamage,
                            x, y,
                            Mathf.random(360f),
                            b.lightningLength
                    );
                }
                b.lightningSound.at(tile, Mathf.random(0.9f, 1.1f));
            }
        }
    }
}
