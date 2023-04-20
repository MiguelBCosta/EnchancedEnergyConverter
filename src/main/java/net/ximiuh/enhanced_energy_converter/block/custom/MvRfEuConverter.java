package net.ximiuh.enhanced_energy_converter.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.ximiuh.enhanced_energy_converter.block.entity.MvRfEuConverterBlockEntity;

public class MvRfEuConverter  extends BaseRfEuConverter implements EntityBlock {
    public MvRfEuConverter(Properties properties) {
        super(properties);

    }

    /* BLOCK ENTITY */

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new MvRfEuConverterBlockEntity(pos, state);
    }
}