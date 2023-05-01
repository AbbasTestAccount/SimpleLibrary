package ir.shabrangkala.simplelibrary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ir.shabrangkala.simplelibrary.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            if (checkInputs(binding.username.text.toString(), binding.password.text.toString())){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Wrong password !!!", Toast.LENGTH_SHORT).show()
            }
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