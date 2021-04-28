package me.tekkashi.zufclient.ui;

import me.tekkashi.zufclient.ZufMod;
import me.tekkashi.zufclient.module.Module;
import me.tekkashi.zufclient.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Comparator;

public class HUD extends Gui {

    private Minecraft mc = Minecraft.getMinecraft();

    public static class ModuleComparator implements Comparator<Module> {

        @Override
        public int compare(Module arg0 , Module arg1) {
            if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())){
                return -1;
            }
            if(Minecraft.getMinecraft().fontRenderer.getStringWidth(arg0.getName()) > Minecraft.getMinecraft().fontRenderer.getStringWidth(arg1.getName())) {
                return 1;
            }
            return 0;
        }
    }

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        ScaledResolution sr = new ScaledResolution(mc);
        FontRenderer fr = mc.fontRenderer;

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            fr.drawStringWithShadow("Ez Client" + " " + Refrence.VERSION, 2, 1, 0xffffff);
        }

        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            int y = 2;
            final int[] counter = {1};
            for (Module mod : ZufMod.moduleManager.getModuleList()) {
                if (!mod.getName().equalsIgnoreCase("") && mod.isToggled()) {
                    fr.drawStringWithShadow(mod.getName(), sr.getScaledWidth() - fr.getStringWidth(mod.getName()) - 2, y, rainbow(counter[0] * 300));
                    y += fr.FONT_HEIGHT;
                    counter[0]++;
                }
            }
        }

    }
        public static int rainbow(int delay) {
            double rainbowState = Math.ceil((System.currentTimeMillis() + delay) / 20.0);
            rainbowState %= 360;
            return Color.getHSBColor((float) (rainbowState / 360.0f) , 0.5f, 1f).getRGB();
    }
}
