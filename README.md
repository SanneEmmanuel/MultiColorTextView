# MultiColorTextView

# Update January 12, 2023 <!-- omit in toc -->

This Package Allows you to add multiple colours and styles to your text in Android Programing.
It is easy to use and you can create dynamic designs with include gradient text and the ability to colour useful part of your text 
To use kindly edit your <a href="">build.gradle</a> file
```implementation
implementation 'com.sanne:multicolortextview:2.0.1'
```

## Intro
This is a dynamic TextView creaed by <a href="https://www.facebook.com/sansax.bassist.5">Sanne Karibo</a> that enables Programmer add different colours to one textview
It is easy to use and has all the regular function of a normal TextView only More.

<p align="center">
  <img alt="Example usage" src="media/screen.jpg">
</p>


## Usage

```Java
import com.sanne.MultiColorTextView;

MultiColorTextView textview= new MultiColorTextView(this);
textview.setText("SOME TEXT");
textview.colorAll("TEXT",Color.RED);

```

<p> In the Above a MultiColorTextView is created in java and text is Added programmatically, then all the occurances of a particular text is coloured Red</p>


```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
	android:orientation="vertical">
<com.sanne.MultiColorTextView
	android:id="@+id/text"
	android:text="@string/hello_world"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content" />
</LinearLayout>
```

<p> In this example a layout file is created for the activity and the MultiColorTextView is given an id of 'text'</p>
<p> You can use the xml layout in mainActivity by calling

```Java
MultiColorTextView text= findViewById(R.id.text);
```

THE PROJECT HAS NO EXTERNAL DEPENDENCY AND IS SUPPORTED IN VARIOUS VERSIONS OF THE ANDROID OS
MIT © [Sanne Karibo]"https://www.github.com/sanneemmanuel

