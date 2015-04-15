import time
import sys

#get modules needed to run monkeyrunner
from com.android.monkeyrunner import MonkeyRunner, MonkeyDevice

#Creating a simple create contact function
def openContacts():
#Making sure starting on home screen
	device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#opening contacts app
	device.touch(141, 755, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)


def delAccount():
#Pressing menu button
	device.touch(435, 760, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Opening up accounts
	device.touch(368, 615, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(237, 512, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

	device.touch(436, 70, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Clicking on remove button
	device.touch(306, 222, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)

#Clicking on confirm button
	device.touch(320, 544, MonkeyDevice.DOWN_AND_UP)
	time.sleep(5)
 
    


#Clicking done
#	device.touch(90, 77, MonkeyDevice.DOWN_AND_UP)
#	time.sleep(4)

device = MonkeyRunner.waitForConnection()

openContacts()

#clicking on sign into account
device.touch(236, 419, MonkeyDevice.DOWN_AND_UP)
time.sleep(7)

#Enter info for email account
device.type("t.test20@outlook.com")
time.sleep(2)

#Clicking on Password Field
device.touch(137, 315, MonkeyDevice.DOWN_AND_UP)
time.sleep(4)

#Filling in Password Field
device.type("@bcd1234")
time.sleep(7)

#Clicking on Next Button
device.touch(344, 393, MonkeyDevice.DOWN_AND_UP)
time.sleep(12)

#Clicking on Next Button
device.touch(344, 692, MonkeyDevice.DOWN_AND_UP)
time.sleep(10)

#Clicking on Next Button
device.touch(347, 356, MonkeyDevice.DOWN_AND_UP)
time.sleep(10)

delAccount()