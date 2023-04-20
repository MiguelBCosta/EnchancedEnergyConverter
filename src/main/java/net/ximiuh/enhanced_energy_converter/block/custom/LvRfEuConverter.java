package net.ximiuh.enhanced_energy_converter.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.ximiuh.enhanced_energy_converter.block.entity.LvRfEuConverterBlockEntity;

public class LvRfEuConverter extends BaseRfEuConverter implements EntityBlock {


    public LvRfEuConverter(Properties properties) {
        super(properties);

    }

    /* BLOCK ENTITY */

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LvRfEuConverterBlockEntity(pos, state);
    }
}
