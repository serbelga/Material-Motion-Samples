/*
 * Copyright 2021 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sergiobelda.materialmotion.sample

import androidx.annotation.StringRes
import com.example.sergiobelda.materialmotion.R
import com.example.sergiobelda.materialmotion.messages.MessagesActivity
import com.example.sergiobelda.materialmotion.music.MusicActivity
import com.example.sergiobelda.materialmotion.notes.NotesActivity
import com.example.sergiobelda.materialmotion.planets.PlanetsActivity
import com.example.sergiobelda.materialmotion.signin.SignInActivity
import com.example.sergiobelda.materialmotion.walkthrough.WalkthroughActivity

data class SampleItem(
    @StringRes val nameRes: Int,
    @StringRes val descriptionRes: Int,
    val activity: Class<*>
)

val messagesSample = SampleItem(
    nameRes = R.string.messages,
    descriptionRes = R.string.messages_card_body,
    activity = MessagesActivity::class.java
)

val notesSample = SampleItem(
    nameRes = R.string.notes,
    descriptionRes = R.string.notes_card_body,
    activity = NotesActivity::class.java
)

val walkthroughSample = SampleItem(
    nameRes = R.string.walkthrough,
    descriptionRes = R.string.walkthrough_card_body,
    activity = WalkthroughActivity::class.java
)

val solarSystemSample = SampleItem(
    nameRes = R.string.solar_system,
    descriptionRes = R.string.solar_system_card_body,
    activity = PlanetsActivity::class.java
)

val signInSample = SampleItem(
    nameRes = R.string.sign_in,
    descriptionRes = R.string.sign_in_card_body,
    activity = SignInActivity::class.java
)

val musicSample = SampleItem(
    nameRes = R.string.music,
    descriptionRes = R.string.music_card_body,
    activity = MusicActivity::class.java
)

val samples = arrayListOf(
    messagesSample,
    notesSample,
    walkthroughSample,
    solarSystemSample,
    signInSample,
    musicSample
)
