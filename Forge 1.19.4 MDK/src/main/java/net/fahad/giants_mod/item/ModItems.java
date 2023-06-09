package net.fahad.giants_mod.item;

import net.fahad.giants_mod.GiantsMod;
import net.fahad.giants_mod.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GiantsMod.MOD_ID);

    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GIANT,0xaf7f5c,0x7c4a25, new Item.Properties()));

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
