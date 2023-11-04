
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

@file:Suppress("ktlint:standard:max-line-length")

package dev.sergiobelda.samples.materialmotion.music

data class Artist(
    val id: Int,
    val name: String,
    val image: String,
)

data class Album(
    val id: Int,
    val name: String,
    val image: String,
)

val shiroi =
    Album(
        id = 1,
        name = "Shiroi",
        image = "https://img.discogs.com/EI7SfveNHws0ONsXJO9FLEpZFYc=/fit-in/600x536/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-12841514-1544304275-9214.jpeg.jpg",
    )

val wywh =
    Album(
        id = 2,
        name = "Wish You Were Here",
        image = "https://img.discogs.com/tQj6wwY11KUz3TUwq8DHOnZdWl0=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-3354750-1477237778-6311.jpeg.jpg",
    )

val jazzmaica =
    Album(
        id = 3,
        name = "Jazzmaica",
        image = "https://img.discogs.com/JQny678Vd6janet-PeNjrlK66z8=/fit-in/600x599/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-8489874-1510971569-9261.jpeg.jpg",
    )

val albums = listOf(shiroi, wywh, jazzmaica)

val snarky =
    Artist(
        id = 1,
        name = "Snarky Puppy",
        image = "https://is2-ssl.mzstatic.com/image/thumb/Features20/v4/bf/82/f8/bf82f863-1edd-626a-2d9b-8c76cbabdd83/mzl.pouxzkfo.jpg/1000x1000cc.jpg",
    )

val yussef =
    Artist(
        id = 2,
        name = "Yussef Dayes",
        image = "https://is3-ssl.mzstatic.com/image/thumb/Music123/v4/ca/c7/96/cac7966f-dd10-d016-b146-6d8e8cf8fb70/pr_source.png/1000x1000cc.jpg",
    )

val dubinc =
    Artist(
        id = 3,
        name = "Dub Inc",
        image = "https://is3-ssl.mzstatic.com/image/thumb/Music123/v4/34/75/9f/34759f94-c43b-1861-8fc3-12b2e40198b1/pr_source.png/1000x1000cc.jpg",
    )

val cory =
    Artist(
        id = 4,
        name = "Cory Henry",
        image = "https://is1-ssl.mzstatic.com/image/thumb/Music123/v4/70/5e/fe/705efec8-c546-0534-64fa-77ee0c8fd99d/pr_source.png/1000x1000cc.jpg",
    )

val artists = listOf(cory, dubinc, snarky, yussef)
