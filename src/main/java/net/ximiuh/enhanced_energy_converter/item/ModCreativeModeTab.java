package net.ximiuh.enhanced_energy_converter.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.ximiuh.enhanced_energy_converter.block.ModBlocks;

public class ModCreativeModeTab {
    public static final CreativeModeTab ENHANCED_ENERGY_CONVERTER = new CreativeModeTab("enhanced_energy_converter") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.LV_RF_EU_CONVERTER.get().asItem());
        }
    };
}
