###############################################################################
# Jython script to test MonkeyRunner script                                   
# Author: Roopesh Rai  
# Date: 20/12/2011                                  ###############################################################################

# Import Class Files

import sys
import commands
import time

from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

###############################################################################

# Creating Alert Box To Specify Goal Of Script 

MonkeyRunner.alert("\n\nMonkeyRunnerScript\n\tIt is a Jython script\n \
        \tWill test emulator or device by sending events\n\n\n\n\n \
        PRESS 'Continue' TO RESUME...","MonkeyRunner","Continue");

# Checking Available Devices And Validating

devices = \
commands.getoutput('../platform-tools/adb devices').strip().split('\n')[1:]

if len(devices) == 0:
    MonkeyRunner.alert("Select device to connect.",
            "No devices found", "Exit")
    sys.exit(1) 

# Select Any One Device And Ask User's Choice. Select Actual Device To Execute

device_index = MonkeyRunner.choice("List of devices attached to system\n" +
    " Select target Device.", devices, "Select target device");

if device_index == -1:
    sys.exit(1)

Actual_device = devices[device_index].split('\t')[0] 

# Connects To The Current Device, Returning A MonkeyDevice Object

device = MonkeyRunner.waitForConnection(5, Actual_device)

###############################################################################

# Take Input From User To Enter Application Name To Install

application_name = MonkeyRunner.input("Enter Application to install on Device" +
        " " + Actual_device,"myproject/","Step 1: Install Application",
        "OK", "Cancel")

if not application_name:
    sys.exit(1) 


# Install Application And Validate The Installation Status

install_status = device.installPackage(application_name)

if not install_status:
    MonkeyRunner.alert("Installation of " + application_name +" Failed",
            "Error","Exit");
    sys.exit(1)


# Uninstall Installed Application

def removing_application_from_device(application_name):
    remove_status = device.removePackage(package)
    if not remove_status:
        MonkeyRunner.alert("Uninstallation of " + application_name +
                " Failed", "Error","Exit");
        sys.exit(1)
        
    MonkeyRunner.alert(application_name + " Successifuly uninstalled from" + 
    " device" + Actual_device,"Test Complete","OK");
    sys.exit(1)

# Taking snapshot of screen

###############################################################################

def snapshot_screen(Actual_device):
    
    # Takes A Screenshot
    
    MonkeyRunner.alert("Taking screenshot of device  " + Actual_device,
    "Screenshot","Take Screenshot");
    result = device.takeSnapshot()
    
    # Writes The Screenshot To A File
    
    result.writeToFile('myproject/Snapshot-' + time.ctime() + '.png','png')

###############################################################################

# Take Input From User To Enter Package Name Of Application And Validate 
# Input

package = MonkeyRunner.input("Enter Package name of application " + \
        application_name,"com.","Step 2: Get Package Name","OK",
        "Cancel")



if not package:
    removing_application_from_device(application_name)
    

# Take Input From User To Enter Launching Activity Name Of Application and
# Validate the Input

activity = MonkeyRunner.input("Enter launching activity application " + \
        application_name,package + ".",
        "Step 3: Get Launching activity name","OK", "Cancel")

if not activity:
    removing_application_from_device(application_name)

# Sets The Name Of The Component To Start

runComponent = package + '/' + activity

# Runs The Component

device.startActivity(component=runComponent)


###############################################################################

# Presses The Menu Button

device.press('KEYCODE_MENU', MonkeyDevice.DOWN_AND_UP)

# Dragging To Specific Coordinate (x,y)

device.drag((15, 80),(15,400),5,10)
snapshot_screen(Actual_device)
device.drag((15, 400),(200,400),5,10)
snapshot_screen(Actual_device)
device.drag((200, 400),(200,80),5,10)
snapshot_screen(Actual_device)
device.drag((200, 80),(15,80),5,10)
snapshot_screen(Actual_device)


###############################################################################

removing_application_from_device(application_name);

###############################################################################