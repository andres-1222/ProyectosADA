plugins { java
    application}
repositories { mavenCentral() }
dependencies { implementation("org.json:json:20250517") }
application {
    mainClass.set("com.andresfhc.tema01.parsers.Main")
}