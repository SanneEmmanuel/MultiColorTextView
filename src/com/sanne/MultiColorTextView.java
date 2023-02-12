package com.sanne;
	import android.app.*;
	import android.os.*;
	import android.view.*;
	import android.widget.*;
	import java.net.*;
	import android.text.*;
	import android.text.style.*;
	import android.graphics.*;
	import java.util.*;

	class Spanz{
		public Object obj;
		public int start;
		public int end;
		public Spanz(Object obj, int start, int end){
			this.obj=obj;
			this.start=start;
			this.end=end;
		};
	}
	public class MultiColorTextView extends android.widget.TextView{
		private android.text.Spannable span;
		private ArrayList<Spanz> spanz;
		public MultiColorTextView(android.content.Context context){
			super(context);
			spanz= new ArrayList<Spanz>();
			if(span==null)span= new SpannableString("");

		}

		//ADDING GRADIENT TO TEXT
		public void setTextColor(int gradientColors[])
		{
			Shader textShader = new LinearGradient(0, 0, this.getWidth(), this.getTextSize(),
		    gradientColors, null, Shader.TileMode.CLAMP);
			this.getPaint().setShader(textShader);
			
			super.setTextColor(gradientColors[0]);
		}

		//FUNCTION THAT SETS THE TEXT OF A TEXTVIEW AND ADDS DEFAULT COLOUR
		public void setText(String text, int color)
		{
			try{
				super.setText(text);
				super.setBackgroundColor(color);
			}catch(Exception e){Toast.makeText(getContext(),"Sanne_Error:: "+e.getMessage(),Toast.LENGTH_LONG).show();}
		}

		//FUNCTION THAT COLOURS ALL THE OCCURANCES OF A TEXT
		public void colourAll(String text,int color){
			String fullText= this.getText().toString();
			if(!fullText.contains(text))return;
			for( int x=0; x< fullText.length();x++){
				int start= fullText.indexOf(text,x);
				if(start<0)break;
				x= start+ text.length();
				Object obj= new ForegroundColorSpan(color);

				spanz.add(new Spanz(obj,start,x));

			}
			span= new SpannableString(fullText);
			addSpans();
		}

		//FUNCTION THAT COLOURS THE FIRST OCCURANCE OF A DTRING IN TEXTVIEW
		public void colourFirstOccurance(String text,int color){
			String fullText= this.getText().toString();
			if(!fullText.contains(text))return;
			int start= fullText.indexOf(text);
			int end= start+ text.length();
			Object obj= new ForegroundColorSpan(color);
			spanz.add(new Spanz(obj,start,end));
			span= new SpannableString(fullText);
			addSpans();
		}
		//FUNCTION THAT COLOURS THE LAST OCCURANCE OF A DTRING IN TEXTVIEW
		public void colourLastOccurance(String text,int color){
			String fullText= this.getText().toString();
			if(!fullText.contains(text))return;
			int start= fullText.lastIndexOf(text);
			int end= start+ text.length();
			Object obj= new ForegroundColorSpan(color);
			spanz.add(new Spanz(obj,start,end));
			span= new SpannableString(fullText);
			addSpans();
		}
		//MAIN FUNCTION THAT ADDS A TEXT TO TEXVIEW WITH IT'S COLOUR
		public void addText(String text, int color){
			try{
				Object obj= new ForegroundColorSpan(color);
				int start= span.length();
				int end= start+text.length();
				spanz.add(new Spanz(obj,start,end));
				span= new SpannableString(this.getText().toString()+text);
				addSpans();
			}catch(Exception e){e.printStackTrace(); super.setText(text);}
		} 

		//EXTRAS
		public void addBulletPoint(String text, int color,int spaceFromText){

			Object obj= new BulletSpan(spaceFromText,color);
			int start= span.length();
			int end= start+text.length();
			spanz.add(new Spanz(obj,start,end));
			span= new SpannableString(this.getText().toString()+text);
			addSpans();

		}
		public void addBulletPoint(String text){
			this.addBulletPoint(text,Color.DKGRAY,3);
		};

		//FUNCTION THAT ADDS SPANS TO TEXTVIEW
		private void addSpans(){
			for(int x=0; x<spanz.size(); x++)
			{   Spanz i= spanz.get(x);
				span.setSpan(i.obj,i.start,i.end,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);}
			this.setText(span,TextView.BufferType.SPANNABLE);
		}
		//END CLass
	
}
