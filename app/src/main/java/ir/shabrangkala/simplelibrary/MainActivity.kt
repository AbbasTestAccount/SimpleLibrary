package ir.shabrangkala.simplelibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.shabrangkala.simplelibrary.databinding.ActivityMainBinding
import ir.shabrangkala.simplelibrary.databinding.HomeFragmentBinding
import ir.shabrangkala.simplelibrary.fragments.HomeFragment

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_icon -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.main_frame_for_fragments, HomeFragment())
                    transaction.commit()
                }
            }
            true
        }

        binding.bottomNavigationView.setOnItemReselectedListener { //do nothing right now
        }



    }
}