import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import org.jetbrains.kotlin.com.intellij.openapi.util.text.HtmlChunk.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "com.binayshaw7777.repeakt"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Repeakt")
            head.add {
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(rel = "preconnect", href = "https://fonts.gstatic.com") { attributes["crossorigin"] = "" }
                link(
                    href = "https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,100..900;1,100..900&display=swap",
                    rel = "stylesheet"
                )
                link(
                    href = "https://fonts.googleapis.com/css2?family=Darker+Grotesque:wght@300..900&family=Inter:wght@100..900&family=Syne&display=swap",
                    rel = "stylesheet"
                )
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("repeakt", includeServer = true)

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            
        }
        jvmMain.dependencies {
            compileOnly(libs.kobweb.api) // Provided by Kobweb backend at runtime
        }
    }
}
