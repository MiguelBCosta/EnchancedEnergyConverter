package net.ximiuh.enhanced_energy_converter.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class HvRfEuConverterBlockEntity extends BaseConverterBlockEntity {
    public HvRfEuConverterBlockEntity(BlockPos pos, BlockState state) {
        super(3,800000,4096,8,pos, state);
    }

    @Override
    public BlockEntityType<?> createType() {
        return ModBlockEntities.HV_RF_EU_CONVERTER.get();
    }
}