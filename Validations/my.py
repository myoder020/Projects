#importing proper libraries
import time
import sys

#get modules needed to run monkeyrunner
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

#Creating a simple create contact function
def createContact():
#Making sure starting on home screen
	device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#opening contacts app
	device.touch(71, 375, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#clicking on create contact
	device.touch(116, 160, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#clicking on Name Field for contact
	device.touch(81, 117, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Filling in name field
	device.type("Test")
	time.sleep(2)

#Clicking on Phone Field
	device.touch(52, 193, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Filling in Phone Field
	device.type("1111111111")
	time.sleep(4)

#Closing virtual keyboard
	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Clicking on Email Field
	device.touch(41, 293, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Filling in Email Field
	device.type("test@gmail.com")
	time.sleep(4)


#Create a delete contact function
def delContact():
	device.touch(34, 34, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Clicking on menu button
	device.touch(215, 36, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Erasing contact
	device.touch(95, 150, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

	device.touch(173, 231, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Going back to home screen
	device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Connect to emulator
device = MonkeyRunner.waitForConnection()

#calling createContact function
createContact()
delContact()
createContact()
delContact()




print "Test done"


