package org.smlk.ink33.cheapitems;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.core.researching.Research;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricOreGrinder;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.ElectricPress;
import io.github.thebusybiscuit.slimefun4.implementation.items.electric.machines.HeatedPressureChamber;
import io.github.thebusybiscuit.slimefun4.implementation.items.multiblocks.GrindStone;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class CheapItems extends JavaPlugin implements SlimefunAddon {

        @Override
        public void onEnable() {
                ItemStack categoryItem = new CustomItem(Material.GRASS, "&4Cheap Items", "",
                                "&aClick to get cheap items");
                NamespacedKey namespacedKey = new NamespacedKey(this, "CHEAP_ITEM");

                Category category = new Category(namespacedKey, categoryItem);
                Research research = new Research(namespacedKey, 20727, "Cheap Items", 30);

                ItemStack quartzRecipe = new ItemStack(Material.SAND, 8);

                ItemStack[] recipeinSlimeItem = { null, null, null, null, quartzRecipe, null, null, null, null };
                SlimefunItemStack cheapQuartzStack = new SlimefunItemStack("CHEAP_QUARTZ",
                                new CustomItem(Material.QUARTZ, "&3Cheap Quartz", "", "I am very CHEAP!"));
                SlimefunItem cheapQuartz = new SlimefunItem(category, cheapQuartzStack,
                                RecipeType.HEATED_PRESSURE_CHAMBER, recipeinSlimeItem);
                cheapQuartz.setResearch(research);
                cheapQuartz.register(this);

                ItemStack[] cheapQuartzin = { quartzRecipe };
                ItemStack[] cheapQuartzinout = { cheapQuartz.getItem() };

                HeatedPressureChamber Press1 = (HeatedPressureChamber) SlimefunPlugin.getRegistry().getSlimefunItemIds()
                                .get("HEATED_PRESSURE_CHAMBER");
                Press1.registerRecipe(8, cheapQuartzin, cheapQuartzinout);

                HeatedPressureChamber Press2 = (HeatedPressureChamber) SlimefunPlugin.getRegistry().getSlimefunItemIds()
                                .get("HEATED_PRESSURE_CHAMBER_2");
                Press2.registerRecipe(20, cheapQuartzin, cheapQuartzinout);

                ItemStack cheapQuartzBlockPrepare = new ItemStack(cheapQuartz.getItem());
                cheapQuartzBlockPrepare.setAmount(4);
                ItemStack[] quartzBlockin = { cheapQuartzBlockPrepare };
                ItemStack[] quartzBlockout = { new ItemStack(Material.QUARTZ_BLOCK) };

                ElectricPress QuartzBlock1 = (ElectricPress) SlimefunPlugin.getRegistry().getSlimefunItemIds()
                                .get("ELECTRIC_PRESS");
                QuartzBlock1.registerRecipe(6, quartzBlockin, quartzBlockout);

                ElectricPress QuartzBlock2 = (ElectricPress) SlimefunPlugin.getRegistry().getSlimefunItemIds()
                                .get("ELECTRIC_PRESS_2");
                QuartzBlock2.registerRecipe(9, quartzBlockin, quartzBlockout);

                GrindStone Block2Quartz = (GrindStone) SlimefunPlugin.getRegistry().getSlimefunItemIds()
                                .get("GRINDSTONE");

                ItemStack[] b1 = { new ItemStack(Material.QUARTZ_BLOCK) };
                ItemStack b2 = new ItemStack(Material.QUARTZ);
                ItemStack[] b21 = {b2};
                b2.setAmount(4);
                Block2Quartz.addRecipe(b1, b2);
                ElectricOreGrinder B2Q1 = (ElectricOreGrinder) SlimefunPlugin.getRegistry().getSlimefunItemIds()
                                .get("ELECTRIC_OREGINDER");
                ElectricOreGrinder B2Q2 = (ElectricOreGrinder) SlimefunPlugin.getRegistry().getSlimefunItemIds()
                                .get("ELECTRIC_OREGINDER_2");
                B2Q1.registerRecipe(2, b1, b21);
                B2Q2.registerRecipe(1, b1, b21);
        }

        @Override
        public void onDisable() {
                // Logic for disabling the plugin...
        }

        @Override
        public String getBugTrackerURL() {
                // You can return a link to your Bug Tracker instead of null here
                return null;
        }

        @Override
        public JavaPlugin getJavaPlugin() {
                return this;
        }

}
