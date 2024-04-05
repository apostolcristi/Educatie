package com.example.educatie
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.educatie.R // Asigurați-vă că importați pachetul corect pentru resursele dvs.

class LearningTopic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning)

        // Recuperați informațiile despre materia selectată din intent
        val subject = intent.getStringExtra("subject")

        // Înlocuiți fragmentul corespunzător în funcție de materia selectată
        val fragment: Fragment = when (subject) {
            "Matematică" -> MathematicsFragment()
            "Chimie" -> ChemistryFragment()
            "Fizică" -> PhysicsFragment()
            // Adăugați alte cazuri pentru alte materii, dacă este necesar
            else -> MathematicsFragment() // Fragment implicit
        }

        // Înlocuiți fragmentul actual cu fragmentul corespunzător
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
