package com.codekaffe.copper.sound;

import com.codekaffe.copper.KafCopper;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent UWU = registerSoundEvent("uwu");
    public static final SoundEvent SOUND_BLOCK_BREAK = registerSoundEvent("sound_block_break");
    public static final SoundEvent SOUND_BLOCK_STEP = registerSoundEvent("sound_block_step");
    public static final SoundEvent SOUND_BLOCK_PLACE = registerSoundEvent("sound_block_place");
    public static final SoundEvent SOUND_BLOCK_HIT = registerSoundEvent("sound_block_hit");
    public static final SoundEvent SOUND_BLOCK_FALL = registerSoundEvent("sound_block_fall");

    public static final BlockSoundGroup SOUND_BLOCK_SOUNDS = new BlockSoundGroup(
            1f,
            1f,
            ModSounds.SOUND_BLOCK_BREAK,
            ModSounds.SOUND_BLOCK_STEP,
            ModSounds.SOUND_BLOCK_PLACE,
            ModSounds.SOUND_BLOCK_HIT,
            ModSounds.SOUND_BLOCK_FALL
    );

    public static final SoundEvent EMERALD_DISC = registerSoundEvent("emerald_disc");

    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(KafCopper.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        KafCopper.LOGGER.info("Registering sounds for " + KafCopper.MOD_ID);
    }
}
