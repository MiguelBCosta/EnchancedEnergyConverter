package net.ximiuh.enhanced_energy_converter.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ximiuh.enhanced_energy_converter.EnhancedEnergyConverter;
import net.ximiuh.enhanced_energy_converter.block.custom.HvRfEuConverter;
import net.ximiuh.enhanced_energy_converter.block.custom.LvRfEuConverter;
import net.ximiuh.enhanced_energy_converter.block.custom.MvRfEuConverter;
import net.ximiuh.enhanced_energy_converter.item.ModCreativeModeTab;
import net.ximiuh.enhanced_energy_converter.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnhancedEnergyConverter.MOD_ID);

    public static final RegistryObject<Block> LV_RF_EU_CONVERTER = registerBlock("lv_rf_eu_converter", () -> new LvRfEuConverter(BlockBehaviour.Properties.of(Material.STONE).strength(1f)), ModCreativeModeTab.ENHANCED_ENERGY_CONVERTER);
    public static final RegistryObject<Block> MV_RF_EU_CONVERTER = registerBlock("mv_rf_eu_converter", () -> new MvRfEuConverter(BlockBehaviour.Properties.of(Material.STONE).strength(1f)), ModCreativeModeTab.ENHANCED_ENERGY_CONVERTER);
    public static final RegistryObject<Block> HV_RF_EU_CONVERTER = registerBlock("hv_rf_eu_converter", () -> new HvRfEuConverter(BlockBehaviour.Properties.of(Material.STONE).strength(1f)), ModCreativeModeTab.ENHANCED_ENERGY_CONVERTER);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
