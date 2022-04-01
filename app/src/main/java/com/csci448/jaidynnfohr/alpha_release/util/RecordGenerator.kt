package com.csci448.jaidynnfohr.alpha_release.util

import android.provider.MediaStore
import com.csci448.jaidynnfohr.alpha_release.data.PastRecord
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

object RecordGenerator {
    private fun <T> List<T>.rand() = shuffled().first()
    private val titles = listOf("Things Going Better","stressed today","Breakup","feeling pretty good :)","Family problems", null)
    private val textBodies = listOf("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
            "   incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco " +
            "laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " +
            "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa " +
            "qui officia deserunt mollit anim id est laborum.",
        "Sit amet purus gravida quis blandit turpis. Pulvinar sapien et ligula ullamcorper malesuada proin libero. Amet " +
                "porttitor eget dolor morbi non. Risus ultricies tristique nulla aliquet. Ut etiam sit amet nisl purus " +
                "in mollis nunc. Dolor purus non enim praesent. Porta nibh venenatis cras sed felis eget velit aliquet " +
                "sagittis. Sed tempus urna et pharetra pharetra massa massa. Eros in cursus turpis massa tincidunt dui. " +
                "Nibh ipsum consequat nisl vel pretium. Nec feugiat nisl pretium fusce id velit ut tortor pretium. " +
                "Imperdiet sed euismod nisi porta lorem. Egestas diam in arcu cursus euismod quis viverra nibh.")
    private val date = LocalDate.now()
    private val textTime = LocalTime.now()
    private val audioTime = LocalTime.now()
    private val audio = listOf(null,MediaStore.Audio())

    fun generateRandomRecord() = PastRecord(title = titles.rand(), textEntry = textBodies.rand(), date = date, textTime = textTime, audioTime = audioTime, audio = audio.rand())
}