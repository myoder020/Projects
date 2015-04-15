import sys
import os
import subprocess
import time
import signal
import ctypes


print("Start Logging...")
p = subprocess.Popen("adb logcat > a.log", stdout=subprocess.PIPE, shell=True)
time.sleep(2)

print ("setting current directory into a variable")
dir = os.getcwd()

print ("Running contacts script")

cmd = "monkeyrunner " + dir + "\\contact.py"
subprocess.call(cmd, shell=True)

p.terminate()

