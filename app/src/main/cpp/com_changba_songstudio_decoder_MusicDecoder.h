/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
#include "music_decoder/song_decoder_controller.h"
/* Header for class com_changba_songstudio_decoder_MusicDecoder */

#ifndef _Included_com_changba_songstudio_decoder_MusicDecoder
#define _Included_com_changba_songstudio_decoder_MusicDecoder
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    init
 * Signature: (FI)V
 */
JNIEXPORT void JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_init
  (JNIEnv *, jobject, jfloat, jint);

/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    readSamples
 * Signature: ([SI[I[I)I
 */
JNIEXPORT jint JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_readSamples
  (JNIEnv *, jobject, jshortArray, jint, jintArray, jintArray);

/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    setAccompanyVolume
 * Signature: (FF)V
 */
JNIEXPORT void JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_setAccompanyVolume
  (JNIEnv *, jobject, jfloat, jfloat);

/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    startAccompany
 * Signature: (Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_startAccompany
  (JNIEnv *, jobject, jstring);

/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    pauseAccompany
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_pauseAccompany
  (JNIEnv *, jobject);

/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    resumeAccompany
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_resumeAccompany
  (JNIEnv *, jobject);

/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    stopAccompany
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_stopAccompany
  (JNIEnv *, jobject);

/*
 * Class:     com_changba_songstudio_decoder_MusicDecoder
 * Method:    destory
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_example_videorecorder_songstudio_decoder_MusicDecoder_destory
  (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif
