package org.club.sports.android.tabletennisscoringapp.util

import com.google.firebase.firestore.BuildConfig
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseUtils {

    /** Use emulators only in debug builds **/
    private val sUseEmulators: Boolean = BuildConfig.DEBUG

    private lateinit var firestore: FirebaseFirestore

    fun getFirestore() {
        if (firestore == null) {
            firestore = FirebaseFirestore.getInstance()
            // Connect to the Cloud Firestore emulator when appropriate. The host '10.0.2.2' is a
            // special IP address to let the Android emulator connect to 'localhost'.
            if (sUseEmulators) {
                firestore.useEmulator("10.0.2.2", 8080)
            }
        }
    }
}