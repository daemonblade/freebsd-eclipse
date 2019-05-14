/*******************************************************************************
 * Copyright (c) 2000, 2016 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation
 *******************************************************************************/

/* Note: This file was auto-generated by org.eclipse.swt.tools.internal.JNIGenerator */
/* DO NOT EDIT - your changes will be lost. */

#include "swt.h"
#include "glx_stats.h"

#ifdef NATIVE_STATS

char * GLX_nativeFunctionNames[] = {
	"XVisualInfo_1sizeof",
	"_1glGetIntegerv",
	"_1glViewport",
	"_1glXChooseVisual",
	"_1glXCreateContext",
	"_1glXDestroyContext",
	"_1glXGetConfig",
	"_1glXGetCurrentContext",
	"_1glXMakeCurrent",
	"_1glXSwapBuffers",
	"memmove",
};
#define NATIVE_FUNCTION_COUNT sizeof(GLX_nativeFunctionNames) / sizeof(char*)
int GLX_nativeFunctionCount = NATIVE_FUNCTION_COUNT;
int GLX_nativeFunctionCallCount[NATIVE_FUNCTION_COUNT];

#define STATS_NATIVE(func) Java_org_eclipse_swt_tools_internal_NativeStats_##func

JNIEXPORT jint JNICALL STATS_NATIVE(GLX_1GetFunctionCount)
	(JNIEnv *env, jclass that)
{
	return GLX_nativeFunctionCount;
}

JNIEXPORT jstring JNICALL STATS_NATIVE(GLX_1GetFunctionName)
	(JNIEnv *env, jclass that, jint index)
{
	return (*env)->NewStringUTF(env, GLX_nativeFunctionNames[index]);
}

JNIEXPORT jint JNICALL STATS_NATIVE(GLX_1GetFunctionCallCount)
	(JNIEnv *env, jclass that, jint index)
{
	return GLX_nativeFunctionCallCount[index];
}

#endif