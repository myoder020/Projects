#importing proper libraries
import time
import sys
import os
import subprocess
import telnetlib

#get modules needed to run monkeyrunner
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

def telnet_call(number, text):
	print "send sms: " + number + " " + text
	tn = telnetlib.Telnet("localhost", 5554)
	while True:
		tn.read_until("OK")
		print "start writing"
		tn.write("sms send " + number + " " + text + "\n")
		#suppose we always succeed
		ret = tn.read_until("OK")
		print "sms sent " + number + " " + text
		break
	tn.write("exit\n")

#Go home function
def goHome():
	device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Creating a simple create contact function
def createContact(name, phone, email, haveContact, add, addPhone):
	def phoneAdd():
#adding second number
		device.touch(143, 478, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
		device.type("2112342234")
		time.sleep(5)
		device.touch(368, 462, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
#Setting type to home fax
		device.touch(384, 339, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)	
#Removing number
		device.touch(452, 471, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
	
	def goHome():
		device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
#Making sure starting on home screen
	goHome()

#opening contacts app
	device.touch(141, 755, MonkeyDevice.DOWN_AND_UP)
	time.sleep(7)
    
    
#clicking on create contact
	if haveContact == 0:
		device.touch(228, 325, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
	else: 
		device.touch(229, 758, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)

#clicking on Name Field for contact
	device.touch(144, 364, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Filling in name field
	device.type(name)
	time.sleep(2)

#Clicking on Phone Field
	device.touch(189, 418, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Filling in Phone Field
	device.type(phone)
	time.sleep(5)
	if addPhone == 1:
		phoneAdd()

#Closing virtual keyboard
	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)
 
#Clicking on Email Field
 	device.touch(194, 588, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Filling in Email Field
	device.type(email)
	time.sleep(5)
	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Clicking on Address Field
 	device.touch(231, 661, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)
	device.type("testAddress")
	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Adding Field
	if add == 1:
		device.touch(242, 714, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
		device.touch(244, 498, MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)
		device.type("testNick")
		device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)

#Clicking done
	device.touch(90, 77, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)


#Create a delete contact function
def delContact():
#Clicking on menu button
	print "In delete contact function"
	def goHome():
		device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
		time.sleep(5)

	goHome()
#opening contacts app
	device.touch(141, 755, MonkeyDevice.DOWN_AND_UP)
	time.sleep(7)

#Clicking on contact    
	device.touch(224, 360, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)
	
#Erasing contact
	device.touch(436, 77, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(297, 297, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(340, 463, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

def addFav():
	device.touch(186, 363, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(358, 80, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(48, 75, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

def testMessage():
	device.touch(429, 451, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)

	device.press('KEYCODE_BACK', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(53, 73, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(241, 73, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

def edit():
	device.touch(434, 69, MonkeyDevice.DOWN_AND_UP)
	time.sleep(10)

	device.touch(415, 147, MonkeyDevice.DOWN_AND_UP)
	time.sleep(6)	

	device.touch(454, 615, MonkeyDevice.DOWN_AND_UP)
	time.sleep(6)	

	device.drag((226,746),(215, 448), 3, 1)
	time.sleep(5)	

	device.touch(234, 718, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(249, 569, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)	

	device.type("testWebsite.com")
	time.sleep(4)
 	
	device.touch(87, 72, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

def delMessages():
	device.touch(335, 750, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(432, 767, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(316, 696, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(351, 516, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)


#Connect to emulator
device = MonkeyRunner.waitForConnection()

#creating and deleting test contact
print "Creating first test contact"
createContact("test1", "3333333333", "test1@email.com", 0, 0, 0)

print "Editing first contact"
time.sleep(2)
edit()

print "Creating second test contact"
createContact("test2", "2222222222", "test2@email.com", 1, 1, 1)

#add contact to favorites
print "Adding contact to favorites"
addFav()

#Going to favorites tab
print "Navigating to favorites tab"
device.touch(48, 75, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)

#Clicking on contact in favorites tab
print "Clicking on contact in favorites tab"
device.touch(113, 218, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)

print "Testing incoming message from contact"
telnet_call("2222222222", "Test")
time.sleep(3)

print "Testing incoming message from stranger"
telnet_call("2222222223", "Test")
time.sleep(3)

print "Testing opening the messaging app from within a contact"
testMessage()

print "Adding contact to homescreen"
device.touch(228, 364, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)	

device.touch(437, 74, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)	

device.touch(248, 515, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)

print "Start to make contact then discard it"
goHome()
#opening contacts app
device.touch(141, 755, MonkeyDevice.DOWN_AND_UP)
time.sleep(7)

device.touch(229, 758, MonkeyDevice.DOWN_AND_UP)
time.sleep(7)

device.type("Discarded")

device.touch(440, 72, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)


#Clicking on discard
device.touch(302, 220, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)

device.touch(341, 467, MonkeyDevice.DOWN_AND_UP)
time.sleep(5)


print "Deleting all contacts"
delContact()
delContact()
print "Going back to home screen"
device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
time.sleep(5)

device.drag((61, 150), (236, 40), 3, 1)
time.sleep(5)

#Deleting messages
print "Deleting messages"
delMessages()
goHome()


print "Test done"



