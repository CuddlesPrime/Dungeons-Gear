package com.infamous.dungeons_gear.client;

import com.infamous.dungeons_gear.DungeonsGear;
import com.infamous.dungeons_gear.items.armor.FreezingResistanceArmorGear;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = DungeonsGear.MODID, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void handleToolTip(ItemTooltipEvent event) {
        List<Component> tooltip = event.getToolTip();
        int index = 0;
        Item item = event.getItemStack().getItem();
        if (item instanceof FreezingResistanceArmorGear) {
            FreezingResistanceArmorGear armor = (FreezingResistanceArmorGear) item;
            // DOUBLE OR INT
            if (armor.getFreezingResistance() > 0) {
                tooltip.add(index + 1, Component.translatable(
                                "+" + armor.getFreezingResistance() + "% ")
                        .append(Component.translatable(
                                "attribute.name.freezingResistance"))
                        .withStyle(ChatFormatting.GREEN));
            }
        }
    }
}
