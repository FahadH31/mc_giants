package net.fh_mods.colossal_giants_mod.item;

import net.fh_mods.colossal_giants_mod.ColossalGiantsMod;
import net.fh_mods.colossal_giants_mod.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ColossalGiantsMod.MOD_ID);

    public static final RegistryObject<Item> GIANT_SPAWN_EGG = ITEMS.register("giant_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GIANT,0xaf7f5c,0x7c4a25,
                    new Item.Properties()));

    public static final RegistryObject<Item> SPIKED_CLUB = ITEMS.register("spiked_club",
            () -> new SwordItem(new ForgeTier(1, 1000, 0f, 1, 14, null, null),
                    7,-3.5f, new Item.Properties()));

    public static void register (IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
