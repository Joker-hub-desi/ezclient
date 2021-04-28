package me.tekkashi.zufclient.module.movement;

import me.tekkashi.zufclient.module.Category;
import me.tekkashi.zufclient.module.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module{

    public Sprint() {
        super("Sprint" , "Auto runs when u hold w", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_V);
    }

}
