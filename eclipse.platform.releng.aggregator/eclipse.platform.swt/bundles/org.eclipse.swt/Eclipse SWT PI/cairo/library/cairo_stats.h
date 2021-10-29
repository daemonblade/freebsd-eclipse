/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * Contributor(s):
 *
 * IBM
 * -  Binding to permit interfacing between Cairo and SWT
 * -  Copyright (C) 2005, 2021 IBM Corp.  All Rights Reserved.
 *
 * ***** END LICENSE BLOCK ***** */

/* Note: This file was auto-generated by org.eclipse.swt.tools.internal.JNIGenerator */
/* DO NOT EDIT - your changes will be lost. */

#ifdef NATIVE_STATS
extern int Cairo_nativeFunctionCount;
extern int Cairo_nativeFunctionCallCount[];
extern char* Cairo_nativeFunctionNames[];
#define Cairo_NATIVE_ENTER(env, that, func) Cairo_nativeFunctionCallCount[func]++;
#define Cairo_NATIVE_EXIT(env, that, func) 
#else
#ifndef Cairo_NATIVE_ENTER
#define Cairo_NATIVE_ENTER(env, that, func) 
#endif
#ifndef Cairo_NATIVE_EXIT
#define Cairo_NATIVE_EXIT(env, that, func) 
#endif
#endif

typedef enum {
	CAIRO_1VERSION_1ENCODE_FUNC,
	cairo_1append_1path_FUNC,
	cairo_1arc_FUNC,
	cairo_1arc_1negative_FUNC,
	cairo_1clip_FUNC,
	cairo_1close_1path_FUNC,
	cairo_1copy_1path_FUNC,
	cairo_1copy_1path_1flat_FUNC,
	cairo_1create_FUNC,
	cairo_1curve_1to_FUNC,
	cairo_1destroy_FUNC,
	cairo_1fill_FUNC,
	cairo_1font_1options_1create_FUNC,
	cairo_1font_1options_1destroy_FUNC,
	cairo_1font_1options_1get_1antialias_FUNC,
	cairo_1font_1options_1set_1antialias_FUNC,
	cairo_1get_1antialias_FUNC,
	cairo_1get_1current_1point_FUNC,
	cairo_1get_1fill_1rule_FUNC,
	cairo_1get_1font_1face_FUNC,
	cairo_1get_1matrix_FUNC,
	cairo_1get_1source_FUNC,
	cairo_1get_1target_FUNC,
	cairo_1get_1tolerance_FUNC,
	cairo_1identity_1matrix_FUNC,
	cairo_1image_1surface_1create_FUNC,
	cairo_1image_1surface_1get_1data_FUNC,
	cairo_1image_1surface_1get_1format_FUNC,
	cairo_1image_1surface_1get_1height_FUNC,
	cairo_1image_1surface_1get_1stride_FUNC,
	cairo_1image_1surface_1get_1width_FUNC,
	cairo_1in_1fill_FUNC,
	cairo_1in_1stroke_FUNC,
	cairo_1line_1to_FUNC,
	cairo_1matrix_1init_FUNC,
	cairo_1matrix_1init_1identity_FUNC,
	cairo_1matrix_1invert_FUNC,
	cairo_1matrix_1multiply_FUNC,
	cairo_1matrix_1rotate_FUNC,
	cairo_1matrix_1scale_FUNC,
	cairo_1matrix_1transform_1point_FUNC,
	cairo_1matrix_1translate_FUNC,
	cairo_1move_1to_FUNC,
	cairo_1new_1path_FUNC,
	cairo_1paint_FUNC,
	cairo_1paint_1with_1alpha_FUNC,
	cairo_1path_1data_1t_1sizeof_FUNC,
	cairo_1path_1destroy_FUNC,
	cairo_1path_1t_1sizeof_FUNC,
	cairo_1pattern_1add_1color_1stop_1rgba_FUNC,
	cairo_1pattern_1create_1for_1surface_FUNC,
	cairo_1pattern_1create_1linear_FUNC,
	cairo_1pattern_1destroy_FUNC,
	cairo_1pattern_1set_1extend_FUNC,
	cairo_1pattern_1set_1filter_FUNC,
	cairo_1pattern_1set_1matrix_FUNC,
	cairo_1pdf_1surface_1set_1size_FUNC,
	cairo_1pop_1group_1to_1source_FUNC,
	cairo_1ps_1surface_1set_1size_FUNC,
	cairo_1push_1group_FUNC,
	cairo_1rectangle_FUNC,
	cairo_1rectangle_1int_1t_1sizeof_FUNC,
	cairo_1reference_FUNC,
	cairo_1region_1contains_1point_FUNC,
	cairo_1region_1contains_1rectangle_FUNC,
	cairo_1region_1copy_FUNC,
	cairo_1region_1create_FUNC,
	cairo_1region_1create_1rectangle_FUNC,
	cairo_1region_1destroy_FUNC,
	cairo_1region_1get_1extents_FUNC,
	cairo_1region_1get_1rectangle_FUNC,
	cairo_1region_1intersect_FUNC,
	cairo_1region_1is_1empty_FUNC,
	cairo_1region_1num_1rectangles_FUNC,
	cairo_1region_1subtract_FUNC,
	cairo_1region_1translate_FUNC,
	cairo_1region_1union_FUNC,
	cairo_1region_1union_1rectangle_FUNC,
	cairo_1reset_1clip_FUNC,
	cairo_1restore_FUNC,
	cairo_1save_FUNC,
	cairo_1scale_FUNC,
	cairo_1select_1font_1face_FUNC,
	cairo_1set_1antialias_FUNC,
	cairo_1set_1dash_FUNC,
	cairo_1set_1fill_1rule_FUNC,
	cairo_1set_1font_1size_FUNC,
	cairo_1set_1line_1cap_FUNC,
	cairo_1set_1line_1join_FUNC,
	cairo_1set_1line_1width_FUNC,
	cairo_1set_1matrix_FUNC,
	cairo_1set_1miter_1limit_FUNC,
	cairo_1set_1operator_FUNC,
	cairo_1set_1source_FUNC,
	cairo_1set_1source_1rgb_FUNC,
	cairo_1set_1source_1rgba_FUNC,
	cairo_1set_1source_1surface_FUNC,
	cairo_1set_1tolerance_FUNC,
	cairo_1show_1page_FUNC,
	cairo_1stroke_FUNC,
	cairo_1surface_1destroy_FUNC,
	cairo_1surface_1finish_FUNC,
	cairo_1surface_1flush_FUNC,
	cairo_1surface_1get_1content_FUNC,
	cairo_1surface_1get_1device_1scale_FUNC,
	cairo_1surface_1get_1type_FUNC,
	cairo_1surface_1mark_1dirty_FUNC,
	cairo_1surface_1reference_FUNC,
	cairo_1surface_1set_1device_1scale_FUNC,
	cairo_1transform_FUNC,
	cairo_1translate_FUNC,
	cairo_1user_1to_1device_1distance_FUNC,
	cairo_1version_FUNC,
	cairo_1xlib_1surface_1get_1height_FUNC,
	cairo_1xlib_1surface_1get_1width_FUNC,
	memmove__Lorg_eclipse_swt_internal_cairo_cairo_1path_1data_1t_2JJ_FUNC,
	memmove__Lorg_eclipse_swt_internal_cairo_cairo_1path_1t_2JJ_FUNC,
	memmove__Lorg_eclipse_swt_internal_cairo_cairo_1rectangle_1int_1t_2JJ_FUNC,
	memmove___3DJJ_FUNC,
} Cairo_FUNCS;
