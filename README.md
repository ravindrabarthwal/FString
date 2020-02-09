[1.1]: http://i.imgur.com/wWzX9uB.png (Twitter)
[1.2]: http://i.imgur.com/9I6NRUm.png (GitHub)
[1.3]: http
[2.1]: https://twitter.com/ravinBarthwal
[2.2]: http://www.github.com/ravindrabarthwal
[3.2]: https://github.com/palashbansal96

# FString - Dynamically Updatable* strings.xml for Android
FString provides an elegant solution for dynamically updating the strings.xml values. It uses a combination of Android **SharedPreferences**, **strings.xml** and **reflections** to dynamically update the values. By using FString, strings.xml existing value can be updated using JSON string without releasing a new version.

FString stores the updated values in the SharedPreferences (as we can not update strings.xml directly). FString first checks the value in the SharedPreferences otherwise it returns the default value from the strings.xml

## Installation 
- In your project's module **build.gradle** add this dependency
  ```groovy
  implementation 'com.ravindrabarthwal.fstring:fstring:1.0.0'
  ```
- In your Android **Application** class add the following code 
  ```kotlin
  import com.example.myapp.R.string as RString // Import your string 
  
  class MyApp: Application() {
  
      override fun onCreate() {
          super.onCreate()
          FString.init(RString::class.java) // Initializes the FString
      }
      
  }
  ```
  
## Usage
  **To access the strings**
  ```kotlin
    // This is how you get strings without FString
    context.getString(R.string.my_app_name) // This is how you normally do
    
    // To get the string using FString use
    FString.getString(context, R.string.my_app_name)
    
    // If you prefer extension function use
    context.getFString(R.string.my_app_name) // This is how FString works ;)
  ```
  
  **To update the FString values** 
  ```kotlin
    /*
     * Assume this JSON is coming from server. The JSON string 
     * must be parseable to a JSON object with key and value pairs
     */
    var jsonFromServer = """
        {
          "my_app_name": "MyApp v2.0",
          "some_other_string": "this is so cool",
        }
    """.trimIndent()
    
    // This will update the SharedPreference using keys from
    // above JSON and corresponding value. The SharedPreference will
    // not save any key that is not is strings.xml
    FString.update(context, jsonFromServer) 
    
  ```
  
  **To clear values**
  ```kotlin
    /*
     * If you want to clear some keys' value to default, either update 
     * the FString with previous values or use the below api
     */
     
     // To clear all values
     FString.clearAll(context)
     
     // To clear specific values send JSON String that must be 
     // parseable to a JSONArray containing the keys to clear
     
     val jsonToClear = """
         [
            "my_app_name"
         ]
     """.trimIndent()
     
     FString.clear(context, jsonToClear)
    
  ```
  
## Limitations
  - TODO: Currently string template is not supported. 
  ```xml
    // If strings.xml contains 
    <string name="my_app_name">My App %s</string>
  ```
  ```kotlin
    // Android provides varargs support. This is currently
    // not supported by FString
    context.getString(R.string.my_app_name, "v2.0")
  ```
  
## Contributors 
  - Ravindra Barthwal (Me) [![alt text][1.1]][2.1]  [![alt text][1.2]][2.2]
  - Palash Bansal [![alt text][1.2]][3.2]
    
## Contribution Guideline
Feel free to fork it and create a pull request.




*Made with ❤ at [Mouve - Animated Stories Creator for Instagram](https://mouve.app)*
  
  
  
