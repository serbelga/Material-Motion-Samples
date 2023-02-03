plugins {
    `kotlin-dsl`
}

group = "dev.sergiobelda.materialmotionsamples.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("spotless") {
            id = "materialmotionsamples.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
    }
}
