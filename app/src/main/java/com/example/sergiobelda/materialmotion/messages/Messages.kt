package com.example.sergiobelda.materialmotion.messages

data class Message(
    val id: Int,
    val contact: Contact,
    val body: String
)

data class Contact(
    val id: Int,
    val name: String,
    val email: String,
    val image: String
)

val contact1 = Contact(
    id = 1,
    name = "Jacob",
    email = "jacob@mail.com",
    image = "https://i.picsum.photos/id/1012/300/300.jpg"
)

val contact2 = Contact(
    id = 2,
    name = "Sophie",
    email = "sophie@mail.com",
    image = "https://i.picsum.photos/id/237/300/300.jpg"
)

val contact3 = Contact(
    id = 3,
    name = "Ada",
    email = "ada@mail.com",
    image = "https://i.picsum.photos/id/786/300/300.jpg"
)

val contact4 = Contact(
    id = 4,
    name = "William",
    email = "william@mail.com",
    image = "https://i.picsum.photos/id/1035/300/300.jpg"
)

val message1 = Message(
    id = 1,
    contact = contact1,
    body = "Hello Friend"
)

val message2 = Message(
    id = 2,
    contact = contact2,
    body = "Hi!"
)

val message3 = Message(
    id = 3,
    contact = contact3,
    body = "..."
)

val message4 = Message(
    id = 4,
    contact = contact4,
    body = "Hey!"
)

val contacts = listOf(contact1, contact2, contact3, contact4)

val favContacts = listOf(contact1, contact2, contact3)

val messages = listOf(message1, message2, message3, message4)