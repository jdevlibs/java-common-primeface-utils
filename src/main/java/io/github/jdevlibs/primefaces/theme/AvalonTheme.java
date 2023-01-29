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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.PrimeFaces;

/**
* @author supot.jdev
* @version 1.0
*/
public class AvalonTheme implements PrimefacesTheme<AvalonTheme> {
	private static final long serialVersionUID = 1L;
	private static final String OVERLAY = "overlay";
	private static final String HORIZONTAL = "horizontal";
	
	//Themes
	private Map<String, String> themeColors;
    private String theme = "green";
    private String layout = "green";
    private String menuClass 	= null;
    private String profileMode 	= "inline";
    private String menuLayout 	= HORIZONTAL;
    private String inputStyle = "outlined";
    private List<ThemeComponent> componentThemes;
    private List<ThemeLayout> layoutThemes;
    private List<ThemeLayoutSpecial> layoutSpecialThemes;
    
    @Override
	public void initThemeInfo() {
        themeColors = new HashMap<>();
        themeColors.put("green", "#1F8E38");
        componentThemes = ThemeUtils.avalonComponents();
        layoutThemes = ThemeUtils.avalonLayouts();
        layoutSpecialThemes = ThemeUtils.avalonLayoutSpecials();
	}

	@Override
	public String getLayoutConfig() {
		return null;
	}

	@Override
	public String getThemeName() {
		return "avalon-" + this.theme;
	}

	@Override
	public AvalonTheme getTheme() {
		return this;
	}
	
    public String getInputStyleClass() {
    	return ThemeUtils.getInputStyleClass(inputStyle);
    }
    
    public void onLayoutChange() {
        PrimeFaces.current().executeScript("PrimeFaces.AvalonConfigurator.changeMenuLayout('" + menuLayout + "')");
    }

    public void onMenuThemeChange() {
        if ("layout-menu-dark".equals(menuClass)) {
            PrimeFaces.current().executeScript("PrimeFaces.AvalonConfigurator.changeMenuToDark()");
        } else {
            PrimeFaces.current().executeScript("PrimeFaces.AvalonConfigurator.changeMenuToLight()");
        }
    }
    
    public String getMenu() {
        switch (this.menuLayout) {
            case OVERLAY:
                return "menu-layout-overlay";
            case HORIZONTAL:
                this.profileMode = OVERLAY;
                return "menu-layout-static menu-layout-horizontal";
            case "slim":
                return "menu-layout-static menu-layout-slim";
            default:
                return "menu-layout-static";
        }
    }

    public void setLayout(String layout, boolean special) {
        this.layout = layout;
        if (special) {
            this.menuClass = "layout-menu-dark";
        }
    }
    
    public void setMenuLayout(String menuLayout) {
        if (HORIZONTAL.equalsIgnoreCase(menuLayout)) {
            this.profileMode = OVERLAY;
        }
        
        this.menuLayout = menuLayout;
    }

	public Map<String, String> getThemeColors() {
		return themeColors;
	}

	public void setThemeColors(Map<String, String> themeColors) {
		this.themeColors = themeColors;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getMenuClass() {
		return menuClass;
	}

	public void setMenuClass(String menuClass) {
		this.menuClass = menuClass;
	}

	public String getProfileMode() {
		return profileMode;
	}

	public void setProfileMode(String profileMode) {
		this.profileMode = profileMode;
	}

	public String getInputStyle() {
		return inputStyle;
	}

	public void setInputStyle(String inputStyle) {
		this.inputStyle = inputStyle;
	}

	public List<ThemeComponent> getComponentThemes() {
		return componentThemes;
	}

	public void setComponentThemes(List<ThemeComponent> componentThemes) {
		this.componentThemes = componentThemes;
	}

	public List<ThemeLayout> getLayoutThemes() {
		return layoutThemes;
	}

	public void setLayoutThemes(List<ThemeLayout> layoutThemes) {
		this.layoutThemes = layoutThemes;
	}

	public List<ThemeLayoutSpecial> getLayoutSpecialThemes() {
		return layoutSpecialThemes;
	}

	public void setLayoutSpecialThemes(List<ThemeLayoutSpecial> layoutSpecialThemes) {
		this.layoutSpecialThemes = layoutSpecialThemes;
	}

	public String getMenuLayout() {
		return menuLayout;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
    
}
