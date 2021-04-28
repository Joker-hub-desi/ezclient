package me.tekkashi.zufclient.module;

import me.tekkashi.zufclient.ZufMod;
import me.tekkashi.zufclient.module.combat.CrystalAura;
import me.tekkashi.zufclient.module.exploit.EzDupe;
import me.tekkashi.zufclient.module.movement.Sprint;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<Module>()).clear();

        //Combat
        this.modules.add(new CrystalAura());
        //Exploit
        this.modules.add(new EzDupe());
        //Misc
        //Movement
        this.modules.add(new Sprint());
        //Render
        //World
    }

    public Module getModule(String name) {
        for (Module m : this.modules) {
            if (m.getName().equalsIgnoreCase(name)) {
                return m;
            }
        }
        return null;

    }

    public ArrayList<Module> getModuleList() {
        return this.modules;
    }

    public static List<Module> getModulesByCategory(Category c) {
        List<Module> modules = new ArrayList<Module>();

        for(Module m : ZufMod.moduleManager.modules){
            if(m.getCategory() == c) {
                modules.add(m);
            }
        }
        return modules;
    }

}
