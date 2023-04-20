package net.ximiuh.enhanced_energy_converter.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.ximiuh.enhanced_energy_converter.EnhancedEnergyConverter;
import net.ximiuh.enhanced_energy_converter.block.ModBlocks;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, EnhancedEnergyConverter.MOD_ID);

    public static final RegistryObject<BlockEntityType<LvRfEuConverterBlockEntity>> LV_RF_EU_CONVERTER =
            BLOCK_ENTITIES.register("lv_rf_eu_converter", () ->
                    BlockEntityType.Builder.of(LvRfEuConverterBlockEntity::new, ModBlocks.LV_RF_EU_CONVERTER.get()).build(null));

    public static final RegistryObject<BlockEntityType<MvRfEuConverterBlockEntity>> MV_RF_EU_CONVERTER =
            BLOCK_ENTITIES.register("mv_rf_eu_converter", () ->
                    BlockEntityType.Builder.of(MvRfEuConverterBlockEntity::new, ModBlocks.MV_RF_EU_CONVERTER.get()).build(null));

    public static final RegistryObject<BlockEntityType<HvRfEuConverterBlockEntity>> HV_RF_EU_CONVERTER =
            BLOCK_ENTITIES.register("hv_rf_eu_converter", () ->
                    BlockEntityType.Builder.of(HvRfEuConverterBlockEntity::new, ModBlocks.HV_RF_EU_CONVERTER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
