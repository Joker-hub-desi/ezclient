package me.tekkashi.zufclient.module.combat;

import me.tekkashi.zufclient.module.Category;
import me.tekkashi.zufclient.module.Module;
import org.lwjgl.input.Keyboard;

public class CrystalAura extends Module {

    public CrystalAura() {
        super("CrystalAura" , "Automaticly places crystals", Category.COMBAT);
        this.setKey(Keyboard.KEY_R);
    }
}
