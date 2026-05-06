package brimstone;

import arc.*;
import arc.util.*;
import brimstone.content.*;
import brimstone.content.customSprites.BlueFire;
import mindustry.content.Blocks;
import mindustry.ctype.ContentType;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mindustry.world.blocks.production.Drill;

import static mindustry.Vars.content;

public class BrimstoneMod extends Mod {

    @Override
    public void loadContent() {
        BrimstoneGas.load();
        BrimstoneItems.load();
        BlueFire.load();
        BrimstoneBlocks.load();
        BrimstoneTurrets.load();
        BrimstoneLiquids.load();
    }
}
    