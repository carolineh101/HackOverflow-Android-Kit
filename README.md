# HackOverflow Android Development Kit

### Description
This tutorial will walk you through an Android app (written in Java) which sends auto-formatted follow-up letters. You can download the app (APK file) in the [release](https://github.com/carolineh101/HackOverflow-Android-Kit/releases) section of this repository.

### Before Starting...
Download Android Studio [here](https://developer.android.com/studio/index.html).

### Get Started
1. Click the green "Clone or download" button and then click "Download ZIP."
2. Open Android Studio and click "Open an existing Android Studio project." Find and select "HackOverflow-Android-Kit-master" (the Android Studio logo should be displayed next to it).
3. Click the green "play" button to build and run to test the app out! (Note: Emailing won't work on the emulator.)

### The UI
1. On the left sidebar, go to Projects -> app -> res -> layout -> activity_main.xml. (Think of an [activity](https://developer.android.com/reference/android/app/Activity.html) as one screen of an app!) You should see a palette of UI elements like labels (```TextView```s), text fields (```EditText```s), and buttons on the left. You can drag these onto the screen to add elements.
2. Below the palette is the component tree, which shows how these elements are organized on the screen (we use ```LinearLayout```s to structure and group them).
3. Currently, the screen is already populated with a number of different elements to create a UI for a form to fill out; you can either click on the elements in the component tree or directly on the element on the screen to get more information about its properties (which can be edited) on the right. Notice that we've given some of the elements IDs – these will be used in the code later.

### The Code
1. On the left sidebar, go to Projects -> app -> java -> (top option) -> MainActivity. What you see should look fairly familiar if you've taken 106A – the activity's just a class. Notice the naming convention for the variables (```Type mName```).
2. As you can see, our code is all in the ```onCreate()``` method, which sets up our activity. (If you want to know more about what this method specifically does or if you want to create more complex apps, I'd suggest taking a look at the [activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle.html). The first few lines of code connect the code to the UI and remove that pesky bar at the top of the UI you can see in ```activity_main.xml```.
3. The next section of code sets the variables we declared earlier to their corresponding components in the UI through ```findViewByID()```. (This is where having a descriptive ID for your UI component comes in handy!)
4. The next large chunk sets up an ```onClickListener``` we name ```sendEmailListener``` which performs the actions in ```onClick()``` when its associated component is clicked. (We set the listener's associated component to the button ```mSendEmail``` at the end of the code with ```mSendEmail.setOnClickListener(sendEmailListener)```.)
5. That long boolean statement presents a ```Toast``` (informative pop-up statement) if the form for sending the email isn't completely filled out.
6. The next section (from ```String greeting``` to ```String message```) creates the string representing the user's follow-up email based on their responses.
7. The final section (starting at ```Intent i = new Intent(Intent.ACTION_SEND)```) actually sends the email using an [intent](https://developer.android.com/guide/components/intents-filters.html), which is an object that interacts with other activities (usually by sending the user to another screen) or services (here, email). The intent sets the email address, subject, and text with ```putExtra()``` and then checks whether the user has a valid email client. If so, the intent allows the user to select which email client to send the message with; if not, it presents a ```Toast``` with an informative message.

### Now That You're Done...
- Want to download your app to your phone? In the menu, go to Build -> Build APK. The file created can be opened as an app on your Android phone.
- Check out the [Android developer website](https://developer.android.com/training/index.html) to learn more about Android development.
- Interested in taking an Android dev class in the future? Sign up for CS 193A!
