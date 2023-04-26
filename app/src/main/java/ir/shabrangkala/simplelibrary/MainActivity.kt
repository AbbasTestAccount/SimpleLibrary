package ir.shabrangkala.simplelibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import ir.shabrangkala.simplelibrary.databinding.ActivityMainBinding
import ir.shabrangkala.simplelibrary.databinding.HomeFragmentBinding
import ir.shabrangkala.simplelibrary.fragments.HomeFragment
import ir.shabrangkala.simplelibrary.fragments.ProfileFragment
import ir.shabrangkala.simplelibrary.fragments.SearchFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startFrag()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_icon -> {
                    setFrag(HomeFragment())
                }
                R.id.prof_icon -> {
                    setFrag(ProfileFragment())
                }
                R.id.search_icon -> {
                    setFrag(SearchFragment())
                }
            }
            true
        }

        binding.bottomNavigationView.setOnItemReselectedListener { //do nothing right now
        }



    }

    fun setFrag(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.main_frame_for_fragments, fragment)
        transaction.commit()
    }

    fun startFrag(){
        setFrag(HomeFragment())
        binding.bottomNavigationView.selectedItemId = R.id.home_icon
    }
}