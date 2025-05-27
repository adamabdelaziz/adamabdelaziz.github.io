package org.adam.resume.website

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import compose.icons.FeatherIcons
import compose.icons.feathericons.Clipboard
import compose.icons.feathericons.Codesandbox
import compose.icons.feathericons.Info
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import org.adam.resume.website.ui.components.Project
import org.adam.resume.website.ui.components.projectList

data class SiteState(
    val selectedTab: SiteTabs = SiteTabs.ABOUT,
    val isDarkTheme: Boolean = true,
    val outlinedText: String = "Software Engineer",
    val clickedSkill: String? = null,
    val clickedProject: Project? = null,
)

sealed class SiteEvent {
    data class OnTabSelected(val tab: SiteTabs) : SiteEvent()
    data object OnToggleThemeClicked : SiteEvent()
    data class OnSkillClicked(val skill: String) : SiteEvent()
    data class OnProjectClicked(val project: String) : SiteEvent()
}

enum class SiteTabs(val title: String, val icon: ImageVector) {
    ABOUT(title = "About", icon = FeatherIcons.Info),
    SKILLS_AND_TECHNOLOGIES(title = "Skills and Technologies", icon = FeatherIcons.Clipboard),
    PROJECTS(title = "Projects", icon = FeatherIcons.Codesandbox),
}

class SiteViewModel : ViewModel() {
    private val _state = mutableStateOf(SiteState())

    val state: State<SiteState>
        get() = _state

    private val listOfTextChoices = listOf("Software Engineer", "Kotlin Enthusiast", "Mobile Developer", "Android Engineer")

    init {
        viewModelScope.launch {
            while (isActive) {
                _state.value = _state.value.copy(
                    outlinedText = listOfTextChoices.random()
                )
                kotlinx.coroutines.delay(3000)
            }
        }
    }

    fun onEvent(event: SiteEvent) {
        when (event) {
            is SiteEvent.OnTabSelected -> {
                _state.value = _state.value.copy(selectedTab = event.tab)
            }

            is SiteEvent.OnToggleThemeClicked -> {
                _state.value = _state.value.copy(isDarkTheme = !_state.value.isDarkTheme)
            }



            is SiteEvent.OnSkillClicked -> {
                _state.value = _state.value.copy(clickedSkill = event.skill)
            }

            is SiteEvent.OnProjectClicked -> {
                val project = projectList.firstOrNull { it.title == event.project }
                _state.value = _state.value.copy(clickedProject = project)
            }
        }
    }
}