package com.example.sergiobelda.materialmotion.notes

import androidx.annotation.ColorRes
import com.example.sergiobelda.materialmotion.R

data class Note(
    val id: Int,
    val title: String,
    val body: String,
    @ColorRes val colorRes: Int
)

val note1 = Note(
    id = 1,
    title = "ToDo 1",
    body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus scelerisque placerat nisl, nec semper felis ullamcorper vel. Nullam egestas ante nec tortor egestas mattis. Duis ut diam nec nibh sodales commodo at at diam. Nunc tempor eu lectus ut feugiat. Etiam eget ullamcorper est, at scelerisque lectus. Aliquam erat volutpat. Maecenas est urna, vestibulum non eros non, dignissim feugiat mi. Cras sit amet ex hendrerit, accumsan dolor in, bibendum erat. Maecenas ullamcorper ut risus eget congue. Vestibulum aliquam ipsum ut turpis efficitur, vel malesuada neque aliquam. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean egestas justo id rutrum blandit. Vestibulum id orci libero. Aliquam pharetra sed mauris ac vehicula.",
    colorRes = R.color.blue300
)

val note2 = Note(
    id = 2,
    title = "ToDo 2",
    body = "Fusce hendrerit enim in eros congue, sed pharetra libero tempus. Integer accumsan euismod nibh non vestibulum. Curabitur finibus imperdiet nunc vel ornare. Ut maximus fringilla sapien in viverra. Aenean a nulla feugiat, hendrerit risus et, congue erat. Ut venenatis lorem sit amet volutpat sollicitudin. Donec ac lorem auctor sem mattis faucibus non ac ante. Phasellus id sem non ante bibendum porta non in tellus. Etiam pellentesque porta luctus.",
    colorRes = R.color.amber300
)

val note3 = Note(
    id = 3,
    title = "ToDo 3",
    body = "Praesent interdum dictum magna quis pretium. Suspendisse at cursus ante, id rutrum nunc. Nullam at lacinia nibh, nec gravida lectus. Quisque maximus vulputate leo, et sollicitudin turpis luctus pellentesque. Nullam vehicula sagittis magna, consectetur congue neque ullamcorper vel. Praesent sed vulputate nunc. Ut ligula lorem, lobortis tristique interdum at, mollis a dolor. Ut sed fringilla urna, id suscipit justo. Praesent ut tortor pharetra, laoreet metus non, iaculis mi. Duis vel lacus fermentum, porta neque id, ultricies arcu. Nunc interdum, est ac sodales tristique, elit urna feugiat dui, quis venenatis ante lorem ullamcorper mi. Nulla id condimentum lorem. Nunc ac scelerisque felis. Nam semper, mi et ultrices rutrum, neque odio molestie tortor, ac iaculis ante arcu eu elit. Phasellus imperdiet tortor quis aliquam ornare.",
    colorRes = R.color.green300
)

val notes = listOf(note1, note2, note3)