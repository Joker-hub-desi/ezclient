package me.tekkashi.zufclient.module.movement;

import me.tekkashi.zufclient.module.Category;
import me.tekkashi.zufclient.module.Module;
import org.lwjgl.input.Keyboard;

public class EntitySpeed extends Module {
    public EntitySpeed() {
        super("EntitySpeed" , "Makes you faster while traveling on entities", Category.MOVEMENT);
        this.setKey(Keyboard.KEY_1);
    }
}
