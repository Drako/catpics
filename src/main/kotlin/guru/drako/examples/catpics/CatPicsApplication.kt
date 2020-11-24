package guru.drako.examples.catpics

import androidx.multidex.MultiDexApplication
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CatPicsApplication : MultiDexApplication() {
  private val appModule = module {
    single { Picasso.get() }
    single { CatApi() }
  }

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidContext(this@CatPicsApplication)
      modules(appModule)
    }
  }
}
