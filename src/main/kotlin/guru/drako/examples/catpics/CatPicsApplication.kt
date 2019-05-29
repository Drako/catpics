package guru.drako.examples.catpics

import android.app.Application
import com.squareup.picasso.Picasso
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class CatPicsApplication : Application() {
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
