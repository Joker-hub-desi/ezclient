package me.tekkashi.zufclient.module;

public enum Category {
    COMBAT("Combat") , EXPLOIT("Exploit") , MISC("Misc") , MOVEMENT("Movement") , RENDER("Render") , WORLD("World") ;

    public String name;
    public int moduleIndex;

    Category(String name) {
        this.name = name;
    }
}
