# coding:utf-8
import RPi.GPIO as gpio
import time, sys
from pynput import keyboard
gpio.setwarnings(False)
# 定义引脚
in1 = 12
in2 = 16
in3 = 18
in4 = 22

# 设置GPIO口为BOARD编号规
gpio.setmode(gpio.BOARD)

# 设置GPIO口为输出
gpio.setup(in1, gpio.OUT)
gpio.setup(in2, gpio.OUT)
gpio.setup(in3, gpio.OUT)
gpio.setup(in4, gpio.OUT)

# 设置PWM波,频率为500Hz
pwm1 = gpio.PWM(in1, 500)
pwm2 = gpio.PWM(in2, 500)
pwm3 = gpio.PWM(in3, 500)
pwm4 = gpio.PWM(in4, 500)
pwm1.start(0)
pwm2.start(0)
pwm3.start(0)
pwm4.start(0)
# 定义向前
def go():
    pwm1.ChangeDutyCycle(60)
    pwm2.ChangeDutyCycle(60)
    pwm3.ChangeDutyCycle(0)
    pwm4.ChangeDutyCycle(0)
def go1():
    pwm1.ChangeDutyCycle(100)
    pwm2.ChangeDutyCycle(100)
    pwm3.ChangeDutyCycle(0)
    pwm4.ChangeDutyCycle(0)
# 定义向右
def right():
    pwm1.ChangeDutyCycle(0)
    pwm2.ChangeDutyCycle(50)
    pwm3.ChangeDutyCycle(50)
    pwm4.ChangeDutyCycle(0)
def right1():
    pwm1.ChangeDutyCycle(0)
    pwm2.ChangeDutyCycle(100)
    pwm3.ChangeDutyCycle(100)
    pwm4.ChangeDutyCycle(0)
# 定义向左
def left():
    pwm1.ChangeDutyCycle(50)
    pwm2.ChangeDutyCycle(0)
    pwm3.ChangeDutyCycle(0)
    pwm4.ChangeDutyCycle(50)
def left1():
    pwm1.ChangeDutyCycle(100)
    pwm2.ChangeDutyCycle(0)
    pwm3.ChangeDutyCycle(0)
    pwm4.ChangeDutyCycle(100)
# 定义向后
def back():
    pwm1.ChangeDutyCycle(0)
    pwm2.ChangeDutyCycle(0)
    pwm3.ChangeDutyCycle(60)
    pwm4.ChangeDutyCycle(60)
def back1():
    pwm1.ChangeDutyCycle(0)
    pwm2.ChangeDutyCycle(0)
    pwm3.ChangeDutyCycle(100)
    pwm4.ChangeDutyCycle(100)
# 定义停止
def stop():
    pwm1.ChangeDutyCycle(0)
    pwm2.ChangeDutyCycle(0)
    pwm3.ChangeDutyCycle(0)
    pwm4.ChangeDutyCycle(0)
def fun():
    for i in range(280000):
        right1()

def on_press(key):
    try:
        global temp
        if key =='2':
            temp=True
        if key =='1':
            temp=False
        if key == 'w':
            #print("ggggg")
            go()
        if key == 'w' and temp:
            go1()
        if key == 'a':
            left()
        if key == 'a' and temp:
            left1()
        if key == 's':
            back()
        if key == 's' and temp:
            back1()
        if key == 'd':
            right()
        if key.char == 'd'and temp:
            right1()
        if key == '9':
            fun()
    except AttributeError:
        1
        #print('special key {0} pressed'.format(key))


def on_release(key):
    stop()
    if key == keyboard.Key.esc:
        return False
temp=False
# 键盘监听
#while True:
    #with keyboard.Listener(
            #on_press=on_press, on_release=on_release) as listener:
        #listener.join()
import os
import time
f = open("/home/pi/Desktop/temp","r",encoding='ascii')
while (True):
    key=f.read(2)
    if (len(key)!=0):
        on_press(key[0])
        time.sleep(1)
        if (key[0]!=1 and key[0]!=2):
            stop()
        #on_release(key)
        #(key)
f.close()
    



pwm1.stop()
pwm2.stop()
pwm3.stop()
pwm4.stop()
gpio.cleanup()
