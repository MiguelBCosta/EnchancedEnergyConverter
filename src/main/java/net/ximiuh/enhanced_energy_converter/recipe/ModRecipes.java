package net.ximiuh.enhanced_energy_converter.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.ximiuh.enhanced_energy_converter.EnhancedEnergyConverter;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, EnhancedEnergyConverter.MOD_ID);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}