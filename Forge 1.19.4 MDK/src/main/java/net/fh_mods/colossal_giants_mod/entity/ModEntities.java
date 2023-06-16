package net.fh_mods.colossal_giants_mod.entity;

import net.fh_mods.colossal_giants_mod.ColossalGiantsMod;
import net.fh_mods.colossal_giants_mod.entity.custom.GiantEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ColossalGiantsMod.MOD_ID);

    public static final RegistryObject<EntityType<GiantEntity>> GIANT =
            ENTITY_TYPES.register("giant",
                    () -> EntityType.Builder.of(GiantEntity::new, MobCategory.CREATURE)
                            .sized(3f, 10f)
                            .build(new ResourceLocation(ColossalGiantsMod.MOD_ID, "giant").toString()));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
