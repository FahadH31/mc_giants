package net.fahad.giants_mod.datagen;

import net.fahad.giants_mod.GiantsMod;
import net.fahad.giants_mod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper){
        super(output, GiantsMod.MOD_ID, existingFileHelper);
    }

    @Override
    public void registerModels(){
        withExistingParent(ModItems.GIANT_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(GiantsMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
