dependencies {
    api(libs.hikari)

    implementation(libs.h2)
    api(project(":arivon-common"))
    api(project(":arivon-sql-parent"))
}