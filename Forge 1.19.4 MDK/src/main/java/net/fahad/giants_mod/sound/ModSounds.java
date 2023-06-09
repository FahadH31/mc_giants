package net.fahad.giants_mod.sound;

import net.fahad.giants_mod.GiantsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GiantsMod.MOD_ID);

    public static final RegistryObject<SoundEvent> GIANT_FOOTSTEPS = registerSoundEvent("giant_footsteps");

    private static RegistryObject<SoundEvent> registerSoundEvent (String name){
        ResourceLocation id = new ResourceLocation(GiantsMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
