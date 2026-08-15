package com.hbm.registry;

import com.hbm.main.NuclearTechMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NtmSoundEvents {

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, NuclearTechMod.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_REVOLVER_COCK = reg("weapon.reload.revolver_cock");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_REVOLVER_CLOSE = reg("weapon.reload.revolver_close");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_REVOLVER_SPIN = reg("weapon.reload.revolver_spin");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_PISTOL_COCK = reg("weapon.reload.pistol_cock");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_MAG_SMALL_REMOVE = reg("weapon.reload.mag_small_remove");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_MAG_SMALL_INSERT = reg("weapon.reload.mag_small_insert");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_LEVER_COCK = reg("weapon.reload.lever_cock");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_SHOTGUN_LOAD = reg("weapon.reload.shotgun_reload");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_SHOTGUN_OPEN = reg("weapon.reload.shotgun_cock_open");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_SHOTGUN_CLOSE = reg("weapon.reload.shotgun_cock_close");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_SHOTGUN_COCK = reg("weapon.reload.shotgun_cock");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_DRY_FIRE = reg("weapon.reload.dry_fire_click");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_HEAVY_REVOLVER_FIRE = reg("weapon.fire.44_shoot");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_SHOTGUN_FIRE = reg("weapon.fire.shotgun");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_SPAS_FIRE = reg("weapon.shotgun_shoot");
    public static final DeferredHolder<SoundEvent, SoundEvent> GUN_WHACK = reg("weapon.foley.gun_whack");
    public static final DeferredHolder<SoundEvent, SoundEvent> PLINK_SHELL = reg("weapon.casing.shell");
    public static final DeferredHolder<SoundEvent, SoundEvent> PLINK_SMALL = reg("weapon.casing.small");
    public static final DeferredHolder<SoundEvent, SoundEvent> PLINK_MEDIUM = reg("weapon.casing.medium");
    public static final DeferredHolder<SoundEvent, SoundEvent> PLINK_LARGE = reg("weapon.casing.large");
    public static final DeferredHolder<SoundEvent, SoundEvent> RICOCHET = reg("weapon.ricochet"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> MISSILE_TAKEOFF = reg("weapon.missile_takeoff"); // PLAYERS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> MUKE_EXPLOSION = reg("weapon.muke_explosion"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> ROBIN_EXPLOSION = reg("weapon.robin_explosion"); // PLAYERS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> NUCLEAR_EXPLOSION = reg("weapon.nuclear_explosion"); // BLOCKS CATEGORY, STREAM
    public static final DeferredHolder<SoundEvent, SoundEvent> EXPLOSION_LARGE_NEAR = reg("weapon.explosion_large_near"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> EXPLOSION_LARGE_FAR =  reg("weapon.explosion_large_far"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> EXPLOSION_SMALL_NEAR = reg("weapon.explosion_small_near"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> EXPLOSION_SMALL_FAR =  reg("weapon.explosion_small_far"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> EXPLOSION_TINY = reg("weapon.explosion_tiny"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> FSTBMB_START = reg("weapon.fstbmb_start"); // PLAYERS CATEGORY???
    public static final DeferredHolder<SoundEvent, SoundEvent> FSTBMB_PING = reg("weapon.fstbmb_ping"); // PLAYERS CATEGORY???
    // FIRE WEAPONS
    public static final DeferredHolder<SoundEvent, SoundEvent> FIRE_DISINTEGRATION = reg("weapon.fire.disintegration"); // PLAYERS CATEGORY
    // ENTITIES
    public static final DeferredHolder<SoundEvent, SoundEvent> OLD_EXPLOSION = reg("entity.old_explosion"); // AMBIENT CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> SOYUZ_TAKE_OFF = reg("entity.soyuz_take_off"); // PLAYER CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> BOMB_WHISTLE = reg("entity.bomb_whistle"); // PLAYER CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> BOMBER_LOOP = reg("entity.bomber_loop"); // HOSTILE CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> BOMBER_SMALL_LOOP = reg("entity.bomber_small_loop"); // HOSTILE CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> PLANE_CRASH = reg("entity.plane_crash"); // HOSTILE CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> PLANE_SHOT_DOWN = reg("entity.plane_shot_down"); // HOSTILE CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> DUCC = reg("entity.ducc"); // NEUTRAL CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> SLICER = reg("entity.slicer"); // NEUTRAL CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> METEORITE_FALLING_LOOP = reg("entity.meteorite_falling_loop"); // BLOCKS CATEGORY???
    // PLAYERS
    public static final DeferredHolder<SoundEvent, SoundEvent> VOMIT = reg("player.vomit"); // PLAYERS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> COUGH = reg("player.cough"); // PLAYERS CATEGORY
    // BLOCKS
    public static final DeferredHolder<SoundEvent, SoundEvent> PRESS_OPERATE = reg("block.press_operate"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> SONAR_PING = reg("block.sonar_ping"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> PIPE_PLACED = reg("block.pipe_placed"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> RBMK_EXPLOSION = reg("block.rbmk_explosion");
    public static final DeferredHolder<SoundEvent, SoundEvent> RBMK_AZ5_COVER = reg("block.rbmk_az5_cover");
    public static final DeferredHolder<SoundEvent, SoundEvent> TURBINE_LEVER = reg("block.chungus_lever");
    public static final DeferredHolder<SoundEvent, SoundEvent> BOBBLE = reg("block.bobble"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> FENSU_HUM = reg("block.fensu_hum"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> DEBRIS = reg("block.debris"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> LOCK_OPEN = reg("block.lock_open"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> SOYUZ_READY = reg("block.soyuz_ready"); // BLOCKS CATEGORY, STREAM
    public static final DeferredHolder<SoundEvent, SoundEvent> CRATE_CLOSE = reg("crate_close"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> CRATE_OPEN = reg("crate_open"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> SQUEAKY_TOY = reg("block.squeaky_toy"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> HUNDUNS_MAGNIFICENT_HOWL = reg("block.hunduns_magnificent_howl"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_MOTOR_LOOP = reg("block.motor"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> BOILER = reg("block.boiler"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> TURBINE_LEVI_LOOP = reg("block.chungus_turbine_running");
    public static final DeferredHolder<SoundEvent, SoundEvent> BOILER_GROAN = reg("block.boilergroan"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> ASSEMBLER_STRIKE = reg("block.assembler_strike"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> ASSEMBLER_CUT = reg("block.assembler_cut"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> ASSEMBLER_START = reg("block.assembler_start"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> ASSEMBLER_STOP = reg("block.assembler_stop"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> CHEMICAL_PLANT_OPERATE = reg("block.chemical_plant_operate"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> CENTRIFUGE_OPERATE = reg("block.centrifuge_operate"); // BLOCKS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> METAL_IMPACT = reg("block.metal_impact"); // BLOCKS CATEGORY
    // DOORS
    public static final DeferredHolder<SoundEvent, SoundEvent> TRANSITION_SEAL_OPEN = reg("door.transition_seal_open");
    public static final DeferredHolder<SoundEvent, SoundEvent> ALARM6 = reg("door.alarm6");
    public static final DeferredHolder<SoundEvent, SoundEvent> SLIDING_DOOR_SHUT = reg("door.sliding_door_shut");
    public static final DeferredHolder<SoundEvent, SoundEvent> SLIDING_DOOR_OPENED = reg("door.sliding_door_opened");
    public static final DeferredHolder<SoundEvent, SoundEvent> SLIDING_DOOR_OPENING = reg("door.sliding_door_opening");
    public static final DeferredHolder<SoundEvent, SoundEvent> GARAGE_MOVE = reg("door.garage_move");
    public static final DeferredHolder<SoundEvent, SoundEvent> GARAGE_STOP = reg("door.garage_stop");
    public static final DeferredHolder<SoundEvent, SoundEvent> LEVER = reg("door.lever");
    public static final DeferredHolder<SoundEvent, SoundEvent> WGH_START = reg("door.wgh_start");
    public static final DeferredHolder<SoundEvent, SoundEvent> WGH_STOP = reg("door.wgh_stop");
    public static final DeferredHolder<SoundEvent, SoundEvent> WGH_BIG_START = reg("door.wgh_big_start");
    public static final DeferredHolder<SoundEvent, SoundEvent> WGH_BIG_STOP = reg("door.wgh_big_stop");
    public static final DeferredHolder<SoundEvent, SoundEvent> QE_SLIDING_SHUT = reg("door.qe_sliding_shut");
    public static final DeferredHolder<SoundEvent, SoundEvent> QE_SLIDING_OPENED = reg("door.qe_sliding_opened");
    public static final DeferredHolder<SoundEvent, SoundEvent> QE_SLIDING_OPENING = reg("door.qe_sliding_opening");
    public static final DeferredHolder<SoundEvent, SoundEvent> SLIDING_SEAL_OPEN = reg("door.sliding_seal_open");
    public static final DeferredHolder<SoundEvent, SoundEvent> SLIDING_SEAL_STOP = reg("door.sliding_seal_stop");
    // ITEMS
    public static final DeferredHolder<SoundEvent, SoundEvent> TECH_BLEEP = reg("item.tech_bleep"); // blee-boo-bee-boop
    public static final DeferredHolder<SoundEvent, SoundEvent> TECH_BOOP = reg("item.tech_boop"); // boop
    public static final DeferredHolder<SoundEvent, SoundEvent> GEIGER1 = reg("item.geiger1");
    public static final DeferredHolder<SoundEvent, SoundEvent> GEIGER2 = reg("item.geiger2");
    public static final DeferredHolder<SoundEvent, SoundEvent> GEIGER3 = reg("item.geiger3");
    public static final DeferredHolder<SoundEvent, SoundEvent> GEIGER4 = reg("item.geiger4");
    public static final DeferredHolder<SoundEvent, SoundEvent> GEIGER5 = reg("item.geiger5");
    public static final DeferredHolder<SoundEvent, SoundEvent> GEIGER6 = reg("item.geiger6");
    public static final DeferredHolder<SoundEvent, SoundEvent> PIN_UNLOCK = reg("item.pin_unlock");
    public static final DeferredHolder<SoundEvent, SoundEvent> PIN_BREAK = reg("item.pin_break");
    public static final DeferredHolder<SoundEvent, SoundEvent> UNPACK = reg("item.unpack");
    public static final DeferredHolder<SoundEvent, SoundEvent> UPGRADE_PLUG = reg("item.upgrade_plug"); // plok
    // ALARMS
    public static final DeferredHolder<SoundEvent, SoundEvent> ALARM_HATCH = reg("alarm.hatch"); // RECORDS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> ALARM_SOYUZED = reg("alarm.soyuzed"); // RECORDS CATEGORY
    public static final DeferredHolder<SoundEvent, SoundEvent> CHIME = reg("alarm.chime"); // RECORDS CATEGORY

    private static DeferredHolder<SoundEvent, SoundEvent> reg(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(NuclearTechMod.withDefaultNamespace(name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
