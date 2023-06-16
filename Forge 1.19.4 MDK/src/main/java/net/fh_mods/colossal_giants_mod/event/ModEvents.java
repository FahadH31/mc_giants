package net.fh_mods.colossal_giants_mod.event;

import net.fh_mods.colossal_giants_mod.ColossalGiantsMod;
import net.fh_mods.colossal_giants_mod.entity.ModEntities;
import net.fh_mods.colossal_giants_mod.entity.custom.GiantEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ColossalGiantsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntities.GIANT.get(), GiantEntity.setAttributes());
    }

    @SubscribeEvent
    public static void entitySpawnRestriction(SpawnPlacementRegisterEvent event){
        event.register(ModEntities.GIANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                PathfinderMob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}
