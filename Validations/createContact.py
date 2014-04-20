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
	device.touch(141, 755, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#clicking on create contact
	device.touch(228, 325, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#clicking on Name Field for contact
	device.touch(144, 364, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Filling in name field
	device.type("Test")
	time.sleep(2)

#Clicking on Phone Field
	device.touch(189, 418, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Filling in Phone Field
	device.type("1111111111")
	time.sleep(4)

#Closing virtual keyboard
	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)
 
#Clicking on Email Field
 	device.touch(194, 588, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Filling in Email Field
	device.type("test@gmail.com")
	time.sleep(4)

#Clicking done
	device.touch(90, 77, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)


#Create a delete contact function
def delContact():
#Clicking on menu button
	device.touch(436, 77, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Erasing contact
	device.touch(297, 297, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

	device.touch(340, 463, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Going back to home screen
	device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Connect to emulator
device = MonkeyRunner.waitForConnection()

#creating and deleting test contact
createContact()
delContact()
createContact()
delContact()

print "Test done"


