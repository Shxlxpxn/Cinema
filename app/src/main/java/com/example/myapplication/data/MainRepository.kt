package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.domain.Film

class MainRepository {
    val filmsDataBase = listOf(
        Film(
            "The Godfather",
            R.drawable.godfather,
            "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
            9.7f
        ),
        Film(
            "Breaking Bad",
            R.drawable.breakingbad,
            "A chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine with a former student in order to secure his family's future.",
            8.2f
        ),
        Film(
            "Baby Reindeer",
            R.drawable.babyreindeer,
            "The story follows writer and performer Richard Gadd's warped relationship with a female stalker and the impact it has on him as he is ultimately forced to face a deep, dark buried trauma.",
            6.3f
        ),
        Film(
            "Schindler's List",
            R.drawable.schindler,
            "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
            8.8f
        ),
        Film(
            "Forrest Gump",
            R.drawable.forrestg,
            "The history of the United States from the 1950s to the '70s unfolds from the perspective of an Alabama man with an IQ of 75, who yearns to be reunited with his childhood sweetheart.",
            9.6f
        ),
        Film(
            "The Matrix",
            R.drawable.matrix,
            "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
            9.2f
        ),
        Film(
            "Interstellar",
            R.drawable.interstellar,
            "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
            9.9f
        ),
        Film(
            "Joker",
            R.drawable.joker,
            "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.",
            9.0f
        ),
        Film(
            "Léon",
            R.drawable.leon,
            "12-year-old Mathilda is reluctantly taken in by Léon, a professional assassin, after her family is murdered. An unusual relationship forms as she becomes his protégée and learns the assassin's trade.",
            6.9f
        )
    )
}