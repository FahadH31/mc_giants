package net.fh_mods.colossal_giants_mod.entity.client;

import net.fh_mods.colossal_giants_mod.ColossalGiantsMod;
import net.fh_mods.colossal_giants_mod.entity.custom.GiantEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GiantModel extends AnimatedGeoModel<GiantEntity> {
    @Override
    public ResourceLocation getModelResource(GiantEntity animatable) {
        return new ResourceLocation(ColossalGiantsMod.MOD_ID, "geo/giant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GiantEntity animatable) {
        return new ResourceLocation(ColossalGiantsMod.MOD_ID, "textures/entity/giant_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GiantEntity animatable) {
        return new ResourceLocation(ColossalGiantsMod.MOD_ID, "animations/giant.animation.json");
    }
}
