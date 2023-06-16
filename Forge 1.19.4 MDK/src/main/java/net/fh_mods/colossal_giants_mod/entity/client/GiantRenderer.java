package net.fh_mods.colossal_giants_mod.entity.client;

import net.fh_mods.colossal_giants_mod.ColossalGiantsMod;
import net.fh_mods.colossal_giants_mod.entity.custom.GiantEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GiantRenderer extends GeoEntityRenderer<GiantEntity> {

    public GiantRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GiantModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GiantEntity animatable) {
        return new ResourceLocation(ColossalGiantsMod.MOD_ID, "textures/entity/giant_texture.png");
    }
}

