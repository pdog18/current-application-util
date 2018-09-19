
## 不需要在Application#onCreate中初始化的Context获取工具类 ##


相信 99% 的 `Android`  开发都遇到过，没有在`Manifest.xml` 声明指定的`Application` ，而导致一些需要在`Application#onCreate`  初始化传入 `Context` 的工具类发生空指针。



现在有一种方法只要声明依赖，然后在需要用到上下文的地方直接使用依赖中的工具类就可以获得`Application` 对象的方法可以了解一下。



原理没有使用反射而是通过`compileOnly` (或者也可以是`provided`)

具体代码查看 [github地址](https://github.com/pdog18/current-application-util)





### 使用方法

**Step 1.** Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```groovy
dependencies {
      implementation 'com.github.pdog18:current-application-util:1.0'
}
```

**Step 3.** Use in Activity(or other file)

```kotlin
class SampleActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        get_current_application.setOnClickListener {

            val application = Util.getCurrentApplication()
            Toast.makeText(application, application.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
```

