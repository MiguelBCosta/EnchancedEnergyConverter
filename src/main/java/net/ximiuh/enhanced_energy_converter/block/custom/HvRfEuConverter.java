package net.ximiuh.enhanced_energy_converter.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.ximiuh.enhanced_energy_converter.block.entity.HvRfEuConverterBlockEntity;

public class HvRfEuConverter  extends BaseRfEuConverter implements EntityBlock {
    public HvRfEuConverter(Properties properties) {
        super(properties);

    }

    /* BLOCK ENTITY */

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HvRfEuConverterBlockEntity(pos, state);
    }
}