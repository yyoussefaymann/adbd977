import processing.sound.*;   
SoundFile song;

int numberOfSlides = 5; 
int Slide = 0;
PImage[] pictures = new PImage[numberOfSlides];
String Text;
PFont font;
int time=0;
void setup()
{
  size(900, 500);
  background(0);
  textAlign(CENTER);
  font= createFont("sanserif.ttf",48);
  textFont(font);

song = new SoundFile(this,"luciddreams.mp3");
  song.play();
  pictures[0]  = loadImage("juice0.jpg");
  pictures[1]  = loadImage("juice1.jpg");
  pictures[2]  = loadImage("juice2.jpg"); 
  pictures[3]  = loadImage("juice3.jpg");
  pictures[4]  = loadImage("juice4.jpg"); 
 
} 
 
void draw() 
{ 
  Slide = (Slide) % numberOfSlides;  
  tint(255,25);
  image(pictures[Slide], 0, 0);
  textSize(25);
    showText();
    time=time+1;
    if(time>450){
      Slide=Slide+1;
      time=0;
    }
    
}
void mouseClicked() {
 if (Slide<5)
  { Slide=Slide+1;
  }
  else {Slide = 0;}
}
void keyPressed(){
  if (key==CODED){
  if(keyCode==RIGHT){
    Slide=Slide+1;
  }
  else if(keyCode==LEFT){
    Slide=Slide-1;
    if(Slide<0){
      Slide=numberOfSlides-1;
    }}
  else{Slide=0;}
}}
void showText(){

  if(Slide>=0 && Slide<1){
    
    textSize(48);
     fill(0,0,255);
  Text="JUICE WRLD";
 }
   if (Slide>=1&&Slide<2){
     
     fill(0);
   Text=("Jared Anothony Higgins was a gifted young rapper born in 1998.");
 }
 if (Slide>=2&&Slide<3){
  
 Text="Unfortunately, due to certain events he died in 2019."+'\n'+"leaving the whole world in shock.";
 }
 if (Slide>=3&&Slide<4){
   fill(255);
 Text="Before his death, He produced tracks that got over a billion streams."+'\n'+"one of them is this song " +"'"+"lucid dreams"+"'"+" which is playing right now.";
 }
if (Slide>=4&&Slide<5){
  
 Text="Till this day, some tracks of his are still being released and achieving"+'\n'+" numbers more than many other rappers.";
}
text(Text,width/2,height/2);
  }
