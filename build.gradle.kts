plugins {
}

allprojects {
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    version = "1.0-SNAPSHOT"
    group = "dev.ole.arivon"

    repositories {
        mavenCentral()
        maven(url = "https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }

    dependencies {
        "annotationProcessor"(rootProject.libs.lombok)
        "implementation"(rootProject.libs.bundles.utils)
    }

    tasks.withType<JavaCompile>().configureEach {
        sourceCompatibility = JavaVersion.VERSION_21.toString()
        targetCompatibility = JavaVersion.VERSION_21.toString()
        options.encoding = "UTF-8"
    }

    extensions.configure<PublishingExtension> {
        publications {
            create("library", MavenPublication::class.java) {
                from(project.components.getByName("java"))

                pom {
                    name.set(project.name)
                    url.set("https://github.com/oleeesch/arivon-database")
                    description.set("Reflection/Data libary")
                    licenses {
                        license {
                            name.set("Apache License")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0")
                        }
                    }
                    developers {
                        developer {
                            name.set("Ole Schumacher")
                            email.set("oleschumacher1801@gmail.com")
                        }
                    }

                    scm {
                        url.set("https://github.com/oleeesch/arivon-database")
                        connection.set("https://github.com/oleeesch/arivon-database.git")
                    }
                }
            }
        }
    }
}