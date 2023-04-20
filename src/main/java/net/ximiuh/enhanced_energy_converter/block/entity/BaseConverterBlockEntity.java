package net.ximiuh.enhanced_energy_converter.block.entity;

import ic2.api.energy.EnergyNet;
import ic2.api.energy.tile.IEnergyAcceptor;
import ic2.api.energy.tile.IEnergySource;
import ic2.core.block.base.tiles.BaseTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.EnergyStorage;

public class BaseConverterBlockEntity extends BaseTileEntity implements IEnergySource {

    private final int tier;
    private final int capacity;
    private final int maxReceive;
    private final int maxEuExtract;
    private final int euBalance;
    private final EnergyStorage energyStorage;
    private boolean addedToEnet = false;
    private final LazyOptional<EnergyStorage> lazyEnergyHandler;

    public BaseConverterBlockEntity(int tier, int pCapacity, int pMaxReceive, int pBalance, BlockPos pos, BlockState state) {
        super(pos, state);
        this.tier = tier;
        this.capacity = pCapacity;
        this.maxReceive = pMaxReceive;
        this.euBalance = pBalance;
        this.maxEuExtract = pMaxReceive / pBalance;
        this.energyStorage = new EnergyStorage(capacity, pMaxReceive);
        this.lazyEnergyHandler = LazyOptional.of(() -> this.energyStorage);
    }

    //<editor-fold desc="Entity Behaviour">
    @Override
    public BlockEntityType<?> createType() {
        return null;
    }

    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap != ForgeCapabilities.ENERGY) {
            return super.getCapability(cap, side);
        } else {
            return (side != this.getFacing() || side == null) && this.lazyEnergyHandler != null ? this.lazyEnergyHandler.cast() : LazyOptional.empty();
        }
    }

    public void setFacing(Direction facing) {
        super.setFacing(facing);
        EnergyNet.INSTANCE.updateTile(this);
    }
    //</editor-fold>

    //<editor-fold desc="Life cycle Methods">
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.energyStorage.deserializeNBT(tag.get("Energy"));
        this.setChanged();
    }

    @Override
    public void onLoaded() {
        super.onLoaded();
        if (this.isSimulating() && !this.addedToEnet) {
            this.addedToEnet = true;
            EnergyNet.INSTANCE.addTile(this);
        }
    }

    public void onUnloaded(boolean chunk) {
        if (this.isSimulating() && this.addedToEnet) {
            this.addedToEnet = false;
            EnergyNet.INSTANCE.removeTile(this);
        }
        super.onUnloaded(chunk);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.lazyEnergyHandler.invalidate();
    }
    //</editor-fold>

    //<editor-fold desc="Class state methods">
    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put("Energy", this.energyStorage.serializeNBT());
    }

    @Override
    public CompoundTag getUpdateTag() {
        return serializeNBT();
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        load(tag);
    }

    //</editor-fold>

    //<editor-fold desc="IC2 Energy Methods">
    public int getEnergyStored() {
        return this.energyStorage.getEnergyStored();
    }

    private int getEuEnergy() {
        return this.energyStorage.getEnergyStored() / this.euBalance;
    }

    @Override
    public int getSourceTier() {
        return this.tier;
    }

    @Override
    public int getMaxEnergyOutput() {
        return this.maxEuExtract;
    }

    @Override
    public int getProvidedEnergy() {
        return this.getEuEnergy() >= this.maxEuExtract ? this.maxEuExtract : 0;
    }

    @Override
    public void consumeEnergy(int i) {
        int rFConsumed = i * this.euBalance;
        this.energyStorage.extractEnergy(rFConsumed, false);
    }

    @Override
    public boolean canEmitEnergy(IEnergyAcceptor iEnergyAcceptor, Direction direction) {
        return direction == this.getFacing();
    }
    //</editor-fold>

}