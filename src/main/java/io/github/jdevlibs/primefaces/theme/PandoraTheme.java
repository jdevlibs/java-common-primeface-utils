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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import io.github.jdevlibs.faces.JSFValidators;

/**
* @author supot.jdev
* @version 1.0
*/
public class PandoraTheme implements PrimefacesTheme<PandoraTheme> {
	private static final long serialVersionUID = 1L;
	private static final String NONE_COLOR = "transparent";
	
	//Themes
	private String menuMode = "layout-horizontal";
	private String menuColor = "colored";
	private String menuTheme = "teallight";
	private String topbarTheme = "light";
	private String inputStyle = "outlined";
    private String componentTheme = "teallight";     
	private String layoutPrimaryColor = "teallight";
    private boolean groupedMenu = true;
    private boolean darkLogo;
    private List<ThemeComponent> componentThemes;
    private List<ThemeTopbar> topbarThemes;
    private Map<String, List<ThemeMenu>> menuColors;
    private List<ThemePalette> palettes;
    private ThemePalette selectedPalette;
    
    @Override
    public void initThemeInfo() {
        componentThemes = ThemeUtils.pandoraComponents();
        topbarThemes = ThemeUtils.pandoraTopbars();
        menuColors = ThemeUtils.pandoraMenuColors();
        palettes = ThemeUtils.pandoraPalettes();
        
        //Menu: Light | Active: Teal-Light | Topbar: Teal-Light | Components: Teal-Light
        selectedPalette = palettes.get(2);
    }
    
    @Override
    public String getLayoutConfig() {
        StringBuilder sb = new StringBuilder();
        String menuModeClass = ThemeUtils.getMenuModeClass(menuMode);
        String menuThemeClass = "layout-menu-" + ("colored".equals(menuColor) ? this.menuTheme : this.menuColor);

        sb.append("layout-topbar-").append(this.topbarTheme);
        sb.append(" ").append(menuThemeClass);
        sb.append(" ").append(menuModeClass);

        return sb.toString();
    }

	@Override
	public String getInputStyleClass() {
		return ThemeUtils.getInputStyleClass(inputStyle);
	}

	@Override
	public String getLayout() {
		return "layout-" + this.layoutPrimaryColor;
	}

	@Override
	public String getThemeName() {
		return "pandora-" + this.componentTheme;
	}
	
	@Override
	public PandoraTheme getTheme() {
		return this;
	}
	
    public void changePalette(ThemePalette palette) {
        this.setMenuColor(palette.getMenuColor().getName());
        this.setMenuTheme(palette.getMenuTheme().getName());
        this.setTopbarTheme(palette.getTopbarTheme().getName());
        this.setComponentTheme(palette.getComponentTheme().getName());
        this.setSelectedPalette(palette);
    }
    
	public List<ThemeMenu> getThemeMenuItems() {
		if (JSFValidators.isEmpty(menuColors)) {
			return Collections.emptyList();
		}
		return menuColors.get(menuColor);
	}
	
	public String getMenuBgColor() {
		return (selectedPalette != null ? selectedPalette.getMenuColor().getCode() : NONE_COLOR);
	}
	
	public String getMenuTitle() {
		return (selectedPalette != null ? selectedPalette.getMenuColor().getName() : "");
	}
	
	public String getThemeBgColor() {
		return (selectedPalette != null ? selectedPalette.getMenuTheme().getCode() : NONE_COLOR);
	}
	
	public String getThemeTitle() {
		return (selectedPalette != null ? selectedPalette.getMenuTheme().getName() : "");
	}
	
	public String getTopbarBgColor() {
		return (selectedPalette != null ? selectedPalette.getTopbarTheme().getCode() : NONE_COLOR);
	}
	
	public String getTopbarTitle() {
		return (selectedPalette != null ? selectedPalette.getTopbarTheme().getName() : "");
	}
	
	public String getComponentBgColor() {
		return (selectedPalette != null ? selectedPalette.getComponentTheme().getCode() : NONE_COLOR);
	}
	
	public String getComponentTitle() {
		return (selectedPalette != null ? selectedPalette.getComponentTheme().getName() : "");
	}

	public String getMenuMode() {
		return menuMode;
	}

	public void setMenuMode(String menuMode) {
		this.menuMode = menuMode;
	}

	public String getMenuColor() {
		return menuColor;
	}

	public void setMenuColor(String menuColor) {
		this.menuColor = menuColor;
	}

	public String getMenuTheme() {
		return menuTheme;
	}

	public void setMenuTheme(String menuTheme) {
		this.menuTheme = menuTheme;
	}

	public String getTopbarTheme() {
		return topbarTheme;
	}

	public void setTopbarTheme(String topbarTheme) {
		this.topbarTheme = topbarTheme;
	}

	public String getInputStyle() {
		return inputStyle;
	}

	public void setInputStyle(String inputStyle) {
		this.inputStyle = inputStyle;
	}

	public String getComponentTheme() {
		return componentTheme;
	}

	public void setComponentTheme(String componentTheme) {
		this.componentTheme = componentTheme;
	}

	public String getLayoutPrimaryColor() {
		return layoutPrimaryColor;
	}

	public void setLayoutPrimaryColor(String layoutPrimaryColor) {
		this.layoutPrimaryColor = layoutPrimaryColor;
	}

	public boolean isGroupedMenu() {
		return groupedMenu;
	}

	public void setGroupedMenu(boolean groupedMenu) {
		this.groupedMenu = groupedMenu;
	}

	public boolean isDarkLogo() {
		return darkLogo;
	}

	public void setDarkLogo(boolean darkLogo) {
		this.darkLogo = darkLogo;
	}

	public List<ThemeComponent> getComponentThemes() {
		return componentThemes;
	}

	public void setComponentThemes(List<ThemeComponent> componentThemes) {
		this.componentThemes = componentThemes;
	}

	public List<ThemeTopbar> getTopbarThemes() {
		return topbarThemes;
	}

	public void setTopbarThemes(List<ThemeTopbar> topbarThemes) {
		this.topbarThemes = topbarThemes;
	}

	public Map<String, List<ThemeMenu>> getMenuColors() {
		return menuColors;
	}

	public void setMenuColors(Map<String, List<ThemeMenu>> menuColors) {
		this.menuColors = menuColors;
	}

	public List<ThemePalette> getPalettes() {
		return palettes;
	}

	public void setPalettes(List<ThemePalette> palettes) {
		this.palettes = palettes;
	}

	public ThemePalette getSelectedPalette() {
		return selectedPalette;
	}

	public void setSelectedPalette(ThemePalette selectedPalette) {
		this.selectedPalette = selectedPalette;
	}
	
}
