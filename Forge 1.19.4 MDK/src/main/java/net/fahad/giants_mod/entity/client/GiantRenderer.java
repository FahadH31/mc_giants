package net.fahad.giants_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fahad.giants_mod.GiantsMod;
import net.fahad.giants_mod.entity.custom.GiantEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GiantRenderer extends GeoEntityRenderer<GiantEntity> {

    public GiantRenderer(EntityRendererProvider.Context renderManager, GeoModel<GiantEntity> model) {
        super(renderManager, new GiantModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GiantEntity animatable) {
        return new ResourceLocation(GiantsMod.MOD_ID, "textures/entity/giantTexture.png");
    }
}
