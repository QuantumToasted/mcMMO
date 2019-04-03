package com.gmail.nossr50.skills.salvage.salvageables;

import com.gmail.nossr50.config.Unload;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;


public class SalvageableManager implements Unload {
    private HashMap<Material, Salvageable> salvageables;

    /*public SalvageableManager() {
        this(55);
    }*/

    @Override
    public void unload() {
        salvageables.clear();
    }

    public SalvageableManager(List<Salvageable> salvageablesCollection) {
        this.salvageables = new HashMap<Material, Salvageable>(salvageablesCollection.size());
        registerSalvageables(salvageablesCollection);
    }

    public void registerSalvageable(Salvageable salvageable) {
        Material item = salvageable.getItemMaterial();
        salvageables.put(item, salvageable);
    }

    public void registerSalvageables(List<Salvageable> salvageables) {
        for (Salvageable salvageable : salvageables) {
            registerSalvageable(salvageable);
        }
    }

    public boolean isSalvageable(Material type) {
        return salvageables.containsKey(type);
    }

    public boolean isSalvageable(ItemStack itemStack) {
        return isSalvageable(itemStack.getType());
    }

    public Salvageable getSalvageable(Material type) {
        return salvageables.get(type);
    }
}
