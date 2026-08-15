package com.hbm.main;

import com.hbm.blockentity.IScreenProvider;
import com.hbm.blockentity.NtmBlockEntityTypes;
import com.hbm.blocks.NtmBlocks;
import com.hbm.entity.NtmEntityTypes;
import com.hbm.items.NtmItems;
import com.hbm.items.weapon.sedna.GunBaseNTItem;
import com.hbm.items.weapon.sedna.factory.LegoClient;
import com.hbm.render.blockentity.*;
import com.hbm.render.entity.EmptyEntityRenderer;
import com.hbm.render.entity.effect.*;
import com.hbm.render.entity.item.RenderFallingBlockEntityNT;
import com.hbm.render.entity.item.RenderTNTPrimedBase;
import com.hbm.render.entity.mob.CreeperNuclearRenderer;
import com.hbm.render.entity.mob.DuckRenderer;
import com.hbm.render.entity.projectile.*;
import com.hbm.render.entity.rocket.*;
import com.hbm.render.item.*;
import com.hbm.render.item.ItemRenderMissileGeneric.RenderMissileType;
import com.hbm.render.item.weapon.sedna.*;
import com.hbm.render.util.RenderInfoSystem;
import com.hbm.render.util.RenderInfoSystem.InfoEntry;
import com.hbm.util.InventoryUtil;
import com.hbm.util.i18n.I18nClient;
import com.hbm.util.i18n.ITranslate;
import com.hbm.util.particle.IParticleCreator;
import com.hbm.util.particle.ParticleCreatorClient;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ClientProxy extends ServerProxy {

    private static final I18nClient I18N = new I18nClient();

    private static final IParticleCreator PARTICLE_CREATOR = new ParticleCreatorClient();

    public ITranslate getI18n() { return I18N; }

    public IParticleCreator getParticleCreator() { return PARTICLE_CREATOR; }

    @Override
    public void registerClientExtensions(RegisterClientExtensionsEvent event) {

        //this bit registers an item renderer for every existing block entity renderer that implements IItemRendererProvider
        for(Entry<BlockEntityType<?>, BlockEntityRendererProvider<?>> entry : BlockEntityRenderers.PROVIDERS.entrySet()) {
            if(entry.getValue() instanceof IBEWLRProvider provider) registerItemRenderer(event, provider.getRenderer(), provider.getItemsForRenderer());
        }

        registerItemRenderer(event, new RenderLaserDetonator(), NtmItems.DETONATOR_LASER.get());

        registerItemRenderer(event, new RenderCableItem(), NtmBlocks.RED_CABLE.asItem());
        registerItemRenderer(event, new RenderDetCordItem(), NtmBlocks.DET_CORD.asItem());

        registerItemRenderer(event, new RenderPipeItem(), NtmBlocks.FLUID_DUCT_NEO.asItem());

        registerItemRenderer(event, new RenderBarrelItem(),
                NtmBlocks.BARREL_RED.asItem(),
                NtmBlocks.BARREL_PINK.asItem(),
                NtmBlocks.BARREL_LOX.asItem(),
                NtmBlocks.BARREL_TAINT.asItem(),
                NtmBlocks.BARREL_PLASTIC.asItem(),
                NtmBlocks.BARREL_STEEL.asItem(),
                NtmBlocks.BARREL_CORRODED.asItem(),
                NtmBlocks.BARREL_TCALLOY.asItem()
        );

        registerItemRenderer(event, new RenderBarbedWireItem(),
                NtmBlocks.BARBED_WIRE.asItem()
        );
        registerItemRenderer(event, new RenderSpikesItem(),
                NtmBlocks.SPIKES.asItem()
        );
        registerItemRenderer(event, new RenderAnvilItem(), NtmBlocks.ANVIL.asItem());
        registerItemRenderer(event, new RenderBatteryPackItem(), NtmItems.BATTERY_PACK.get());

        ItemRenderMissileGeneric.init();
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_TIER0),
                NtmItems.MISSILE_TAINT.get(),
                NtmItems.MISSILE_MICRO.get(),
                NtmItems.MISSILE_BHOLE.get(),
                NtmItems.MISSILE_SCHRABIDIUM.get(),
                NtmItems.MISSILE_EMP.get()
        );
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_TIER1),
                NtmItems.MISSILE_GENERIC.get(),
                NtmItems.MISSILE_DECOY.get(),
                NtmItems.MISSILE_INCENDIARY.get(),
                NtmItems.MISSILE_CLUSTER.get(),
                NtmItems.MISSILE_BUSTER.get()
        );
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_ABM),
                NtmItems.MISSILE_ANTI_BALLISTIC.get()
        );
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_STEALTH),
                NtmItems.MISSILE_STEALTH.get()
        );
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_ROBIN),
                NtmItems.MISSILE_SHUTTLE.get()
        );
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_TIER2),
                NtmItems.MISSILE_STRONG.get(),
                NtmItems.MISSILE_INCENDIARY_STRONG.get(),
                NtmItems.MISSILE_CLUSTER_STRONG.get(),
                NtmItems.MISSILE_BUSTER_STRONG.get(),
                NtmItems.MISSILE_EMP_STRONG.get()
        );
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_TIER3),
                NtmItems.MISSILE_BURST.get(),
                NtmItems.MISSILE_INFERNO.get(),
                NtmItems.MISSILE_RAIN.get(),
                NtmItems.MISSILE_DRILL.get()
        );
        registerItemRenderer(event, new ItemRenderMissileGeneric(RenderMissileType.TYPE_NUCLEAR),
                NtmItems.MISSILE_NUCLEAR.get(),
                NtmItems.MISSILE_NUCLEAR_CLUSTER.get(),
                NtmItems.MISSILE_VOLCANO.get(),
                NtmItems.MISSILE_DOOMSDAY.get(),
                NtmItems.MISSILE_DOOMSDAY_RUSTED.get()
        );
    }

    public static void registerItemRenderer(RegisterClientExtensionsEvent event, BlockEntityWithoutLevelRenderer bewlr, Item... items) {
        event.registerItem(new IClientItemExtensions() {
            private BlockEntityWithoutLevelRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if(renderer == null) this.renderer = bewlr;

                return renderer;
            }
        }, items);
    }

    @Override
    public void registerBlockEntityRenderers() {
        //deco
        BlockEntityRenderers.register(NtmBlockEntityTypes.BOBBLEHEAD.get(), new RenderBobble());
        BlockEntityRenderers.register(NtmBlockEntityTypes.PLUSHIE.get(), new RenderPlushie());
        //bombs
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_GADGET.get(), new RenderNukeGadget());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_LITTLE_BOY.get(), new RenderNukeLittleBoy());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_FAT_MAN.get(), new RenderNukeFatMan());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_IVY_MIKE.get(), new RenderNukeIvyMike());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_TSAR_BOMBA.get(), new RenderNukeTsarBomba());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_PROTOTYPE.get(), new RenderNukePrototype());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_FLEIJA.get(), new RenderNukeFleija());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_SOLINUIM.get(), new RenderNukeSolinium());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_N2.get(), new RenderNukeN2());
        BlockEntityRenderers.register(NtmBlockEntityTypes.NUKE_FSTBMB.get(), new RenderNukeFstbmb());
        BlockEntityRenderers.register(NtmBlockEntityTypes.CRASHED_BOMB.get(), new RenderCrashedBomb());
        //mines
        BlockEntityRenderers.register(NtmBlockEntityTypes.LANDMINE.get(), new RenderLandmine());
        //machines
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_SOLDERING_STATION.get(), new RenderSolderingStation());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_ARC_WELDER.get(), new RenderArcWelder());
        BlockEntityRenderers.register(NtmBlockEntityTypes.HEAT_BOILER.get(), new RenderHeatBoiler());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_INDUSTRIAL_BOILER.get(), new RenderIndustrialBoiler());
        BlockEntityRenderers.register(NtmBlockEntityTypes.HEATER_FIREBOX.get(), new RenderHeaterFirebox());
        BlockEntityRenderers.register(NtmBlockEntityTypes.HEATER_OVEN.get(), new RenderHeatingOven());
        BlockEntityRenderers.register(NtmBlockEntityTypes.HEATER_OILBURNER.get(), new RenderOilburner());
        BlockEntityRenderers.register(NtmBlockEntityTypes.HEATER_ELECTRIC.get(), new RenderHeaterElectric());
        BlockEntityRenderers.register(NtmBlockEntityTypes.HEATER_HEATEX.get(), new RenderHeaterHeatex());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_OIL_WELL.get(), new RenderDerrick());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_PUMPJACK.get(), new RenderPumpjack());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_FRACKING_TOWER.get(), new RenderFrackingTower());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_REFINERY.get(), new RenderRefinery());
        BlockEntityRenderers.register(NtmBlockEntityTypes.FURNACE_COMBINATION.get(), new RenderFurnaceCombination());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_BLAST_FURNACE.get(), new RenderBlastFurnace());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_WOOD_BURNER.get(), new RenderWoodBurner());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_CENTRIFUGE.get(), new RenderCentrifuge());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_CHEMICAL_PLANT.get(), new RenderChemicalPlant());
        BlockEntityRenderers.register(NtmBlockEntityTypes.ASSEMBLY_MACHINE.get(), new RenderAssemblyMachine());
        BlockEntityRenderers.register(NtmBlockEntityTypes.FLUID_TANK.get(), new RenderFluidTank());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_CHUNGUS.get(), new RenderChungus());
        BlockEntityRenderers.register(NtmBlockEntityTypes.PRESS.get(), new RenderPress());
        BlockEntityRenderers.register(NtmBlockEntityTypes.GEIGER_COUNTER.get(), new RenderGeigerBlock());
        BlockEntityRenderers.register(NtmBlockEntityTypes.BATTERY_SOCKET.get(), new RenderBatterySocket());
        BlockEntityRenderers.register(NtmBlockEntityTypes.BATTERY_REDD.get(), new RenderBatteryREDD());
        //ZIRNOX
        BlockEntityRenderers.register(NtmBlockEntityTypes.REACTOR_ZIRNOX.get(), new RenderZirnox());
        BlockEntityRenderers.register(NtmBlockEntityTypes.ZIRNOX_DESTROYED.get(), new RenderZirnoxDestroyed());
        //missile blocks
        BlockEntityRenderers.register(NtmBlockEntityTypes.LAUNCH_PAD.get(), new RenderLaunchPad());
        BlockEntityRenderers.register(NtmBlockEntityTypes.LAUNCH_PAD_LARGE.get(), new RenderLaunchPadLarge());
        BlockEntityRenderers.register(NtmBlockEntityTypes.SOYUZ_LAUNCHER.get(), new RenderSoyuzLauncher());
        BlockEntityRenderers.register(NtmBlockEntityTypes.MACHINE_RADAR.get(), new RenderRadar());
    }

    @Override
    public void registerEntityRenderers() {
        //projectiles
        EntityRenderers.register(NtmEntityTypes.BULLET_MK4.get(), RenderBulletMK4::new);
        EntityRenderers.register(NtmEntityTypes.BOMBLET_ZETA.get(), RenderBombletZeta::new);
        EntityRenderers.register(NtmEntityTypes.METEOR.get(), RenderMeteor::new);
        EntityRenderers.register(NtmEntityTypes.BOMBER.get(), RenderBomber::new);
        EntityRenderers.register(NtmEntityTypes.TOM.get(), RenderTom::new);
        EntityRenderers.register(NtmEntityTypes.RUBBLE.get(), RenderRubble::new);
        EntityRenderers.register(NtmEntityTypes.SHRAPNEL.get(), RenderShrapnel::new);
        EntityRenderers.register(NtmEntityTypes.ROCKET.get(), ThrownItemRenderer::new);
        EntityRenderers.register(NtmEntityTypes.EMP.get(), EmptyEntityRenderer::new);
        EntityRenderers.register(NtmEntityTypes.NUKE_MK5.get(), EmptyEntityRenderer::new);
        EntityRenderers.register(NtmEntityTypes.NUKE_MK3.get(), EmptyEntityRenderer::new);
        EntityRenderers.register(NtmEntityTypes.NUKE_BALEFIRE.get(), EmptyEntityRenderer::new);
        //missiles
        EntityRenderers.register(NtmEntityTypes.MISSILE_MICRO.get(), RenderMissileMicro::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_SCHRABIDIUM.get(), RenderMissileMicro::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_BHOLE.get(), RenderMissileMicro::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_TAINT.get(), RenderMissileMicro::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_EMP.get(), RenderMissileMicro::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_GENERIC.get(), RenderMissileGeneric::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_INCENDIARY.get(), RenderMissileGeneric::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_CLUSTER.get(), RenderMissileGeneric::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_BUSTER.get(), RenderMissileGeneric::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_DECOY.get(), RenderMissileGeneric::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_STRONG.get(), RenderMissileStrong::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_INCENDIARY_STRONG.get(), RenderMissileStrong::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_CLUSTER_STRONG.get(), RenderMissileStrong::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_BUSTER_STRONG.get(), RenderMissileStrong::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_EMP_STRONG.get(), RenderMissileStrong::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_STEALTH.get(), RenderMissileStealth::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_ANTI_BALLISTIC.get(), RenderMissileAntiBallistic::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_BURST.get(), RenderMissileHuge::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_INFERNO.get(), RenderMissileHuge::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_RAIN.get(), RenderMissileHuge::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_DRILL.get(), RenderMissileHuge::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_SHUTTLE.get(), RenderMissileShuttle::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_NUCLEAR.get(), RenderMissileNuclear::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_NUCLEAR_CLUSTER.get(), RenderMissileNuclear::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_VOLCANO.get(), RenderMissileNuclear::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_DOOMSDAY.get(), RenderMissileNuclear::new);
        EntityRenderers.register(NtmEntityTypes.MISSILE_DOOMSDAY_RUSTED.get(), RenderMissileNuclear::new);
        EntityRenderers.register(NtmEntityTypes.SOYUZ_MISSILE.get(), RenderSoyuz::new);
        //effects
        EntityRenderers.register(NtmEntityTypes.FALLOUT_RAIN.get(), RenderFallout::new);
        EntityRenderers.register(NtmEntityTypes.BLACK_HOLE.get(), RenderBlackHole::new);
        EntityRenderers.register(NtmEntityTypes.VORTEX.get(), RenderBlackHole::new);
        EntityRenderers.register(NtmEntityTypes.RAGING_VORTEX.get(), RenderBlackHole::new);
        EntityRenderers.register(NtmEntityTypes.DIGAMMA_QUASAR.get(), RenderQuasar::new);
        EntityRenderers.register(NtmEntityTypes.DEATH_BLAST.get(), RenderDeathBlast::new);
        EntityRenderers.register(NtmEntityTypes.ORBITAL_LASER.get(), RenderOrbitalLaser::new);
        //items
        EntityRenderers.register(NtmEntityTypes.TNT_PRIMED_BASE.get(), RenderTNTPrimedBase::new);
        EntityRenderers.register(NtmEntityTypes.FALLING_BLOCK.get(), RenderFallingBlockEntityNT::new);
        //mobs
        EntityRenderers.register(NtmEntityTypes.CREEPER_NUCLEAR.get(), CreeperNuclearRenderer::new);
        EntityRenderers.register(NtmEntityTypes.DUCK.get(), DuckRenderer::new);
    }

    private static final HashMap<Integer, Long> vanished = new HashMap<>();
    @Override public void vanish(int entityId) { vanished.put(entityId, System.currentTimeMillis() + 2000); }
    @Override public void vanish(int entityId, int duration) { vanished.put(entityId, System.currentTimeMillis() + duration); }

    @Override
    public boolean isVanished(Entity e) {
        if(!vanished.containsKey(e.getId())) return false;
        return vanished.get(e.getId()) > System.currentTimeMillis();
    }

    public void playLocalSound(Vec3 vec, SoundEvent soundEvent, SoundSource source, float volume, float pitch) {
        this.playLocalSound(vec.x, vec.y, vec.z, soundEvent, source, volume, pitch);
    }

    public void playLocalSound(double x, double y, double z, SoundEvent soundEvent, SoundSource source, float volume, float pitch) {
        Minecraft minecraft = Minecraft.getInstance();

        double distSqr = minecraft.gameRenderer.getMainCamera().getPosition().distanceToSqr(x, y, z);
        SimpleSoundInstance instance = new SimpleSoundInstance(soundEvent, source, volume, pitch, RandomSource.create(minecraft.level.random.nextLong()), x, y, z);
        if(distSqr > 100.0) {
            double dist = Math.sqrt(distSqr) / 40.0;
            minecraft.getSoundManager().playDelayed(instance, (int)(dist * 20.0));
        } else {
            minecraft.getSoundManager().play(instance);
        }
    }

    @Override
    public void openScreen(Player player, BlockPos pos) {
        if(player != this.me()) return;

        Minecraft minecraft = Minecraft.getInstance();

        Block block = player.level.getBlockState(pos).getBlock();
        if(block instanceof IScreenProvider igp) {
            Screen screen = (Screen) igp.provideScreen(player, pos);
            if(screen != null) minecraft.setScreen(screen);
        }

        List<ItemStack> stacks = InventoryUtil.getItemsFromBothHands(player);
        for(ItemStack stack : stacks) {
            if(stack.getItem() instanceof IScreenProvider igp) {
                Screen screen = (Screen) igp.provideScreen(player, pos);
                if(screen != null) minecraft.setScreen(screen);
                break;
            }
        }
    }

    @Override
    public void displayTooltip(Component message, int time, int id) {

        InfoEntry entry = new InfoEntry(message, time);
        if(id != 0) {
            RenderInfoSystem.push(entry, id);
        } else {
            RenderInfoSystem.push(entry);
        }
    }

    @Override
    public Player me() {
        return Minecraft.getInstance().player;
    }
}
