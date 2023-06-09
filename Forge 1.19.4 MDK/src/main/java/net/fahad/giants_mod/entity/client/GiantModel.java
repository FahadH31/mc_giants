package net.fahad.giants_mod.entity.client;

import net.fahad.giants_mod.GiantsMod;
import net.fahad.giants_mod.entity.custom.GiantEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GiantModel extends GeoModel<GiantEntity> {
    @Override
    public ResourceLocation getModelResource(GiantEntity animatable) {
        return new ResourceLocation(GiantsMod.MOD_ID, "geo/giant.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GiantEntity animatable) {
        return new ResourceLocation(GiantsMod.MOD_ID, "textures/entity/gianttexture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GiantEntity animatable) {
        return new ResourceLocation(GiantsMod.MOD_ID, "animations/giant.animation.json");
    }

    @Override
    public void setCustomAnimations(GiantEntity animatable, long instanceId, AnimationState<GiantEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if(head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
