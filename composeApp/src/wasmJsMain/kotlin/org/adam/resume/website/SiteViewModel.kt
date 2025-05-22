package org.adam.resume.website

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

data class SiteState(
    val selectedTab: SiteTabs = SiteTabs.ABOUT,
    val isDarkTheme: Boolean = true,
    val outlinedText: String = "Software Engineer",
)

sealed class SiteEvent {
    data class OnTabSelected(val tab: SiteTabs) : SiteEvent()
    data object OnToggleThemeClicked : SiteEvent()
}


enum class SiteTabs(val title: String) {
    ABOUT("About"),
    SKILLS_AND_PROJECTS("Skills and Projects"),
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
        }
    }
}