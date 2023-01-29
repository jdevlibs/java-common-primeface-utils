/*  ---------------------------------------------------------------------------
 *  * Copyright 2023 the original author or authors.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      https://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  ---------------------------------------------------------------------------
 */

package io.github.jdevlibs.primefaces.theme;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author supot.jdev
* @version 1.0
*/
public final class ThemeUtils {
	public static final String THEME_PANDORA  	= "pandora";
	public static final String THEME_AVALON  	= "avalon";
	
	private static final String COLOR_LIGHT 	= "#f8fafc";
	private static final String COLOR_BLUE 		= "#2E88FF";
	private static final String COLOR_TEAL_LIGHT = "#21B5AD";
	
	private static final String INPUT_FILLED 	= "filled";
	
	private ThemeUtils() {
		
	}
	
	public static List<ThemePalette> pandoraPalettes() {
		List<ThemePalette> palettes = new ArrayList<>();
		
        /* Menu: Light | Active: Blue | Topbar: Blue | Components: Blue */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("blue", COLOR_BLUE),
                new ThemeColor("blue", COLOR_BLUE),
                new ThemeColor("blue", COLOR_BLUE)
            )
        );

         /* Menu: Dark | Active: Blue | Topbar: Blue | Components: Blue-Grey */
         palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("blue", COLOR_BLUE),
                new ThemeColor("blue", COLOR_BLUE),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Light | Active: Teal-Light | Topbar: Teal-Light | Components: Teal-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT)
            )
        );

        /* Menu: Dark | Active: Teal-Light | Topbar: Teal-Light | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Dark | Active: Purple | Topbar: Purple | Components: Purple */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("purple", "#636FC0")
            )
        );

        /* Menu: Light | Active: Orange | Topbar: Purple | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Dark | Active: Magenta | Topbar: Magenta | Components: Magenta */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("magenta", "#C03995")
            )
        );

        /* Menu: Light | Active: Cyan | Topbar: Magenta | Components: Cyan */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("cyan", "#2199B5")
            )
        );

        /* Menu: Dark | Active: Yellow | Topbar: Yellow | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("yellow", "#F3A841"),
                new ThemeColor("yellow", "#F3A841"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Light | Active: Yellow | Topbar: Yellow | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("yellow", "#F3A841"),
                new ThemeColor("yellow", "#F3A841"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Dark | Active: Green | Topbar: Green | Components: Green */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("green", "#21B567")
            )
        );

        /* Menu: Light | Active: Green | Topbar: Green | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Dark | Active: Cyan | Topbar: Cyan | Components: Cyan */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("cyan", "#2199B5")
            )
        );

        /* Menu: Light | Active: Cyan | Topbar: Cyan | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Dark | Active: Purple-Light | Topbar: Purple-Light | Components: Purple-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8")
            )
        );

        /* Menu: Light | Active: Purple-Light | Topbar: Purple-Light | Components: Purple-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8")
            )
        );

        /* Menu: Dark | Active: Orange | Topbar: Orange | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Light | Active: Orange | Topbar: Orange | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Dark | Active: Red | Topbar: Red | Components: Red */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("red", "#FE566D"),
                new ThemeColor("red", "#FE566D"),
                new ThemeColor("red", "#FE566D")
            )
        );

        /* Menu: Light | Active: Red | Topbar: Red | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("red", "#FE566D"),
                new ThemeColor("red", "#FE566D"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Dark | Active: Teal-Dark | Topbar: Teal-Dark | Components: Teal-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT)
            )
        );

        /* Menu: Light | Active: Teal-Dark | Topbar: Teal-Dark | Components: Teal-Dark */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("tealdark", "#076D72")
            )
        );

        /* Menu: Dark | Active: Purple-Dark | Topbar: Purple-Dark | Components: Purple-Dark */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("purpledark", "#44358F"),
                new ThemeColor("purpledark", "#44358F"),
                new ThemeColor("purpledark", "#44358F")
            )
        );
        
        /* Menu: Light | Active: Purple-Dark | Topbar: Purple-Dark | Components: Purple-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("purpledark", "#44358F"),
                new ThemeColor("purpledark", "#44358F"),
                new ThemeColor("purplelight", "#9754B8")
            )
        );

        /* Menu: Light | Active: Indigo | Topbar: Indigo | Components: Magenta */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("magenta", "#C03995")
            )
        );

        /* Menu: Dark | Active: Indigo | Topbar: Indigo | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Light | Active: Cyan | Topbar: Seagreen | Components: Cyan */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("seagreen", "#354045"),
                new ThemeColor("cyan", "#2199B5")
            )
        );

        /* Menu: Light | Active: Orange | Topbar: Seagreen | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("seagreen", "#354045"),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Light | Active: Teal-Light | Topbar: Seagreen | Components: Teal-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("seagreen", "#354045"),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT)
            )
        );

        /* Menu: Dark | Active: Blue | Topbar: Dark | Components: Blue */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("blue", COLOR_BLUE),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("blue", COLOR_BLUE)
            )
        );

        /* Menu: Light | Active: Purple | Topbar: Dark | Components: Purple */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("purple", "#636FC0")
            )
        );

        /* Menu: Dark | Active: Green | Topbar: Dark | Components: Green */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("green", "#21B567")
            )
        );

        /* Menu: Light | Active: Cyan | Topbar: Dark | Components: Cyan */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("cyan", "#2199B5")
            )
        );

        /* Menu: Dark | Active: Orange | Topbar: Dark | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Light | Active: Indigo | Topbar: Dark | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Light | Active: Cyan | Topbar: Light | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Light | Active: Teal-Light | Topbar: Light | Components: Teal-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT)
            )
        );

        /* Menu: Light | Active: Purple | Topbar: Light | Components: Purple */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("purple", "#636FC0")
            )
        );

        /* Menu: Light | Active: Cyan | Topbar: Light | Components: Cyan */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5")
            )
        );

        /* Menu: Dark | Active: Orange | Topbar: Light | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Light | Active: Teal-Dark | Topbar: Light | Components: Teal-Dark */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("tealdark", "#076D72")
            )
        );

        /* Menu: Dark | Active: Indigo | Topbar: Light | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Light | Active: Indigo | Topbar: Blue-Dark | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Light | Active: Magenta | Topbar: Blue-Dark | Components: Magenta */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("magenta", "#C03995")
            )
        );

        /* Menu: Light | Active: Purple-Light | Topbar: Blue-Dark | Components: Purple-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("purplelight", "#9754B8")
            )
        );

        /* Menu: Light | Active: Yellow | Topbar: Grey | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("yellow", "#F3A841"),
                new ThemeColor("gray", "#525557"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Light | Active: Teal-Light | Topbar: Grey | Components: Teal-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("gray", "#525557"),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT)
            )
        );

        /* Menu: Light | Active: Magenta | Topbar: Greylight | Components: Magenta */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("magenta", COLOR_TEAL_LIGHT),
                new ThemeColor("graylight", "#8B8E90"),
                new ThemeColor("magenta", "#C03995")
            )
        );

        /* Menu: Light | Active: Magenta | Topbar: Greylight | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("magenta", COLOR_TEAL_LIGHT),
                new ThemeColor("graylight", "#8B8E90"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Blue-Dark | Active: Blue-Dark | Topbar: Blue-Dark | Components: Purple Light*/
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("purple", "#636FC0")
            )
        );

        /* Menu: Blue-Dark | Active: Blue-Dark | Topbar: Blue-Dark | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Blue-Dark | Active: Blue-Dark | Topbar: Blue-Dark | Components: Purple-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("purplelight", "#9754B8")
            )
        );

        /* Menu: Blue-Dark | Active: Blue-Dark | Topbar: Blue-Dark | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Blue-Dark | Active: Blue-Dark | Topbar: Blue-Dark | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Light | Active: Teallight | Topbar: Tealdark | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Light | Active: Teallight | Topbar: Tealdark | Components: Teal-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT)
            )
        );

        /* Menu: Light | Active: Teallight | Topbar: Tealdark | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Light | Active: Teallight | Topbar: Tealdark | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Light | Active: Teallight | Topbar: Tealdark | Components: Teal-Dark */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("teallight", COLOR_TEAL_LIGHT),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("tealdark", "#076D72")
            )
        );

        /* Menu: Light | Active: Blue | Topbar: Dark | Components: Blue */
        palettes.add(
            new ThemePalette(
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("blue", COLOR_BLUE),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("blue", COLOR_BLUE)
            )
        );

        /* Menu: Blue | Active: Blue | Topbar: Light | Components: Blue */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", COLOR_BLUE),
                new ThemeColor("blue", COLOR_BLUE),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("blue", COLOR_BLUE)
            )
        );

        /* Menu: Purple | Active: Purple | Topbar: Purple | Components: Purple */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#636FC0"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("purple", "#636FC0")
            )
        );

        /* Menu: Purple | Active: Purple | Topbar: Darkblue | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#636FC0"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Purple | Active: Purple | Topbar: Dark | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#636FC0"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Magenta | Active: Magenta | Topbar: Magenta | Components: Magenta */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#C03995"),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("magenta", "#C03995")
            )
        );

        /* Menu: Magenta | Active: Magenta | Topbar: Dark | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#C03995"),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Magenta | Active: Magenta | Topbar: Light | Components: Purple-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#C03995"),
                new ThemeColor("magenta", "#C03995"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("purplelight", "#9754B8")
            )
        );

        /* Menu: Cyan | Active: Cyan | Topbar: Cyan | Components: Cyan */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#2199B5"),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("cyan", "#2199B5")
            )
        );

        /* Menu: Cyan | Active: Cyan | Topbar: Light | Components: Cyan */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#2199B5"),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("cyan", "#2199B5")
            )
        );

        /* Menu: Cyan | Active: Cyan | Topbar: Seagreen | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#2199B5"),
                new ThemeColor("cyan", "#2199B5"),
                new ThemeColor("seagreen", "#354045"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Yellow | Active: Yellow | Topbar: Dark | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#F3A841"),
                new ThemeColor("yellow", "#F3A841"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Yellow | Active: Yellow | Topbar: Seagreen | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#F3A841"),
                new ThemeColor("yellow", "#F3A841"),
                new ThemeColor("seagreen", "#354045"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Green | Active: Green | Topbar: Green | Components: Green */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#21B567"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("green", "#21B567")
            )
        );

        /* Menu: Green | Active: Green | Topbar: Dark | Components: Green */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#21B567"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("green", "#21B567")
            )
        );

        /* Menu: Green | Active: Green | Topbar: Light | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#21B567"),
                new ThemeColor("green", "#21B567"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Purple-Light | Active: Purple-Light | Topbar: Purple-Light | Components: Purple-Light */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8")
            )
        );
        
        /* Menu: Purple-Light | Active: Purple-Light | Topbar: Light | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#9754B8"),
                new ThemeColor("purplelight", "#9754B8"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Orange | Active: Orange | Topbar: Dark | Components: Orange */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#EC7A51"),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("orange", "#EC7A51")
            )
        );

        /* Menu: Orange | Active: Orange | Topbar: Light | Components: Yellow */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#EC7A51"),
                new ThemeColor("orange", "#EC7A51"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("yellow", "#F3A841")
            )
        );

        /* Menu: Red | Active: Red | Topbar: Dark | Components: Red */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#FE566D"),
                new ThemeColor("red", "#FE566D"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("red", "#FE566D")
            )
        );

        /* Menu: Red | Active: Red | Topbar: Light | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#FE566D"),
                new ThemeColor("red", "#FE566D"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /* Menu: Dark | Active: Teal-Dark | Topbar: Teal-Dark | Components: Teal-Dark */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("tealdark", "#076D72")
            )
        );

        /* Menu: Dark | Active: Teal-Dark | Topbar: Dark | Components: Blue-Grey */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("dark", "#252729"),
                new ThemeColor("bluegrey", "#607D8B")
            )
        );

        /*Menu: Dark | Active: Teal-Dark | Topbar: Light | Components: Teal-Dark */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("tealdark", "#076D72"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("tealdark", "#076D72")
            )
        );

        /* Menu: Dark | Active: Purple-Dark | Topbar: Purple-Dark | Components: Purple-Dark */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("purpledark", "#44358F"),
                new ThemeColor("purpledark", "#44358F"),
                new ThemeColor("purpledark", "#44358F")
            )
        );

        /* Menu: Dark | Active: Purple-Dark | Topbar: Purple | Components: Purple */
        palettes.add(
            new ThemePalette(
                new ThemeColor("dark", "#252729"),
                new ThemeColor("purpledark", "#44358F"),
                new ThemeColor("purple", "#636FC0"),
                new ThemeColor("purple", "#636FC0")
            )
        );

        /* Menu: Indigo | Active: Indigo | Topbar: Indigo | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#303498"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Indigo | Active: Indigo | Topbar: Darkblue | Components: Indigo */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#303498"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("bluedark", "#232946"),
                new ThemeColor("indigo", "#303498")
            )
        );

        /* Menu: Indigo | Active: Indigo | Topbar: Light | Components: Blue */
        palettes.add(
            new ThemePalette(
                new ThemeColor("colored", "#303498"),
                new ThemeColor("indigo", "#303498"),
                new ThemeColor("light", COLOR_LIGHT),
                new ThemeColor("blue", COLOR_BLUE)
            )
        );		
		return palettes;
	}

	public static Map<String, List<ThemeMenu>> pandoraMenuColors() {
		Map<String, List<ThemeMenu>> menuColors = new HashMap<>();		
        List<ThemeMenu> menus = createThemeMenu();
        menuColors.put("light", menus);
        menuColors.put("dark", menus);

        menus = createThemeMenu();
        menus.add(new ThemeMenu("Blue Dark", "bluedark", "#232946"));
        menuColors.put("colored", menus);
        
        
		return menuColors;
	}
	
	public static List<ThemeTopbar> pandoraTopbars() {
		List<ThemeTopbar> topbars = new ArrayList<>();
        topbars.add(new ThemeTopbar("Seagreen", "seagreen", "#354045"));
        topbars.add(new ThemeTopbar("Dark", "dark", "#252729"));
        topbars.add(new ThemeTopbar("Light", "light", "#f8fafc"));
        topbars.add(new ThemeTopbar("Blue Dark", "bluedark", "#232946"));
        topbars.add(new ThemeTopbar("Blue", "blue", "#2E88FF"));
        topbars.add(new ThemeTopbar("Teal Light", "teallight","#21B5AD"));
        topbars.add(new ThemeTopbar("Purple", "purple", "#636FC0"));
        topbars.add(new ThemeTopbar("Magenta", "magenta","#C03995"));
        topbars.add(new ThemeTopbar("Yellow", "yellow", "#F3A841"));
        topbars.add(new ThemeTopbar("Green", "green", "#21B567"));
        topbars.add(new ThemeTopbar("Cyan", "cyan", "#2199B5"));
        topbars.add(new ThemeTopbar("Gray", "gray", "#525557"));
        topbars.add(new ThemeTopbar("Gray Light", "graylight", "#8B8E90"));
        topbars.add(new ThemeTopbar("Purple Light", "purplelight","#9754B8"));
        topbars.add(new ThemeTopbar("Orange", "orange", "#EC7A51"));
        topbars.add(new ThemeTopbar("Red", "red", "#FE566D"));
        topbars.add(new ThemeTopbar("Teal Dark", "tealdark", "#076D72"));
        topbars.add(new ThemeTopbar("Purple Dark", "purpledark", "#44358F"));
        topbars.add(new ThemeTopbar("Indigo", "indigo", "#303498"));
        
		return topbars;
	}
	
	public static List<ThemeComponent> pandoraComponents() {
		List<ThemeComponent> components = new ArrayList<>();
        components.add(new ThemeComponent("Blue Grey", "bluegrey","#607D8B"));
        components.add(new ThemeComponent("Teal-Light", "teallight","#21B5AD"));
        components.add(new ThemeComponent("Blue", "blue","#2E88FF"));
        components.add(new ThemeComponent("Purple", "purple", "#636FC0"));
        components.add(new ThemeComponent("Magenta", "magenta","#C03995"));
        components.add(new ThemeComponent("Yellow", "yellow","#F3A841"));
        components.add(new ThemeComponent("Green", "green","#21B567"));
        components.add(new ThemeComponent("Cyan", "cyan","#2199B5"));
        components.add(new ThemeComponent("Purple-Light", "purplelight", "#9754B8"));
        components.add(new ThemeComponent("Orange", "orange", "#EC7A51"));
        components.add(new ThemeComponent("Red", "red", "#FE566D"));
        components.add(new ThemeComponent("Teal-Dark", "tealdark","#076D72"));
        components.add(new ThemeComponent("Purple-Dark", "purpledark","#44358F"));
        components.add(new ThemeComponent("Indigo", "indigo", "#303498"));
        
        return components;
	}
	
	public static List<ThemeComponent> avalonComponents() {
		List<ThemeComponent> components = new ArrayList<>();
        components.add(new ThemeComponent("Amber", "amber", "#F8BD0C"));
        components.add(new ThemeComponent("Blue", "blue", "#007bff"));
        components.add(new ThemeComponent("Cyan", "cyan", "#17A2B8"));
        components.add(new ThemeComponent("Indigo", "indigo", "#6610F2"));
        components.add(new ThemeComponent("Purple", "purple", "#883cae"));
        components.add(new ThemeComponent("Teal", "teal", "#20C997"));
        components.add(new ThemeComponent("Orange", "orange", "#FD7E14"));
        components.add(new ThemeComponent("Deep Purple", "deeppurple", "#612FBE"));
        components.add(new ThemeComponent("Light Blue", "lightblue", "#4DA3FF"));
        components.add(new ThemeComponent("Green", "green", "#28A745"));
        components.add(new ThemeComponent("Light Green", "lightgreen", "#61CC79"));
        components.add(new ThemeComponent("Brown", "brown", "#986839"));
        components.add(new ThemeComponent("Dark Grey", "darkgrey", "#6C757D"));
        components.add(new ThemeComponent("Pink", "pink", "#E83E8C"));
        components.add(new ThemeComponent("Lime", "lime", "#74CD32"));
        
        return components;
	 }
	
	public static List<ThemeLayout> avalonLayouts() {
		List<ThemeLayout> layouts = new ArrayList<>();
        layouts.add(new ThemeLayout("Blue", "blue", "#146fd7"));
        layouts.add(new ThemeLayout("Cyan", "cyan", "#0A616F"));
        layouts.add(new ThemeLayout("Indigo", "indigo", "#470EA2"));
        layouts.add(new ThemeLayout("Purple", "purple", "#391F68"));
        layouts.add(new ThemeLayout("Teal", "teal", "#136E52"));
        layouts.add(new ThemeLayout("Pink", "pink", "#771340"));
        layouts.add(new ThemeLayout("Lime", "lime", "#407916"));
        layouts.add(new ThemeLayout("Green", "green", "#1F8E38"));
        layouts.add(new ThemeLayout("Amber", "amber", "#7A5E06"));
        layouts.add(new ThemeLayout("Brown", "brown", "#593E22"));
        layouts.add(new ThemeLayout("Orange", "orange", "#904100"));
        layouts.add(new ThemeLayout("Deep Purple", "deeppurple", "#341A64"));
        layouts.add(new ThemeLayout("Light Blue", "lightblue", "#14569D"));
        layouts.add(new ThemeLayout("Light Green", "lightgreen", "#2E8942"));
        layouts.add(new ThemeLayout("Dark Grey", "darkgrey", "#343A40"));
        
        return layouts;
	}
	
	public static List<ThemeLayoutSpecial> avalonLayoutSpecials() {
		List<ThemeLayoutSpecial> layouts = new ArrayList<>();
		layouts.add(new ThemeLayoutSpecial("Influenza", "influenza", "#a83279", "#f38e00"));
		layouts.add(new ThemeLayoutSpecial("Calm", "calm", "#5f2c82", "#0DA9A4"));
		layouts.add(new ThemeLayoutSpecial("Crimson", "crimson", "#521c52", "#c6426e"));
		layouts.add(new ThemeLayoutSpecial("Night", "night", "#2c0747", "#6441a5"));
		layouts.add(new ThemeLayoutSpecial("Skyline", "skyline", "#2b32b2", "#1488cc"));
		layouts.add(new ThemeLayoutSpecial("Sunkist", "sunkist", "#ee8a21", "#f2c94c"));
		layouts.add(new ThemeLayoutSpecial("Little Leaf", "littleleaf", "#4DB865", "#80D293"));
		layouts.add(new ThemeLayoutSpecial("Joomla", "joomla", "#1e3c72", "#2a5298"));
		layouts.add(new ThemeLayoutSpecial("Firewatch", "firewatch", "#cb2d3e", "#ef473a"));
		layouts.add(new ThemeLayoutSpecial("Suzy", "suzy", "#834d9b", "#d04ed6"));
        
        return layouts;
	}
	
	public static String getInputStyleClass(String inputStyle) {
		return INPUT_FILLED.equalsIgnoreCase(inputStyle) ? "ui-input-filled" : "";
	}
	
	public static String getMenuModeClass(String menuMode) {
		return "layout-static".equalsIgnoreCase(menuMode) ? "layout-static layout-static-active" : menuMode;
	}

    private static List<ThemeMenu> createThemeMenu() {
        List<ThemeMenu> menus = new ArrayList<>();
        menus.add(new ThemeMenu("Teal Light", "teallight", "#21B5AD"));
        menus.add(new ThemeMenu("Blue", "blue","#2E88FF"));
        menus.add(new ThemeMenu("Purple", "purple","#636FC0"));
        menus.add(new ThemeMenu("Magenta", "magenta", "#C03995"));
        menus.add(new ThemeMenu("Cyan", "cyan", "#2199B5"));
        menus.add(new ThemeMenu("Yellow", "yellow","#F3A841"));
        menus.add(new ThemeMenu("Green", "green", "#21B567"));
        menus.add(new ThemeMenu("Purple Light", "purplelight","#9754B8"));
        menus.add(new ThemeMenu("Orange", "orange","#EC7A51"));
        menus.add(new ThemeMenu("Red", "red","#FE566D"));
        menus.add(new ThemeMenu("Teal Dark", "tealdark","#076D72"));
        menus.add(new ThemeMenu("Purple Dark", "purpledark", "#44358F"));
        menus.add(new ThemeMenu("Indigo", "indigo","#303498"));

        return menus;
    }
}