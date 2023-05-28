package ir.shabrangkala.simplelibrary

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.TranslateAnimation
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import ir.shabrangkala.simplelibrary.databinding.ActivityLoginBinding
import java.util.*
import kotlin.concurrent.timerTask

const val WRONG_TIME = 50L
const val WRONG_TRANSLATION = 50f

class LoginActivity : AppCompatActivity() {


    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //sharedPreferences
        val sharedPreferences = getSharedPreferences("logon data", Context.MODE_PRIVATE)


        binding.loginButton.setOnClickListener {

            if (binding.username.text.toString().isEmpty()){
                errorAnim("Enter your user name !!!", binding.usernameTextField)
            }else{
                binding.usernameTextField.error = null
                sharedPreferences.edit().putString("username", binding.username.text.toString()).apply()
            }

            if (checkInputs(binding.username.text.toString(), binding.password.text.toString())){
                sharedPreferences.edit().putString("password", binding.password.text.toString()).apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Wrong password !!!", Toast.LENGTH_SHORT).show()
                errorAnim("Passwords have at least a capital letter !", binding.passwordTextField)
            }
        }

        binding.username.setText(sharedPreferences.getString("username", ""))
        binding.password.setText(sharedPreferences.getString("password", ""))




    }

    private fun errorAnim(errorText : String, textInputLayout: TextInputLayout){
        textInputLayout.error = errorText

        for (i in 0..3){
            Timer().schedule(timerTask {
                runOnUiThread {
                    when(i){
                        0->{
                            val anim = TranslateAnimation(0f, -WRONG_TRANSLATION, 0f, 0f)
                            anim.duration = WRONG_TIME
                            anim.fillAfter = true

                            textInputLayout.startAnimation(anim)
                        }
                        1->{
                            val anim1 = TranslateAnimation(-WRONG_TRANSLATION, 0f, 0f, 0f)
                            anim1.duration = WRONG_TIME
                            anim1.fillAfter = true

                            textInputLayout.startAnimation(anim1)
                        }
                        2->{
                            val anim1 = TranslateAnimation(0f, WRONG_TRANSLATION, 0f, 0f)
                            anim1.duration = WRONG_TIME
                            anim1.fillAfter = true

                            textInputLayout.startAnimation(anim1)
                        }
                        3->{
                            val anim1 = TranslateAnimation(WRONG_TRANSLATION, 0f, 0f, 0f)
                            anim1.duration = WRONG_TIME
                            anim1.fillAfter = true

                            textInputLayout.startAnimation(anim1)
                        }
                    }
                }
            }, (i*WRONG_TIME))
        }
    }

    private fun checkInputs(name: String, password: String): Boolean {
        val namePattern = Regex("^[a-zA-Z][a-zA-Z0-9]+\$")
        val passwordPattern = Regex("[a-z]*[A-Z][a-z]*")
        if (namePattern.containsMatchIn(name) && passwordPattern.containsMatchIn(password)) {
            return true
        }
        return false
    }
}