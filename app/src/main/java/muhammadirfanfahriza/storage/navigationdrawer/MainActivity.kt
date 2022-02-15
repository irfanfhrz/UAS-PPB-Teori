package muhammadirfanfahriza.storage.navigationdrawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var tblMakanMinum : ImageView;
    private lateinit var tblRumahDapur : ImageView;
    private lateinit var tblIbuAnak : ImageView;
    private lateinit var tblSehatCantik : ImageView;
    private lateinit var tblExit : ImageView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val imgMenu = findViewById<ImageView>(R.id.imgMenu)

        val navView = findViewById<NavigationView>(R.id.NavigationDrawer)
        navView.itemIconTintList = null
        imgMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupWithNavController(navView,navController)

        val textTitle = findViewById<TextView>(R.id.title)
        navController
            .addOnDestinationChangedListener { controller, destination, arguments ->
                textTitle.text = destination.label
            }

        //image slider
        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://disk.mediaindonesia.com/thumbs/1800x1200/news/2021/06/624b0264e17758f4a4394526096afc03.jpg"))
        imageList.add(SlideModel("https://upload.wikimedia.org/wikipedia/commons/b/b8/Cryptocurrency_logos.jpg"))
        imageList.add(SlideModel("https://img.inews.co.id/media/822/files/inews_new/2021/06/10/cryptocurrency.jpg"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        //button
        tblMakanMinum = findViewById<ImageView>(R.id.imageView1)
        tblRumahDapur = findViewById<ImageView>(R.id.imageView2)
        tblIbuAnak = findViewById<ImageView>(R.id.imageView3)
        tblSehatCantik = findViewById<ImageView>(R.id.imageView4)

        tblMakanMinum.setOnClickListener{
            val intent = Intent(this, MakanMinum::class.java)
            startActivity(intent)
        }

        tblRumahDapur.setOnClickListener{
            val intent = Intent(this, RumahDapur::class.java)
            startActivity(intent)
        }

        tblIbuAnak.setOnClickListener{
            val intent = Intent(this, IbuAnak::class.java)
            startActivity(intent)
        }

        tblSehatCantik.setOnClickListener{
            val intent = Intent(this, SehatCantik::class.java)
            startActivity(intent)
        }
    }
}