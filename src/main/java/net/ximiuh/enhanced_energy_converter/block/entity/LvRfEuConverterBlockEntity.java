package net.ximiuh.enhanced_energy_converter.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LvRfEuConverterBlockEntity extends BaseConverterBlockEntity {
    public LvRfEuConverterBlockEntity(BlockPos pos, BlockState state) {
        super(1,40000,256,8,pos, state);
    }

    @Override
    public BlockEntityType<?> createType() {
        return ModBlockEntities.LV_RF_EU_CONVERTER.get();
    }
}
