import socket
import json
import numpy as np
import struct


s = socket.socket()
ip_port = ("127.0.0.1", 7000)
s.connect(ip_port)

# data = {"key": "select"}
#
# json_data = json.dumps(data).encode()
#
# num = len(json_data)
#
# re = num.to_bytes(4, byteorder="big", signed=True)
#
# s.send(re + json_data)
#
# receiveData = s.recv(1024).decode()
# print(receiveData)
#
# s.close()


data = {"key": "select", "key1": "update"}
json_data = json.dumps(data, indent=0).encode()

num = len(json_data)
num_data = num.to_bytes(4, byteorder="big", signed=True)

s.send(num_data + json_data)

receiveData = s.recv(4096).decode()
print(receiveData)

s.close()
