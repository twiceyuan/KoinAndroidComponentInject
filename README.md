Koin Android Component Inject
---

Inject Android Activity/Fragment instance with Koin scope.

## Get Start

1. Setup with your base Activity/Fragment (or extends KoinActivity/KoinFragment but not recommended.)

```kotlin
abstract class BaseActivity: AppCompatActivity() {

    open val scope: Scope by lazy { lifecycleScope }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (scope != lifecycleScope) {
            bindScope(scope)
        }

        setupActivityProvider(scope)
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


