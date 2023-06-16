package net.fh_mods.colossal_giants_mod.sound;

import net.fh_mods.colossal_giants_mod.ColossalGiantsMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ColossalGiantsMod.MOD_ID);

    public static final RegistryObject<SoundEvent> GIANT_FOOTSTEPS = registerSoundEvent("giant_footsteps");
    public static final RegistryObject<SoundEvent> GIANT_HURT = registerSoundEvent("giant_hurt");
    public static final RegistryObject<SoundEvent> GIANT_AMBIENT = registerSoundEvent("giant_ambient");

    private static RegistryObject<SoundEvent> registerSoundEvent (String name){
        ResourceLocation id = new ResourceLocation(ColossalGiantsMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
