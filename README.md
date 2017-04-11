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
1. On the left sidebar, go to Projects -> app -> res -> layout -> activity_main.xml. You should see a palette of UI elements like labels (```TextView```s), text fields (```EditText```s), and buttons on the left. You can drag these onto the screen to add elements.
2. Below the palette is the component tree, which shows how these elements are organized on the screen (we use ```LinearLayout```s to structure and group them).
3. Currently, the screen is already populated with a number of different elements to create a UI for a form to fill out; you can either click on the elements in the component tree or directly on the element on the screen to get more information about its properties (which can be edited) on the right. Notice that we've given some of the elements IDs – these will be used in the code later.

### The Code
1. On the left sidebar, go to Projects -> app -> java -> (top option) -> MainActivity.

### Now That You're Done...
- Interested in taking an Android dev class in the future? Sign up for CS 193A!
