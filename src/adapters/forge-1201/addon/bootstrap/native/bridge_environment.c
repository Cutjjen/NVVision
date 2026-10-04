#define WIN32_LEAN_AND_MEAN
#include <windows.h>
#include <jni.h>
#include <stdlib.h>

/* Must be called before loading Mesa. Values are confined to this process. */
JNIEXPORT jboolean JNICALL Java_nvvisionboost_vulkanbridge_bootstrap_BridgeEnvironment_prepare
(JNIEnv *env, jclass klass, jstring cache, jstring descriptors) {
    (void)klass;
    if (!cache || !descriptors) return JNI_FALSE;
    const jchar *cacheChars = (*env)->GetStringChars(env, cache, NULL);
    if (!cacheChars) return JNI_FALSE;
    const jchar *descriptorChars = (*env)->GetStringChars(env, descriptors, NULL);
    if (!descriptorChars) { (*env)->ReleaseStringChars(env, cache, cacheChars); return JNI_FALSE; }
    jsize cacheLength = (*env)->GetStringLength(env, cache);
    jsize descriptorLength = (*env)->GetStringLength(env, descriptors);
    WCHAR *cacheCopy = calloc((size_t)cacheLength + 1, sizeof(WCHAR));
    WCHAR *descriptorCopy = calloc((size_t)descriptorLength + 1, sizeof(WCHAR));
    BOOL ok = FALSE;
    if (cacheCopy && descriptorCopy) {
        memcpy(cacheCopy, cacheChars, (size_t)cacheLength * sizeof(WCHAR));
        memcpy(descriptorCopy, descriptorChars, (size_t)descriptorLength * sizeof(WCHAR));
        ok = SetEnvironmentVariableW(L"GALLIUM_DRIVER", L"zink") &&
             SetEnvironmentVariableW(L"ZINK_DESCRIPTORS", descriptorCopy) &&
             SetEnvironmentVariableW(L"MESA_SHADER_CACHE_DIR", cacheCopy);
        /* Mesa's UCRT can already be loaded by Java. Keep its getenv view consistent. */
        ok = ok && _wputenv_s(L"GALLIUM_DRIVER", L"zink") == 0 &&
             _wputenv_s(L"ZINK_DESCRIPTORS", descriptorCopy) == 0 &&
             _wputenv_s(L"MESA_SHADER_CACHE_DIR", cacheCopy) == 0;
    }
    free(cacheCopy); free(descriptorCopy);
    (*env)->ReleaseStringChars(env, descriptors, descriptorChars);
    (*env)->ReleaseStringChars(env, cache, cacheChars);
    return ok ? JNI_TRUE : JNI_FALSE;
}
