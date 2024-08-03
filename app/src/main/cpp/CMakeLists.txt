# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html.
# For more examples on how to use CMake, see https://github.com/android/ndk-samples.

# Sets the minimum CMake version required for this project.
cmake_minimum_required(VERSION 3.22.1)

# Declares the project name. The project name can be accessed via ${ PROJECT_NAME},
# Since this is the top level CMakeLists.txt, the project name is also accessible
# with ${CMAKE_PROJECT_NAME} (both CMake variables are in-sync within the top level
# build script scope).
project("videorecorder")
include_directories(./)

include_directories(./common/)
include_directories(./camera_preview/)
include_directories(./livecore/)
include_directories(./livecore/common/)
include_directories(./livecore/audio_encoder/)
include_directories(./livecore/consumer/)
include_directories(./livecore/platform_dependent/)
include_directories(./livecore/publisher/)
include_directories(./music_decoder/)
include_directories(./recorder_processor/)
include_directories(./video_consumer/)
include_directories(./video_consumer/libaudio_encoder/)
include_directories(./video_consumer/libmusic_merger/)
include_directories(./video_consumer/libvideo_consumer/)
include_directories(./video_encoder/)
include_directories(./video_encoder/soft_encoder/)
include_directories(./video_encoder/hw_encoder/)

set(VERSION 2.7.7)
set(TYPE STATIC)
set(LIB_EXT a)
set(POSTPROC OFF)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/ffmpeg/${VERSION}/${ANDROID_ABI}/include)

set(ffmpeg_lib_path ${CMAKE_CURRENT_SOURCE_DIR}/ffmpeg/${VERSION}/${ANDROID_ABI}/lib)

add_library( avcodec
        ${TYPE}
        IMPORTED )
add_library( avfilter
        ${TYPE}
        IMPORTED )
add_library( avformat
        ${TYPE}
        IMPORTED )
add_library( avutil
        ${TYPE}
        IMPORTED )
add_library( swresample
        ${TYPE}
        IMPORTED )
add_library( swscale
        ${TYPE}
        IMPORTED )



set_target_properties( avcodec
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_path}/libavcodec.${LIB_EXT} )
set_target_properties( avfilter
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_path}/libavfilter.${LIB_EXT}  )
set_target_properties( avformat
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_path}/libavformat.${LIB_EXT}  )
set_target_properties( avutil
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_path}/libavutil.${LIB_EXT}  )
set_target_properties( swresample
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_path}/libswresample.${LIB_EXT}  )
set_target_properties( swscale
        PROPERTIES IMPORTED_LOCATION
        ${ffmpeg_lib_path}/libswscale.${LIB_EXT}  )

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/lib/fdk-aac/${ANDROID_ABI}/include)

set(fdkaac_lib_path ${CMAKE_CURRENT_SOURCE_DIR}/lib/fdk-aac/${ANDROID_ABI}/lib)
add_library( fdk-aac
        STATIC
        IMPORTED )

set_target_properties( fdk-aac
        PROPERTIES IMPORTED_LOCATION
        ${fdkaac_lib_path}/libfdk-aac.a )

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/lib/x264/${ANDROID_ABI}/include)

set(x264_lib_path ${CMAKE_CURRENT_SOURCE_DIR}/lib/x264/${ANDROID_ABI}/lib)
add_library( x264
        STATIC
        IMPORTED )

set_target_properties( x264
        PROPERTIES IMPORTED_LOCATION
        ${x264_lib_path}/libx264.a )

file(GLOB FILES_JNI_LAYER "./*.cpp")
file(GLOB FILES_LIB_COMMON "./common/*.cpp")
file(GLOB FILES_LIB_COMMON_EGL_CORE "./common/egl_core/*.cpp")
file(GLOB FILES_LIB_COMMON_EGL_CORE "./common/egl_core/*.cpp")
file(GLOB FILES_LIB_COMMON_RESAMPLER "./common/libresampler/*.cpp")
file(GLOB FILES_LIB_COMMON_MSG_Q "./common/message_queue/*.cpp")
file(GLOB FILES_LIB_COMMON_OPENGL_MEDIA "./common/opengl_media/*.cpp")
file(GLOB FILES_LIB_COMMON_OPENGL_MEDIA_RENDER "./common/opengl_media/render/*.cpp")
file(GLOB FILES_LIB_COMMON_OPENGL_MEDIA_TEXTURE "./common/opengl_media/texture/*.cpp")
file(GLOB FILES_LIB_COMMON_OPENGL_MEDIA_TEX_COPIER "./common/opengl_media/texture_copier/*.cpp")
file(GLOB FILES_LIB_CAMERA_PREVIEW "./camera_preview/*.cpp")
file(GLOB FILES_LIB_LIVE_CORE_COMMON "./livecore/common/*.cpp")
file(GLOB FILES_LIB_LIVE_CORE_AUDIOENCODER "./livecore/audio_encoder/*.cpp")
file(GLOB FILES_LIB_LIVE_CORE_CONSUMER "./livecore/consumer/*.cpp")
file(GLOB FILES_LIB_LIVE_CORE_PUBLISHER "./livecore/publisher/*.cpp")
file(GLOB FILES_LIB_MUSIC_DECODER "./music_decoder/*.cpp")
file(GLOB FILES_LIB_RECORDER_PROCESSOR "./recorder_processor/*.cpp")
file(GLOB FILES_LIB_VIDEO_CONSUMER_A_ENCODER "./video_consumer/libaudio_encoder/*.cpp")
file(GLOB FILES_LIB_VIDEO_CONSUMER_MUSIC_MERGER "./video_consumer/libmusic_merger/*.cpp")
file(GLOB FILES_LIB_VIDEO_CONSUMER "./video_consumer/libvideo_consumer/*.cpp")
file(GLOB FILES_LIB_VIDEO_ENCODER "./video_encoder/*.cpp")
file(GLOB FILES_LIB_VIDEO_ENCODER_HW "./video_encoder/hw_encoder/*.cpp")
file(GLOB FILES_LIB_VIDEO_ENCODER_X264 "./video_encoder/soft_encoder/*.cpp")
file(GLOB FILES_LIB_VIDEO_ENCODER_SOFT_COLOR "./video_encoder/soft_encoder/color_conversion/color_conversion_armv7a.cpp")
# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
#
# In this top level CMakeLists.txt, ${CMAKE_PROJECT_NAME} is used to define
# the target library name; in the sub-module's CMakeLists.txt, ${PROJECT_NAME}
# is preferred for the same purpose.
#
# In order to load a library into your app from Java/Kotlin, you must call
# System.loadLibrary() and pass the name of the library defined here;
# for GameActivity/NativeActivity derived applications, the same library name must be
# used in the AndroidManifest.xml file.
add_library(${CMAKE_PROJECT_NAME} SHARED
        # List C/C++ source files with relative paths to this CMakeLists.txt.
        ${FILES_JNI_LAYER}
        ${FILES_LIB_COMMON}
        ${FILES_LIB_COMMON_EGL_CORE}
        ${FILES_LIB_COMMON_MSG_Q}
        ${FILES_LIB_COMMON_RESAMPLER}
        ${FILES_LIB_COMMON_OPENGL_MEDIA}
        ${FILES_LIB_COMMON_OPENGL_MEDIA_RENDER}
        ${FILES_LIB_COMMON_OPENGL_MEDIA_TEXTURE}
        ${FILES_LIB_COMMON_OPENGL_MEDIA_TEX_COPIER}
        ${FILES_LIB_CAMERA_PREVIEW}
        ${FILES_LIB_LIVE_CORE_COMMON}
        ${FILES_LIB_LIVE_CORE_AUDIOENCODER}
        ${FILES_LIB_LIVE_CORE_CONSUMER}
        ${FILES_LIB_LIVE_CORE_PUBLISHER}
        ${FILES_LIB_MUSIC_DECODER}
        ${FILES_LIB_RECORDER_PROCESSOR}
        ${FILES_LIB_VIDEO_CONSUMER_A_ENCODER}
        ${FILES_LIB_VIDEO_CONSUMER_MUSIC_MERGER}
        ${FILES_LIB_VIDEO_CONSUMER}
        ${FILES_LIB_VIDEO_ENCODER}
        ${FILES_LIB_VIDEO_ENCODER_HW}
        ${FILES_LIB_VIDEO_ENCODER_X264}
        ${FILES_LIB_VIDEO_ENCODER_SOFT_COLOR})

# Specifies libraries CMake should link to your target library. You
# can link libraries from various origins, such as libraries defined in this
# build script, prebuilt third-party libraries, or Android system libraries.
target_link_libraries(${CMAKE_PROJECT_NAME}
        # List libraries link to the target library
        avcodec
        avfilter
        avformat
        avutil
        swresample
        swscale
        GLESv2
        EGL
        z
        OpenSLES
        fdk-aac
        x264
        android
        log)