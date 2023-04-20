package net.ximiuh.enhanced_energy_converter.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MvRfEuConverterBlockEntity extends BaseConverterBlockEntity {
    public MvRfEuConverterBlockEntity(BlockPos pos, BlockState state) {
        super(2,160000,1024,8,pos, state);
    }

    @Override
    public BlockEntityType<?> createType() {
        return ModBlockEntities.MV_RF_EU_CONVERTER.get();
    }
}
