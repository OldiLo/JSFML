#include <JSFML/JNI/org_jsfml_audio_Sound.h>

#include <JSFML/Intercom/NativeObject.hpp>
#include <JSFML/Intercom/Time.hpp>

#include <JSFML/JNI/org_jsfml_internal_ExPtr.h>

#include <SFML/Audio/Sound.hpp>

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    nativeCreate
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_jsfml_audio_Sound_nativeCreate (JNIEnv *env, jobject obj) {
	return (jlong)new sf::Sound();
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    nativeSetExPtr
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_nativeSetExPtr (JNIEnv *env, jobject obj) {
    JSFML::NativeObject::SetExPointer(env, obj, org_jsfml_internal_ExPtr_SOUND_SOURCE,
        dynamic_cast<sf::SoundSource*>(THIS(sf::Sound)));
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    nativeDelete
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_nativeDelete (JNIEnv *env, jobject obj) {
    delete THIS(sf::Sound);
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    nativeCopy
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_org_jsfml_audio_Sound_nativeCopy (JNIEnv *env, jobject obj) {
	return (jlong)(new sf::Sound(*THIS(sf::Sound)));
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    play
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_play (JNIEnv *env, jobject obj) {
	THIS(sf::Sound)->play();
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    pause
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_pause (JNIEnv *env, jobject obj) {
	THIS(sf::Sound)->pause();
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    stop
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_stop (JNIEnv *env, jobject obj) {
	THIS(sf::Sound)->stop();
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    nativeSetBuffer
 * Signature: (Lorg/jsfml/audio/SoundBuffer;)V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_nativeSetBuffer
    (JNIEnv *env, jobject obj, jobject buffer) {

	THIS(sf::Sound)->setBuffer(*JSFML::NativeObject::GetPointer<sf::SoundBuffer>(env, buffer));
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    setLoop
 * Signature: (Z)V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_setLoop (JNIEnv *env, jobject obj, jboolean b) {
	THIS(sf::Sound)->setLoop(b);
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    nativeSetPlayingOffset
 * Signature: (Lorg/jsfml/system/Time;)V
 */
JNIEXPORT void JNICALL Java_org_jsfml_audio_Sound_nativeSetPlayingOffset
    (JNIEnv *env, jobject obj, jobject time) {

	THIS(sf::Sound)->setPlayingOffset(JSFML::Time::ToSFML(env, time));
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    isLoop
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_org_jsfml_audio_Sound_isLoop (JNIEnv *env, jobject obj) {
	return THIS(sf::Sound)->getLoop();
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    getPlayingOffset
 * Signature: ()Lorg/jsfml/system/Time;
 */
JNIEXPORT jobject JNICALL Java_org_jsfml_audio_Sound_getPlayingOffset (JNIEnv *env, jobject obj) {
	return JSFML::Time::FromSFML(env, THIS(sf::Sound)->getPlayingOffset());
}

/*
 * Class:     org_jsfml_audio_Sound
 * Method:    nativeGetStatus
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_org_jsfml_audio_Sound_nativeGetStatus (JNIEnv *env, jobject obj) {
	return (jint)THIS(sf::Sound)->getStatus();
}
