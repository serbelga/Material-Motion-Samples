plugins {
    `kotlin-dsl`
}

group = "dev.sergiobelda.samples.materialmotion.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.spotless.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("spotless") {
            id = "samples.materialmotion.spotless"
            implementationClass = "SpotlessConventionPlugin"
        }
    }
}
