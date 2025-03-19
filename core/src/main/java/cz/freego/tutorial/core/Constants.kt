package cz.freego.tutorial.core

object Constants {

    // remote (API)
    const val SPACEX_API_BASE_URL = "https://api.spacexdata.com/v4/"
    const val SIMULATED_ERRORS: Boolean = false // pro testování error state
    const val PRECACHE_ON_SPLASHSCREEN = true // využijeme čas na splash screen a přednačteme obsah
    const val CACHE_DIR = "http_cache" // adresář v sandboxu pro cache
    const val CACHE_SIZE = 10L * 1024L * 1024L // 10 MB cache
    const val CACHE_MAX_AGE_SECS = 60 // životnost cache dat v sekundách

    // paging (definujeme limit stránkování pro každý případ, může se hodit při různě velkých items)
    const val CREW_PAGING_LIMIT: Int = 10
    const val ROCKET_PAGING_LIMIT: Int = 10
    const val DRAGON_PAGING_LIMIT: Int = 10
    const val CAPSULE_PAGING_LIMIT: Int = 10
    const val SHIP_PAGING_LIMIT: Int = 10
    const val LAUNCHPAD_PAGING_LIMIT: Int = 10
    const val LANDPAD_PAGING_LIMIT: Int = 10

}