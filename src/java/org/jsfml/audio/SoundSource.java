package org.jsfml.audio;

import org.jsfml.internal.SFMLNativeObject;
import org.jsfml.system.Vector3f;

/**
 * Abstract base class for playable sound sources.
 */
public abstract class SoundSource extends SFMLNativeObject {
    /**
     * Enumeration of possible sound source states.
     */
    public static enum Status {
        /**
         * Indicates that the sound is currently stopped or has finished playing.
         */
        STOPPED,

        /**
         * Indicates that the sound is currently paused and can be resumed.
         */
        PAUSED,

        /**
         * Indicates that the sound is currently playing.
         */
        PLAYING
    }

    /**
     * Constructs a sound source.
     */
    public SoundSource() {
        super();
    }

    @Deprecated
    @SuppressWarnings("deprecation")
    SoundSource(long wrap) {
        super(wrap);
    }

    /**
     * Sets the pitch factor of the sound.
     * <p/>
     * This factor is used to scale the sound's original pitch. This means that the default
     * value of 1 will not affect the pitch at all. Values between 0 and 1 will pitch
     * down the sound, while values greater than 1 will pitch it up.
     *
     * @param pitch the new pitch factor of the sound.
     */
    public native void setPitch(float pitch);

    /**
     * Sets the volume of the sound.
     * <p/>
     * The sound volume is a percentages and ranges between 0 (silence) and 100 (full volume).
     * The default volume of a sound is 100.
     *
     * @param volume the new volume of the sound, ranging between 0 and 100.
     */
    public native void setVolume(float volume);

    /**
     * Sets the position of the sound in the scene.
     * <p/>
     * This allows for sound spatialization, also involving the {@link Listener}.
     * The sound position is set either absolutely in the scene or relatively to the
     * {@code Listener}, depending on whether {@link #isRelativeToListener()} is
     * {@code true} or {@code false}.
     * <p/>
     * By default, a sound is located at the origin {@code (0, 0, 0)}.
     * <p/>
     * Note that only mono sounds (ie 1 audio channel) can be spatialized.
     *
     * @param x the sound's new X coordinate.
     * @param y the sound's new Y coordinate.
     * @param z the sound's new Z coordinate.
     * @see #setRelativeToListener(boolean)
     */
    public native void setPosition(float x, float y, float z);

    /**
     * Sets the position of the sound in the scene.
     * <p/>
     * This allows for sound spatialization, also involving the {@link Listener}.
     * The sound position is set either absolutely in the scene or relatively to the
     * {@code Listener}, depending on whether {@link #isRelativeToListener()} is
     * {@code true} or {@code false}.
     * <p/>
     * By default, a sound is located at the origin {@code (0, 0, 0)}.
     * <p/>
     * Note that only mono sounds (ie 1 audio channel) can be spatialized.
     *
     * @param v the sound's new position.
     * @see #setRelativeToListener(boolean)
     */
    public final void setPosition(Vector3f v) {
        setPosition(v.x, v.y, v.z);
    }

    /**
     * Determines whether the sound position is bound to be relative to the {@link Listener}
     * or whether it is positioned absolutely in the scene.
     * <p/>
     * By default, the sound's position in the scene is absolute.
     *
     * @param relative {@code true} to make the sound position relative to the listener,
     *                 {@code false} to make it absolute.
     * @see SoundSource#setPosition(float, float, float)
     */
    public native void setRelativeToListener(boolean relative);

    /**
     * Sets the minimum distance of the sound before attenuation kicks in.
     * <p/>
     * If the distance between the sound and the {@link Listener} is less or equal to this value,
     * the sound  will be heard at its maximum volume. As the distance becomes larger,
     * the sound is attenuated (ie become more quiet) according to its attenuation factor.
     * <p/>
     * The default minimum distance is 1.
     *
     * @param distance the minimum distance before attenuation in world units.
     * @see SoundSource#setAttenuation(float)
     */
    public native void setMinDistance(float distance);

    /**
     * Sets the sound's attenuation factor.
     * <p/>
     * As the distance between the sound and the {@link Listener} becomes higher than the
     * minimum distance, the sound volume will decrease according to this factor.
     * <p/>
     * The attenuation factor ranges between 0 (no attenuation) and 100 (instant attenuation),
     * where the default value is 1.
     *
     * @param att the new attenuation factor, ranging between 0 (no attenuation)
     *            and 100 (instant attenuation).
     * @see SoundSource#setMinDistance(float)
     */
    public native void setAttenuation(float att);

    /**
     * Gets the sound's current pitch factor.
     * <p/>
     * A value of 1 means that the sound is not pitched, a value between 0 and 1 means that
     * the sound is pitched down, a value greater than 1 means that the sound is pitched up.
     *
     * @return the sound's current pitch factor.
     */
    public native float getPitch();

    /**
     * Gets the sound's current volume.
     * <p/>
     * The volume level ranges between 0 (silence) and 100 (full volume).
     *
     * @return the sound's current volume, ranging between 0 (silence) and 100 (full volume).
     */
    public native float getVolume();

    /**
     * Gets the sound's current position in the scene.
     *
     * @return the sound's current position in the scene.
     */
    public native Vector3f getPosition();

    /**
     * Returns whether the sound's position is relative to the {@link Listener}.
     *
     * @return {@code true} if the sound's position is relative to the listener, {@code false} if
     *         it is absolute.
     * @see SoundSource#setRelativeToListener(boolean)
     */
    public native boolean isRelativeToListener();

    /**
     * Gets the sound's minimum distance from the {@link Listener} before attenuation sets in.
     *
     * @return the sound's minimum distance before attenuation sets in.
     * @see SoundSource#setMinDistance(float)
     */
    public native float getMinDistance();

    /**
     * Gets the sound's attenuation factor.
     * <p/>
     * The attenuation factor ranges between 0 (no attenuation) and 100 (instant attenuation),
     * where the default value is 1.
     *
     * @return the sound's attenuation factor.
     * @see SoundSource#setAttenuation(float)
     */
    public native float getAttenuation();

    abstract int nativeGetStatus();

    /**
     * Gets the current state of the sound stream.
     *
     * @return the current state of the sound stream.
     */
    protected Status getStatus() {
        return Status.values()[nativeGetStatus()];
    }
}
