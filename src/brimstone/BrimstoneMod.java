package brimstone;

import arc.*;
import arc.util.*;
import brimstone.content.BrimstoneItems;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class BrimstoneMod extends Mod {

    @Override
    public void loadContent() {
        BrimstoneItems.load();
    }
}
