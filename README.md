Koin Android Component Inject
---

[![](https://jitpack.io/v/twiceyuan/KoinAndroidComponentInject.svg)](https://jitpack.io/#twiceyuan/KoinAndroidComponentInject)

Inject Android Activity/Fragment instance with Koin scope.

## Get Start

1. Setup with your base Activity/Fragment (or extends KoinActivity/KoinFragment but not recommended.)

```kotlin
abstract class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Add this line.
        setupActivityProvider(lifecycleScope)
    }
}
```

2. Setup scope with Koin configuration:

```kotlin
startKoin {
    // ...
    modules(sampleModule)
}

val sampleModule = module {
    // ...
    // Lifecycle scope inject
    scope<LifecycleScopeActivity> {
        // use Scope.currentActivity() to inject activity instance
        scoped { SampleModuleImpl(currentActivity()) } bind SampleModule::class
        // or use Scope.get()
        // scoped { SampleModuleImpl(get()) } bind SampleModule::class
    }
}
```

3. Inject by lifecycleScope

```kotlin
class MainActivity : BaseActivity() {

    // inject by lifecycle scope
    private val sampleModule: SampleModule by lifecycleScope.inject()
}
```

Also see samples in submodule: sample/sample-submodule

## How to use

```gradle
// Add maven source
maven { url 'https://jitpack.io/' }

// Add dependency
implementation 'com.github.twiceyuan.KoinAndroidComponentInject:android-component-inject:cee63def7f'
```

