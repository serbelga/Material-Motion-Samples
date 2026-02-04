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

package dev.sergiobelda.samples.materialmotion.planets

data class Planet(
    val id: Int,
    val name: String,
    val mainImage: String,
    val description: String,
)

val mercury =
    Planet(
        id = 1,
        name = "Mercury",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/771_PIA16853.jpg",
        description =
            "The smallest planet in our solar system and nearest to the Sun, Mercury is only slightly larger than Earth's Moon." +
                "\n" +
                "From the surface of Mercury, the Sun would appear more than three times as large as it does when viewed from Earth, and the sunlight would be as much as seven times brighter. Despite its proximity to the Sun, Mercury is not the hottest planet in our solar system – that title belongs to nearby Venus, thanks to its dense atmosphere.",
    )

val venus =
    Planet(
        id = 2,
        name = "Venus",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/775_PIA00271_detail.jpg",
        description = "Second planet from the Sun and our closest planetary neighbor, Venus is similar in structure and size to Earth, but it is now a very different world. Venus spins slowly in the opposite direction most planets do. Its thick atmosphere traps heat in a runaway greenhouse effect, making it the hottest planet in our solar system—with surface temperatures hot enough to melt lead. Glimpses below the clouds reveal volcanoes and deformed mountains.",
    )

val earth =
    Planet(
        id = 3,
        name = "Earth",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/2292_as08-14-2383.jpg",
        description =
            "Our home planet is the third planet from the Sun, and the only place we know of so far that’s inhabited by living things." +
                "\n" +
                "While Earth is only the fifth largest planet in the solar system, it is the only world in our solar system with liquid water on the surface. Just slightly larger than nearby Venus, Earth is the biggest of the four planets closest to the Sun, all of which are made of rock and metal.\n" +
                "\n" +
                "The name Earth is at least 1,000 years old. All of the planets, except for Earth, were named after Greek and Roman gods and goddesses. However, the name Earth is a Germanic word, which simply means “the ground.”",
    )

val mars =
    Planet(
        id = 4,
        name = "Mars",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/948_mars_july18.jpg",
        description =
            "The fourth planet from the Sun, Mars is a dusty, cold, desert world with a very thin atmosphere." +
                "\n" +
                "This dynamic planet has seasons, polar ice caps and weather and canyons and extinct volcanoes, evidence of an even more active past.\n" +
                "\n" +
                "Mars is one of the most explored bodies in our solar system, and it's the only planet where we've sent rovers to roam the alien landscape. NASA currently has three spacecraft in orbit, one rover and one lander on the surface and another rover under construction here on Earth. India and ESA also have spacecraft in orbit above Mars.\n" +
                "\n" +
                "These robotic explorers have found lots of evidence that Mars was much wetter and warmer, with a thicker atmosphere, billions of years ago.",
    )

val jupiter =
    Planet(
        id = 5,
        name = "Jupiter",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/2486_stsci-h-p1936a_1800.jpg",
        description =
            "Jupiter has a long history surprising scientists—all the way back to 1610 when Galileo Galilei found the first moons beyond Earth. That discovery changed the way we see the universe." +
                "Fifth in line from the Sun, Jupiter is, by far, the largest planet in the solar system – more than twice as massive as all the other planets combined.\n" +
                "\n" +
                "Jupiter's familiar stripes and swirls are actually cold, windy clouds of ammonia and water, floating in an atmosphere of hydrogen and helium. Jupiter’s iconic Great Red Spot is a giant storm bigger than Earth that has raged for hundreds of years.\n" +
                "\n" +
                "One spacecraft — NASA's Juno orbiter — is currently exploring this giant world.",
    )

val saturn =
    Planet(
        id = 6,
        name = "Saturn",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/2490_stsci-h-p1943a-f_1200.jpg",
        description =
            "Saturn is the sixth planet from the Sun and the second largest planet in our solar system." +
                "\n" +
                "Adorned with thousands of beautiful ringlets, Saturn is unique among the planets. It is not the only planet to have rings—made of chunks of ice and rock—but none are as spectacular or as complicated as Saturn's.\n" +
                "\n" +
                "Like fellow gas giant Jupiter, Saturn is a massive ball made mostly of hydrogen and helium.",
    )

val uranus =
    Planet(
        id = 7,
        name = "Uranus",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/599_PIA18182.jpg",
        description =
            "The first planet found with the aid of a telescope, Uranus was discovered in 1781 by astronomer William Herschel, although he originally thought it was either a comet or a star." +
                "\n" +
                "It was two years later that the object was universally accepted as a new planet, in part because of observations by astronomer Johann Elert Bode. Herschel tried unsuccessfully to name his discovery Georgium Sidus after King George III. Instead the scientific community accepted Bode's suggestion to name it Uranus, the Greek god of the sky, as suggested by Bode.",
    )

val neptune =
    Planet(
        id = 8,
        name = "Neptune",
        mainImage = "https://solarsystem.nasa.gov/system/resources/detail_files/611_PIA01492.jpg",
        description =
            "Dark, cold and whipped by supersonic winds, ice giant Neptune is the eighth and most distant planet in our solar system." +
                "\n" +
                "More than 30 times as far from the Sun as Earth, Neptune is the only planet in our solar system not visible to the naked eye and the first predicted by mathematics before its discovery. In 2011 Neptune completed its first 165-year orbit since its discovery in 1846.\n" +
                "\n" +
                "NASA's Voyager 2 is the only spacecraft to have visited Neptune up close. It flew past in 1989 on its way out of the solar system.",
    )

val planets = arrayListOf(mercury, venus, earth, mars, jupiter, saturn, uranus, neptune)
