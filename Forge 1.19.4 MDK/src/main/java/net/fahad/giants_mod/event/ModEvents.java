package net.fahad.giants_mod.event;

import net.fahad.giants_mod.GiantsMod;
import net.fahad.giants_mod.entity.ModEntities;
import net.fahad.giants_mod.entity.custom.GiantEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GiantsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntities.GIANT.get(), GiantEntity.setAttributes());
    }
}
