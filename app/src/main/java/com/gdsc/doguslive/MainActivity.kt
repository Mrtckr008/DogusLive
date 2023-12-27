package com.gdsc.doguslive

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.gdsc.doguslive.databinding.ActivityMainBinding
import com.gdsc.doguslive.live.User
import com.gdsc.doguslive.live.classsamples.ImagePost
import com.gdsc.doguslive.live.classsamples.MovieData
import com.gdsc.doguslive.live.classsamples.PostSample
import com.gdsc.doguslive.live.classsamples.VideoPost
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab).setAction("Action", null).show()

            val navController = findNavController(R.id.nav_host_fragment_content_main)

            navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


        val user: User = User() // User sınıfından user nesnesi oluşturduk.

        user.userName = "dogusgdsc" // user nesnesinin userName özelliğine değer atadık.

        val userName = user.userName // bu değeri başka bir değişkene atadık.

        user.sharePost() // user nesnesinden bir fonksiyon çağırdık.

        val post: PostSample = PostSample("dwehbnkj.jpg") // Sınıfın constructor'ını kullanarak nesne oluşturduk


        val imagePost: ImagePost = ImagePost() // ImagePost sınıfından nesnesini oluşturduk
        val videoPost: VideoPost = VideoPost() // VideoPost sınıfından nesnesini oluşturduk

        imagePost.zoomIn() // ImagePosttan bir fonksiyon çağırdık
        videoPost.pauseContent() // VideoPosttan bir fonksiyon çağırdık


        val movieData: MovieData = MovieData( // Bir dataclass sınıfı oluşturduk.
            "1", "Thor", 2011, arrayListOf("de", "eng"), true
        )

        // textview -> MovieMovie
        movieData.name
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}