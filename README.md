# Steps_Android

Is android component to show your steps in modern view.
 
 **Sample**
 
 ![Circle Image Steps](https://github.com/mmoamenn/Steps_Android/blob/master/samples/videotogif_2017.04.21_17.54.05.gif)
 
 **Installation**
 
 Add it in your root build.gradle at the end of repositories:
 
 	allprojects {
 		repositories {
 			...
 			maven { url 'https://jitpack.io' }
 		}
 	}
 	
 Step 2. Add the dependency
 
 	dependencies {
 	     compile 'com.github.mmoamenn:Steps_Android:0.0.1'
     }

 	
 **XML**
 
` <com.bluehomestudio.steps.CircleImageSteps
         android:id="@+id/cis_steps"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         ImageStep:step_size="40dp"/>`
         
 You must use the following properties in your XML to adjust your steps raduis
 
 * `ImageStep:step_size`
 
 and this to set active and in active step color 
 
 * `ImageStep:active_step_color`
 * `ImageStep:inActive_step_color`
 
 **JAVA**
 
 Functions to use after reference CircleImageSteps
 
 _Function to add steps images you can add any number or images_ 
 
 * `addSteps(R.drawable.flag , R.drawable.fish
                 , R.drawable.cooking , R.drawable.alarm
                 , R.drawable.eat);`
                 
 _Function to highlight next or previous step_
 
 * `nextStep();`
 * `previousStep();`
