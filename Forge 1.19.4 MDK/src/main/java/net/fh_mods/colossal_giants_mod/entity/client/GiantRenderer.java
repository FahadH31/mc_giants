package net.fh_mods.colossal_giants_mod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fh_mods.colossal_giants_mod.ColossalGiantsMod;
import net.fh_mods.colossal_giants_mod.entity.custom.GiantEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class GiantRenderer extends GeoEntityRenderer<GiantEntity> {

    public GiantRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GiantModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GiantEntity animatable) {
        return new ResourceLocation(ColossalGiantsMod.MOD_ID, "textures/entity/giant_texture.png");
    }

    @Override
    public RenderType getRenderType(GiantEntity animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

