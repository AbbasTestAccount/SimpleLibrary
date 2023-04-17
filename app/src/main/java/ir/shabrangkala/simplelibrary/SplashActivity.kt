package ir.shabrangkala.simplelibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shabrangkala.simplelibrary.databinding.ActivitySplashBinding
import java.util.Timer
import kotlin.concurrent.timerTask
import kotlin.collections.ArrayList
import kotlin.random.Random

lateinit var splashBinding: ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    val notes = arrayListOf<String>(" یک کتاب خوب، بهترین دوست و همدم انسان می باشد.",
        "خانه بدون کتاب روز بدون خورشید است",
        "یک کتاب، هزار نفر را می آموزد.",
        " یک کتاب خوب، بهترین دوست و همدم انسان می باشد.",
        "یک کتاب خوب روشن تر از ستاره ها میدرخشد.")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding.root)

        splashBinding.note.text = notes[Random(System.nanoTime()).nextInt(0, notes.size)]

        Timer().schedule(timerTask {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }
}