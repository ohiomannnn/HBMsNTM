package com.hbm.main;

import com.hbm.blockentity.network.PipeBaseBlockEntity;
import com.hbm.blocks.ICustomBlockHighlight;
import com.hbm.blocks.ILookOverlay;
import com.hbm.blocks.IMultiBlock;
import com.hbm.blocks.NtmBlocks;
import com.hbm.blocks.bomb.BalefireBlock;
import com.hbm.blocks.generic.SellafieldSlakedBlock;
import com.hbm.config.NtmConfig;
import com.hbm.extprop.HbmLivingAttachments;
import com.hbm.fluids.NtmFluidTypes;
import com.hbm.handler.HazmatRegistry;
import com.hbm.hazard.HazardSystem;
import com.hbm.interfaces.IHoldableWeapon;
import com.hbm.interfaces.Spaghetti;
import com.hbm.inventory.MetaHelper;
import com.hbm.inventory.fluid.FluidType;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.inventory.screens.LoadingScreenRendererNT;
import com.hbm.items.*;
import com.hbm.items.special.PolaroidItem;
import com.hbm.items.tools.GeigerCounterItem;
import com.hbm.items.weapon.sedna.GunBaseNTItem;
import com.hbm.items.weapon.sedna.factory.GunFactoryClient;
import com.hbm.network.toserver.Ducc;
import com.hbm.particle.*;
import com.hbm.particle.ContrailParticle.ABMContrailProvider;
import com.hbm.particle.CoolingTowerParticle.CoolingTowerProvider;
import com.hbm.particle.ParticleDust.SweatProvider;
import com.hbm.particle.ParticleDust.VomitBloodProvider;
import com.hbm.particle.ParticleDust.VomitNormalProvider;
import com.hbm.particle.ParticleDust.VomitSmokeProvider;
import com.hbm.particle.RadiationFogParticle.RadiationFogProvider;
import com.hbm.particle.RocketFlameParticle.ExhaustMeteorProvider;
import com.hbm.particle.RocketFlameParticle.ExhaustSoyuzProvider;
import com.hbm.particle.SmokePlumeParticle.LaunchSmokeProvider;
import com.hbm.particle.engine.ParticleEngineNT;
import com.hbm.particle.engine.util.SpriteSetNT;
import com.hbm.particle.helper.ParticleCreators;
import com.hbm.particle.vanilla.PlayerCloudParticle;
import com.hbm.particle.vanilla.SmokeParticle;
import com.hbm.registry.NtmBiomes;
import com.hbm.render.entity.effect.SkeletonModel;
import com.hbm.render.entity.projectile.ModelRubble;
import com.hbm.render.entity.projectile.ModelShrapnel;
import com.hbm.render.item.weapon.sedna.ItemRenderWeaponBase;
import com.hbm.render.loader.HFRModelReloader;
import com.hbm.render.model.loader.NtmGeometryLoader;
import com.hbm.render.util.RenderInfoSystem;
import com.hbm.render.util.RenderScreenOverlay;
import com.hbm.util.*;
import com.hbm.util.mixins.invokers.RegisterClientExtensionsEventInvoker;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.gui.screens.LevelLoadingScreen;
import net.minecraft.client.gui.screens.ReceivingLevelScreen;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ItemFrame;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent.Stage;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.neoforge.network.PacketDistributor;

import java.awt.*;
import java.util.List;

@Spaghetti("die")
@Mod(value = NuclearTechMod.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(value = Dist.CLIENT)
public class NuclearTechModClient {

    public NuclearTechModClient(ModContainer modContainer) {
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            ItemBlockRenderTypes.setRenderLayer(NtmBlocks.REINFORCED_LAMINATE.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(NtmBlocks.GLASS_QUARTZ.get(), RenderType.cutout());

            // CIRCLES IN MINECRAFT
            ResourceManager.init();

            NuclearTechMod.proxy.registerBlockEntityRenderers();
            NuclearTechMod.proxy.registerClientExtensions(RegisterClientExtensionsEventInvoker.create());
            GunFactoryClient.init(RegisterClientExtensionsEventInvoker.create());
            NuclearTechMod.proxy.registerEntityRenderers();

            // todo find better place for this
            NtmItems.ITEMS.getEntries().forEach(holder -> {
                Item item = holder.get();

                if(item instanceof EnumMultiItem multiItem) {
                    if(multiItem.multiTexture) ItemProperties.register(item, NuclearTechMod.withDefaultNamespace("item_meta"), (itemStack, level, livingEntity, seed) -> MetaHelper.getMeta(itemStack));
                }
            });
            NtmBlocks.BLOCKS.getEntries().forEach(holder -> {
                Block block = holder.get();

                if(block instanceof IMultiBlock) {
                    ItemProperties.register(block.asItem(), NuclearTechMod.withDefaultNamespace("item_meta"), (itemStack, level, livingEntity, seed) -> MetaHelper.getMeta(itemStack));
                }
            });
            ItemProperties.register(NtmItems.MISSILE_SOYUZ.get(), NuclearTechMod.withDefaultNamespace("item_meta"), (stack, level, entity, seed) -> MetaHelper.getMeta(stack));
            ItemProperties.register(NtmItems.POLAROID.get(), NuclearTechMod.withDefaultNamespace("polaroid_id"), (stack, level, entity, seed) -> PolaroidItem.polaroidID);
        });
    }


    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            private static final ResourceLocation STILL = NuclearTechMod.withDefaultNamespace("block/volcanic_lava_still");
            private static final ResourceLocation FLOWING = NuclearTechMod.withDefaultNamespace("block/volcanic_lava_flowing");

            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING;
            }

        }, NtmFluidTypes.VOLCANIC_LAVA_TYPE.get());

        event.registerFluidType(new IClientFluidTypeExtensions() {
            private static final ResourceLocation STILL = NuclearTechMod.withDefaultNamespace("block/rad_lava_still");
            private static final ResourceLocation FLOWING = NuclearTechMod.withDefaultNamespace("block/rad_lava_flowing");;

            @Override
            public ResourceLocation getStillTexture() {
                return STILL;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return FLOWING;
            }

        }, NtmFluidTypes.RAD_LAVA_TYPE.get());
    }

    @SubscribeEvent
    public static void registerGeometryLoaders(ModelEvent.RegisterGeometryLoaders event) {
        event.register(NtmGeometryLoader.ID, NtmGeometryLoader.INSTANCE);
    }

    @SubscribeEvent
    public static void onRegisterClientReloadListeners(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(new HFRModelReloader());
    }

    @SubscribeEvent
    public static void onScreenRender(ScreenEvent.Render.Post event) {
        if (NtmConfig.CLIENT.ENABLE_TIPS.get()) {
            Screen screen = event.getScreen();
            if (screen instanceof LevelLoadingScreen || screen instanceof ReceivingLevelScreen) {
                LoadingScreenRendererNT.render(event.getGuiGraphics());
            }
        }
    }

    @SubscribeEvent
    public static void onJoin(ClientPlayerNetworkEvent.LoggingOut event) {
        if (NtmConfig.CLIENT.ENABLE_TIPS.get()) {
            LoadingScreenRendererNT.resetMessage();
        }
        RenderInfoSystem.clear();
    }

    public static final int ID_DUCK = 0;
    public static final int ID_FILTER = 1;
    public static final int ID_COMPASS = 2;
    public static final int ID_CABLE = 3;
    public static final int ID_DRONE = 4;
    public static final int ID_JETPACK = 5;
    public static final int ID_MAGNET = 6;
    public static final int ID_HUD = 7;
    public static final int ID_DETONATOR = 8;
    public static final int ID_FLUID_ID = 9;
    public static final int ID_FAN_MODE = 10;
    public static final int ID_TOOLABILITY = 11;
    public static final int ID_GAS_HAZARD = 12;

    public static void displayTooltip(Component component, int time, int id) {
        RenderInfoSystem.InfoEntry entry = new RenderInfoSystem.InfoEntry(component, time);
        if (id != 0) {
            RenderInfoSystem.push(entry, id);
        } else {
            RenderInfoSystem.push(entry);
        }
    }

    public static final int flashDuration = 5_000;
    public static long flashTimestamp;
    public static final int shakeDuration = 1_500;
    public static long shakeTimestamp;

    @SubscribeEvent
    public static void onRenderGuiPre(RenderGuiLayerEvent.Pre event) {

        Player player = NuclearTechMod.proxy.me();
        ItemStack stack = player.getMainHandItem();
        if(stack.getItem() instanceof IHUDItem hudItem) hudItem.renderHUD(event, player, stack);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onRenderGuiPre(RenderGuiEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        ClientLevel level = mc.level;
        if(player == null || level == null) return;

        /// NUKE SHAKE ///
        if((shakeTimestamp + shakeDuration - System.currentTimeMillis()) > 0 && NtmConfig.CLIENT.ENABLE_NUKE_HUD_SHAKE.get()) {
            double mult = (shakeTimestamp + shakeDuration - System.currentTimeMillis()) / (double) shakeDuration * 2;
            double horizontal = Mth.clamp(Math.sin(System.currentTimeMillis() * 0.02), -0.7, 0.7) * 15;
            double vertical = Mth.clamp(Math.sin(System.currentTimeMillis() * 0.01 + 2), -0.7, 0.7) * 3;
            event.getGuiGraphics().pose().translate(horizontal * mult, vertical * mult, 0);
        }

        HitResult hr = mc.hitResult;

        if(hr != null) {
            if(hr instanceof BlockHitResult bhr) {
                for(ItemStack stack : InventoryUtil.getItemsFromBothHands(player)) {
                    if(stack.getItem() instanceof ILookOverlay lookOverlay) lookOverlay.printHook(event, level, bhr.getBlockPos());
                }
                if(level.getBlockState(bhr.getBlockPos()).getBlock() instanceof ILookOverlay ilo) {
                    ilo.printHook(event, level, bhr.getBlockPos());
                }
            }
        }
    }

    public static boolean ducked = false;

    @SubscribeEvent
    public static void onRenderGuiPost(RenderGuiEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        GuiGraphics guiGraphics = event.getGuiGraphics();

        /// NUKE FLASH ///
        if (NtmConfig.CLIENT.ENABLE_NUKE_HUD_FLASH.get() && (flashTimestamp + flashDuration - Clock.get_ms()) > 0 && !mc.options.hideGui) {
            float brightness = (flashTimestamp + flashDuration - Clock.get_ms()) / (float) flashDuration;
            int alpha = (int)(brightness * 255.0F);
            int width = mc.getWindow().getGuiScaledWidth();
            int height = mc.getWindow().getGuiScaledHeight();

            // finally!
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShader(GameRenderer::getPositionColorShader);

            Tesselator tess = Tesselator.getInstance();
            BufferBuilder buf = tess.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
            buf.addVertex(width, 0, 0).setColor(255, 255, 255, alpha);
            buf.addVertex(0, 0, 0).setColor(255, 255, 255, alpha);
            buf.addVertex(0, height, 0).setColor(255, 255, 255, alpha);
            buf.addVertex(width, height, 0).setColor(255, 255, 255, alpha);
            BufferUploader.drawWithShader(buf.buildOrThrow());

            RenderSystem.defaultBlendFunc();
            RenderSystem.disableBlend();
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
        }

        /// GEIGER GUI ///
        if (checkForGeiger(mc.player)) {
            float rads = HbmLivingAttachments.getRadiation(mc.player);

            RenderScreenOverlay.renderRadCounter(guiGraphics, rads);
        }

        if (!ducked && InputConstants.isKeyDown(mc.getWindow().getWindow(), InputConstants.KEY_O) && mc.screen == null) {
            ducked = true;
            PacketDistributor.sendToServer(new Ducc());
        }

    }

    private static boolean checkForGeiger(Player player) {
        for(ItemStack stack : player.getInventory().items) {
            if(stack.getItem() instanceof GeigerCounterItem) return true;
        }
        for(ItemStack stack : player.getInventory().armor) {
            if(stack.getItem() instanceof GeigerCounterItem) return true;
        }
        for(ItemStack stack : player.getInventory().offhand) {
            if(stack.getItem() instanceof GeigerCounterItem) return true;
        }
        return false;
    }

    @SubscribeEvent
    public static void onClickInput(InputEvent.InteractionKeyMappingTriggered event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if(player == null) return;
        ItemStack itemInHand = player.getItemInHand(InteractionHand.MAIN_HAND);
        if(itemInHand.getItem() instanceof GunBaseNTItem) {
            HitResult hitResult = Minecraft.getInstance().hitResult;
            if(hitResult instanceof EntityHitResult entityHitResult && entityHitResult.getEntity() instanceof ItemFrame) return;
            event.setSwingHand(false);
            event.setCanceled(true);
        }
    }

    public static boolean renderLodeStar = false;
    public static long lastStarCheck = 0L;

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onClientTickLast(ClientTickEvent.Pre event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null) return;

        //prune other entities' muzzle flashes
        if(mc.level.getGameTime() % 30 == 0) {
            long millis = System.currentTimeMillis();
            //dead entities may have later insertion order than actively firing ones, so we be safe
            ItemRenderWeaponBase.flashMap.values().removeIf(entry -> millis - entry.longValue() >= 150);
        }

        long millis = Clock.get_ms();
        if (millis == 0) millis = System.currentTimeMillis();

        Holder<Biome> biome = player.level.getBiome(player.blockPosition);
        if (biome.is(NtmBiomes.CRATER) || biome.is(NtmBiomes.CRATER)) {
            RandomSource rand = player.random;
            for(int i = 0; i < 3; i++) {
                Minecraft.getInstance().particleEngine.createParticle(ParticleTypes.MYCELIUM, player.position.x + rand.nextGaussian() * 3, player.position.y + rand.nextGaussian() * 2, player.position.z + rand.nextGaussian() * 3, 0, 0, 0);
            }
        }

        if (lastStarCheck + 100 < millis) {
            renderLodeStar = false;
            lastStarCheck = millis;

            Vec3 pos = player.position();
            Vec3 lodestarHeading = new Vec3(0, 0, -1).xRot((float) Math.toRadians(-15)).scale(25);

            Vec3 nextPos = pos.add(lodestarHeading);
            ClipContext context = new ClipContext(pos, nextPos, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player);

            BlockHitResult hit = player.level.clip(context);
            if (hit.getType() == Type.BLOCK) {
                BlockPos blockPos = hit.getBlockPos();
                BlockState state = player.level.getBlockState(blockPos);

                if (state.is(Blocks.GLASS)) {
                    renderLodeStar = true;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onClientTickPost(ClientTickEvent.Post event) {
        GunBaseNTItem.prevOffsetVertical = GunBaseNTItem.offsetVertical;
        GunBaseNTItem.prevOffsetHorizontal = GunBaseNTItem.offsetHorizontal;

        GunBaseNTItem.offsetVertical += GunBaseNTItem.recoilVertical;
        GunBaseNTItem.offsetHorizontal += GunBaseNTItem.recoilHorizontal;

        GunBaseNTItem.recoilVertical *= GunBaseNTItem.recoilDecay;
        GunBaseNTItem.recoilHorizontal *= GunBaseNTItem.recoilDecay;

        float dV = GunBaseNTItem.offsetVertical * GunBaseNTItem.recoilRebound;
        float dH = GunBaseNTItem.offsetHorizontal * GunBaseNTItem.recoilRebound;

        GunBaseNTItem.offsetVertical -= dV;
        GunBaseNTItem.offsetHorizontal -= dH;
    }

    @SubscribeEvent
    public static void onCameraRender(ViewportEvent.ComputeCameraAngles event) {

        float partialTick = (float) event.getPartialTick();

        float smoothV = Mth.lerp(partialTick, GunBaseNTItem.prevOffsetVertical, GunBaseNTItem.offsetVertical);
        float smoothH = Mth.lerp(partialTick, GunBaseNTItem.prevOffsetHorizontal, GunBaseNTItem.offsetHorizontal);

        event.setPitch(event.getPitch() - smoothV);
        event.setYaw(event.getYaw() - smoothH);
    }

    @SubscribeEvent
    public static void onRenderHighlight(RenderHighlightEvent.Block event) {

        Level level = Minecraft.getInstance().level;

        BlockHitResult bhr = event.getTarget();

        if (bhr.getType() == Type.BLOCK) {
            Block b = level.getBlockState(bhr.getBlockPos()).getBlock();
            if (b instanceof ICustomBlockHighlight cus) {
                if (cus.shouldDrawHighlight(level, bhr.getBlockPos())) {
                    cus.drawHighlight(event, level, bhr.getBlockPos());
                    event.setCanceled(true);
                }
            }
        }
    }
    @SubscribeEvent
    public static void onOpenGUI(ScreenEvent.Opening event) {
        if(event.getScreen() instanceof TitleScreen titleScreen && NtmConfig.CLIENT.ENABLE_MAIN_MENU_WACKY_SPLASHES.get()) {

            int rand = (int) (Math.random() * 150);
            String text = switch(rand) {
                case 0 -> "Floppenheimer!";
                case 1 -> "i should dip my balls in sulfuric acid";
                case 2 -> "All answers are popbob!";
                case 3 -> "None may enter The Orb!";
                case 4 -> "Wacarb was here";
                case 5 -> "SpongeBoy me Bob I am overdosing on ketamine agagagagaga";
                case 6 -> ChatFormatting.RED + "I know where you live, " + System.getProperty("user.name");
                case 7 -> "Nice toes, now hand them over.";
                case 8 -> "I smell burnt toast!";
                case 9 -> "There are bugs under your skin!";
                case 10 -> "Fentanyl!";
                case 11 -> "Do drugs!";
                case 12 -> "Imagine being scared by splash texts!";
                case 13 -> "Semantic versioning? More like pedantic versioning.";
                case 14 -> ChatFormatting.RED + "" + ChatFormatting.BOLD + "AW SHUCKS!";
                default -> null;
            };

            double d = Math.random();
            if(d < 0.1) text = "Redditors aren't people!";
            else if(d < 0.2) text = "Can someone tell me what corrosive fumes the people on Reddit are huffing so I can avoid those more effectively?";

            if(text == null) return;

            titleScreen.splash = new SplashRenderer(text);
        }
    }

    @SubscribeEvent
    public static void registerBlockColors(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, world, pos, tintIndex) -> {
                    int variant = state.getValue(SellafieldSlakedBlock.COLOR_LEVEL);
                    return Color.HSBtoRGB(0F, 0F, 1F - variant / 15F);
                },
                NtmBlocks.SELLAFIELD_SLAKED.get(),
                NtmBlocks.SELLAFIELD_BEDROCK.get(),
                NtmBlocks.ORE_SELLAFIELD_DIAMOND.get(),
                NtmBlocks.ORE_SELLAFIELD_EMERALD.get()
        );
        event.register(
                (state, world, pos, tintIndex) -> {
                    int age = state.getValue(BalefireBlock.AGE);
                    return Color.HSBtoRGB(0F, 0F, 1F - age / 30F);
                },
                NtmBlocks.BALEFIRE.get()
        );
        event.register(
                (state, level, pos, tintIndex) -> {
                    // overlay quads use tintIndex 1
                    if (tintIndex != 1) return 0xFFFFFFFF;
                    if (level == null || pos == null) return 0xFFFFFFFF;

                    BlockEntity te = level.getBlockEntity(pos);
                    if (!(te instanceof PipeBaseBlockEntity pipe)) return 0xFFFFFFFF;
                    FluidType type = pipe.getFluidType();
                    if (type == null) return 0xFFFFFFFF;
                    return 0xFF000000 | type.getColor();
                },
                NtmBlocks.FLUID_DUCT_NEO.get()
        );
    }

    @SubscribeEvent
    public static void registerItemColors(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) -> event.getBlockColors().getColor(
                        ((BlockItem) stack.getItem()).getBlock().defaultBlockState(),
                        null, null, tintIndex
                ),
                NtmBlocks.SELLAFIELD_SLAKED.get(),
                NtmBlocks.SELLAFIELD_BEDROCK.get(),
                NtmBlocks.ORE_SELLAFIELD_DIAMOND.get(),
                NtmBlocks.ORE_SELLAFIELD_EMERALD.get()
        );
        event.register(
                (stack, tintIndex) -> tintIndex == 1 ? 0xFF000000 | Fluids.NONE.getColor() : 0xFFFFFFFF,
                NtmBlocks.FLUID_DUCT_NEO.get()
        );
        event.register(
                (stack, tintIndex) -> 0xFF000000 | Fluids.fromID(MetaHelper.getMeta(stack)).getColor(),
                NtmItems.FLUID_ICON.get()
        );
        event.register(
                (stack, tintIndex) -> {
                    if (tintIndex == 1) {
                        return 0xFF000000 | Fluids.fromID(MetaHelper.getMeta(stack)).getColor();
                    }
                    return 0xFFFFFFFF;
                },
                NtmItems.FLUID_IDENTIFIER_MULTI.get(),
                NtmItems.FLUID_TANK_FULL.get(),
                NtmItems.FLUID_TANK_LEAD_FULL.get(),
                NtmItems.FLUID_BARREL_FULL.get(),
                NtmItems.FLUID_PACK_FULL.get()
        );
        event.register(
                (stack, tintIndex) -> tintIndex == 0 ? 0xFF000000 | ((CastPlateItem) stack.getItem()).getColor(stack) : 0xFFFFFFFF,
                NtmItems.CAST_PLATE.get(),
                NtmItems.CAST_PLATE_WELDED.get()
        );
        event.register(
                (stack, tintIndex) -> tintIndex == 0 ? 0xFF000000 | ((RawIngotItem) stack.getItem()).getColor(stack) : 0xFFFFFFFF,
                NtmItems.INGOT_RAW.get()
        );
        event.register(
                (stack, tintIndex) -> tintIndex == 0 ? 0xFF000000 | ((WireDenseItem) stack.getItem()).getColor(stack) : 0xFFFFFFFF,
                NtmItems.WIRE_DENSE.get()
        );
        event.register(
                (stack, tintIndex) -> switch(tintIndex) {
                    case 0 -> 0xFF000000 | ((BoltItem) stack.getItem()).getDarkColor(stack);
                    case 1 -> 0xFF000000 | ((BoltItem) stack.getItem()).getLightColor(stack);
                    default -> 0xFFFFFFFF;
                },
                NtmItems.BOLT.get()
        );
        event.register(
                // todo KILL TS NOW
                (stack, tintIndex) -> {
                    int color = 0xFFFFFFFF;
                    if(stack.is(NtmItems.SHELL_TITANIUM.get())) color = 0xFFA99E79;
                    if(stack.is(NtmItems.SHELL_ALUMINIUM.get()) || stack.is(NtmItems.PIPE_ALUMINIUM)) color = 0xFFD0B8EB;
                    if(stack.is(NtmItems.SHELL_COPPER.get()) || stack.is(NtmItems.PIPE_COPPER)) color = 0xFFC18336;
                    if(stack.is(NtmItems.SHELL_STEEL.get()) || stack.is(NtmItems.PIPE_STEEL)) color = 0xFF4A4A4A;
                    if(stack.is(NtmItems.SHELL_WEAPON_STEEL.get())) color = 0xFF808080;
                    if(stack.is(NtmItems.SHELL_SATURNITE.get())) color = 0xFF30A4B7;
                    if(stack.is(NtmItems.PIPE_IRON.get())) color = 0xFFFFA259;
                    if(stack.is(NtmItems.PIPE_LEAD.get())) color = 0xFF646470;
                    if(stack.is(NtmItems.PIPE_STEEL.get())) color = 0xFF4A4A4A;
                    if(stack.is(NtmItems.PIPE_DURA_STEEL.get())) color = 0xFF42665C;
                    if(stack.is(NtmItems.PIPE_RUBBER.get())) color = 0xFF808080;
                    return color;
                },
                NtmItems.SHELL_TITANIUM.get(),
                NtmItems.SHELL_ALUMINIUM.get(),
                NtmItems.SHELL_COPPER.get(),
                NtmItems.SHELL_STEEL.get(),
                NtmItems.SHELL_WEAPON_STEEL.get(),
                NtmItems.SHELL_SATURNITE.get(),
                NtmItems.PIPE_IRON.get(),
                NtmItems.PIPE_COPPER.get(),
                NtmItems.PIPE_ALUMINIUM.get(),
                NtmItems.PIPE_LEAD.get(),
                NtmItems.PIPE_STEEL.get(),
                NtmItems.PIPE_DURA_STEEL.get(),
                NtmItems.PIPE_RUBBER.get()
        );
    }

    @SubscribeEvent
    public static void onRenderWorldLast(RenderLevelStageEvent event) {
        if(event.getStage() == Stage.AFTER_TRANSLUCENT_BLOCKS) { Clock.update(); }
    }

    @SubscribeEvent
    public static void onRenderLiving(RenderLivingEvent.Pre<? extends LivingEntity, ? extends EntityModel<?>> event) {
        if (NuclearTechMod.proxy.isVanished(event.getEntity())) event.setCanceled(true);
        if (!(event.getRenderer().getModel() instanceof HumanoidModel<?> model)) return;

        ItemStack mainHand = event.getEntity().getMainHandItem();
        ItemStack offHand = event.getEntity().getOffhandItem();

        if (event.getEntity() instanceof Player player && player.getMainArm() == HumanoidArm.LEFT) {
            if (mainHand.getItem() instanceof IHoldableWeapon) {
                model.leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
            }
            if (offHand.getItem() instanceof IHoldableWeapon ihw && ihw.shouldChangeOffhand()) {
                model.rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
            }
        } else {
            if (mainHand.getItem() instanceof IHoldableWeapon) {
                model.rightArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
            }
            if (offHand.getItem() instanceof IHoldableWeapon ihw && ihw.shouldChangeOffhand()) {
                model.leftArmPose = HumanoidModel.ArmPose.BOW_AND_ARROW;
            }
        }
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModelShrapnel.LAYER, ModelShrapnel::createBodyLayer);
        event.registerLayerDefinition(ModelRubble.LAYER, ModelRubble::createBodyLayer);

        event.registerLayerDefinition(SkeletonModel.SKELETON_PART_LAYER, SkeletonModel::createLayer);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void drawTooltip(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        List<Component> list = event.getToolTip();
        Item.TooltipContext context = event.getContext();
        TooltipFlag flag = event.getFlags();

        DamageResistanceHandler.addInfo(stack, list);
        HazardSystem.addFullTooltip(stack, list);
        HazmatRegistry.addInfo(list, context.level(), stack);
        ArmorRegistry.addTooltip(list, stack);

        if (flag.isAdvanced()) {
            boolean hasTags = event.getItemStack().getTags().findAny().isPresent();

            if (hasTags) {
                list.add(Component.empty());
                list.add(Component.literal("Item tags:").withStyle(ChatFormatting.BLUE));
                stack.getTags().map(TagKey::location).sorted(ResourceLocation::compareTo).forEach(location ->
                        list.add(Component.literal(" -" + location).withStyle(ChatFormatting.AQUA)
                ));
            }
            Item item = stack.getItem();
            if (item instanceof BlockItem blockItem) {
                Block block = blockItem.getBlock();
                boolean hasBlockTags = block.builtInRegistryHolder().tags().findAny().isPresent();

                if (hasBlockTags) {
                    list.add(Component.empty());
                    list.add(Component.literal("Block tags:").withStyle(ChatFormatting.GREEN));
                    block.builtInRegistryHolder().tags().map(TagKey::location).sorted(ResourceLocation::compareTo).forEach(location ->
                            list.add(Component.literal(" -" + location).withStyle(ChatFormatting.DARK_GREEN))
                    );
                }
            }
        }
    }

    @SubscribeEvent
    public static void onTextureAtlasStitched(TextureAtlasStitchedEvent event) {
        if (event.getAtlas().location().equals(TextureAtlas.LOCATION_PARTICLES)) {
            NtmParticleTypes.BASE_PARTICLE_SPRITES = new SpriteSetNT(event.getAtlas(), NuclearTechMod.withDefaultNamespace("base_particle"));

            NtmParticleTypes.VANILLA_CLOUD_SPRITES = new SpriteSetNT(event.getAtlas(), new ResourceLocation[] {
                    ResourceLocation.withDefaultNamespace("generic_7"),
                    ResourceLocation.withDefaultNamespace("generic_6"),
                    ResourceLocation.withDefaultNamespace("generic_5"),
                    ResourceLocation.withDefaultNamespace("generic_4"),
                    ResourceLocation.withDefaultNamespace("generic_3"),
                    ResourceLocation.withDefaultNamespace("generic_2"),
                    ResourceLocation.withDefaultNamespace("generic_1"),
                    ResourceLocation.withDefaultNamespace("generic_0"),
            });
        }
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpecial(NtmParticleTypes.DIGAMMA_SMOKE.get(), new DigammaSmokeParticle.Provider());
        event.registerSpecial(NtmParticleTypes.DEBRIS.get(), new ParticleDebris.Provider());
        event.registerSpecial(NtmParticleTypes.FOAM.get(), new ParticleFoam.Provider());
        event.registerSpecial(NtmParticleTypes.ASHES.get(), new AshesParticle.Provider());
        event.registerSpriteSet(NtmParticleTypes.DEAD_LEAF.get(), DeadLeafParticle.Provider::new);
        event.registerSpriteSet(NtmParticleTypes.AURA.get(), ParticleAura.Provider::new);
        event.registerSpecial(NtmParticleTypes.SKELETON.get(), new SkeletonParticle.Provider());
        event.registerSpriteSet(NtmParticleTypes.POWER_DEBUG.get(), DebugParticle.PowerProvider::new);
        event.registerSpriteSet(NtmParticleTypes.FLUID_DEBUG.get(), DebugParticle.FluidProvider::new);
        event.registerSpecial(NtmParticleTypes.SPARK.get(), new SparkParticle.Provider());

        event.registerSpecial(NtmParticleTypes.VANILLA_CLOUD.get(), new PlayerCloudParticle.Provider());

        event.registerSpecial(NtmParticleTypes.ABM_CONTRAIL.get(), new ABMContrailProvider());
        event.registerSpecial(NtmParticleTypes.LAUNCH_SMOKE.get(), new LaunchSmokeProvider());
        event.registerSpecial(NtmParticleTypes.RADIATION_FOG.get(), new RadiationFogProvider());
        event.registerSpecial(NtmParticleTypes.EXHAUST_SOYUZ.get(), new ExhaustSoyuzProvider());
        event.registerSpecial(NtmParticleTypes.EXHAUST_METEOR.get(), new ExhaustMeteorProvider());
        event.registerSpecial(NtmParticleTypes.SWEAT.get(), new SweatProvider());
        event.registerSpecial(NtmParticleTypes.VOMIT_NORMAL.get(), new VomitNormalProvider());
        event.registerSpecial(NtmParticleTypes.VOMIT_BLOOD.get(), new VomitBloodProvider());
        event.registerSpecial(NtmParticleTypes.VOMIT_SMOKE.get(), new VomitSmokeProvider());
        event.registerSpecial(NtmParticleTypes.AMAT.get(), new AmatFlashParticle.Provider());
        event.registerSpecial(NtmParticleTypes.RBMK_FLAME.get(), new RBMKFlameParticle.Provider());
        event.registerSpecial(NtmParticleTypes.COOLING_TOWER.get(), new CoolingTowerProvider());
        event.registerSpriteSet(NtmParticleTypes.GAS_FLAME.get(), ParticleGasFlame.Provider::new);
        event.registerSpecial(NtmParticleTypes.TOM_BLAST.get(), new CloudTomParticle.Provider());
    }

    @Deprecated
    public static void effectNT(CompoundTag data) {
        Minecraft mc = Minecraft.getInstance();

        mc.execute(() -> {
            Minecraft innerMc = Minecraft.getInstance();
            ClientLevel level = innerMc.level;
            if (level == null) return;

            Player player = innerMc.player;
            int particleSetting = innerMc.options.particles().get().getId();

            String type = data.getString("type");
            double x = data.getDouble("posX");
            double y = data.getDouble("posY");
            double z = data.getDouble("posZ");

            RandomSource rand = RandomSource.create();

            if (ParticleCreators.particleCreators.containsKey(type)) {
                ParticleCreators.particleCreators.get(type).makeParticle(level, player, rand, x, y, z, data);
                return;
            }

            if ("missileContrail".equals(type)) {

                if (new Vec3(player.getX() - x, player.getY() - y, player.getZ() - z).length() > 350) return;

                float scale = data.contains("scale") ? data.getFloat("scale") : 1F;
                double mX = data.getDouble("moX");
                double mY = data.getDouble("moY");
                double mZ = data.getDouble("moZ");

                RocketFlameParticle particle = new RocketFlameParticle(level, x, y, z);
                particle.quadSize = scale;
                particle.xd = mX;
                particle.yd = mY;
                particle.zd = mZ;
                if (data.contains("maxAge")) particle.lifetime = data.getInt("maxAge");
                ParticleEngineNT.INSTANCE.add(particle);
            }

            if ("smoke".equals(type)) {

                String mode = data.getString("mode");
                int count = Math.max(1, data.getInt("count"));

                if ("cloud".equals(mode)) {

                    for (int i = 0; i < count; i++) {
                        ParticleExSmoke particle = new ParticleExSmoke(level, x, y, z);
                        particle.xd = rand.nextGaussian() * (1 + (count / 150));
                        particle.yd = rand.nextGaussian() * (1 + (count / 100));
                        particle.zd = rand.nextGaussian() * (1 + (count / 150));
                        if (rand.nextBoolean()) particle.yd = Math.abs(particle.yd);
                        ParticleEngineNT.INSTANCE.add(particle);
                    }
                }

                if ("radial".equals(mode)) {

                    for (int i = 0; i < count; i++) {
                        ParticleExSmoke particle = new ParticleExSmoke(level, x, y, z);
                        particle.xd = rand.nextGaussian() * (1 + (count / 50));
                        particle.yd = rand.nextGaussian() * (1 + (count / 50));
                        particle.zd = rand.nextGaussian() * (1 + (count / 50));
                        ParticleEngineNT.INSTANCE.add(particle);
                    }
                }

                if ("radialDigamma".equals(mode)) {

                    Vec3NT vec = new Vec3NT(2, 0, 0);
                    vec.rotateAroundYRad(rand.nextFloat() * (float)Math.PI * 2F);

                    for (int i = 0; i < count; i++) {
                        DigammaSmokeParticle particle = new DigammaSmokeParticle(level, x, y, z);
                        particle.setParticleSpeed(vec.xCoord, 0, vec.zCoord);
                        innerMc.particleEngine.add(particle);

                        vec.rotateAroundYRad((float)Math.PI * 2F / (float)count);
                    }
                }

                if ("shock".equals(mode)) {

                    double strength = data.getDouble("strength");

                    Vec3NT vec = new Vec3NT(strength, 0, 0);
                    vec.rotateAroundYRad(rand.nextInt(360));

                    for (int i = 0; i < count; i++) {
                        ParticleExSmoke particle = new ParticleExSmoke(level, x, y, z);
                        particle.xd = vec.xCoord;
                        particle.zd = vec.zCoord;
                        ParticleEngineNT.INSTANCE.add(particle);

                        vec.rotateAroundXRad((float)Math.PI * 2F / (float)count);
                    }
                }

                if ("shockRand".equals(mode)) {

                    double strength = data.getDouble("strength");

                    Vec3NT vec = new Vec3NT(strength, 0, 0);
                    vec.rotateAroundYRad(rand.nextInt(360));
                    double r;

                    for (int i = 0; i < count; i++) {
                        r = rand.nextDouble();
                        ParticleExSmoke particle = new ParticleExSmoke(level, x, y, z);
                        particle.xd = vec.xCoord * r;
                        particle.zd = vec.zCoord * r;
                        ParticleEngineNT.INSTANCE.add(particle);

                        vec.rotateAroundYRad(360 / count);
                    }
                }

                if ("wave".equals(mode)) {

                    double strength = data.getDouble("range");

                    Vec3NT vec = new Vec3NT(strength, 0, 0);

                    for (int i = 0; i < count; i++) {

                        vec.rotateAroundYRad((float) Math.toRadians(rand.nextFloat() * 360F));

                        ParticleExSmoke particle = new ParticleExSmoke(level, x + vec.xCoord, y, z + vec.zCoord);
                        particle.lifetime = 50;
                        particle.xd = 0;
                        particle.yd = 0;
                        particle.zd = 0;
                        ParticleEngineNT.INSTANCE.add(particle);

                        vec.rotateAroundYRad(360 / count);
                    }
                }

                if ("foamSplash".equals(mode)) {

                    double strength = data.getDouble("range");

                    Vec3NT vec = new Vec3NT(strength, 0, 0);

                    for (int i = 0; i < count; i++) {

                        vec.rotateAroundYRad((float) Math.toRadians(rand.nextFloat() * 360F));

                        ParticleFoam particle = new ParticleFoam(level, x + vec.xCoord, y, z + vec.zCoord);
                        particle.setLifetime(50);
                        particle.setParticleSpeed(0, 0, 0);
                        innerMc.particleEngine.add(particle);

                        vec.rotateAroundYRad(360 / count);
                    }
                }
            }

            if ("muke".contains(type)) {

                ParticleEngineNT.INSTANCE.add(new MukeFlashParticle(level, x, y, z, data.getBoolean("balefire")));
                ParticleEngineNT.INSTANCE.add(new MukeWaveParticle(level, x, y, z));

                //single swing: 			HT 15,  MHT 15
                //double swing: 			HT 60,  MHT 50

                if (player != null) {
                    player.hurtTime = 15;
                    player.hurtDuration = 15;
                    player.hurtDir = 0.0F;
                }
            }

            if ("tinytot".contains(type)) {
                ParticleEngineNT.INSTANCE.add(new MukeWaveParticle(level, x, y, z));

                for (double d = 0.0D; d <= 1.6D; d += 0.1) {
                    MukeCloudParticle cloud = new MukeCloudParticle(level, x, y, z, rand.nextGaussian() * 0.05, d + rand.nextGaussian() * 0.02, rand.nextGaussian() * 0.05);
                    ParticleEngineNT.INSTANCE.add(cloud);
                }
                for (int i = 0; i < 50; i++) {
                    MukeCloudParticle cloud = new MukeCloudParticle(level, x, y + 0.5, z, rand.nextGaussian() * 0.5, rand.nextInt(5) == 0 ? 0.02 : 0, rand.nextGaussian() * 0.5);
                    ParticleEngineNT.INSTANCE.add(cloud);
                }
                for (int i = 0; i < 15; i++) {
                    double ix = rand.nextGaussian() * 0.2;
                    double iz = rand.nextGaussian() * 0.2;

                    if (ix * ix + iz * iz > 0.75) {
                        ix *= 0.5;
                        iz *= 0.5;
                    }

                    double iy = 1.6 + (rand.nextDouble() * 2 - 1) * (0.75 - (ix * ix + iz * iz)) * 0.5;

                    MukeCloudParticle cloud = new MukeCloudParticle(level, x, y, z, ix, iy + rand.nextGaussian() * 0.02, iz);
                    ParticleEngineNT.INSTANCE.add(cloud);
                }

                if (player != null) {
                    player.hurtTime = 15;
                    player.hurtDuration = 15;
                    player.hurtDir = 0.0F;
                }
            }

            if ("rbmkmush".equals(type)) {
                float scale = data.getFloat("scale");
                ParticleEngineNT.INSTANCE.add(new RBMKMushParticle(level, x, y, z, scale));
            }

            if ("network".equals(type)) {
                DebugParticle particle = null;
                double mX = data.getDouble("mX");
                double mY = data.getDouble("mY");
                double mZ = data.getDouble("mZ");

                if ("power".equals(data.getString("mode"))) {
                    particle = new DebugParticle(level, x, y, z, mX, mY, mZ);
                }
                if ("fluid".equals(data.getString("mode"))) {
                    int color = data.getInt("color");
                    particle = new DebugParticle(level, x, y, z, mX, mY, mZ, color);
                }

                if (particle != null) innerMc.particleEngine.add(particle);
            }

            if ("deadleaf".equals(type)) {
                if (particleSetting == 0 || (particleSetting == 1 && rand.nextBoolean())) {
                    innerMc.particleEngine.add(new DeadLeafParticle(level, x, y, z));
                }
            }

            if ("radiation".equals(type)) {
                if (player == null) return;
                for (int i = 0; i < data.getInt("count"); i++) {
                    ParticleAura flash = new ParticleAura(
                            level,
                            player.getX() + rand.nextGaussian() * 4,
                            player.getY() + rand.nextGaussian() * 2,
                            player.getZ() + rand.nextGaussian() * 4,
                            0, 0, 0
                    );

                    flash.setColor(0F, 0.75F, 1F);
                    flash.setParticleSpeed(rand.nextGaussian(), rand.nextGaussian(), rand.nextGaussian());
                    innerMc.particleEngine.add(flash);
                }
            }

            if("vanillaExt".equals(type)) {
                double mX = data.getDouble("mX");
                double mY = data.getDouble("mY");
                double mZ = data.getDouble("mZ");

                Particle particle = null;

                if("cloud".equals(data.getString("mode"))) {
                    particle = new PlayerCloudParticle(level, x, y, z, mX, mY, mZ);

                    if(data.contains("r")) {
                        float rng = rand.nextFloat() * 0.1F;
                        particle.setColor(data.getFloat("r") + rng, data.getFloat("g") + rng, data.getFloat("b") + rng);
                        ((PlayerCloudParticle) particle).scaleFactor = 7.5F;
                        particle.setParticleSpeed(0, 0, 0);
                    }
                }

                if("townaura".equals(data.getString("mode"))) {
                    particle = new ParticleAura(level, x, y, z, 0, 0, 0);
                    float color = 0.5F + rand.nextFloat() * 0.5F;
                    particle.setColor(0.8F * color, 0.9F * color, 1.0F * color);
                    particle.setParticleSpeed(mX, mY, mZ);
                }

                if("volcano".equals(data.getString("mode"))) {
                    particle = new SmokeParticle(level, x, y, z, mX, mY, mZ, 100, false);
                    particle.setLifetime(200 + rand.nextInt(50));
                    particle.setParticleSpeed(rand.nextGaussian() * 0.2, 2.5 + rand.nextDouble(), rand.nextGaussian() * 0.2);
                }

                if(particle != null) {
                    innerMc.particleEngine.add(particle);
                }
            }

            if("tau".equals(type)) {
                for(int i = 0; i < data.getByte("count"); i++)
                    innerMc.particleEngine.add(new SparkParticle(level, x, y, z, rand.nextGaussian() * 0.05, 0.05, rand.nextGaussian() * 0.05));
                ParticleEngineNT.INSTANCE.add(new HadronParticle(level, x, y, z));
            }

            if ("giblets".equals(type)) {
                int ent = data.getInt("ent");
                int gibType = data.getInt("gibType");
                Entity e = level.getEntity(ent);

                if (e == null) return;

                NuclearTechMod.proxy.vanish(e.getId());

                float width = e.getBbWidth();
                float height = e.getBbHeight();
                int gW = (int)(width / 0.25F);
                int gH = (int)(height / 0.25F);

                int count = (int) (gW * 1.5 * gH);

                if (data.contains("cDiv")) count = (int) Math.ceil(count / (double)data.getInt("cDiv"));

                boolean blowMeIntoTheGodDamnStratosphere = rand.nextInt(15) == 0;
                double mult = 1D;

                if (blowMeIntoTheGodDamnStratosphere) mult *= 10;

                for (int i = 0; i < count; i++) {
                    ParticleEngineNT.INSTANCE.add(new GibletParticle(level, x, y, z, rand.nextGaussian() * 0.25 * mult, rand.nextDouble() * mult, rand.nextGaussian() * 0.25 * mult, gibType));
                }
            }
        });
    }
}
