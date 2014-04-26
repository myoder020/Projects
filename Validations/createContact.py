#importing proper libraries
import time
import sys
import os
import subprocess

#get modules needed to run monkeyrunner
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

#Creating a simple create contact function
def createContact(name, phone, email, set):
#Making sure starting on home screen
	device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#opening contacts app
	device.touch(141, 755, MonkeyDevice.DOWN_AND_UP)
	time.sleep(7)
    
    
#clicking on create contact
	if set == 0:
		device.touch(228, 325, MonkeyDevice.DOWN_AND_UP)
		time.sleep(6)
	else: 
		device.touch(229, 758, MonkeyDevice.DOWN_AND_UP)
		time.sleep(6)

#clicking on Name Field for contact
	device.touch(144, 364, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Filling in name field
	device.type(name)
	time.sleep(2)

#Clicking on Phone Field
	device.touch(189, 418, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Filling in Phone Field
	device.type(phone)
	time.sleep(4)

#Closing virtual keyboard
	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)
 
#Clicking on Email Field
 	device.touch(194, 588, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

#Filling in Email Field
	device.type(email)
	time.sleep(4)

#Clicking done
	device.touch(90, 77, MonkeyDevice.DOWN_AND_UP)
	time.sleep(6)


#Create a delete contact function
def delContact(set):
#Clicking on menu button
	print "In delete contact function"
	if set == 0:
		device.touch(436, 77, MonkeyDevice.DOWN_AND_UP)
		time.sleep(4)
#Erasing contact
		device.touch(297, 297, MonkeyDevice.DOWN_AND_UP)
		time.sleep(4)

		device.touch(340, 463, MonkeyDevice.DOWN_AND_UP)
		time.sleep(4)

		device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
	else: 
		device.touch(232, 365, MonkeyDevice.DOWN_AND_UP)
		time.sleep(4)

		device.touch(438, 73, MonkeyDevice.DOWN_AND_UP)
		time.sleep(4)

		device.touch(255, 292, MonkeyDevice.DOWN_AND_UP)
		time.sleep(4)

		device.touch(341, 461, MonkeyDevice.DOWN_AND_UP)
		time.sleep(4)


def addFav():
	device.touch(186, 363, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

	device.touch(358, 80, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

	device.touch(48, 75, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

def testMessage():
	device.touch(429, 451, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

	device.touch(53, 73, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)

	device.touch(241, 73, MonkeyDevice.DOWN_AND_UP)
	time.sleep(4)


#Connect to emulator
device = MonkeyRunner.waitForConnection()
#adbLoc = "C:\Program Files (x86)\Android\\android-sdk\platform-tools\\"
#print  adbLoc
#assert os.path.isdir(adbLoc)
#os.chdir(adbLoc)
#subprocess.Popen(["adb.exe", "logcat", ">", "log.log"], shell=True)

#creating and deleting test contact
print "Creating first test contact"
createContact("test", "3333333333", "test@email.com", 0)
print "Deleting contact"
delContact(0)
print "Creating second test contact"
createContact("test1", "2222222222", "test1@email.com", 0)
print "Deleting contact"
delContact(0)
print "Creating third test contact"
createContact("test2", "4444444444", "test2@email.com", 0)
print "Creating fourth contact"
createContact("test3", "5555555555", "test3@email.com", 1)

#add contact to favorites
print "Adding contact to favorites"
addFav()

#Going to favorites tab
print "Navigating to favorites tab"
device.touch(48, 75, MonkeyDevice.DOWN_AND_UP)
time.sleep(4)

#Clicking on contact in favorites tab
print "Clicking on contact in favorites tab"
device.touch(113, 218, MonkeyDevice.DOWN_AND_UP)
time.sleep(4)

print "Testing opening the messaging app from within a contact"
testMessage()

print "Deleting all other contacts"
delContact(1)
delContact(1)

print "Going back to home screen"
device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
time.sleep(5)

#f = open('myFile.txt', 'w')
#f.write(testLog)
#f.close

print "Test done"


