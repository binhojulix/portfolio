/*
 * Author: Anthony Spagnoletti
 * 
 * Motion Sensor Alarm Code
 * 
 */

 
// defines pins numbers and variables
int trigPin = 9,
echoPin = 10,
buzzer = 11,
redLed = 13,
red2Led = 8,
blueLed = 12,
blue2Led = 7,
counter = 0,
distance,
safeDistance;

boolean isOn = false;
long duration;

void setup() {
pinMode(trigPin, OUTPUT);   //sets the trigPin as an Output
pinMode(echoPin, INPUT);    //sets the echoPin as an Input
pinMode(buzzer, OUTPUT);    //sets the buzzer as an Output
pinMode(redLed, OUTPUT);    //sets the red Led as an Output
pinMode(red2Led, OUTPUT);   //sets the second red Led as an Output
pinMode(blueLed, OUTPUT);   //sets the blue Led as an Output
pinMode(blue2Led, OUTPUT);  //sets the second blue Led as an Output
}


void loop() {
//clears the trigPin
digitalWrite(trigPin, LOW);
delay(2);

//sets the trigPin on HIGH state for 10 microseconds
digitalWrite(trigPin, HIGH);
delay(10);
digitalWrite(trigPin, LOW);

duration = pulseIn(echoPin, HIGH);  //reads the echoPin, returns the sound wave travel time in microseconds
distance = duration*0.034/2;        //calculate the distance
safeDistance = distance;

if (safeDistance <= 100){
    while(counter < 1)
    {
    //Makes the led's blink repeatedly
    digitalWrite(buzzer, isOn);
    digitalWrite(redLed, isOn);
    digitalWrite(red2Led, isOn);
    digitalWrite(blueLed, isOn);
    digitalWrite(blue2Led, isOn);
    isOn = !isOn; //Flip the boolean for the next iteration.
    delay(50);
    }
  }
}
