package brimstone;

import arc.*;
import arc.util.*;
import mindustry.content.Blocks;
import brimstone.content.BrimstoneBlocks;
import brimstone.content.BrimstoneItems;
import mindustry.ctype.ContentType;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mindustry.world.blocks.production.Drill;

import static mindustry.Vars.content;

public class BrimstoneMod extends Mod {

    @Override
    public void loadContent() {
        BrimstoneItems.load();
        BrimstoneBlocks.load();
        Drill d = (Drill)content.getByName(ContentType.block, "drill-mark-1");
        Log.info("drill region null? {0}", d.region == null);
        Log.info("drill topRegion null? {0}", d.topRegion == null);
        Log.info("drill rotatorRegion null? {0}", d.rotatorRegion == null);

    }
}
    