package com.hbm.datagen;

import com.hbm.main.NuclearTechMod;
import com.hbm.registry.NtmSoundEvents;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class NtmSoundDefinitionsProvider extends SoundDefinitionsProvider {

    protected NtmSoundDefinitionsProvider(PackOutput output, ExistingFileHelper helper) {
        super(output, NuclearTechMod.MODID, helper);
    }

    @Override
    public void registerSounds() {

        // WEAPONS
        this.add(NtmSoundEvents.GUN_REVOLVER_COCK, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/revolver_cock")))
        );
        this.add(NtmSoundEvents.GUN_REVOLVER_CLOSE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/revolver_close")))
        );
        this.add(NtmSoundEvents.GUN_REVOLVER_SPIN, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/revolver_spin")))
        );
        this.add(NtmSoundEvents.GUN_PISTOL_COCK, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/pistol_cock")))
        );
        this.add(NtmSoundEvents.GUN_MAG_SMALL_REMOVE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/mag_small_remove")))
        );
        this.add(NtmSoundEvents.GUN_MAG_SMALL_INSERT, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/mag_small_insert")))
        );
        this.add(NtmSoundEvents.GUN_LEVER_COCK, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/lever_cock")))
        );
        this.add(NtmSoundEvents.GUN_SHOTGUN_LOAD, SoundDefinition.definition()
                .with(
                        sound(NuclearTechMod.withDefaultNamespace("weapon/reload/shotgun_reload1")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/reload/shotgun_reload2")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/reload/shotgun_reload3"))
                )
        );
        this.add(NtmSoundEvents.GUN_SHOTGUN_OPEN, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/shotgun_cock_open")))
        );
        this.add(NtmSoundEvents.GUN_SHOTGUN_CLOSE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/shotgun_cock_close")))
        );
        this.add(NtmSoundEvents.GUN_SHOTGUN_COCK, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/shotgun_cock")))
        );
        this.add(NtmSoundEvents.GUN_DRY_FIRE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/reload/dry_fire_click")))
        );
        this.add(NtmSoundEvents.GUN_HEAVY_REVOLVER_FIRE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/fire/44_shoot")))
        );
        this.add(NtmSoundEvents.GUN_SHOTGUN_FIRE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/fire/shotgun")))
        );
        this.add(NtmSoundEvents.GUN_SPAS_FIRE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("weapon/shotgun_shoot")))
        );
        this.add(NtmSoundEvents.GUN_WHACK, SoundDefinition.definition()
                .with(
                        sound(NuclearTechMod.withDefaultNamespace("weapon/foley/gun_whack1")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/foley/gun_whack2"))
                )
        );
        this.add(NtmSoundEvents.PLINK_SHELL, SoundDefinition.definition()
                .with(
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/shell1")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/shell2")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/shell3"))
                )
        );
        this.add(NtmSoundEvents.PLINK_SMALL, SoundDefinition.definition()
                .with(
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/small1")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/small2")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/small3"))
                )
        );
        this.add(NtmSoundEvents.PLINK_MEDIUM, SoundDefinition.definition()
                .with(
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/medium1")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/medium2")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/medium3"))
                )
        );
        this.add(NtmSoundEvents.PLINK_LARGE, SoundDefinition.definition()
                .with(
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/large1")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/large2")),
                        sound(NuclearTechMod.withDefaultNamespace("weapon/casing/large3"))
                )
        );
        this.add(NtmSoundEvents.RICOCHET, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:weapon/ric1"),
                        sound("hbmsntm:weapon/ric2"),
                        sound("hbmsntm:weapon/ric3"),
                        sound("hbmsntm:weapon/ric4"),
                        sound("hbmsntm:weapon/ric5")
                )
        );
        this.add(NtmSoundEvents.MISSILE_TAKEOFF, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/missile_takeoff"))
        );
        this.add(NtmSoundEvents.MUKE_EXPLOSION, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/muke_explosion"))
        );
        this.add(NtmSoundEvents.ROBIN_EXPLOSION, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/robin_explosion"))
        );
        this.add(NtmSoundEvents.NUCLEAR_EXPLOSION, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/nuclear_explosion").stream())
        );
        this.add(NtmSoundEvents.EXPLOSION_LARGE_NEAR, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/explosion_large_near"))
        );
        this.add(NtmSoundEvents.EXPLOSION_LARGE_FAR, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/explosion_large_far"))
        );
        this.add(NtmSoundEvents.EXPLOSION_SMALL_NEAR, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:weapon/explosion_small_near1"),
                        sound("hbmsntm:weapon/explosion_small_near2"),
                        sound("hbmsntm:weapon/explosion_small_near3")
                )
        );
        this.add(NtmSoundEvents.EXPLOSION_SMALL_FAR, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:weapon/explosion_small_far1"),
                        sound("hbmsntm:weapon/explosion_small_far2")
                )
        );
        this.add(NtmSoundEvents.EXPLOSION_TINY, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:weapon/explosion_tiny1"),
                        sound("hbmsntm:weapon/explosion_tiny2")
                )
        );
        this.add(NtmSoundEvents.FSTBMB_START, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/fstbmb_start"))
        );
        this.add(NtmSoundEvents.FSTBMB_PING, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/fstbmb_ping"))
        );
        // FIRE WEAPONS
        this.add(NtmSoundEvents.FIRE_DISINTEGRATION, SoundDefinition.definition()
                .with(sound("hbmsntm:weapon/fire/disintegration"))
        );
        // ENTITIES
        this.add(NtmSoundEvents.OLD_EXPLOSION, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/old_explosion"))
        );
        this.add(NtmSoundEvents.SOYUZ_TAKE_OFF, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/soyuz_take_off"))
        );
        this.add(NtmSoundEvents.BOMB_WHISTLE, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/bomb_whistle"))
        );
        this.add(NtmSoundEvents.BOMBER_LOOP, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/bomber_loop"))
        );
        this.add(NtmSoundEvents.BOMBER_SMALL_LOOP, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/bomber_small_loop"))
        );
        this.add(NtmSoundEvents.PLANE_CRASH, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/plane_crash"))
        );
        this.add(NtmSoundEvents.PLANE_SHOT_DOWN, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/plane_shot_down"))
        );
        this.add(NtmSoundEvents.DUCC, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:entity/ducc1"),
                        sound("hbmsntm:entity/ducc2")
                )
        );
        this.add(NtmSoundEvents.SLICER, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:entity/slicer1"),
                        sound("hbmsntm:entity/slicer2"),
                        sound("hbmsntm:entity/slicer3"),
                        sound("hbmsntm:entity/slicer4")
                )
        );
        this.add(NtmSoundEvents.METEORITE_FALLING_LOOP, SoundDefinition.definition()
                .with(sound("hbmsntm:entity/meteorite_falling_loop"))
        );
        // PLAYERS
        this.add(NtmSoundEvents.VOMIT, SoundDefinition.definition()
                .with(sound("hbmsntm:player/vomit"))
        );
        this.add(NtmSoundEvents.COUGH, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:player/cough1"),
                        sound("hbmsntm:player/cough2"),
                        sound("hbmsntm:player/cough3"),
                        sound("hbmsntm:player/cough4")
                )
        );
        // BLOCKS
        this.add(NtmSoundEvents.PRESS_OPERATE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/press_operate")))
        );
        this.add(NtmSoundEvents.SONAR_PING, SoundDefinition.definition()
                .with(sound("hbmsntm:block/sonar_ping"))
        );
        this.add(NtmSoundEvents.PIPE_PLACED, SoundDefinition.definition()
                .with(sound("hbmsntm:block/pipe_placed"))
        );
        this.add(NtmSoundEvents.RBMK_EXPLOSION, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/rbmk_explosion")))
        );
        this.add(NtmSoundEvents.RBMK_AZ5_COVER, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/rbmk_az5_cover")))
        );
        this.add(NtmSoundEvents.TURBINE_LEVER, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/chungus_lever")))
        );
        this.add(NtmSoundEvents.BOBBLE, SoundDefinition.definition()
                .with(sound("hbmsntm:block/bobble"))
        );
        this.add(NtmSoundEvents.FENSU_HUM, SoundDefinition.definition()
                .with(sound("hbmsntm:block/fensu_hum"))
        );
        this.add(NtmSoundEvents.DEBRIS, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:block/debris1"),
                        sound("hbmsntm:block/debris2"),
                        sound("hbmsntm:block/debris3")
                )
        );
        this.add(NtmSoundEvents.LOCK_OPEN, SoundDefinition.definition()
                .with(sound("hbmsntm:block/lock_open"))
        );
        this.add(NtmSoundEvents.SOYUZ_READY, SoundDefinition.definition()
                .with(sound("hbmsntm:block/soyuz_ready"))
        );
        this.add(NtmSoundEvents.CRATE_CLOSE, SoundDefinition.definition()
                .with(sound("hbmsntm:block/crate_close"))
        );
        this.add(NtmSoundEvents.CRATE_OPEN, SoundDefinition.definition()
                .with(sound("hbmsntm:block/crate_open"))
        );
        this.add(NtmSoundEvents.SQUEAKY_TOY, SoundDefinition.definition()
                .with(sound("hbmsntm:block/squeaky_toy"))
        );
        this.add(NtmSoundEvents.HUNDUNS_MAGNIFICENT_HOWL, SoundDefinition.definition()
                .with(sound("hbmsntm:block/hunduns_magnificent_howl"))
        );
        this.add(NtmSoundEvents.ELECTRIC_MOTOR_LOOP, SoundDefinition.definition()
                .with(sound("hbmsntm:block/motor"))
        );
        this.add(NtmSoundEvents.BOILER, SoundDefinition.definition()
                .with(sound("hbmsntm:block/boiler"))
        );
        this.add(NtmSoundEvents.BOILER_GROAN, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:block/boilergroan0"),
                        sound("hbmsntm:block/boilergroan1"),
                        sound("hbmsntm:block/boilergroan2")
                )
        );
        this.add(NtmSoundEvents.TURBINE_LEVI_LOOP, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/chungus_turbine")))
        );
        this.add(NtmSoundEvents.ASSEMBLER_STRIKE, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:block/assembler_strike1"),
                        sound("hbmsntm:block/assembler_strike2")
                )
        );
        this.add(NtmSoundEvents.ASSEMBLER_CUT, SoundDefinition.definition()
                .with(sound("hbmsntm:block/assembler_cut"))
        );
        this.add(NtmSoundEvents.ASSEMBLER_START, SoundDefinition.definition()
                .with(sound("hbmsntm:block/assembler_start"))
        );
        this.add(NtmSoundEvents.ASSEMBLER_STOP, SoundDefinition.definition()
                .with(sound("hbmsntm:block/assembler_stop"))
        );
        this.add(NtmSoundEvents.CENTRIFUGE_OPERATE, SoundDefinition.definition()
                .with(sound("hbmsntm:block/centrifugeoperate"))
        );
        this.add(NtmSoundEvents.CHEMICAL_PLANT_OPERATE, SoundDefinition.definition()
                .with(sound("hbmsntm:block/chemicalplant"))
        );
        this.add(NtmSoundEvents.METAL_IMPACT, SoundDefinition.definition()
                .with(
                        sound(NuclearTechMod.withDefaultNamespace("block/metal_impact1")),
                        sound(NuclearTechMod.withDefaultNamespace("block/metal_impact2"))
                )
        );
        // DOORS
        this.add(NtmSoundEvents.TRANSITION_SEAL_OPEN, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/transition_seal_open")))
        );
        this.add(NtmSoundEvents.ALARM6, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/alarm6")))
        );
        this.add(NtmSoundEvents.SLIDING_DOOR_SHUT, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/sliding_door_shut")))
        );
        this.add(NtmSoundEvents.SLIDING_DOOR_OPENED, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/sliding_door_opened")))
        );
        this.add(NtmSoundEvents.SLIDING_DOOR_OPENING, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/sliding_door_opening")))
        );
        this.add(NtmSoundEvents.GARAGE_MOVE, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/garage_move")))
        );
        this.add(NtmSoundEvents.GARAGE_STOP, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/garage_stop")))
        );
        this.add(NtmSoundEvents.LEVER, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/lever")))
        );
        this.add(NtmSoundEvents.WGH_START, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/wgh_start")))
        );
        this.add(NtmSoundEvents.WGH_STOP, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/wgh_stop")))
        );
        this.add(NtmSoundEvents.WGH_BIG_START, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/wgh_big_start")))
        );
        this.add(NtmSoundEvents.WGH_BIG_STOP, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/wgh_big_stop")))
        );
        this.add(NtmSoundEvents.QE_SLIDING_SHUT, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/qe_sliding_shut")))
        );
        this.add(NtmSoundEvents.QE_SLIDING_OPENED, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/qe_sliding_opened")))
        );
        this.add(NtmSoundEvents.QE_SLIDING_OPENING, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/qe_sliding_opening")))
        );
        this.add(NtmSoundEvents.SLIDING_SEAL_OPEN, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/sliding_seal_open")))
        );
        this.add(NtmSoundEvents.SLIDING_SEAL_STOP, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("block/door/sliding_seal_stop")))
        );
        // ITEMS
        this.add(NtmSoundEvents.TECH_BLEEP, SoundDefinition.definition()
                .with(sound("hbmsntm:tool/tech_bleep"))
        );
        this.add(NtmSoundEvents.TECH_BOOP, SoundDefinition.definition()
                .with(sound("hbmsntm:tool/tech_boop"))
        );
        this.add(NtmSoundEvents.GEIGER1, SoundDefinition.definition().with(sound("hbmsntm:tool/geiger1")));
        this.add(NtmSoundEvents.GEIGER2, SoundDefinition.definition().with(sound("hbmsntm:tool/geiger2")));
        this.add(NtmSoundEvents.GEIGER3, SoundDefinition.definition().with(sound("hbmsntm:tool/geiger3")));
        this.add(NtmSoundEvents.GEIGER4, SoundDefinition.definition().with(sound("hbmsntm:tool/geiger4")));
        this.add(NtmSoundEvents.GEIGER5, SoundDefinition.definition().with(sound("hbmsntm:tool/geiger5")));
        this.add(NtmSoundEvents.GEIGER6, SoundDefinition.definition().with(sound("hbmsntm:tool/geiger6")));
        this.add(NtmSoundEvents.PIN_UNLOCK, SoundDefinition.definition()
                .with(sound("hbmsntm:tool/pin_unlock"))
        );
        this.add(NtmSoundEvents.PIN_BREAK, SoundDefinition.definition()
                .with(sound("hbmsntm:tool/pin_break"))
        );
        this.add(NtmSoundEvents.UNPACK, SoundDefinition.definition()
                .with(
                        sound("hbmsntm:tool/extract1"),
                        sound("hbmsntm:tool/extract2")
                )
        );
        this.add(NtmSoundEvents.UPGRADE_PLUG, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("tool/upgrade_plug")))
        );
        // ALARMS
        this.add(NtmSoundEvents.ALARM_HATCH, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("alarm/lpfhaiwg")))
        );
        this.add(NtmSoundEvents.ALARM_SOYUZED, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("alarm/soyuzed")))
        );
        this.add(NtmSoundEvents.CHIME, SoundDefinition.definition()
                .with(sound(NuclearTechMod.withDefaultNamespace("alarm/chime")))
        );
    }
}
