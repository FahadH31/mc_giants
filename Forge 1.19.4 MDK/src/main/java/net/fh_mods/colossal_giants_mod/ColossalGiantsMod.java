package net.fh_mods.colossal_giants_mod;

import net.fh_mods.colossal_giants_mod.entity.ModEntities;
import net.fh_mods.colossal_giants_mod.entity.client.GiantRenderer;
import net.fh_mods.colossal_giants_mod.item.ModItems;
import net.fh_mods.colossal_giants_mod.sound.ModSounds;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ColossalGiantsMod.MOD_ID)
public class ColossalGiantsMod
{
    public static final String MOD_ID = "colossal_giants_mod";


    public ColossalGiantsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.SPAWN_EGGS){
            event.accept(ModItems.GIANT_SPAWN_EGG);
        }
        if(event.getTab() == CreativeModeTabs.COMBAT){
            event.accept(ModItems.SPIKED_CLUB);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.GIANT.get(), GiantRenderer::new);
        }
    }
}
