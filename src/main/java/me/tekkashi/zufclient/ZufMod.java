package me.tekkashi.zufclient;

import me.tekkashi.zufclient.module.Module;
import me.tekkashi.zufclient.module.ModuleManager;
import me.tekkashi.zufclient.proxy.CommonProxy;
import me.tekkashi.zufclient.ui.HUD;
import me.tekkashi.zufclient.util.Refrence;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = Refrence.MOD_ID, name = Refrence.NAME, version = Refrence.VERSION)
public class ZufMod {

    public static ModuleManager moduleManager;
    public static HUD hud;

    @Mod.Instance
    public  ZufMod instance;

    @SidedProxy(clientSide = Refrence.CLIENT_PROXY_CLASS, serverSide = Refrence.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void  PreInit (FMLPreInitializationEvent event){

    }

    @Mod.EventHandler
    public void init (FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(instance);
        MinecraftForge.EVENT_BUS.register(new HUD());
        moduleManager = new ModuleManager();
        hud = new HUD();
    }

    @Mod.EventHandler
    public static void PostInit (FMLPreInitializationEvent event) {

    }

    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent e){
        if(Minecraft.getMinecraft().world == null || Minecraft.getMinecraft().player == null) {
            return;
        }

        try {
            if (Keyboard.isCreated()){
                if (Keyboard.getEventKeyState()){
                    int keyCode = Keyboard.getEventKey();
                    if (keyCode <= 0){
                        return;
                    }
                    for (Module m : moduleManager.modules){
                        if(m.getKey() == keyCode && keyCode > 0){
                            m.toggle();
                        }
                    }
                }
            }
        } catch (Exception q){
            q.printStackTrace();
        }
    }

}
