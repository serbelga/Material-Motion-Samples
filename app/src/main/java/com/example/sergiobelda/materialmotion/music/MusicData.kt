package com.example.sergiobelda.materialmotion.music

data class Artist(
    val id: Int,
    val name: String,
    val image: String
)

data class Album(
    val id: Int,
    val name: String,
    val image: String
)

val shiroi = Album(
    id = 1,
    name = "Shiroi",
    image = "https://img.discogs.com/EI7SfveNHws0ONsXJO9FLEpZFYc=/fit-in/600x536/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-12841514-1544304275-9214.jpeg.jpg"
)

val wywh = Album(
    id = 2,
    name = "Wish You Were Here",
    image = "https://img.discogs.com/tQj6wwY11KUz3TUwq8DHOnZdWl0=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-3354750-1477237778-6311.jpeg.jpg"
)

val jazzmaica = Album(
    id = 3,
    name = "Jazzmaica",
    image = "https://img.discogs.com/JQny678Vd6janet-PeNjrlK66z8=/fit-in/600x599/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-8489874-1510971569-9261.jpeg.jpg"
)

val albums = arrayListOf(shiroi, wywh, jazzmaica)