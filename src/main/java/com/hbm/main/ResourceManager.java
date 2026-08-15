package com.hbm.main;

import com.hbm.render.anim.AnimationLoader;
import com.hbm.render.anim.BusAnimation;
import com.hbm.render.loader.HFRWavefrontObject;
import com.hbm.render.loader.IModelCustom;
import com.hbm.render.loader.IObjRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.HashMap;

public class ResourceManager {
    public static final ResourceLocation EMPTY = ResourceLocation.withDefaultNamespace("missingno");

    public static final ResourceLocation MINE_AP_STONE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_ap.png");
    public static final ResourceLocation MINE_AP_SNOW_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_ap_snow.png");
    public static final ResourceLocation MINE_AP_GRASS_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_ap_grass.png");
    public static final ResourceLocation MINE_AP_DESERT_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_ap_desert.png");
    public static final ResourceLocation MINE_HE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_he.png");
    public static final ResourceLocation MINE_SHRAPNEL_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_shrap.png");
    public static final ResourceLocation MINE_NAVAL_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_naval.png");
    public static final ResourceLocation MINE_FAT_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/mine_fat.png");

    public static final ResourceLocation NUKE_GADGET_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_gadget.png");
    public static final ResourceLocation NUKE_LITTLE_BOY_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_little_boy.png");
    public static final ResourceLocation NUKE_FAT_MAN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_fatman.png");
    public static final ResourceLocation NUKE_IVY_MIKE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_ivy_mike.png");
    public static final ResourceLocation NUKE_TSAR_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_tsar.png");
    public static final ResourceLocation NUKE_PROTOTYPE = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_prototype.png");
    public static final ResourceLocation NUKE_FLEIJA_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_fleija.png");
    public static final ResourceLocation NUKE_SOLINIUM_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_solinium.png");
    public static final ResourceLocation NUKE_N2_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_n2.png");
    public static final ResourceLocation NUKE_FSTBMB_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/nuke_fstbmb.png");

    public static final ResourceLocation DUD_BALEFIRE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/dud_balefire.png");
    public static final ResourceLocation DUD_CONVENTIONAL_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/dud_conventional.png");
    public static final ResourceLocation DUD_NUKE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/dud_nuke.png");
    public static final ResourceLocation DUD_SALTED_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bombs/dud_salted.png");

    public static final ResourceLocation TANK_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/tank.png");
    public static final ResourceLocation TANK_INNER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/tank_inner.png");

    //Large Turbine
    public static final ResourceLocation CHUNGUS_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/chungus.png");

    public static final ResourceLocation BATTERY_SOCKET_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/battery_socket.png");
    public static final ResourceLocation SOLDERING_STATION_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/soldering_station.png");
    public static final ResourceLocation ARC_WELDER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/arc_welder.png");
    public static final ResourceLocation DERRICK_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/derrick.png");
    public static final ResourceLocation PUMPJACK_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/pumpjack.png");
    public static final ResourceLocation FRACKING_TOWER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/fracking_tower.png");
    public static final ResourceLocation REFINERY_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/refinery.png");
    public static final ResourceLocation FURNACE_COMBINATION_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/combination_oven.png");
    public static final ResourceLocation BLAST_FURNACE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/blast_furnace.png");
    public static final ResourceLocation WOOD_BURNER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/wood_burner.png");
    public static final ResourceLocation CENTRIFUGE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/centrifuge_new.png");
    public static final ResourceLocation CHEMICAL_PLANT_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/chemical_plant.png");
    public static final ResourceLocation CHEMICAL_PLANT_FLUID_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/chemical_plant_fluid.png");
    public static final ResourceLocation BOILER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/boiler.png");
    public static final ResourceLocation INDUSTRIAL_BOILER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/industrial_boiler.png");
    public static final ResourceLocation HEATER_FIREBOX_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/firebox.png");
    public static final ResourceLocation HEATER_OVEN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/heating_oven.png");
    public static final ResourceLocation HEATER_OILBURNER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/oilburner.png");
    public static final ResourceLocation HEATER_ELECTRIC_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/electric_heater.png");
    public static final ResourceLocation HEATER_HEATEX_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/heater_heatex.png");
    public static final ResourceLocation BATTERY_SC_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/battery_sc.png");
    public static final ResourceLocation BATTERY_REDD_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/fensu2.png");

    // Radar
    public static final ResourceLocation RADAR_BASE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/radar_base.png");
    public static final ResourceLocation RADAR_DISH_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/radar_dish.png");
    public static final ResourceLocation RADAR_LARGE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/radar_large.png");
    public static final ResourceLocation RADAR_SCREEN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/radar_screen.png");

    //Press
    public static final ResourceLocation PRESS_BODY_TEX = NuclearTechMod.withDefaultNamespace("textures/models/press_body.png");
    public static final ResourceLocation PRESS_HEAD_TEX = NuclearTechMod.withDefaultNamespace("textures/models/press_head.png");

    public static final ResourceLocation GEIGER_TEX = NuclearTechMod.withDefaultNamespace("textures/block/geiger.png");
    public static final ResourceLocation ASSEMBLY_MACHINE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/machines/assembly_machine.png");

    public static final ResourceLocation FUSION_PLASMA_TEX = NuclearTechMod.withDefaultNamespace("textures/models/fusion/plasma.png");
    public static final ResourceLocation FUSION_PLASMA_GLOW_TEX = NuclearTechMod.withDefaultNamespace("textures/models/fusion/plasma_glow.png");
    public static final ResourceLocation FUSION_PLASMA_SPARKLE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/fusion/plasma_sparkle.png");

    // Blast
    public static final ResourceLocation TOM_BLAST_TEX = NuclearTechMod.withDefaultNamespace("textures/models/explosion/tom_blast.png");

    // Boxcar
    public static final ResourceLocation TOM_MAIN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/tom_main.png");
    public static final ResourceLocation TOM_FLAME_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/tom_flame.png");

    // Projectiles
    public static final ResourceLocation CASINGS_TEX = NuclearTechMod.withDefaultNamespace("textures/particle/casings.png");

    // Bomber
    public static final ResourceLocation DORNIER_1_TEX = NuclearTechMod.withDefaultNamespace("textures/models/dornier_1.png");
    public static final ResourceLocation DORNIER_2_TEX = NuclearTechMod.withDefaultNamespace("textures/models/dornier_2.png");
    public static final ResourceLocation DORNIER_4_TEX = NuclearTechMod.withDefaultNamespace("textures/models/dornier_4.png");
    public static final ResourceLocation B29_0_TEX = NuclearTechMod.withDefaultNamespace("textures/models/b29_0.png");
    public static final ResourceLocation B29_1_TEX = NuclearTechMod.withDefaultNamespace("textures/models/b29_1.png");
    public static final ResourceLocation B29_2_TEX = NuclearTechMod.withDefaultNamespace("textures/models/b29_2.png");
    public static final ResourceLocation B29_3_TEX = NuclearTechMod.withDefaultNamespace("textures/models/b29_3.png");
    public static final ResourceLocation C130_0_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/c130_0.png");

    // Missiles
    public static final ResourceLocation MISSILE_MICRO_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_micro.png");
    public static final ResourceLocation MISSILE_MICRO_TAINT_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_micro_taint.png");
    public static final ResourceLocation MISSILE_MICRO_BHOLE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_micro_bhole.png");
    public static final ResourceLocation MISSILE_MICRO_SCHRABIDIUM_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_micro_schrab.png");
    public static final ResourceLocation MISSILE_MICRO_EMP_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_micro_emp.png");
    public static final ResourceLocation MISSILE_V2_HE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_v2.png");
    public static final ResourceLocation MISSILE_V2_IN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_v2_inc.png");
    public static final ResourceLocation MISSILE_V2_CL_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_v2_cl.png");
    public static final ResourceLocation MISSILE_V2_BU_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_v2_bu.png");
    public static final ResourceLocation MISSILE_V2_DECOY_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_v2_decoy.png");
    public static final ResourceLocation MISSILE_STEALTH_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_stealth.png");
    public static final ResourceLocation MISSILE_AA_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_abm.png");
    public static final ResourceLocation MISSILE_STRONG_HE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_strong.png");
    public static final ResourceLocation MISSILE_STRONG_EMP_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_strong_emp.png");
    public static final ResourceLocation MISSILE_STRONG_IN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_strong_inc.png");
    public static final ResourceLocation MISSILE_STRONG_CL_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_strong_cl.png");
    public static final ResourceLocation MISSILE_STRONG_BU_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_strong_bu.png");
    public static final ResourceLocation MISSILE_HUGE_HE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_huge.png");
    public static final ResourceLocation MISSILE_HUGE_IN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_huge_inc.png");
    public static final ResourceLocation MISSILE_HUGE_CL_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_huge_cl.png");
    public static final ResourceLocation MISSILE_HUGE_BU_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_huge_bu.png");
    public static final ResourceLocation MISSILE_NUCLEAR_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_atlas_nuclear.png");
    public static final ResourceLocation MISSILE_THERMO_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_atlas_thermo.png");
    public static final ResourceLocation MISSILE_VOLCANO_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_atlas_tectonic.png");
    public static final ResourceLocation MISSILE_DOOMSDAY_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_atlas_doomsday.png");
    public static final ResourceLocation MISSILE_DOOMSDAY_RUSTED_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_atlas_doomsday_weathered.png");
    public static final ResourceLocation MISSILE_SHUTTLE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/missile/missile_shuttle.png");

    public static final ResourceLocation SOYUZ_ENGINEBLOCK = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/engineblock.png");
    public static final ResourceLocation SOYUZ_BOTTOMSTAGE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/bottomstage.png");
    public static final ResourceLocation SOYUZ_TOPSTAGE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/topstage.png");
    public static final ResourceLocation SOYUZ_PAYLOAD = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/payload.png");
    public static final ResourceLocation SOYUZ_PAYLOADBLOCKS = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/payloadblocks.png");
    public static final ResourceLocation SOYUZ_LES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/les.png");
    public static final ResourceLocation SOYUZ_LESTHRUSTERS = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/lesthrusters.png");
    public static final ResourceLocation SOYUZ_MAINENGINES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/mainengines.png");
    public static final ResourceLocation SOYUZ_SIDEENGINES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/sideengines.png");
    public static final ResourceLocation SOYUZ_BOOSTER = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/booster.png");
    public static final ResourceLocation SOYUZ_BOOSTERSIDE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz/boosterside.png");
    public static final ResourceLocation SOYUZ_LUNA_ENGINEBLOCK = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/engineblock.png");
    public static final ResourceLocation SOYUZ_LUNA_BOTTOMSTAGE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/bottomstage.png");
    public static final ResourceLocation SOYUZ_LUNA_TOPSTAGE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/topstage.png");
    public static final ResourceLocation SOYUZ_LUNA_PAYLOAD =NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/payload.png");
    public static final ResourceLocation SOYUZ_LUNA_PAYLOADBLOCKS = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/payloadblocks.png");
    public static final ResourceLocation SOYUZ_LUNA_LES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/les.png");
    public static final ResourceLocation SOYUZ_LUNA_LESTHRUSTERS = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/lesthrusters.png");
    public static final ResourceLocation SOYUZ_LUNA_MAINENGINES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/mainengines.png");
    public static final ResourceLocation SOYUZ_LUNA_SIDEENGINES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/sideengines.png");
    public static final ResourceLocation SOYUZ_LUNA_BOOSTER = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/booster.png");
    public static final ResourceLocation SOYUZ_LUNA_BOOSTERSIDE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_luna/boosterside.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_ENGINEBLOCK = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/engineblock.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_BOTTOMSTAGE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/bottomstage.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_TOPSTAGE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/topstage.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_PAYLOAD = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/payload.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_PAYLOADBLOCKS = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/payloadblocks.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_LES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/les.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_LESTHRUSTERS = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/lesthrusters.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_MAINENGINES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/mainengines.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_SIDEENGINES = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/sideengines.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_BOOSTER = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/booster.png");
    public static final ResourceLocation SOYUZ_AUTHENTIC_BOOSTERSIDE = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_authentic/boosterside.png");
    public static final ResourceLocation SOYUZ_MEMENTO = NuclearTechMod.withDefaultNamespace("textures/items/polaroid_memento.png");

    public static final ResourceLocation SOYUZ_LANDER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_capsule/soyuz_lander.png");
    public static final ResourceLocation SOYUZ_LANDER_RUST_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_capsule/soyuz_lander_rust.png");
    public static final ResourceLocation SOYUZ_CHUTE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_capsule/soyuz_chute.png");
    public static final ResourceLocation SUPPLY_CRATE = NuclearTechMod.withDefaultNamespace("textures/blocks/crate_can.png");

    public static final ResourceLocation SOYUZ_MODULE_DOME_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_capsule/module_dome.png");
    public static final ResourceLocation SOYUZ_MODULE_LANDER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_capsule/module_lander.png");
    public static final ResourceLocation SOYUZ_MODULE_PROPULSION_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_capsule/module_propulsion.png");
    public static final ResourceLocation SOYUZ_MODULE_SOLAR_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_capsule/module_solar.png");

    public static final ResourceLocation SOYUZ_LAUNCHER_LEGS_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_launcher/launcher_leg.png");
    public static final ResourceLocation SOYUZ_LAUNCHER_TABLE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_launcher/launcher_table.png");
    public static final ResourceLocation SOYUZ_LAUNCHER_TOWER_BASE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_launcher/launcher_tower_base.png");
    public static final ResourceLocation SOYUZ_LAUNCHER_TOWER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_launcher/launcher_tower.png");
    public static final ResourceLocation SOYUZ_LAUNCHER_SUPPORT_BASE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_launcher/launcher_support_base.png");
    public static final ResourceLocation SOYUZ_LAUNCHER_SUPPORT_TEX = NuclearTechMod.withDefaultNamespace("textures/models/soyuz_launcher/launcher_support.png");

    // Missile Parts
    public static final ResourceLocation MISSILE_PAD_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/silo.png");
    public static final ResourceLocation MISSILE_PAD_RUSTED_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/silo_rusted.png");
    public static final ResourceLocation MISSILE_ERECTOR_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/pad.png");
    public static final ResourceLocation MISSILE_ERECTOR_MICRO_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/erector_micro.png");
    public static final ResourceLocation MISSILE_ERECTOR_V2_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/erector_v2.png");
    public static final ResourceLocation MISSILE_ERECTOR_STRONG_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/erector_strong.png");
    public static final ResourceLocation MISSILE_ERECTOR_HUGE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/erector_huge.png");
    public static final ResourceLocation MISSILE_ERECTOR_ATLAS_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/erector_atlas.png");
    public static final ResourceLocation MISSILE_ERECTOR_ABM_TEX = NuclearTechMod.withDefaultNamespace("textures/models/launchpad/erector_abm.png");

    public static final ResourceLocation BOMBLET_ZETA_TEX = NuclearTechMod.withDefaultNamespace("textures/models/bomblet_zeta.png");

    public static final ResourceLocation DETONATOR_LASER_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/detonator_laser.png");

    // Shimmer Sledge
    public static final ResourceLocation SHIMMER_SLEDGE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/shimmer_sledge.png");
    public static final ResourceLocation SHIMMER_AXE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/shimmer_axe.png");

    public static final ResourceLocation MARESLEG_TEX =  NuclearTechMod.withDefaultNamespace("textures/models/weapon/maresleg.png");
    public static final ResourceLocation MARESLEG_BROKEN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/maresleg_broken.png");
    public static final ResourceLocation DEBUG_GUN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/debug_gun.png");
    public static final ResourceLocation SPAS_12_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/spas-12.png");
    public static final ResourceLocation FATMAN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/fatman.png");
    public static final ResourceLocation FATMAN_MININUKE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/fatman_mininuke.png");
    public static final ResourceLocation FATMAN_BALEFIRE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/fatman_balefire.png");
    public static final ResourceLocation CLUSTER_SUBMUNITION_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/fatman_submunition.png");
    public static final ResourceLocation HANGMAN_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/hangman.png");
    public static final ResourceLocation DOUBLE_BARREL_SACRED_DRAGON_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/double_barrel_sacred_dragon.png");
    public static final ResourceLocation N_I_4_N_I_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/n_i_4_n_i.png");
    public static final ResourceLocation N_I_4_N_I_GREYSCALE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/weapon/n_i_4_n_i_greyscale.png");

    public static final ResourceLocation HEV_HELMET = NuclearTechMod.withDefaultNamespace("textures/armor/hev_helmet.png");
    public static final ResourceLocation HEV_LEG = NuclearTechMod.withDefaultNamespace("textures/armor/hev_leg.png");
    public static final ResourceLocation HEV_CHEST = NuclearTechMod.withDefaultNamespace("textures/armor/hev_chest.png");
    public static final ResourceLocation HEV_ARM = NuclearTechMod.withDefaultNamespace("textures/armor/hev_arm.png");

    public static final ResourceLocation HAT_TEX = NuclearTechMod.withDefaultNamespace("textures/armor/hat.png");
    public static final ResourceLocation NO9_TEX = NuclearTechMod.withDefaultNamespace("textures/armor/no9.png");
    public static final ResourceLocation NO9_INSIGNIA_TEX = NuclearTechMod.withDefaultNamespace("textures/armor/no9_insignia.png");

    //ZIRNOX
    public static final ResourceLocation ZIRNOX_TEX = NuclearTechMod.withDefaultNamespace("textures/models/zirnox.png");
    public static final ResourceLocation ZIRNOX_DESTROYED_TEX = NuclearTechMod.withDefaultNamespace("textures/models/zirnox_destroyed.png");

    public static final ResourceLocation WHITE_TEX = NuclearTechMod.withDefaultNamespace("textures/models/white.png");

    // Landmines
    public static IModelCustom mine_ap;
    public static IModelCustom mine_he;
    public static IModelCustom mine_naval;
    public static IModelCustom mine_fat;

    // Tank
    public static IModelCustom fluid_tank;
    public static IModelCustom fluid_tank_exploded;

    // Large Turbine
    public static IModelCustom chungus;

    // Press
    public static IObjRenderer press_body;
    public static IObjRenderer press_head;

    // Assembler
    public static IModelCustom assembly_machine;
    public static IModelCustom assembly_factory;

    public static IModelCustom nuke_gadget;
    public static IModelCustom nuke_little_boy;
    public static IObjRenderer nuke_fat_man;
    public static IModelCustom nuke_ivy_mike;
    public static IModelCustom nuke_tsar;
    public static IModelCustom nuke_prototype;
    public static IModelCustom nuke_fleija;
    public static IModelCustom nuke_solinium;
    public static IModelCustom nuke_n2;
    public static IModelCustom nuke_fstbmb;

    public static IModelCustom dud_balefire;
    public static IModelCustom dud_conventional;
    public static IModelCustom dud_nuke;
    public static IModelCustom dud_salted;

    public static HFRWavefrontObject barrel;
    public static HFRWavefrontObject barbed_wire;
    public static HFRWavefrontObject anvil;
    public static HFRWavefrontObject spikes;
    public static HFRWavefrontObject cable_neo;
    public static HFRWavefrontObject pipe_neo;
    public static HFRWavefrontObject difurnace_extension;

    public static IModelCustom geiger;

    // FENSU
    public static IModelCustom battery_socket;
    public static IModelCustom battery_redd;
    public static IModelCustom soldering_station;
    public static IModelCustom arc_welder;
    //Oil Pumps
    public static IModelCustom oil_derrick;
    public static IModelCustom pumpjack;
    public static IModelCustom fracking_tower;
    public static IModelCustom refinery;
    public static IModelCustom furnace_combination;
    public static IModelCustom blast_furnace;
    public static IModelCustom wood_burner;
    public static IModelCustom centrifuge;
    public static IModelCustom chemical_plant;
    public static IModelCustom boiler;
    public static IModelCustom boiler_burst;
    public static IModelCustom industrial_boiler;
    public static IModelCustom heater_firebox;
    public static IModelCustom heater_oven;
    public static IModelCustom heater_oilburner;
    public static IModelCustom heater_electric;
    public static IModelCustom heater_heatex;

    // Radar
    public static IModelCustom radar_body;
    public static IModelCustom radar;
    public static IModelCustom radar_large;
    public static IModelCustom radar_screen;

    // Boxcar
    public static IModelCustom tom_main;
    public static IModelCustom tom_flame;

    public static IObjRenderer casings;

    // Bomber
    public static IModelCustom dornier;
    public static IModelCustom b29;
    public static IModelCustom c130;

    // Missiles
    public static IModelCustom missileV2;
    public static IModelCustom missileABM;
    public static IModelCustom missileStealth;
    public static IModelCustom missileStrong;
    public static IModelCustom missileHuge;
    public static IModelCustom missileNuclear;
    public static IModelCustom missileMicro;
    public static IModelCustom missileShuttle;
    public static IModelCustom soyuz;
    public static IModelCustom soyuz_lander;
    public static IModelCustom soyuz_module;
    public static IModelCustom soyuz_launcher_legs;
    public static IModelCustom soyuz_launcher_table;
    public static IModelCustom soyuz_launcher_tower_base;
    public static IModelCustom soyuz_launcher_tower;
    public static IModelCustom soyuz_launcher_support_base;
    public static IModelCustom soyuz_launcher_support;

    //Missile Parts
    public static IModelCustom missile_pad;
    public static IModelCustom missile_erector;

    public static IModelCustom bomblet_zeta;

    public static IModelCustom detonator_laser;

    //Shimmer Sledge
    public static IModelCustom shimmer_sledge;
    public static IModelCustom shimmer_axe;

    public static IModelCustom maresleg;
    public static IModelCustom lilmac;
    public static IModelCustom spas_12;
    public static IModelCustom fatman;
    public static IModelCustom hangman;
    public static IModelCustom double_barrel;
    public static IModelCustom n_i_4_n_i;

    public static HashMap<String, BusAnimation> spas_12_anim;

    public static IModelCustom armor_hev;
    public static IModelCustom armor_hat;
    public static IModelCustom armor_no9;

    public static IObjRenderer sphere;
    public static IModelCustom sphere_new;

    // ZIRNOX
    public static IModelCustom zirnox;
    public static IModelCustom zirnox_destroyed;

    public static void init() {

        mine_ap = new HFRWavefrontObject("models/obj/bomb/mine_ap.obj").asVBO();
        mine_he = new HFRWavefrontObject("models/obj/bomb/mine_he.obj").asVBO();
        mine_naval = new HFRWavefrontObject("models/obj/bomb/mine_naval.obj").asVBO();
        mine_fat = new HFRWavefrontObject("models/obj/bomb/mine_fat.obj").asVBO();

        fluid_tank = new HFRWavefrontObject("models/obj/machines/fluid_tank.obj").asVBO();
        fluid_tank_exploded = new HFRWavefrontObject("models/obj/machines/fluid_tank_exploded.obj").asVBO();

        chungus = new HFRWavefrontObject("models/obj/machines/chungus.obj").asVBO();

        press_body = new HFRWavefrontObject("models/obj/press_body.obj").getRenderer();
        press_head = new HFRWavefrontObject("models/obj/press_head.obj").getRenderer();

        assembly_machine = new HFRWavefrontObject("models/obj/machines/assembly_machine.obj").asVBO();
        assembly_factory = new HFRWavefrontObject("models/obj/machines/assembly_factory.obj").asVBO();

        nuke_gadget = new HFRWavefrontObject("models/obj/bomb/nuke_gadget.obj").asVBO();
        nuke_little_boy = new HFRWavefrontObject("models/obj/bomb/nuke_little_boy.obj").asVBO();
        nuke_fat_man = new HFRWavefrontObject("models/obj/bomb/nuke_fatman.obj").getRenderer();
        nuke_ivy_mike = new HFRWavefrontObject("models/obj/bomb/nuke_ivy_mike.obj").asVBO();
        nuke_tsar = new HFRWavefrontObject("models/obj/bomb/nuke_tsar.obj").asVBO();
        nuke_prototype = new HFRWavefrontObject("models/obj/bomb/nuke_prototype.obj").asVBO();
        nuke_fleija = new HFRWavefrontObject("models/obj/bomb/nuke_fleija.obj").asVBO();
        nuke_solinium = new HFRWavefrontObject("models/obj/bomb/nuke_solinium.obj").asVBO();
        nuke_n2 = new HFRWavefrontObject("models/obj/bomb/nuke_n2.obj").asVBO();
        nuke_fstbmb = new HFRWavefrontObject("models/obj/bomb/nuke_fstbmb.obj").asVBO();

        dud_balefire = new HFRWavefrontObject("models/obj/bomb/dud_balefire.obj").asVBO();
        dud_conventional = new HFRWavefrontObject("models/obj/bomb/dud_conventional.obj").asVBO();
        dud_nuke = new HFRWavefrontObject("models/obj/bomb/dud_nuke.obj").asVBO();
        dud_salted = new HFRWavefrontObject("models/obj/bomb/dud_salted.obj").asVBO();

        barrel = new HFRWavefrontObject("models/obj/block/barrel.obj");
        barbed_wire = new HFRWavefrontObject("models/obj/block/barbed_wire.obj");
        anvil = new HFRWavefrontObject("models/obj/block/anvil.obj");
        spikes = new HFRWavefrontObject("models/obj/block/spikes.obj");
        cable_neo = new HFRWavefrontObject("models/obj/block/cable_neo.obj");
        pipe_neo = new HFRWavefrontObject("models/obj/block/pipe_neo.obj");
        difurnace_extension = new HFRWavefrontObject("models/obj/block/difurnace_extension.obj");

        geiger = new HFRWavefrontObject("models/obj/block/geiger.obj").asVBO();

        battery_socket = new HFRWavefrontObject("models/obj/machines/battery.obj").asVBO();
        battery_redd = new HFRWavefrontObject("models/obj/machines/fensu2.obj").asVBO();
        soldering_station = new HFRWavefrontObject("models/obj/machines/soldering_station.obj").asVBO();
        arc_welder = new HFRWavefrontObject("models/obj/machines/arc_welder.obj").asVBO();
        oil_derrick = new HFRWavefrontObject("models/obj/machines/oil_derrick.obj").asVBO();
        pumpjack = new HFRWavefrontObject("models/obj/machines/pumpjack.obj").asVBO();
        fracking_tower = new HFRWavefrontObject("models/obj/machines/fracking_tower.obj").asVBO();
        refinery = new HFRWavefrontObject("models/obj/machines/refinery.obj").asVBO();
        furnace_combination = new HFRWavefrontObject("models/obj/machines/combination_oven.obj").asVBO();
        blast_furnace = new HFRWavefrontObject("models/obj/machines/blast_furnace.obj").asVBO();
        wood_burner = new HFRWavefrontObject("models/obj/machines/wood_burner.obj").asVBO();
        centrifuge = new HFRWavefrontObject("models/obj/machines/centrifuge.obj").asVBO();
        chemical_plant = new HFRWavefrontObject("models/obj/machines/chemical_plant.obj").asVBO();
        boiler = new HFRWavefrontObject("models/obj/machines/boiler.obj").asVBO();
        boiler_burst = new HFRWavefrontObject("models/obj/machines/boiler_burst.obj").asVBO();
        industrial_boiler = new HFRWavefrontObject("models/obj/machines/industrial_boiler.obj").asVBO();
        heater_firebox = new HFRWavefrontObject("models/obj/machines/firebox.obj").asVBO();
        heater_oven = new HFRWavefrontObject("models/obj/machines/heating_oven.obj").asVBO();
        heater_oilburner = new HFRWavefrontObject("models/obj/machines/oilburner.obj").asVBO();
        heater_electric = new HFRWavefrontObject("models/obj/machines/electric_heater.obj").asVBO();
        heater_heatex = new HFRWavefrontObject("models/obj/machines/heatex.obj").asVBO();

        radar_body = new HFRWavefrontObject("models/obj/radar_base.obj").noSmooth().asVBO();
        radar = new HFRWavefrontObject("models/obj/machines/radar.obj").noSmooth().asVBO();
        radar_large = new HFRWavefrontObject("models/obj/machines/radar_large.obj").noSmooth().asVBO();
        radar_screen = new HFRWavefrontObject("models/obj/machines/radar_screen.obj").noSmooth().asVBO();

        tom_main = new HFRWavefrontObject("models/obj/weapons/tom_main.obj").asVBO();
        tom_flame = new HFRWavefrontObject("models/obj/weapons/tom_flame.obj").asVBO();

        casings = new HFRWavefrontObject("models/obj/effect/casings.obj").getRenderer();

        dornier = new HFRWavefrontObject("models/obj/dornier.obj").asVBO();
        b29 = new HFRWavefrontObject("models/obj/b29.obj").asVBO();
        c130 = new HFRWavefrontObject("models/obj/weapons/c130.obj").asVBO();

        missileV2 = new HFRWavefrontObject("models/obj/missile_v2.obj").asVBO();
        missileABM = new HFRWavefrontObject("models/obj/missile_abm.obj").asVBO();
        missileStealth = new HFRWavefrontObject("models/obj/missile_stealth.obj").asVBO();
        missileStrong = new HFRWavefrontObject("models/obj/missile_strong.obj").asVBO();
        missileHuge = new HFRWavefrontObject("models/obj/missile_huge.obj").asVBO();
        missileNuclear = new HFRWavefrontObject("models/obj/missile_atlas.obj").asVBO();
        missileMicro = new HFRWavefrontObject("models/obj/missile_micro.obj").asVBO();
        missileShuttle = new HFRWavefrontObject("models/obj/missile_shuttle.obj").asVBO();
        soyuz = new HFRWavefrontObject("models/obj/soyuz.obj").asVBO();
        soyuz_lander = new HFRWavefrontObject("models/obj/soyuz_lander.obj").asVBO();
        soyuz_module = new HFRWavefrontObject("models/obj/soyuz_module.obj").asVBO();
        soyuz_launcher_legs = new HFRWavefrontObject("models/obj/launch_table/soyuz_launcher_legs.obj").noSmooth().asVBO();
        soyuz_launcher_table = new HFRWavefrontObject("models/obj/launch_table/soyuz_launcher_table.obj").noSmooth().asVBO();
        soyuz_launcher_tower_base = new HFRWavefrontObject("models/obj/launch_table/soyuz_launcher_tower_base.obj").noSmooth().asVBO();
        soyuz_launcher_tower = new HFRWavefrontObject("models/obj/launch_table/soyuz_launcher_tower.obj").noSmooth().asVBO();
        soyuz_launcher_support_base = new HFRWavefrontObject("models/obj/launch_table/soyuz_launcher_support_base.obj").noSmooth().asVBO();
        soyuz_launcher_support = new HFRWavefrontObject("models/obj/launch_table/soyuz_launcher_support.obj").noSmooth().asVBO();

        missile_pad = new HFRWavefrontObject("models/obj/weapons/launch_pad_silo.obj").asVBO();
        missile_erector = new HFRWavefrontObject("models/obj/weapons/launch_pad_erector.obj").asVBO();

        bomblet_zeta = new HFRWavefrontObject("models/obj/bomblet_zeta.obj").asVBO();

        detonator_laser = new HFRWavefrontObject("models/obj/weapons/detonator_laser.obj").asVBO();

        //shimmer_sledge = new HFRWavefrontObject("models/obj/shimmer_sledge.obj").asVBO();
        shimmer_axe = new HFRWavefrontObject("models/obj/shimmer_axe.obj").asVBO();

        maresleg = new HFRWavefrontObject("models/obj/weapons/maresleg.obj").asVBO();
        lilmac = new HFRWavefrontObject("models/obj/weapons/lilmac.obj").asVBO();
        spas_12 = new HFRWavefrontObject("models/obj/weapons/spas-12.obj").asVBO();
        fatman = new HFRWavefrontObject("models/obj/weapons/fatman.obj").asVBO();
        hangman = new HFRWavefrontObject("models/obj/weapons/hangman.obj").asVBO();
        double_barrel = new HFRWavefrontObject("models/obj/weapons/sacred_dragon.obj").asVBO();
        n_i_4_n_i = new HFRWavefrontObject("models/obj/weapons/n_i_4_n_i.obj").asVBO();

        spas_12_anim = AnimationLoader.load(NuclearTechMod.withDefaultNamespace("models/animations/spas12.json"));

        armor_hev = new HFRWavefrontObject("models/obj/armor/hev.obj").asVBO();
        armor_hat = new HFRWavefrontObject("models/obj/armor/hat.obj").asVBO();
        armor_no9 = new HFRWavefrontObject("models/obj/armor/no9.obj").asVBO();

        sphere = new HFRWavefrontObject("models/obj/sphere.obj").getRenderer();
        sphere_new = new HFRWavefrontObject("models/obj/sphere_new.obj").asVBO();

        zirnox = new HFRWavefrontObject("models/obj/zirnox.obj").asVBO();
        zirnox_destroyed = new HFRWavefrontObject("models/obj/zirnox_destroyed.obj").asVBO();
    }
}
