# FlightSimulatorApp

## Main Objectives:
1. Building an android App for Remote Control Joystick.
2. Using FlightGear Simulator with TCP connection.


## Summary

The FlightSimulatorApp is an android app for Remote Control the flight that perform in FlightGear Simulator. 
Using Joystick controls Alieron and Elevator, and seekBar's controling Ruuder and Thorttle.

![](ReadMePic/firsr activity.PNG)
![](ReadMePic/second activity.PNG)

## Folder Structure

```
.Milestone_2
├── client              # UI of the web application (View part of the MVC architecture)
|   ├── public          # contain the public files such as the index.html, the main page.
|   ├── src             # UI implementation folder.
|   |   ├── api         # HTTP requests implemantation files.	
|   |   ├── components	# The different UI componenets in the web app.
|   |   |   ├──...      # The UI componenets implementations.
|   |   ├── utils       # Holds helper logic files.
├── Server
|   ├── controller      # controller part of the MVC architecture.
|   |   ├── anomaly     # implements the get http request for anomaly
|   |   ├── model       # implements the get http for model 
|   |   ├── models      # implements the get http for models
|   ├── lib             # anomaly detection logic.
|   ├── model           # the model part of the MVC architecture whice communicates with the data base.
```
## Compiling and running
1. Clone/download this repo.
2. Open the folder in an IDE like Android Studio.
3. Open the flightGear Simulator, go to Setting and insert '--telnet=socket,in,10,192.168.1.169,6400,tcp' in the Additional Settings.
4. Run the app in your phone or in Android Studio's simulator.
5. Enter your computer's IP and port: 6400, and press the Connect button. 
6. Now you can control the plane.

## Additional Links
- [Short instructional video about the project.](https://www.youtube.com/watch?v=Rtib_R_Ls4Y)
